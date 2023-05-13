package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 * 
 */

public class DiaDia{

	public static final String OUTPUT_VITTORIA = "Hai vinto!";


	public static final String OUTPUT_ESAURIMENTO_CFU = "Hai esaurito i CFU...";


	static final public String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";


	private Partita partita;
	private IO io;
	private FabbricaDiComandi factory;


	public DiaDia(Labirinto labirinto, IO io) {
		this.partita= new Partita(labirinto);
		this.io=io;
		this.factory= new FabbricaDiComandiFisarmonica(io);
		
	}


	public void gioca() {
		String istruzione; 
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione=io.leggiRiga();	
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		comandoDaEseguire= factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if(this.partita.vinta())
			io.mostraMessaggio(OUTPUT_VITTORIA);
		if(!this.partita.giocatoreIsVivo())
			io.mostraMessaggio(OUTPUT_ESAURIMENTO_CFU);
		return this.partita.isFinita();
		

	}  
	public Partita getPartita() {
		return this.partita;
	}



	public static void main(String[] argc) {
		IO io= new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addAttrezzo("pc", 2)
				.addStanza("bagno")
				.addAttrezzo("lanterna", 1)
				.addAdiacenza("LabCampusOne", "bagno", "est")
				.addStanza("cucina")
				.addAttrezzo("cucchiaio", 2)
				.addAdiacenza("LabCampusOne", "cucina", "nord")
				.addStanzaBuia("sgabuzzino", "lanterna")
				.addAttrezzo("spadino", 1)
				.addAdiacenza("LabCampusOne", "sgabuzzino", "sud")
				.addStanzaBloccata("tunnel", "spadino", "nord")
				.addAttrezzo("sasso", 2)
				.addAdiacenza("sgabuzzino", "tunnel", "est")
				.addStanzaMagica("narnia", 2)
				.addAdiacenza("tunnel", "narnia", "nord")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Biblioteca", "narnia", "est")
				.addAdiacenza("LabCampusOne","Biblioteca","ovest")
				.getLabirinto();
		DiaDia gioco = new DiaDia(labirinto,io);
		gioco.gioca();
	}
}