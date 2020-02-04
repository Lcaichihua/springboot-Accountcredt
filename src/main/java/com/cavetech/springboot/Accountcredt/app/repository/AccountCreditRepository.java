package com.cavetech.springboot.Accountcredt.app.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.cavetech.springboot.Accountcredt.app.domain.AccountCredit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AccountCreditRepository extends ReactiveMongoRepository<AccountCredit, String>{
	//public  Flux<AccountBank> findxClient(Client Client);
	
	@Query("{'client.id' : ?0 , 'client.type.id' : ?1 , 'accountbank.id' : ?2}")
	public Flux<AccountCredit> buscarPorCodigoTipoClienteIdTipoProducto(String idCliente, Integer codigoTipoCliente, Integer idTipoProducto);

	public Mono<AccountCredit> findByNumcount( String numcount);
	
}
