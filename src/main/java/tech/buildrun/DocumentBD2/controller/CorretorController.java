package tech.buildrun.DocumentBD2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import tech.buildrun.DocumentBD2.entity.Corretor;

@RestController
@RequestMapping("/corretor")
public class CorretorController {

	@Autowired
	private DynamoDbTemplate dynamoDbTeamplate;


	@PostMapping
	public ResponseEntity<Corretor> createCorretor(@RequestBody Corretor imobiliaria) {
		dynamoDbTeamplate.save(imobiliaria);
		return ResponseEntity.ok(imobiliaria);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Corretor> getCorretor(@PathVariable String id) {
		var entity = dynamoDbTeamplate.load(Key.builder().partitionValue(id).build(), Corretor.class);
		return entity == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(entity);
	}
	
	
	@PutMapping("/{id}")
    public ResponseEntity<Corretor> updateCorretor(@PathVariable String id, @RequestBody Corretor corretorAtualizado) { 	
		Corretor corretorExistente = dynamoDbTeamplate.load(
				Key.builder()
				.partitionValue(id).build(),
				Corretor.class);
		
		if(corretorExistente == null) {
			return ResponseEntity.notFound().build();
			
		}
		
		corretorExistente.setEmail(corretorAtualizado.getEmail());
		corretorExistente.setNome(corretorAtualizado.getNome());
		corretorExistente.setTelefone(corretorAtualizado.getTelefone());
		corretorExistente.setImoveis(corretorAtualizado.getImoveis());
		
		
		dynamoDbTeamplate.save(corretorExistente);
		return ResponseEntity.ok(corretorExistente);
    }


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCorretor(@PathVariable String id) {
		Corretor corretorExistente = dynamoDbTeamplate.load(
				Key.builder()
				.partitionValue(id).build(),
				Corretor.class);
		
		
		if (corretorExistente != null) {
			dynamoDbTeamplate.delete(corretorExistente);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}