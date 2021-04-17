package wsb.com.cadastroFuncionarios.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wsb.com.cadastroFuncionarios.Model.Diretor;
import wsb.com.cadastroFuncionarios.Model.DiretorLogin;
import wsb.com.cadastroFuncionarios.Repository.DiretorRepository;
import wsb.com.cadastroFuncionarios.Service.DiretorService;

@RestController
@RequestMapping("/direcao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DiretorController {

	@Autowired
	private DiretorRepository repository;

	@Autowired
	private DiretorService service;

	@PostMapping("/logar")
	public ResponseEntity<DiretorLogin> Autentication(@RequestBody Optional<DiretorLogin> user) {
		return service.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Diretor> Post(@RequestBody Diretor diretoria) {
		Optional<Diretor> user = service.CadastrarUsuario(diretoria);
		try {
			return ResponseEntity.ok(user.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

}
