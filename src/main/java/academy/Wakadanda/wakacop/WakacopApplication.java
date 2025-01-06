package academy.Wakadanda.wakacop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients(basePackages = "academy.Wakadanda.wakacop.associado.infra.client")
@RequestMapping("/")
public class WakacopApplication {
	@GetMapping
	public String testeHome(){
		return "teste home wakacop";
	}

	public static void main(String[] args) {
		SpringApplication.run(WakacopApplication.class, args);
	}

}
