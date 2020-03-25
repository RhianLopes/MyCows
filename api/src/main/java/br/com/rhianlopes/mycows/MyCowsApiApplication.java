package br.com.rhianlopes.mycows;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableSwagger2
@EnableFeignClients
@SpringBootApplication
public class MyCowsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCowsApiApplication.class, args);
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Belem"));
	}
}
