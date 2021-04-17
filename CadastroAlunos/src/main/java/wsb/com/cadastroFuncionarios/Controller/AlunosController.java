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

import wsb.com.cadastroFuncionarios.Model.Alunos;
import wsb.com.cadastroFuncionarios.Model.Coordenador;
import wsb.com.cadastroFuncionarios.Repository.AlunosRepository;
import wsb.com.cadastroFuncionarios.Service.AlunosService;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class AlunosController {

	@Autowired
	private AlunosRepository repository;

	@Autowired
	private AlunosService service;

	@GetMapping
	public ResponseEntity<List<Alunos>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Alunos> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Alunos>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}

	@GetMapping("/matricula/{matricula}")
	public ResponseEntity<List<Alunos>> GetByMatricula(@PathVariable String matricula) {
		return ResponseEntity.ok(repository.findAllByMatricula(matricula));
	}

	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<List<Alunos>> GetByCpf(@PathVariable String cpf) {
		return ResponseEntity.ok(repository.findAllByCpf(cpf));
	}

	@PostMapping
	public ResponseEntity<Alunos> post(@RequestBody Alunos produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarProduto(produto));
	}

	@PutMapping
	public ResponseEntity<Alunos> put(@RequestBody Alunos produto) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {

	}

}
