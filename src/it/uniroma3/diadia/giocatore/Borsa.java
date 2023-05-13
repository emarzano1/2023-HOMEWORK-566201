package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerNome;
import it.uniroma3.diadia.attrezzi.ComparatorePerPeso;
import it.uniroma3.diadia.attrezzi.ComparatorePrimaPesoPoiNome;

public class Borsa   {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() { 
		this(DEFAULT_PESO_MAX_BORSA);

	}

	public Borsa(int pesoMax) { 
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>();

	}
	/**
	 * Aggiunge un attrezzo nella borsa
	 * @param attrezzo
	 * @return true se � stato aggiunto, false altrimenti
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null)
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.add(attrezzo);
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
		
		for (Attrezzo attrezzo:this.attrezzi)
			if (attrezzo != null && attrezzo.getNome().equals(nomeAttrezzo)) 
				 return attrezzo;
		
		return null;
	}
	/**
	 * Calcola il peso corrente della borsa ad ogni sua invocazione
	 * @return peso della borsa aggiornato
	 */
	public int getPeso() {
		int pesoTotale = 0;
		for(Attrezzo a : this.attrezzi)
			pesoTotale += a.getPeso();
		return pesoTotale;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.contains(this.getAttrezzo(nomeAttrezzo));
	}

	public boolean removeAttrezzo(String nomeAttrezzo) {
		if(nomeAttrezzo == null || !this.hasAttrezzo(nomeAttrezzo))
			return false;
		Iterator<Attrezzo> it= this.attrezzi.iterator();
		Attrezzo a=null;
		while(it.hasNext()) {
			a=it.next();
			if(a.getNome().contentEquals(nomeAttrezzo)) {
				it.remove();
				return true;
				}	
		}
		return false;
			
	}
	public String toString() {

		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo attrezzo: this.attrezzi)
				s.append(attrezzo.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	public int getNumAttrezzi() {
		return this.attrezzi.size();
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		ComparatorePerPeso comp =new ComparatorePerPeso();
		Collections.sort(this.attrezzi,comp);
		return this.attrezzi;
			 
	}
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		ComparatorePerNome comp=new ComparatorePerNome();
		TreeSet<Attrezzo> setOrdinato= new TreeSet<Attrezzo>(comp);
		setOrdinato.addAll(attrezzi);
		return setOrdinato;
	}
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){;
		Set<Attrezzo> tmp;
		ComparatorePerNome comp=new ComparatorePerNome();
		Map<Integer,Set<Attrezzo>> contenuto;
		contenuto= new HashMap<Integer,Set<Attrezzo>>();
		for(Attrezzo attrezzo:this.attrezzi) {
			if(contenuto.containsKey(attrezzo.getPeso())){
				tmp=contenuto.get(attrezzo.getPeso());
				tmp.add(attrezzo);
			}
			else {
				tmp=new TreeSet<Attrezzo>(comp);
				tmp.add(attrezzo);
				contenuto.put(attrezzo.getPeso(), tmp);
			}
		}
		
		return contenuto;
	}
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		ComparatorePrimaPesoPoiNome comp=new ComparatorePrimaPesoPoiNome();
		TreeSet<Attrezzo> tmpSortedSet=new TreeSet<Attrezzo>(comp);
		tmpSortedSet.addAll(this.attrezzi);
		return tmpSortedSet;
	
	}

	

}