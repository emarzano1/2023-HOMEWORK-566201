package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {

		this.pesoMax = DEFAULT_PESO_MAX_BORSA;
		this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
		this.numeroAttrezzi = 0;
	}
	/**
	 * Aggiunge un attrezzo nella borsa
	 * @param attrezzo
	 * @return true se è stato aggiunto, false altrimenti
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null)
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;

		return true;
	}
	/**
	 * 
	 * @return restituisce il peso massimo sostenibile dalla borsa
	 */
	public int getPesoMax() {
		return pesoMax;
	}
	/**
	 * Controlla se il nome dell'attrezzo nel parametro corrisponde ad un attrezzo nella borsa
	 * @param nomeAttrezzo
	 * @return attrezzo richiesto, altrimenti null
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {

		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i] != null && this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a = attrezzi[i];
				}
		return a;
	}
	/**
	 * Calcola il peso corrente della borsa ad ogni sua invocazione
	 * @return peso della borsa aggiornato
	 */
	public int getPeso() {

		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		return peso;
	}
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		for (Attrezzo attrezzo : this.attrezzi) {
			if(nomeAttrezzo!=null && attrezzo != null) {
				if (attrezzo.getNome().equals(nomeAttrezzo)) 
					trovato = true;
				

			}
		}
		return trovato;
	}

	public boolean removeAttrezzo(String attrezzo) {
		if(attrezzo == null || this.numeroAttrezzi==0 || !this.hasAttrezzo(attrezzo))
			return false;

		Attrezzo attrezzoDaRimuovere=this.getAttrezzo(attrezzo);
		for(int i=0; i<this.numeroAttrezzi; i++) {
			if(this.attrezzi[i] !=null && this.attrezzi[i].equals(attrezzoDaRimuovere) && i<numeroAttrezzi-1) {
				this.attrezzi[i]=this.attrezzi[i+1];
				this.numeroAttrezzi--;
				return true;
				}
			}
		this.numeroAttrezzi--;
		return true;
	}
	public String toString() {

		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	public int getNumAttrezzi() {
		return this.numeroAttrezzi;
	}

}