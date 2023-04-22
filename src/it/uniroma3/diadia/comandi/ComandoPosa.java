package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	
	private String attrezzo;
	private IO io;

	@Override
	public void esegui(Partita partita) {
		if(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
			Attrezzo attrezzoPosato=partita.getGiocatore().getBorsa().getAttrezzo(attrezzo);
			if(partita.getStanzaCorrente().addAttrezzo(attrezzoPosato)){
				if(partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo)) 
					if(io!=null)io.mostraMessaggio("è stato posato nella stanza");
			}
			else
				if(io!=null)io.mostraMessaggio("Spiacente stanza piena");}
		else
			if(io!=null)io.mostraMessaggio("Oggetto non presente");

	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo=parametro;

	}
	@Override
	public String getParametro() {
		return attrezzo;
	}
	@Override
	public String getNome() {
		return "posa";
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