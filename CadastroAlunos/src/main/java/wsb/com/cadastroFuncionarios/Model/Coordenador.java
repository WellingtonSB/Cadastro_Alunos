package wsb.com.cadastroFuncionarios.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Coordenador")
public class Coordenador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(min = 5)
	private String nome;

	@OneToMany(mappedBy = "coordenador", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("coordenador")
	private List<Escolas> escolas;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Escolas> getEscolas() {
		return escolas;
	}

	public void setEscolas(List<Escolas> escolas) {
		this.escolas = escolas;
	}

}
