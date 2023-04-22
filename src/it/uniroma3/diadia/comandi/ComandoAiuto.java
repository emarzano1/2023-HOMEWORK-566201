package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	static final private String[] elencoComandi = {"vai + <direzione>", "aiuto", "fine", "prendi + <nomeAttrezzo>", "posa + <nomeAttrezzo>", "guarda"};
	
	private IO io;



	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			if(io!=null)io.mostraMessaggio(elencoComandi[i]+" ");
		if(io!=null)io.mostraMessaggio(" ");
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