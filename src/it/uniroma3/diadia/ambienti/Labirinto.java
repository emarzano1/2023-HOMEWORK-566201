package it.uniroma3.diadia.ambienti;

public interface Labirinto {
	public void init();
	public Stanza getStanzaVincente();
	public Stanza getStanzaCorrente();
	public Stanza getStanzaIniziale();
	public Stanza getUltimaStanzaAggiunta();
}
