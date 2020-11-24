package ar.edu.unlam.pb220202c.eva03;

public class Camion extends Vehiculo implements Imultable{
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los que crean conveniente
	
	//el Limite de velociadad para autos es de 80km
	//en caso que supere dicho limite el este sera multado
	private Integer cantidadDeEjes;
	private static final Integer LimiteDeVelocidad = 130;
	
	public Camion(String patente, Integer velocidadActual, Integer cantidadDeEjes) {
		super(patente, velocidadActual, LimiteDeVelocidad);
		this.cantidadDeEjes=cantidadDeEjes;
	}

	public Integer getCantidadDeEjes() {
		return cantidadDeEjes;
	}



	@Override
	public Boolean enInfraccion() {
		if(this.getVelocidadActual()>this.getLimiteVelocidad()) {
			return true;
		}
		return false;
	}

	
}
