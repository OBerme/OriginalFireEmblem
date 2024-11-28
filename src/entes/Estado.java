package entes;

public class Estado {
	private StateSerVivo tipoEstado;
	public Estado(StateSerVivo tipoEstado) {
		this.tipoEstado = tipoEstado;
	}
	public StateSerVivo getTipoEstado() {
		return this.tipoEstado;
	}
	public void accionEstado() {
		System.out.println("Acción de estado: " + this.tipoEstado);
	}
}
