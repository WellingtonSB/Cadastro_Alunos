package wsb.com.cadastroFuncionarios.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wsb.com.cadastroFuncionarios.Model.Escolas;

@Repository
public interface EscolasRepository extends JpaRepository<Escolas, Long> {
	public List<Escolas> findAllByNomeContainingIgnoreCase(String nome);

	public List<Escolas> findAllByCep(String cep);

}
