package jp.co.timepage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "jp.co.timepage.mybatis.mapper")
@SpringBootApplication
public class TimePageApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimePageApplication.class, args);
	}
}
