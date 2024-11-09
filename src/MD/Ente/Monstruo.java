package MD.Ente;


public class Monstruo extends SerVivo {
	public Monstruo(int hp, String name, Estado estado) {
		super(hp, name, estado);
		// TODO Auto-generated constructor stub
	}
	public void ataqueEspecial() {
		System.out.println(name + "usa un ataque especial");
	}

}
