package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {
	public static final int SOGLIA_MAGICA_DEFAULT = 5;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;

	public StanzaMagica(String nome) {
		this (nome, SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagica(String nome, int sogliaMagica) {
		super(nome);
		contatoreAttrezziPosati=0;
		this.sogliaMagica=sogliaMagica;
	}
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),
				pesoX2);
		return attrezzo;
	}
	@Override 
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if (this.contatoreAttrezziPosati > this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		if (this.numeroAttrezzi<this.attrezzi.length) {
			this.attrezzi[this.numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			return true;

		}
		else return false;

	}

}