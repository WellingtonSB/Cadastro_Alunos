package wsb.com.cadastroFuncionarios.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wsb.com.cadastroFuncionarios.Model.Escolas;
import wsb.com.cadastroFuncionarios.Repository.EscolasRepository;

@RestController
@RequestMapping("/escola")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class EscolasController {

	@Autowired
	private EscolasRepository repository;

	@GetMapping
	public ResponseEntity<List<Escolas>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Escolas> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/cep/{cep}")
	public ResponseEntity<List<Escolas>> GetByCep(@PathVariable String cep) {
		return ResponseEntity.ok(repository.findAllByCep(cep));
	}

	@PostMapping
	public ResponseEntity<Escolas> post(@RequestBody Escolas escolas) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(escolas));
	}

	@PutMapping
	public ResponseEntity<Escolas> put(@RequestBody Escolas escolas) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(escolas));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {

	}

}
