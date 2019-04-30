package com.hanson.transform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Hanson create on 2018年3月11日
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.hanson.**.**.mapper")
@ComponentScan(basePackages= {"com.hanson"})
public class TransformBootStarp {
	public static void main(String[] args) {
		SpringApplication.run(TransformBootStarp.class, args);
	}
}