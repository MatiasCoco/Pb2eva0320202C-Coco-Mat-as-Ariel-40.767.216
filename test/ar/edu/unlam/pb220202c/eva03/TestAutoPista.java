package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestAutoPista {
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		
		Autopista autopista = new Autopista();
		Vehiculo ford = new Automovil("abc 123",100);
		
		autopista.agregarAutoACirculacion(ford);
		assertEquals(true, autopista.registrarTelepase(100, ford));
	}
	
	@Test(expected = VehiculoNotFounException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFounException {
		
		Autopista autopista = new Autopista();
		Vehiculo ford = new Automovil("abc 123",100);
		
		autopista.salirAutpista(ford);
	}
	
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente(){
		
		Autopista autopista = new Autopista();
		Vehiculo primero = new Automovil("aaa 123",300);
		Vehiculo segundo = new Automovil("bbb 123",300);
		Vehiculo ultimo = new Automovil("ccc 123",300);
		
		autopista.agregarAutoACirculacion(ultimo);
		autopista.agregarAutoACirculacion(segundo);
		autopista.agregarAutoACirculacion(primero);
		
		String primeroEsperado = primero.getPatente();
		String ultimoEsperado = ultimo.getPatente();
		
		String primeroObtenido = autopista.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().first().getPatente();
		String ultimoObtenido =autopista.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().last().getPatente();
		assertEquals(primeroEsperado,primeroObtenido);
		assertEquals(ultimoEsperado,ultimoObtenido);
		
	}
	
	@Test
	public void queIngreseALaAutopistaUnAutoConTelepase() {

		Autopista autopista = new Autopista();
		Vehiculo ford = new Automovil("abc 123",100);
		
		autopista.agregarAutoACirculacion(ford);
		autopista.registrarTelepase(111, ford);
		
		try {
			assertEquals(true, autopista.ingresarAutopista(111));
		} catch (VehiculoNotFounException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void cantidadDeAutosEnCirculacion() {
		
		Autopista autopista = new Autopista();
		Vehiculo primero = new Automovil("aaa 123",300);
		Vehiculo segundo = new Automovil("bbb 123",300);
		Vehiculo ultimo = new Automovil("ccc 123",300);
		
		autopista.agregarAutoACirculacion(ultimo);
		autopista.agregarAutoACirculacion(segundo);
		autopista.agregarAutoACirculacion(primero);
		Integer valorEsperado=3;
		
		assertEquals(valorEsperado, autopista.cantidadDeVehiculosENCirculacion());
	}
	
}
