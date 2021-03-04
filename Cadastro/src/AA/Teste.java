package AA;

public class Teste {
	public static void main(String[] args) {
		Pessoa Wellington = new Pessoa("Wellington", 0001);
		Funcionario Pedro = new Funcionario("Pedro", 222, "Ti");
		Pessoa Maria = new Funcionario("Maria", 0002, "Informatica-Dev");
		Pessoa Jessica = new Coordenador("Jessica", 2, "CC");
		System.out.println(Jessica.getMatricula());
		System.out.println(Pedro.getDepartamento());
		System.out.println(Maria.getMatricula());
		System.out.println(Wellington.getNome());

	}

}
