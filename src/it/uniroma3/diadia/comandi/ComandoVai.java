package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;
	private IO io;

	/**
	 * esecuzione del comando
	 */
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();

		Stanza prossimaStanza= null;
		if(direzione==null) {
			if(io!=null)io.mostraMessaggio("Dove Vuoi andare?\nDevi specificare una direzione");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);

		if(prossimaStanza==null) {
			if(io!=null)io.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		if(io!=null)io.mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}
	@Override
	public void setParametro(String parametro) {
		this.direzione= parametro;
	}
	@Override
	public String getParametro() {
		return direzione;
	}
	@Override
	public String getNome() {
		return "vai";
	}
	@Override
	public IO getIO() {
		return this.io;
		
	}


	@Override
	/**
	 * prende come parametro la IO per renderla utilizzabile al comando
	 */
	public void setIo(IO io) {
		this.io=io;
		
	}

}