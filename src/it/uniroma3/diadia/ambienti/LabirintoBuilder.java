package it.uniroma3.diadia.ambienti;


import java.util.LinkedList;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder implements Labirinto{
	
	private Stanza stanzaIngresso;
	private Stanza stanzaVincente;
	private Stanza stanzaCorrente;
	private Stanza ultimaStanzaAggiunta;

	private LinkedList<Stanza> labirintoCostruito;

	
	public LabirintoBuilder() {
		
		init();
	}
	@Override
	public void init() {
		labirintoCostruito= new LinkedList<Stanza>();
	}

	public LabirintoBuilder addStanzaIniziale(String nomeStanza){
		this.stanzaIngresso=new Stanza(nomeStanza);
		labirintoCostruito.add(stanzaIngresso);
		stanzaCorrente=stanzaIngresso;
		return this;

	}
	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		this.stanzaVincente= new Stanza(nomeStanza);
		labirintoCostruito.addLast(stanzaVincente);
		stanzaCorrente=stanzaVincente;
		return this;
	}
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo,int peso) {
		if(labirintoCostruito.isEmpty() ) 
			this.stanzaVincente.addAttrezzo(new Attrezzo(nomeAttrezzo,peso));
		else 
				labirintoCostruito.get(labirintoCostruito.size()-1).addAttrezzo(new Attrezzo(nomeAttrezzo,peso));
		return this;
		}
	
	public LabirintoBuilder addStanza(String nomeStanza) {
		Stanza nuovaStanza=new Stanza(nomeStanza);
		labirintoCostruito.add(nuovaStanza);
		stanzaCorrente=nuovaStanza;
		ultimaStanzaAggiunta=nuovaStanza;
		return this;
	}
	public LabirintoBuilder addAdiacenza(String nomeStanza, String nomeAdiacenza, String direzione) {
		int index=labirintoCostruito.indexOf(new Stanza(nomeStanza));
		Stanza stanza=this.labirintoCostruito.get(index);
		index=labirintoCostruito.indexOf(new Stanza(nomeAdiacenza));
		Stanza stanzaAdiacente=this.labirintoCostruito.get(index);
		if(stanza!=null && stanzaAdiacente!=null)
			stanza.impostaStanzaAdiacente(direzione, stanzaAdiacente);
			stanzaAdiacente.impostaStanzaAdiacente(getDirezioneOpposta(direzione), stanza);
		return this;
	
	}
	private String getDirezioneOpposta(String direzione) {
		if(direzione=="nord")
			return "sud";
		if(direzione=="sud")
			return "nord";
		if(direzione=="est")
			return "ovest";
		return "est";
	}
	public Labirinto getLabirinto() {

		return this;
	}
	public Stanza getStanza(String nomeStanza) {
		int index=labirintoCostruito.indexOf(new Stanza(nomeStanza));
		return this.labirintoCostruito.get(index);



	}
	@Override
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	@Override
	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	
}
	@Override
	public Stanza getStanzaIniziale() {
		return stanzaIngresso;
	}
	@Override
	public Stanza getUltimaStanzaAggiunta() {
		return ultimaStanzaAggiunta;
	}
	public LabirintoBuilder addStanzaBuia(String nomeStanza, String nomeAttrezzo) {
		Stanza nuovaStanza=new StanzaBuia(nomeStanza).setAttrezzoIlluminante(nomeAttrezzo);
		labirintoCostruito.add(nuovaStanza);
		ultimaStanzaAggiunta=nuovaStanza;
		return this;
	}
	public LabirintoBuilder addStanzaBloccata(String nomeStanza, String passPartout, String dirBloccata) {
		Stanza nuovaStanza=new StanzaBloccata(nomeStanza).setPass(passPartout).setBlocco(dirBloccata);
		labirintoCostruito.add(nuovaStanza);
		ultimaStanzaAggiunta=nuovaStanza;
		
		return this;
	}
	public LabirintoBuilder addStanzaMagica(String nomeStanza, int numSoglia) {
		Stanza nuovaStanza=new StanzaMagica(nomeStanza, numSoglia);
		labirintoCostruito.add(nuovaStanza);
		ultimaStanzaAggiunta=nuovaStanza;
		return this;
	}


}