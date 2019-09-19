package com.wong.upala.ai;

import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 项目启动类
 * @author upala
 */
@SpringBootApplication
@Log4j2
@MapperScan("com.wong.upala.ai.mapper")
@EnableTransactionManagement
public class ScoreEngine {

	public static void main(String[] args) {
		log.info("service start....");
		SpringApplication.run(ScoreEngine.class, args);
		log.info("service done....");
	}

}
