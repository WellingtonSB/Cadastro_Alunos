package wsb.com.cadastroFuncionarios.Repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import wsb.com.cadastroFuncionarios.Model.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Long> {
	public List<Diretor> findAllByNomeContainingIgnoreCase(String nome);

	public Optional<Diretor> findByUsuarioAndSenha(String usuario, String senha);

	public Optional<Diretor> findByUsuario(String usuario);
}