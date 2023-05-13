package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	

	private String attrezzoIlluminante;

	public StanzaBuia(String nome) {
		super(nome);
		attrezzoIlluminante=null;
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoIlluminante))
			return this.toString();
		else
			return ("qui c'è buio ");
	}
	public StanzaBuia setAttrezzoIlluminante(String nomeAttrezzo) {
		this.attrezzoIlluminante=nomeAttrezzo;
		return this;
	}
	

}
