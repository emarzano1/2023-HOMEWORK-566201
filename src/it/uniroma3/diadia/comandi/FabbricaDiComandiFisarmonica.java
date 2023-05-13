
package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
	


	public static final String GUARDA = "guarda";
	public static final String FINE = "fine";
	public static final String AIUTO = "aiuto";
	public static final String POSA = "posa";
	public static final String PRENDI = "prendi";
	public static final String VAI = "vai";
	
	private String nomeComando;
	private String parametro;
	private Comando comando;
	private IO io;

	public FabbricaDiComandiFisarmonica(IO io) {
		this.nomeComando=null;
		this.parametro = null;
		this.comando = null;
		this.io = io;

	}

	@Override
	
	public Comando costruisciComando (String istruzione) {

		Scanner scannerDiParole = new Scanner(istruzione);

		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();   // seconda parola: eventuale parametro
		if (nomeComando == null)
			comando = new ComandoNonValido();
		else if (nomeComando.equals(VAI))
			comando = new ComandoVai();
		
		else if (nomeComando.equals(PRENDI))
			comando = new ComandoPrendi();
		
		else if (nomeComando.equals(POSA))
			comando = new ComandoPosa();
		
		else if (nomeComando.equals(AIUTO))
			comando = new ComandoAiuto();
		
		else if (nomeComando.equals(FINE))
			comando = new ComandoFine();
		
		else if (nomeComando.equals(GUARDA))
			comando = new ComandoGuarda();
		
		else comando = new ComandoNonValido();
		comando.setIo(io);
		comando.setParametro(parametro);
		scannerDiParole.close();
		return comando;}            
}