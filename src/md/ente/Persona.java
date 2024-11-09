package md.ente;

public class Persona extends SerVivo{
	public Persona(int hp, String name, Estado estado) {
		super(hp, name, estado);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "P";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		if(obj instanceof Persona) {
			return super.equals(obj);
		}
		
		// TODO Auto-generated method stub
		return false;
	}
}
