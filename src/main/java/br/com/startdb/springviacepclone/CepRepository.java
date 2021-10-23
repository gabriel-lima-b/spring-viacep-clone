package br.com.startdb.springviacepclone;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CepRepository extends CrudRepository<Cep, Long> {

	Cep findByCep(String cep);
	
	Cep findById(long id);
}
