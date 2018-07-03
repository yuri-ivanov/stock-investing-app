
import { scaleTime } from "d3-scale";
import { format } from "d3-format";
import { timeFormat } from "d3-time-format";

import React from "react";
import PropTypes from "prop-types";

import { ChartCanvas, Chart } from "react-stockcharts";
import { AreaSeries } from "react-stockcharts/lib/series";
import { XAxis, YAxis } from "react-stockcharts/lib/axes";
import { fitWidth } from "react-stockcharts/lib/helper";
import { BarSeries } from "react-stockcharts/lib/series";
import {
	CrossHairCursor,
	MouseCoordinateX,
	MouseCoordinateY,
} from "react-stockcharts/lib/coordinates";

class AreaChartWithYPercent extends React.Component {
	render() {

		const { data, type, width, ratio } = this.props;

    if(!data ||  data.length===0){
      console.log('no data', data);
      return (<div>no data</div>);
    }

		return (
			<ChartCanvas ratio={ratio} width={width} height={400}
					margin={{ left: 50, right: 50, top: 10, bottom: 30 }}
					seriesName="MSFT"
					data={data} type={type}
					xAccessor={d => d.date}
					xScale={scaleTime().range([10,50])}
					xExtents={[new Date(2018, 5, 25), new Date(2018, 5, 28)]}>

				<Chart id={0} yExtents={d => d.close}>
					<XAxis axisAt="bottom" orient="bottom" ticks={6}/>
					<YAxis axisAt="left" orient="left" />

          <MouseCoordinateY
						at="right"
						orient="right"
						displayFormat={format(".2f")}
					/>

          <AreaSeries yAccessor={d => d.close}/>

				</Chart>
        <Chart id={2}
					yExtents={d => d.volume}
					height={150} origin={(w, h) => [0, h - 150]}
				>
					<YAxis axisAt="right" orient="right" ticks={5} tickFormat={format(".2s")}/>

          <MouseCoordinateX
						at="bottom"
						orient="bottom"
						displayFormat={timeFormat("%Y-%m-%d")} />
					<MouseCoordinateY
						at="left"
						orient="left"
						displayFormat={format(".4s")} />

					<BarSeries yAccessor={d => d.volume} fill={d => d.close > d.open ? "#6BA583" : "#FF0000"} />
				</Chart>
        <CrossHairCursor />
			</ChartCanvas>

		);
	}
}

AreaChartWithYPercent.propTypes = {
	data: PropTypes.array.isRequired,
	width: PropTypes.number.isRequired,
	ratio: PropTypes.number.isRequired,
	type: PropTypes.oneOf(["svg", "hybrid"]).isRequired,
};

AreaChartWithYPercent.defaultProps = {
	type: "svg",
};
AreaChartWithYPercent = fitWidth(AreaChartWithYPercent);


export default AreaChartWithYPercent;
