package it.uniroma3.diadia;

public class IOSimulator implements IO {
	
	private static final int NUMERO_MASSIMO_OUTPUT = 150;



	private String[] outPut;
	private String[] inPut;
	private int numeroOutPut;
	private int numeroInPut;
	
	public IOSimulator() {
		this.outPut= new String[NUMERO_MASSIMO_OUTPUT];
		this.inPut=new String[NUMERO_MASSIMO_OUTPUT];
		this.numeroOutPut=0;
		this.numeroInPut=0;
		
	}
	@Override
	public void mostraMessaggio(String messaggio) {
		this.outPut[numeroOutPut++] = messaggio;

		
	}

	@Override
	public String leggiRiga() {
		return this.inPut[numeroInPut++];
		
	}
	/**
	 * Restituisce tutto l'output del codice in un un'unica stringa
	 * @return String
	 */
	
	/**
	 * Prende come parametro un array di Comandi sequenziali
	 * che verranno inseriti nel codice dal simulatore
	 * @param demo
	 */
	public void setInput(String...demo ) {
		this.inPut=demo;
	}
	/**
	 * Verifica se una determinata stringa è contenuta nell'output
	 * @param parolaDaCercare
	 * @return
	 */
	public boolean hasParola(String parolaDaCercare) {
		boolean trovata=false;
		for(int i=0;i<this.getOutput().length();i++) {
			String cavia=this.outPut[i];
			if(cavia!= null && cavia.equals(parolaDaCercare))
				trovata=true;
			
		}
		return trovata;
	}
	public String getOutput() {
		StringBuilder risultato = new StringBuilder();
		for(int i=0;i<this.outPut.length;i++)
			if(this.outPut[i]!=null)
					risultato.append(this.outPut[i]);
		return risultato.toString();
	}


	
	
}