package ar.edu.unlam.pb220202c.eva03;

public abstract class Vehiculo implements Imultable,Comparable<Vehiculo>{

	//Se debe crear contructeres getters y Setters y loos que crean convenientes
	private String patente;
	private Integer velocidadActual;
	private Integer limiteVelocidad;
	private Boolean autoMultado=false;

	
	
	public Vehiculo(String patente, Integer velocidadActual, Integer limiteVelocidad) {
		super();
		this.patente = patente;
		this.velocidadActual = velocidadActual;
		this.limiteVelocidad = limiteVelocidad;
	}

	public String getPatente() {
		return patente;
	}


	public Integer getVelocidadActual() {
		return velocidadActual;
	}


	public Integer getLimiteVelocidad() {
		return limiteVelocidad;
	}
	
	

	public Boolean getAutoMultado() {
		return autoMultado;
	}

	public void incrmentarVelocidad(Integer velocidad) {
	
		if(this.limiteVelocidad>=velocidad && this.velocidadActual<velocidad) {
			this.velocidadActual=velocidad;
			this.autoMultado=true;
		}	
	}

	public int compareTo(Vehiculo otroVehiculo) {
		return this.patente.compareTo(otroVehiculo.patente);
	}
	
	
}
