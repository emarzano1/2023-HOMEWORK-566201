package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class GiocatoreTest {
	 
		private Giocatore giocatore;
		
		@Test
		public void testSetCfu() {
			giocatore=new Giocatore();
			this.giocatore.setCfu(5);
			assertEquals("Errore, dovrebbe essere 5", 5 , this.giocatore.getCfu());
		}
		
		@Test
		public void testGetCfuIniziali() {
			giocatore=new Giocatore();
			assertEquals("Errore, dovrebbe essere 20", 20 , this.giocatore.getCfu());
		}
		@Test
		
		public void getBorsaNotNull() {
			giocatore=new Giocatore();
			assertNotNull(this.giocatore.getBorsa());
		}
	}
	
	
