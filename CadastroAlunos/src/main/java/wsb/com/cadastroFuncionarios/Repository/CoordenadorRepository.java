package wsb.com.cadastroFuncionarios.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wsb.com.cadastroFuncionarios.Model.Coordenador;

@Repository
public interface CoordenadorRepository extends JpaRepository<Coordenador, Long> {
	public List<Coordenador> findAllByNomeContainingIgnoreCase(String nome);

}
