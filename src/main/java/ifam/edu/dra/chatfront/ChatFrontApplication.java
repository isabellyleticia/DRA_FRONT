package ifam.edu.dra.chatfront;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import ifam.edu.dra.chatfront.model.Contato;

@SpringBootApplication
public class ChatFrontApplication {

	private static final Logger log = LoggerFactory.getLogger(ChatFrontApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ChatFrontApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Contato contato = restTemplate.getForObject("http://localhost:8080/contato/1", Contato.class);
			log.info(contato.toString());
		};
	}
}
