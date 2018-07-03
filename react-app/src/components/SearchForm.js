import React, { Component } from 'react';
import PropTypes from 'prop-types';


class SearchForm extends Component {
  constructor(){
    super();
    this.state = {
      volume: 1000
    };
  }

  componentDidMount() {
    this.handleSubmit();
  }


  handleSubmit(e){
    if(this.refs.volume.value === ''){
      console.log('required input');
    } else {
      this.setState({
        volume:this.refs.volume.value
      })
      this.props.searchFormCallback({volume:this.refs.volume.value});
    }
    if(e){
      e.preventDefault();
    }
  }

  onChangeVolume(e) {
    this.state.volume=e.target.value;
  }

  render() {
    return (
      <div>
        <h3>TimeSeries filter</h3>
        <form onSubmit={this.handleSubmit.bind(this)}>
          <div>
            <label>volume</label><input type="text" ref="volume"  defaultValue={this.state.volume} /><input type="submit" value="Submit" />
          </div>
        </form>
      </div>
    );
  }
}

SearchForm.propTypes = {
  searchFormCallback: PropTypes.func.isRequired
}

export default SearchForm;
