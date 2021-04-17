package wsb.com.cadastroFuncionarios.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wsb.com.cadastroFuncionarios.Model.Alunos;
import wsb.com.cadastroFuncionarios.Repository.AlunosRepository;

@Service
public class AlunosService {
	Random aleatorio = new Random(9000);

	@Autowired
	private AlunosRepository repository;

	public Alunos cadastrarProduto(Alunos alunos) {

		List<Alunos> listaAlunos = repository.findAll();

		int last = listaAlunos.size() - 1;

		if (listaAlunos.size() != 0) {

			alunos.setMatricula(listaAlunos.get(last).getMatricula() + aleatorio.nextInt(999));

			repository.save(alunos);
		} else {
			alunos.setMatricula(2021);
			repository.save(alunos);
		}
		return alunos;
	}
}
