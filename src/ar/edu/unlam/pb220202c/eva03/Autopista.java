package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;

import java.util.HashSet;
import java.util.TreeSet;


public class Autopista {
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
	private HashMap <Integer,Vehiculo> telepase;
	private HashSet <Vehiculo> vehiculosEnCirculacion;
	
	public Autopista() {
		this.telepase = new HashMap<Integer,Vehiculo>();
		this.vehiculosEnCirculacion=new HashSet<Vehiculo>();
	}

	public Boolean registrarTelepase (Integer numeroTelpase, Vehiculo vehiculo) {
		
		
			if(this.vehiculosEnCirculacion.contains(vehiculo)) {
				
				if(this.telepase.containsKey(numeroTelpase)==false) {
					this.telepase.put(numeroTelpase, vehiculo);
					return true;
				}
			}
		return false;	
	}
	
	public Boolean ingresarAutopista (Integer numeroTelepase) throws VehiculoNotFounException {
		//si el telepase no esta registrado lanza una Exceptios del tipo VehiculoNotFounException
	   // y no permite ingresar al autopista	
	
		if(this.telepase.containsKey(numeroTelepase)==false)
			throw new VehiculoNotFounException("Vehiculo inexistente");
		
		else 
			return true;
		
	}
	
	public void salirAutpista (Vehiculo vehiculo) throws VehiculoNotFounException {
		//lanza Una exception VehiculoNotFounException si no esta en circulacion
		if(this.vehiculosEnCirculacion.contains(vehiculo)==false) {
			throw new VehiculoNotFounException("Vehiculo inexistente");
		}
		
	}
	
	public Boolean agregarAutoACirculacion(Vehiculo vehiculo) {
		return this.vehiculosEnCirculacion.add(vehiculo);
	}
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
		TreeSet<Vehiculo> vehiculosConMultas = new TreeSet<Vehiculo>();
		vehiculosConMultas.addAll(this.vehiculosEnCirculacion);
		
		for(Vehiculo actual : this.vehiculosEnCirculacion) {
			
			if(actual.getAutoMultado()) {
				vehiculosConMultas.remove(actual);
			}
		}	
		return vehiculosConMultas;	
    }

	public Integer cantidadDeVehiculosENCirculacion() {
	
		return this.vehiculosEnCirculacion.size();
}
	}
