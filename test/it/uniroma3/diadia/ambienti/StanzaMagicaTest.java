package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	
	private StanzaMagica roomMagic;
	private Attrezzo frusta;

	private Attrezzo bacchetta;
	
	@Before
	public void setUp() {
		roomMagic= new StanzaMagica("magic", 1);
		frusta= new Attrezzo("frusta",3);

		bacchetta= new Attrezzo("bacchetta",2);
	}
	@Test
	public void testAddAttrezzoConUnAttrezzoNessunaReazione() {
		assertNull( roomMagic.getAttrezzo("bacchetta"));
		roomMagic.addAttrezzo(bacchetta);
		assertEquals("Errore, la stanza non dovrebbe impazzire", bacchetta, roomMagic.getAttrezzo("bacchetta"));
	}
	@Test
	public void testAddAttrezzoConDueAttrezziConReazione() {
		roomMagic.addAttrezzo(bacchetta);
		roomMagic.addAttrezzo(frusta);
		assertEquals("Errore, il nome  non dovrebbe essere invertito", "bacchetta (2kg)", roomMagic.getAttrezzo("bacchetta").toString());
		assertEquals("Errore, il nome non dovrebbe essere invertito", bacchetta, roomMagic.getAttrezzo("bacchetta"));
		assertEquals("Errore, l'attrezzo deve stare nella stanza col nome invertito", true, roomMagic.hasAttrezzo("atsurf"));
		assertEquals("Errore, il nome dovrebbe essere invertito ed il peso raddoppiato", "atsurf (6kg)", roomMagic.getAttrezzo("atsurf").toString());
	}
	
}