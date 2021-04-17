package wsb.com.cadastroFuncionarios.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wsb.com.cadastroFuncionarios.Model.Alunos;


@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Long>{
	
	public List<Alunos> findAllByNomeContainingIgnoreCase(String nome);
	public List<Alunos> findAllByMatricula(String matricula);
	public List<Alunos> findAllByCpf(String cpf);
	
}
