package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	private Stanza vuotaMaAdiacente;
	private Stanza stanzaNord;
	private Stanza stanzaSud;
	private Stanza stanzaEst;
	private Stanza stanzaOvest;
	private Attrezzo palo;
	private Attrezzo arma;
	private Attrezzo frusta;
	private Attrezzo spada;
	private Attrezzo pugnale;
	private Attrezzo catena;
	private Attrezzo grimaldello;
	private Stanza ciecaMaPiena;


	private Stanza nulla;

	@Before
	public void setUp() {

		this.stanzaEst= new Stanza("Est");
		this.stanzaOvest= new Stanza("Ovest");
		this.stanzaNord= new Stanza("Nord");
		this.stanzaSud= new Stanza("Sud");
		this.vuotaMaAdiacente= new Stanza("vuota ma adiacente");
		this.vuotaMaAdiacente.impostaStanzaAdiacente("nord", stanzaNord);
		this.vuotaMaAdiacente.impostaStanzaAdiacente("est", stanzaEst);
		this.vuotaMaAdiacente.impostaStanzaAdiacente("sud", stanzaSud);
		this.vuotaMaAdiacente.impostaStanzaAdiacente("ovest", stanzaOvest);
		this.palo= new Attrezzo("palo", 10);
		this.catena= new Attrezzo("catena", 1);
		this.grimaldello=new Attrezzo("grimaldello", 1);
		this.arma= new Attrezzo("arma", 4);
		this.frusta= new Attrezzo("frusta", 3);
		this.spada= new Attrezzo("spada", 1);
		this.pugnale= new Attrezzo("pugnale", 20);
		this.ciecaMaPiena= new Stanza("cieca ma piena");
		this.ciecaMaPiena.addAttrezzo(palo);
		this.ciecaMaPiena.addAttrezzo(arma);
		this.ciecaMaPiena.addAttrezzo(frusta);
		this.ciecaMaPiena.addAttrezzo(spada);

		
		
		this.nulla= new Stanza("Stanza nulla");

	}

	/**
	 * Test metodo getStanzaAdiacente
	 */
	@Test
	public void testAdiacenzeNord() {
		assertEquals("Errore adiacenza Nord",stanzaNord ,this.vuotaMaAdiacente.getStanzaAdiacente("nord"));
	}
	@Test
	public void testAdiacenzeEst() {
		assertEquals("Errore adiacenza Est",stanzaEst ,this.vuotaMaAdiacente.getStanzaAdiacente("est"));
	}
	@Test
	public void testAdiacenzeSud() {
		assertEquals("Errore adiacenza Sud",stanzaSud ,this.vuotaMaAdiacente.getStanzaAdiacente("sud"));
	}
	@Test
	public void testAdiacenzeOvest() {
		assertEquals("Errore adiacenza Ovest",stanzaOvest ,this.vuotaMaAdiacente.getStanzaAdiacente("ovest"));
	}


	/**
	 * Test metodo impostaStanzaAdiacente
	 */


	@Test
	public void testImpostaAdiacenzaNord() {
		this.ciecaMaPiena.impostaStanzaAdiacente("nord", stanzaNord);
		assertEquals("Errore Impostazione adiacenza nord" , stanzaNord , this.ciecaMaPiena.getStanzaAdiacente("nord"));
	}
	@Test
	public void testImpostaAdiacenzaEst() {
		this.ciecaMaPiena.impostaStanzaAdiacente("est", stanzaEst);
		assertEquals("Errore Impostazione adiacenza est" ,stanzaEst , this.ciecaMaPiena.getStanzaAdiacente("est"));
	}
	@Test
	public void testImpostaAdiacenzaSud() {
		this.ciecaMaPiena.impostaStanzaAdiacente("sud", stanzaSud);
		assertEquals("Errore Impostazione adiacenza sud" ,stanzaSud , this.ciecaMaPiena.getStanzaAdiacente("sud"));
	}
	@Test
	public void testImpostaAdiacenzaOvest() {
		this.ciecaMaPiena.impostaStanzaAdiacente("ovest", stanzaOvest);
		assertEquals("Errore Impostazione adiacenza ovest" ,stanzaOvest , this.ciecaMaPiena.getStanzaAdiacente("ovest"));
	}
	@Test
	public void testImpostaAdiacenzaDirezioneNulla() {
		this.ciecaMaPiena.impostaStanzaAdiacente(null, stanzaSud);
		assertEquals("Errore, gli sto dando una direzione nulla", null, this.ciecaMaPiena.getStanzaAdiacente(null));
	}
	@Test
	public void testImpostaAdiacenzaDirezioneErrata() {
		this.ciecaMaPiena.impostaStanzaAdiacente("sdu", stanzaSud);
		assertEquals("Errore, gli sto dando una direzione nulla", stanzaSud, this.ciecaMaPiena.getStanzaAdiacente("sdu"));
	}
	@Test
	public void testImpostaAdiacenzaStanzaNulla() {
		this.ciecaMaPiena.impostaStanzaAdiacente("nord", null);
		assertEquals("Errore, gli sto dando una stanza null", null , this.ciecaMaPiena.getStanzaAdiacente("nord"));
	}
	@Test
	public void testImpostaAdiacenzaNulla() {
		this.ciecaMaPiena.impostaStanzaAdiacente(null, null);
		assertEquals("Errore, tutto nullo", null, this.ciecaMaPiena.getStanzaAdiacente(null));
	}

	/**
	 * Test metodo getDescrizione
	 */

	@Test
	public void testGetDescrizioneVuotaMaAdiacente() {
		assertEquals("Errore Descrizione di vuotaMaAdiacente", "vuota ma adiacente\nUscite:  nord est sud ovest\nAttrezzi nella stanza: ", this.vuotaMaAdiacente.getDescrizione());
	}

	@Test
	public void testGetDescrizioneCiecaMaPiena() {
		assertEquals("Errore Descrizione di ciecaMaPiena", "cieca ma piena\nUscite: \nAttrezzi nella stanza: palo (10kg) arma (4kg) frusta (3kg) spada (1kg) ", this.ciecaMaPiena.getDescrizione());
	}

	@Test 
	public void testGetDescrizioneNulla() {
		assertEquals("Errore Descrizione di nulla", "Stanza nulla\nUscite: \nAttrezzi nella stanza: ", this.nulla.getDescrizione());
	}

	/**
	 * Test metodo addAttrezzo
	 */

	@Test
	public void testAddAttrezzoStanzaPiena() {
		this.ciecaMaPiena.addAttrezzo(catena);
		this.ciecaMaPiena.addAttrezzo(grimaldello);
		assertEquals("Errore, non avrebbe potuto aggiungerlo", false , this.ciecaMaPiena.addAttrezzo(pugnale) );

	}

	@Test
	public void testAddAttrezzoStanzaVuota() {
		assertEquals("Errore, avrebbe dovuto aggiungerlo", true, this.vuotaMaAdiacente.addAttrezzo(catena));

	}

	@Test
	public void testAddAttrezzoSenzaAttrezzo() {
		assertEquals("Errore, non hai aggiunto nessun attrezzo", false, this.vuotaMaAdiacente.addAttrezzo(null));
	}


	/**
	 * Test metodo hasAttrezzo
	 */

	@Test
	public void testHasAttrezzoConAttrezzoPresente() {
		assertEquals("Errore, l'attrezzo è presente", true, this.ciecaMaPiena.hasAttrezzo("spada"));
	}

	@Test
	public void testHasAttrezzoConAttrezzoNonPresente() {
		assertEquals("Errore, l'attrezzo non è presente", false, this.ciecaMaPiena.hasAttrezzo("joint"));
	}
	@Test
	public void testHasAttrezzoConAttrezzoNonPresenteBis() {
		assertEquals("Errore, non ci sono proprio attrezzi qui", false, this.vuotaMaAdiacente.hasAttrezzo("joint"));
	}

	@Test
	public void testHasAttrezzoConAttrezzoSconosciuto() {
		assertEquals("Errore, l'attrezzo non esiste proprio", false, this.ciecaMaPiena.hasAttrezzo("cravatta"));


	}

	/**
	 * Test metodo getAttrezzo
	 */

	@Test
	public void testGetAttrezzoConAttrezzoPresente() {
		assertEquals("Errore, l'attrezzo è presente", "spada (1kg)", this.ciecaMaPiena.getAttrezzo("spada").toString());
	}

	@Test
	public void testGetAttrezzoConAttrezzoNonPresente() {
		assertEquals("Errore, l'attrezzo non è presente", null, this.ciecaMaPiena.getAttrezzo("joint"));
	}
	@Test
	public void testGetAttrezzoConAttrezzoNonPresenteBis() {
		assertEquals("Errore, non ci sono proprio attrezzi qui", null, this.vuotaMaAdiacente.getAttrezzo("joint"));
	}


	@Test
	public void testGetAttrezzoConAttrezzoSconosciuto() {
		assertEquals("Errore, l'attrezzo non esiste proprio", null , this.ciecaMaPiena.getAttrezzo("cravatta"));


	}

	/**
	 * Test metodo removeAttrezzo
	 */

	@Test
	public void testRemoveAttrezzoConAttrezzoPresente() {

		assertEquals("Errore, l'attrezzo era presente", true, this.ciecaMaPiena.removeAttrezzo("spada"));
	}
	@Test
	public void testRemoveAttrezzoConAttrezzoNonPresente() {

		assertEquals("Errore, l'attrezzo non era presente", false , this.ciecaMaPiena.removeAttrezzo("catena"));
	}@Test
	public void testRemoveAttrezzoConAttrezzoNullo() {
		assertEquals("Errore, non gli avevi dato nulla da rimuovere", false, this.ciecaMaPiena.removeAttrezzo(null));
	}
}