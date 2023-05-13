package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{

	private String vietato;
	private String ovunque;


	public StanzaBloccata(String nome) {
		super(nome);
		vietato=null;
		ovunque=null;


	}



	public StanzaBloccata setPass(String passPartout) {
		this.ovunque=passPartout;
		return this;
	}

	public StanzaBloccata setBlocco(String blocco) {
		this.vietato=blocco;
		return this;	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.contentEquals(vietato) && !this.hasAttrezzo(ovunque)) {
			return this;
		}
		else
			return this.getAdiacenze().get(direzione);
	}

	@Override
	public String getDescrizione() {
		
		if(this.getAttrezzi().get(ovunque)==null && this.getAdiacenze().containsKey(vietato))
			return "Stanza Bloccata, sar� necessario forzarla";
		else
			return this.toString();


	}

}