package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {
	
	private Partita session;
	private Stanza stanzaCorrente;
	private Stanza stanzaProssima;
	private Comando vai;
	private FabbricaDiComandi factory;


	
	@Before
	public void setUp() {
		session= new Partita();

		stanzaCorrente = new Stanza("corrente");
		stanzaProssima = new Stanza("prossima");
		stanzaCorrente.impostaStanzaAdiacente("nord", stanzaProssima);
		session.setStanzaCorrente(stanzaCorrente);
		vai= new ComandoVai();
		factory= new FabbricaDiComandiFisarmonica();
	}

	@Test
	public void testEseguiComandoConParametro() {
		vai= factory.costruisciComando("vai nord");

		vai.esegui(this.session);
		assertEquals("Errore,dovrebbe stampare la prossima stanza",stanzaProssima, session.getStanzaCorrente());

	
	}
	@Test
	public void testEseguiComandoSenzaParametro() {
		vai= factory.costruisciComando("vai");

		vai.esegui(this.session);
		assertEquals("Errore,dovrebbe stampare la stanza corrente",stanzaCorrente, session.getStanzaCorrente());

	
	}
	

}