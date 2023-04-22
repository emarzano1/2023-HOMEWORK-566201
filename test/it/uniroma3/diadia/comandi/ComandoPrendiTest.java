package it.uniroma3.diadia.comandi;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

	private Partita session;
	private Stanza stanzaCorrente;
	private Attrezzo chiave;
	private Comando prendi;
	private FabbricaDiComandi factory;

	
	@Before
	public void setUp() {
		session= new Partita();
		chiave= new Attrezzo("chiave",1);
		stanzaCorrente = session.getStanzaCorrente();
		stanzaCorrente.addAttrezzo(chiave);
		prendi= new ComandoPrendi();
		factory= new FabbricaDiComandiFisarmonica();


	}

	@Test
	public void testEseguiComandoPrendiConParametro() {
		assertNull(session.getGiocatore().getBorsa().getAttrezzo("chiave"));
		prendi= factory.costruisciComando("prendi chiave");
		prendi.esegui(this.session);
		assertEquals("Errore,dovrebbe stampare chiave",chiave, session.getGiocatore().getBorsa().getAttrezzo("chiave"));

	
	}
	@Test
	public void testEseguiComandoSenzaParametro() {
		assertEquals(0,session.getGiocatore().getBorsa().getNumAttrezzi());
		prendi= factory.costruisciComando("prendi");
		prendi.esegui(this.session);
		assertEquals(0,session.getGiocatore().getBorsa().getNumAttrezzi());

	
	}

}
