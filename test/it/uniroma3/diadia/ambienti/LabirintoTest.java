package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	private Labirinto labirinto;
	private Stanza atrio;
	private Stanza biblioteca;
	
	@Before
	public void setUp() {
		this.labirinto=new Labirinto();
		atrio=this.labirinto.getStanzaCorrente();
		biblioteca=this.labirinto.getStanzaVincente();
	}

	@Test
	public void testStanzaCorrente() {
		assertEquals(atrio, this.labirinto.getStanzaCorrente());
	}
	
	@Test
	public void testStanzaVincente() {
		assertEquals(biblioteca,this.labirinto.getStanzaVincente());
	}

}
