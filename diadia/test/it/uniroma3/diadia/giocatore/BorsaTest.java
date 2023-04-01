package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

	private Borsa borsaVuota;
	private Borsa borsaPiena;
	private Attrezzo palo;
	private Attrezzo arma;

	
	@Before
	public  void setUp() {
		borsaPiena= new Borsa();
		borsaVuota= new Borsa();
		this.palo= new Attrezzo("palo", 10);
		this.arma= new Attrezzo("arma", 4);
		this.borsaPiena.addAttrezzo(palo);

		
	}
	
	

	@Test
	public void testRemoveAttrezzoBorsaVuota() {
		assertEquals("Errore, non c'è il palo", false , this.borsaVuota.removeAttrezzo("palo"));
	}


	
	@Test
	public void testRemoveAttrezzoBorsaPiena() {
		assertEquals("Errore, l'attrezzo è presente e la borsa è piena", true , this.borsaPiena.removeAttrezzo("palo"));

	}
	
	@Test
	public void testRemoveAttrezzoBorsaPienaAttrezzoNonPresente() {
		assertEquals("Errore, l'attrezzo è presente e la borsa è piena", false , this.borsaPiena.removeAttrezzo("arma"));

	}
	/**
	 * Test metodo addAttrezzo
	 */

	@Test
	public void testAddAttrezzoBorsaPiena() {

		assertEquals("Errore, non avrebbe potuto aggiungerlo", false , this.borsaPiena.addAttrezzo(arma));

	}

	@Test
	public void testAddAttrezzoBorseVuota() {
		assertEquals("Errore, avrebbe dovuto aggiungerlo", true, this.borsaVuota.addAttrezzo(arma));

	}

	@Test
	public void testAddAttrezzoSenzaAttrezzo() {
		assertEquals("Errore, non hai aggiunto nessun attrezzo", false, this.borsaVuota.addAttrezzo(null));
	}


	/**
	 * Test metodo hasAttrezzo
	 */

	@Test
	public void testHasAttrezzoConAttrezzoPresente() {
		assertEquals("Errore, l'attrezzo è presente", true, this.borsaPiena.hasAttrezzo("palo"));
	}

	@Test
	public void testHasAttrezzoConAttrezzoNonPresente() {
		assertEquals("Errore, l'attrezzo non è presente", false, this.borsaPiena.hasAttrezzo("joint"));
	}
	@Test
	public void testHasAttrezzoConAttrezzoNonPresenteBis() {
		assertEquals("Errore, non ci sono proprio attrezzi qui", false, this.borsaVuota.hasAttrezzo("joint"));
	}

	@Test
	public void testHasAttrezzoConAttrezzoSconosciuto() {
		assertEquals("Errore, l'attrezzo non esiste proprio", false, this.borsaPiena.hasAttrezzo("cravatta"));


	}

	/**
	 * Test metodo getAttrezzo
	 */

	@Test
	public void testGetAttrezzoConAttrezzoPresente() {
		assertEquals("Errore, l'attrezzo è presente", palo , this.borsaPiena.getAttrezzo("palo"));
	}

	@Test
	public void testGetAttrezzoConAttrezzoNonPresente() {
		assertEquals("Errore, l'attrezzo non è presente", null, this.borsaPiena.getAttrezzo("joint"));
	}
	@Test
	public void testGetAttrezzoConAttrezzoNonPresenteBis() {
		assertEquals("Errore, non ci sono proprio attrezzi qui", null, this.borsaVuota.getAttrezzo("joint"));
	}


	@Test
	public void testGetAttrezzoConAttrezzoSconosciuto() {
		assertEquals("Errore, l'attrezzo non esiste proprio", null , this.borsaPiena.getAttrezzo("cravatta"));


	}
	
}