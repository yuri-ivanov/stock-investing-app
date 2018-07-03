import React, { Component } from 'react';
import SearchForm from './components/SearchForm';
import TimeSeries from './components/TimeSeries';
import AreaChart from './Chart';
import './App.css';

class App extends Component {
  constructor(){
    super();
    this.state = {
      trades: [],
      searchData: {}
    };
  }

  componentDidMount() {
    this.fetchPosts();
  }

  componentWillMount(){
  }

  searchFormAction(data){
    console.log('searchData', data);
    this.setState({searchData:data});
  }

  convertDataForChart(data) {
    const  chartData = data.map(d => {
      return {
        date: new Date(d.time),
        open: d.price,
        high: d.price,
        low: d.price,
        close: d.price,
        volume: d.quantity }
    });
    return chartData;
  }

  fetchPosts(){
    console.log('fetch posts');
    return fetch("/api/stock/nas/trades")
    .then(response => response.json())
    .then(data => this.setState({
      trades: this.convertDataForChart(data),
      data1: data
    }));
  }

  render() {
    return (
        <div className="App">
          <h1>Stock App</h1>
          <AreaChart data={this.state.trades} />
          <SearchForm searchFormCallback={this.searchFormAction.bind(this)}/>
          <TimeSeries data={this.state.data1} filterData={this.state.searchData} />
        </div>
    );
  }
}

export default App;
