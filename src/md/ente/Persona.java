package md.ente;

public class Persona extends Ente {
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
