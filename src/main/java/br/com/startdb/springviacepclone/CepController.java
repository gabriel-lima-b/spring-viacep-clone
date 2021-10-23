package br.com.startdb.springviacepclone;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gabriel Lima Brito da Silva
 * 
 */

@RestController
@CrossOrigin(exposedHeaders = "errors,content-type")
public class CepController {

	private CepRepository cepRepository;

	@RequestMapping(value = "/{cep}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Cep> getCep(@PathVariable("cep") String cep) {
		// save a few ceps
		cepRepository.save(new Cep("90420020", "Rua Professor Álvaro Alvim", "", "Rio Branco", "Porto Alegre", "RS",
				"4314902", "", "51", "8801"));
		cepRepository.save(new Cep("91530080", "Rua Oswaldo Pereira de Freitas", "", "Partenon", "Porto Alegre", "RS",
				"4314902", "", "51", "8801"));
		cepRepository.save(new Cep("90050100", "Rua General Lima e Silva", "até 868 - lado par", "Centro Histórico",
				"Porto Alegre", "RS", "4314902", "", "51", "8801"));
		cepRepository.save(new Cep("91530034", "Rua Professor Cristiano Fischer", "de 1900 ao fim - lado par",
				"Partenon", "Porto Alegre", "RS", "4314902", "", "51", "8801"));
		cepRepository.save(
				new Cep("91530010", "Rua Albion", "", "Partenon", "Porto Alegre", "RS", "4314902", "", "51", "8801"));

		Cep cepObj = cepRepository.findByCep(cep);
		if (cep == null) {
			return new ResponseEntity<Cep>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cep>(cepObj, HttpStatus.OK);
	}
}