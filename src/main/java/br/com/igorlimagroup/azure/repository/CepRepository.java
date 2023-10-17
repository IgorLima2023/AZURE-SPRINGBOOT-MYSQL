package br.com.igorlimagroup.azure.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface CepRepository {
	
	@GetMapping("{cep}/json")
	String getEnderecoPorCep(@PathVariable("cep") String cep);
	
}
