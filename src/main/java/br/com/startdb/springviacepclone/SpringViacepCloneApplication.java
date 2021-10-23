package br.com.startdb.springviacepclone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringViacepCloneApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringViacepCloneApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringViacepCloneApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CepRepository repository) {
		return (args) -> {
			// save a few ceps
			repository.save(new Cep("90420020", "Rua Professor Álvaro Alvim", "", "Rio Branco", "Porto Alegre", "RS",
					"4314902", "", "51", "8801"));
			repository.save(new Cep("91530080", "Rua Oswaldo Pereira de Freitas", "", "Partenon", "Porto Alegre", "RS",
					"4314902", "", "51", "8801"));
			repository.save(new Cep("90050100", "Rua General Lima e Silva", "até 868 - lado par", "Centro Histórico",
					"Porto Alegre", "RS", "4314902", "", "51", "8801"));
			repository.save(new Cep("91530034", "Rua Professor Cristiano Fischer", "de 1900 ao fim - lado par",
					"Partenon", "Porto Alegre", "RS", "4314902", "", "51", "8801"));
			repository.save(new Cep("91530010", "Rua Albion", "", "Partenon", "Porto Alegre", "RS", "4314902", "", "51",
					"8801"));

			// fetch all ceps
			log.info("Ceps found with findAll():");
			log.info("-------------------------------");
			for (Cep cep : repository.findAll()) {
				log.info(cep.toString());
			}
			log.info("");

			// fetch an individual cep by ID
			Cep cep = repository.findById(1L);
			log.info("Cep found with findById(1L):");
			log.info("--------------------------------");
			log.info(cep.toString());
			log.info("");

			// fetch cep by cep
			log.info("Cep found with findByCep('91530080'):");
			log.info("--------------------------------------------");
			repository.findByCep("91530080").toString();
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// log.info(bauer.toString());
			// }
			log.info("");
		};
	}
}
