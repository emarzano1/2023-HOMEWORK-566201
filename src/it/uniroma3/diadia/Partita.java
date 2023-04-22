package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private String[] percorso;
	private int numStanzeVisitate;
	
	public Partita(){
		labirinto= new Labirinto();
		this.finita = false;
		stanzaCorrente= labirinto.getStanzaCorrente();
		stanzaVincente= labirinto.getStanzaVincente();
		giocatore= new Giocatore();
		percorso= new String[20];						//tiene i nomi delle stanze attraversate.
		numStanzeVisitate=0;
	}

    
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 *  
	 * @return vero se partita vinta
	 */
	
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}
	/**
	 * 
	 * @return la stanza vincente
	 */
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
/**
 * 
 * @return restituisce la stanza corrente
 */
	public Stanza getStanzaCorrente() {
		return stanzaCorrente ;
	}
/**
 * 
 * @return il giocatore
 */
	public Giocatore getGiocatore(){
		return giocatore;
	}
	/**
	 * aggiorna la stanza corrente con la prossima stanza 
	 * @param prossimaStanza
	 */
	public void setStanzaCorrente(Stanza prossimaStanza) {
		this.percorso[numStanzeVisitate++]=prossimaStanza.getNome();
		this.stanzaCorrente=prossimaStanza;
		
	}



	public boolean giocatoreIsVivo() {
		return (this.giocatore.getCfu()>0);
		
	}
	/**
	 * Restituisce un array si stringhe con i nomi delle stanze attraversate.
	 * @param tappe cioè il numero di stanze attraversate
	 * @return	percorso String[]
	 */
	public String getPercorso(int tappe) {
		return this.percorso[tappe];
	}
}