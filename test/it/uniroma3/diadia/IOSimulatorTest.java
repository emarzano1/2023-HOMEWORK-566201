package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class IOSimulatorTest {

	private DiaDia session;
	private IOSimulator io;
	
	/**
	 * Raccolta di output statici
	 */
	final static private String OUTPUT_INIZIALE= ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	final static private String OUTPUT_FINALE="Grazie di aver giocato!";
	final static private String OUTPUT_NON_VALIDO="Comando non valido";
	final static private String OUTPUT_AIUTO="vai + <direzione> aiuto fine prendi + <nomeAttrezzo> posa + <nomeAttrezzo> guarda  ";
	final static private String OUTPUT_POSA_CON_ATTREZZO_IN_BORSA="� stato posato nella stanza";
	final static private String OUTPUT_POSA_PRENDI_SENZA_SUCCESSO="Oggetto non presente";
	final static private String OUTPUT_PRENDI_CON_ATTREZZO_IN_STANZA="L'attrezzo � stato preso e messo nello zaino";
	final static private String OUTPUT_DIREZIONE_INESISTENTE="Direzione inesistente";
	final static private String OUTPUT_VAI_SENZA_DIREZIONE="Dove Vuoi andare?\nDevi specificare una direzione";
	final static private String OUTPUT_VITTORIA="Hai vinto!";
	final static private String OUTPUT_ESAURIMENTO_CFU="Hai esaurito i CFU...";
	/**
	 * Raccolta output dinamici
	 */
	
	private String outputStanza;
	private String outputBorsa;
	private String outputGuarda;





	@Before

	public void setUp() {

		this.io = new IOSimulator();
		session=new DiaDia(io);


	}

	@Test
	public void testSimulazioneSempliceFine() {

		String[] simulazione= {"fine"};
		this.io.setInput(simulazione);
		session.gioca();
		assertEquals("Errore",OUTPUT_INIZIALE+OUTPUT_FINALE, this.io.getOutput());
	}
	@Test
	public void testSimulazioneSempliceGuarda() {

		String[] simulazione= {"guarda","fine"};
		this.io.setInput(simulazione);
		session.gioca();
		outputStanza=this.session.getPartita().getStanzaCorrente().getDescrizione();
		outputBorsa=this.session.getPartita().getGiocatore().getBorsa().toString();
		outputGuarda=outputStanza+outputBorsa;

		assertEquals("Errore",(outputGuarda+OUTPUT_FINALE), this.io.getOutput().substring(OUTPUT_INIZIALE.length()));
	}
	@Test
	public void testSimulazioneSempliceNonValido() {
		String[] simulazione= {"sbagliato","fine"};
		this.io.setInput(simulazione);
		session.gioca();
		assertEquals("Errore",(OUTPUT_NON_VALIDO+OUTPUT_FINALE), this.io.getOutput().substring(OUTPUT_INIZIALE.length()));
	}
	@Test
	public void testSimulazioneSempliceAiuto() {
		String[] simulazione= {"aiuto","fine"};
		this.io.setInput(simulazione);
		session.gioca();
		assertEquals("Errore",(OUTPUT_AIUTO+OUTPUT_FINALE), this.io.getOutput().substring(OUTPUT_INIZIALE.length()));
	}
	@Test
	public void testSimulazioneSemplicePosaConParametroEAttrezzoInBorsa() {
		Attrezzo attrezzo=new Attrezzo("chiave",1);
		this.session.getPartita().getGiocatore().getBorsa().addAttrezzo(attrezzo);
		String[] simulazione= {"posa chiave","fine"};
		this.io.setInput(simulazione);
		session.gioca();
		assertEquals("Errore",(OUTPUT_POSA_CON_ATTREZZO_IN_BORSA+OUTPUT_FINALE), this.io.getOutput().substring(OUTPUT_INIZIALE.length()));
	}
	@Test
	public void testSimulazioneSemplicePosaConParametroEAttrezzoNonInBorsa() {
		String[] simulazione= {"posa chiave","fine"};
		this.io.setInput(simulazione);
		session.gioca();
		assertEquals("Errore",(OUTPUT_POSA_PRENDI_SENZA_SUCCESSO+OUTPUT_FINALE), this.io.getOutput().substring(OUTPUT_INIZIALE.length()));
	}
	@Test
	public void testSimulazioneSemplicePosaSenzaParametro() {
		String[] simulazione= {"posa","fine"};
		this.io.setInput(simulazione);
		session.gioca();
		assertEquals("Errore",(OUTPUT_POSA_PRENDI_SENZA_SUCCESSO+OUTPUT_FINALE), this.io.getOutput().substring(OUTPUT_INIZIALE.length()));
	}
	@Test
	public void testSimulazioneSemplicePrendiConParametroEAttrezzoInBorsa() {
		Attrezzo attrezzo=new Attrezzo("chiave",1);
		this.session.getPartita().getStanzaCorrente().addAttrezzo(attrezzo);
		String[] simulazione= {"prendi chiave","fine"};
		this.io.setInput(simulazione);
		session.gioca();
		assertEquals("Errore",(OUTPUT_PRENDI_CON_ATTREZZO_IN_STANZA+OUTPUT_FINALE), this.io.getOutput().substring(OUTPUT_INIZIALE.length()));
	}
	@Test
	public void testSimulazioneSemplicePrendiConParametroEAttrezzoNonInBorsa() {
		String[] simulazione= {"prendi chiave","fine"};
		this.io.setInput(simulazione);
		session.gioca();
		assertEquals("Errore",(OUTPUT_POSA_PRENDI_SENZA_SUCCESSO+OUTPUT_FINALE), this.io.getOutput().substring(OUTPUT_INIZIALE.length()));
	}
	@Test
	public void testSimulazioneSemplicePrendiSenzaParametro() {
		String[] simulazione= {"prendi","fine"};
		this.io.setInput(simulazione);
		session.gioca();
		assertEquals("Errore",(OUTPUT_POSA_PRENDI_SENZA_SUCCESSO+OUTPUT_FINALE), this.io.getOutput().substring(OUTPUT_INIZIALE.length()));
	}
	@Test
	public void testSimulazioneSempliceVaiConParametroErrato() {
		String[] simulazione= {"vai piano","fine"};
		this.io.setInput(simulazione);
		session.gioca();
		assertEquals("Errore",(OUTPUT_DIREZIONE_INESISTENTE+OUTPUT_FINALE), this.io.getOutput().substring(OUTPUT_INIZIALE.length()));
	}
	@Test
	public void testSimulazioneSempliceVaiSenzaParametro() {
		String[] simulazione= {"vai","fine"};
		this.io.setInput(simulazione);
		session.gioca();
		assertEquals("Errore",(OUTPUT_VAI_SENZA_DIREZIONE+OUTPUT_FINALE), this.io.getOutput().substring(OUTPUT_INIZIALE.length()));
	}
	@Test 
	public void testSimulazioneSempliceVaiConParametroEsatto() {
		String[] simulazione= {"vai sud","fine"};
		int i=0;
		this.io.setInput(simulazione);
		session.gioca();
		assertEquals("Errore",(this.session.getPartita().getPercorso(i++)+OUTPUT_FINALE),this.io.getOutput().substring(OUTPUT_INIZIALE.length()));

	}@Test 
	/**
	 * se il test � valido per N spostamenti, lo sar� anche per gli N+1 
	 * 				
	 */
	public void testSimulazioneDoppioVaiConParametroEsatto() {
		String[] simulazione= {"vai sud","vai nord","fine"};
		int i=0;
		this.io.setInput(simulazione);
		session.gioca();
		assertEquals("Errore",(this.session.getPartita().getPercorso(i++)+this.session.getPartita().getPercorso(i++)+
					OUTPUT_FINALE),this.io.getOutput().substring(OUTPUT_INIZIALE.length()));

	}
	@Test 
	public void testSimulazioneAttrezzoCambiaStanza() {
		String[] simulazione= {"prendi osso","vai est","posa osso","guarda", "fine"};
		int i=0;
		this.io.setInput(simulazione);
		session.gioca();
		outputStanza=this.session.getPartita().getStanzaCorrente().getDescrizione();
		outputBorsa=this.session.getPartita().getGiocatore().getBorsa().toString();
		outputGuarda=outputStanza+outputBorsa;

		assertEquals("Errore",(OUTPUT_PRENDI_CON_ATTREZZO_IN_STANZA+this.session.getPartita().getPercorso(i++)+
					OUTPUT_POSA_CON_ATTREZZO_IN_BORSA+outputGuarda+OUTPUT_FINALE),this.io.getOutput().substring(OUTPUT_INIZIALE.length()));

	}
	@Test 
	public void testSimulazioneVittoria() {
		String[] simulazione= {"vai sud","vai nord","vai nord"};
		int i=0;
		this.io.setInput(simulazione);
		session.gioca();

		assertEquals("Errore",(this.session.getPartita().getPercorso(i++)+this.session.getPartita().getPercorso(i++)+
					this.session.getPartita().getPercorso(i++)+OUTPUT_VITTORIA),this.io.getOutput().substring(OUTPUT_INIZIALE.length()));

	}
	@Test 
	public void testSimulazioneSconfittaEsaurimentoCFU() {
		String[] simulazione= {"vai sud","vai nord","vai est"};
		int i=0;
		this.session.getPartita().getGiocatore().setCfu(3);
		this.io.setInput(simulazione);
		session.gioca();

		assertEquals("Errore",(this.session.getPartita().getPercorso(i++)+this.session.getPartita().getPercorso(i++)+
					this.session.getPartita().getPercorso(i++)+
					OUTPUT_ESAURIMENTO_CFU),this.io.getOutput().substring(OUTPUT_INIZIALE.length()));

	}
	@Test 
	public void testSimulazioneComandiErrati() {
		String[] simulazione= {"via sia","prova casa","auto","fane","fine"};
		this.io.setInput(simulazione);
		session.gioca();

		assertEquals("Errore",OUTPUT_NON_VALIDO+OUTPUT_NON_VALIDO+OUTPUT_NON_VALIDO+
					OUTPUT_NON_VALIDO+OUTPUT_FINALE,this.io.getOutput().substring(OUTPUT_INIZIALE.length()));

	}
	@Test 
	public void testSimulazioneParametriErrati() {
		String[] simulazione= {"vai via","prendi mele","posa cibo","vai a casa","prendi la prima a destra","fine"};
		this.io.setInput(simulazione);
		session.gioca();

		assertEquals("Errore",OUTPUT_DIREZIONE_INESISTENTE+OUTPUT_POSA_PRENDI_SENZA_SUCCESSO+OUTPUT_POSA_PRENDI_SENZA_SUCCESSO+
					OUTPUT_DIREZIONE_INESISTENTE+OUTPUT_POSA_PRENDI_SENZA_SUCCESSO+
					OUTPUT_FINALE,this.io.getOutput().substring(OUTPUT_INIZIALE.length()));

	}
	@Test 
	public void testSimulazioneUtonto() {
		String[] simulazione= {"vai via","prendi mele","posa cibo","vai a casa","prendi la prima a destra","vai via","prendi mele","posa cibo","vai a casa","prendi la prima a destra","fine"};
		this.io.setInput(simulazione);
		session.gioca();

		assertEquals("Errore",OUTPUT_DIREZIONE_INESISTENTE+OUTPUT_POSA_PRENDI_SENZA_SUCCESSO+
				OUTPUT_POSA_PRENDI_SENZA_SUCCESSO+OUTPUT_DIREZIONE_INESISTENTE+OUTPUT_POSA_PRENDI_SENZA_SUCCESSO+
				OUTPUT_DIREZIONE_INESISTENTE+OUTPUT_POSA_PRENDI_SENZA_SUCCESSO+OUTPUT_POSA_PRENDI_SENZA_SUCCESSO+
				OUTPUT_DIREZIONE_INESISTENTE+OUTPUT_POSA_PRENDI_SENZA_SUCCESSO+OUTPUT_FINALE,this.io.getOutput().substring(OUTPUT_INIZIALE.length()));

	}





}