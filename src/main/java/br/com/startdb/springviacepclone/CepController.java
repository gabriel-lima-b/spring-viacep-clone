package br.com.startdb.springviacepclone;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private CepRepository cepRepository;

	@RequestMapping(value = "/{cep}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Cep> getCep(@PathVariable("cep") String cep) {
		Cep cepObj = cepRepository.findByCep(cep);
		if (cep == null) {
			return new ResponseEntity<Cep>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cep>(cepObj, HttpStatus.OK);
	}
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Cep> getAllCep() {
		return cepRepository.findAll();
	}
}