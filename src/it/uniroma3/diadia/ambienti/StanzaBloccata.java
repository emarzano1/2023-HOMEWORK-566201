package it.uniroma3.diadia.ambienti;
/**
 * Estensione classe Stanza che, nel caso in cui nella stanza
 * non ci sia un determinato attrezzo,
 * ha una direzione inaccessibile.
 * Normale altrimenti.
 *
 */
public class StanzaBloccata extends Stanza{

	private String vietato;
	private String ovunque;

	public StanzaBloccata(String nome) {
		super(nome);
		vietato=null;
		ovunque=null;
	}
	
	public void setPass(String ovunque) {
		this.ovunque=ovunque;
		
	}

	public void setBlocco(String blocco) {
		this.vietato=blocco;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanza = null;
		if(direzione != null) {
			for(int i=0; i<this.numeroStanzeAdiacenti; i++) {
				if (this.direzioni[i].equals(direzione) && this.direzioni[i].equals(vietato)) {
					if(this.hasAttrezzo(ovunque))
						stanza = this.stanzeAdiacenti[i];
					else
						stanza= this;
				}
				if (this.direzioni[i].equals(direzione) && !this.direzioni[i].equals(vietato))
					stanza = this.stanzeAdiacenti[i];}
		}
		return stanza;
	}
	@Override
	public String getDescrizione() {
		for(int i=0;i<this.direzioni.length; i++)
			if(this.direzioni[i].contentEquals(vietato) && (!this.hasAttrezzo(ovunque))) {
				this.direzioni[i]="Stanza Bloccata";
				return "Stanza Bloccata, sarà necessario forzarla";}
			return this.toString();
	}
}