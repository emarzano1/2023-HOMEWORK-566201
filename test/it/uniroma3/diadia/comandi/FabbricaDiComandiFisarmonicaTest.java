package it.uniroma3.diadia.comandi;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiFisarmonicaTest {
	
	private FabbricaDiComandi factory;
	private Comando comandoDiTest;

	
	@Before
	public void setUp() {

		factory= new FabbricaDiComandiFisarmonica();
		
	}
	
	@Test
	public void testCostruisciComandoAiuto() {
		comandoDiTest=factory.costruisciComando("aiuto");
		assertEquals("Errore, il nome del comando deve essere quello!", "aiuto", comandoDiTest.getNome());
	}
	@Test
	public void testCostruisciComandoFine() {
		comandoDiTest=factory.costruisciComando("fine");
		assertEquals("Errore, il nome del comando deve essere quello!", "fine", comandoDiTest.getNome());
	}
	@Test
	public void testCostruisciComandoGuarda() {
		comandoDiTest=factory.costruisciComando("guarda");
		assertEquals("Errore, il nome del comando deve essere quello!", "guarda", comandoDiTest.getNome());
	}
	@Test
	public void testCostruisciComandoNonValido() {
		comandoDiTest=factory.costruisciComando("impiccati");
		assertEquals("Errore, il nome del comando deve essere quello!", "comando non valido", comandoDiTest.getNome());
	}
	@Test
	public void testCostruisciComandoVaiSenzaParametro() {
		comandoDiTest=factory.costruisciComando("vai");
		assertEquals("Errore, il nome del comando deve essere quello!", "vai", comandoDiTest.getNome());
		assertNull(comandoDiTest.getParametro());
	}
	@Test
	public void testCostruisciComandoVaiConParametro() {
		comandoDiTest=factory.costruisciComando("vai nord");
		assertEquals("Errore, il nome del comando deve essere quello!", "vai", comandoDiTest.getNome());
		assertEquals("Errore, il parametro deve corrispondere","nord",comandoDiTest.getParametro() );
	}
	@Test
	public void testCostruisciComandoPrendiSenzaParametro() {
		comandoDiTest=factory.costruisciComando("prendi");
		assertEquals("Errore, il nome del comando deve essere quello!", "prendi", comandoDiTest.getNome());
		assertNull(comandoDiTest.getParametro());
	}
	@Test
	public void testCostruisciComandoPrendiConParametro() {
		comandoDiTest=factory.costruisciComando("prendi bottino");
		assertEquals("Errore, il nome del comando deve essere quello!", "prendi", comandoDiTest.getNome());
		assertEquals("Errore, il parametro deve corrispondere","bottino",comandoDiTest.getParametro() );
	}
	@Test
	public void testCostruisciComandoPosaSenzaParametro() {
		comandoDiTest=factory.costruisciComando("posa");
		assertEquals("Errore, il nome del comando deve essere quello!", "posa", comandoDiTest.getNome());
		assertNull(comandoDiTest.getParametro());
	}
	@Test
	public void testCostruisciComandoPosaConParametro() {
		comandoDiTest=factory.costruisciComando("posa malloppo");
		assertEquals("Errore, il nome del comando deve essere quello!", "posa", comandoDiTest.getNome());
		assertEquals("Errore, il parametro deve corrispondere","malloppo",comandoDiTest.getParametro() );
	}
}