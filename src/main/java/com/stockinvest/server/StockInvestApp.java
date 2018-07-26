package com.stockinvest.server;

import com.stockinvest.stock.NetfondsDataSource;
import com.stockinvest.stock.StockPriceDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = { "com.stockinvest"}  )
public class StockInvestApp {

	@Value("${useMockData}")
	private Boolean useMockData;

	@Bean
	public StockPriceDataSource stockPriceDataSource(){
		if(useMockData){
			return new NetfondsDataSource(StockInvestApp.class.getClassLoader().getResource("nas-20180627.csv").toString());
		}
		return new NetfondsDataSource();
	}

	public static void main(String[] args) {
		SpringApplication.run(StockInvestApp.class, args);
	}
}
