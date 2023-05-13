package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	static final String  MESSAGGIO_AIUTO ="vai + <direzione>    aiuto    fine    prendi + <nomeAttrezzo>    posa + <nomeAttrezzo>    guarda";
	
	private IO io;



	@Override
	public void esegui(Partita partita) {

	io.mostraMessaggio(MESSAGGIO_AIUTO);
	}
	

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}


	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getNome() {
		return "aiuto";
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