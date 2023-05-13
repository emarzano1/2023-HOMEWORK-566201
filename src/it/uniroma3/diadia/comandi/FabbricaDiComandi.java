package it.uniroma3.diadia.comandi;

public interface FabbricaDiComandi{
	/**
	 * In base alla stringa che riceve per parametro, determina il
	 * sottotipo di Comando dalla quale invocare il metodo Esegui.
	 * @param istruzione 
	 */
	public Comando costruisciComando(String istruzione);
}
