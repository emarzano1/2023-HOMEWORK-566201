package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	public static final String OUTPUT_PRENDI_SENZA_SUCCESSO = "Oggetto non presente";
	public static final String OUTPUT_LIMITE_BORSA = "La borsa cosi non regge, vai oltre il limite di peso";
	public static final String OUTPUT_PRESA_FALLITA = "Ops, non sei riuscito a prenderlo dalla stanza";
	public static final String OUTPUT_PRENDI_CON_ATTREZZO_IN_STANZA = "L'attrezzo è stato preso e messo nello zaino";
	private String attrezzo;
	private IO io;
	
	@Override
	public void esegui(Partita partita) {

		if(partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
			Attrezzo attrezzoPreso=partita.getStanzaCorrente().getAttrezzo(attrezzo);
			if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPreso)) {
				if(partita.getStanzaCorrente().removeAttrezzo(attrezzo)) {
					if(io!=null)io.mostraMessaggio(OUTPUT_PRENDI_CON_ATTREZZO_IN_STANZA);

				}
				else
					if(io!=null)io.mostraMessaggio(OUTPUT_PRESA_FALLITA);
			}
			else 
				if(io!=null)io.mostraMessaggio(OUTPUT_LIMITE_BORSA);

		}else
			if(io!=null)io.mostraMessaggio(OUTPUT_PRENDI_SENZA_SUCCESSO);
	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo= parametro;

	}
	@Override
	public String getParametro() {
		return attrezzo;
	}
	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public IO getIO() {
		return this.io;
		
	}


	@Override
	public void setIo(IO io) {
		this.io=io;
		
	}

}