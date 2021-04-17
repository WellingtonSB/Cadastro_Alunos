package wsb.com.cadastroFuncionarios.Controller;

import java.util.List;

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

import wsb.com.cadastroFuncionarios.Model.Coordenador;
import wsb.com.cadastroFuncionarios.Model.Escolas;
import wsb.com.cadastroFuncionarios.Repository.CoordenadorRepository;
import wsb.com.cadastroFuncionarios.Repository.EscolasRepository;

@RestController
@RequestMapping("/coordenador")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class CoordenadorController {

	@Autowired
	private CoordenadorRepository repository;

	@GetMapping
	public ResponseEntity<List<Coordenador>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Coordenador> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Coordenador>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}

	@PostMapping
	public ResponseEntity<Coordenador> post(@RequestBody Coordenador coordenador) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(coordenador));
	}

	@PutMapping
	public ResponseEntity<Coordenador> put(@RequestBody Coordenador coordenador) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(coordenador));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {

	}

}
