package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

//import java.util.Scanner;


public interface Comando {
	/**
	 * esecuzione del comando
	 * @param partita
	 */
	public void esegui(Partita partita);
	/**
	 * set parametro del comando
	 * @param parametro
	 */
	public void setParametro(String parametro);
	/**
	 * restituisce il parametro
	 */
	public String getParametro();
	
	public String getNome();
	
	/**
	 * Metodo accessorio non utilizzato.
	 * @return la IO attuale del comando
	 */
	public IO getIO();
	/**
	 * prende come parametro la IO per renderla utilizzabile al comando
	 * @param IO
	 */
	public void setIo(IO io);
	
   
}