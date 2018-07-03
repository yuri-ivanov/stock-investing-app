import React, { Component } from 'react';
import PropTypes from 'prop-types';

class TimeSeries extends Component {

  constructor(){
    super();
    this.state={max:100};
  }

  componentWillReceiveProps(nextProps) {
    if(nextProps.newPost){
      this.props.posts.unshift(nextProps.newPost);
    }
  }

  filterData(item){
    if(!this.props.filterData.volume) return item;
    if(item.quantity > this.props.filterData.volume){
      return item;
    }
  }

  findClass(trade){
    let tradeClass = "";
    if(trade.type === "SELL"){
      tradeClass = "time-series-sell";
    } else if(trade.type === "BUY"){
      tradeClass = "time-series-buy";
    }
    return tradeClass;
  }

  render() {
    console.log('TimeSeries', this.props);

    const postItems = (this.props.data)?this.props.data.filter(this.filterData.bind(this)).slice(0,this.state.max).map(post => (
      <tr className={this.findClass(post)}>
        <td>{new Date(post.time).toLocaleString()}</td>
        <td>{post.price}</td>
        <td>{post.quantity}</td>
        <td>{post.type}</td>
      </tr>
    )):null;

    const filterCount = (postItems)?postItems.length:null;
    const max = this.state.max;
    return (
      <div>
        <div>filter:{filterCount} show max:{max}</div>
        <table className="time-series">
        <tr><th>time</th><th>price</th><th>volume</th><th>type</th></tr>
        <tbody>
          {postItems}
        </tbody></table>
      </div>
    );
  }
}

TimeSeries.propTypes = {
  data: PropTypes.array.isRequired,
  filterData: PropTypes.object
}

export default TimeSeries;
