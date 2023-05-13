package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoPredefinito;
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
	private List<String> percorso;

	
	public Partita() {
		this(new LabirintoPredefinito());
	}
	public Partita(Labirinto labirinto){

		this.labirinto=labirinto;
		this.finita = false;
		stanzaCorrente= this.labirinto.getStanzaIniziale();
		stanzaVincente= this.labirinto.getStanzaVincente();
		giocatore= new Giocatore();
		percorso= new ArrayList<String>();						//tiene i nomi delle stanze attraversate.

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
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto=labirinto;
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
		this.percorso.add(prossimaStanza.getNome());
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
		return this.percorso.get(tappe);
	}
}