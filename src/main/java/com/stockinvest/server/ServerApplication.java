package com.stockinvest.server;

import com.stockinvest.stock.NetfondsDataSource;
import com.stockinvest.stock.StockPriceDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@SpringBootApplication(scanBasePackages = { "com.stockinvest"}  )
public class ServerApplication {

	@Value("${useMockData}")
	private Boolean useMockData;

	@Bean
	public StockPriceDataSource stockPriceDataSource(){
		if(useMockData){
			return new NetfondsDataSource(ServerApplication.class.getClassLoader().getResource("nas-20180627.csv").toString());
		}
		return new NetfondsDataSource();
	}

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
}
