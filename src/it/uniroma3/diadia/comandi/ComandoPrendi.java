package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private String attrezzo;
	private IO io;
	
	@Override
	public void esegui(Partita partita) {

		if(partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
			Attrezzo attrezzoPreso=partita.getStanzaCorrente().getAttrezzo(attrezzo);
			if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPreso)) {
				if(partita.getStanzaCorrente().removeAttrezzo(attrezzo)) {
					if(io!=null)io.mostraMessaggio("L'attrezzo è stato preso e messo nello zaino");

				}
				else
					if(io!=null)io.mostraMessaggio("Ops, non sei riuscito a prenderlo dalla stanza");
			}
			else 
				if(io!=null)io.mostraMessaggio("La borsa cosi non regge, vai oltre il limite di peso");

		}else
			if(io!=null)io.mostraMessaggio("Oggetto non presente");
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