package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	private IO io;


	@Override
	public void esegui(Partita partita) {
		if(io!=null)io.mostraMessaggio("Grazie di aver giocato!");
		partita.setFinita();
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}
	@Override
	public String getParametro() {
		return null;
	}
	@Override
	public String getNome() {
		return "fine";
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