package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	
	//per vedere se la partita è vinta
	private Partita partita1;
	private Stanza corrente1;
	private Partita partita2;
	private Partita partita3;

	
	//per vedere se la partita è finita
	private Partita partita4;
	private Partita partita5;
	private Partita partita6;
	private Partita partita7;
	private Partita partita8;
	private Partita partita9;
	private Partita partita10;
	private Partita partita11;
	
	@Before
	public void setUp() {
		//per vedere se la partita è vinta
		//stanza corrente e vincente diverse
		this.partita1=new Partita();
		this.corrente1=new Stanza("Corrente1");
		this.partita1.setStanzaCorrente(corrente1);

		
		//stanza corrente uguale alla vincente
		this.partita2=new Partita();
		this.partita2.setStanzaCorrente(this.partita2.getStanzaVincente());
		
		//una delle due è null
		this.partita3=new Partita();

		
		
		//per vedere se la partita è finita
		this.partita4=new Partita();  //finita1 vinta0 cfu0
		this.partita4.setFinita();
		this.partita4.getGiocatore().setCfu(0);
		
		this.partita5=new Partita();  //finita0 vinta1 cfu0
		this.partita5.setStanzaCorrente(this.partita5.getStanzaVincente());
		this.partita5.getGiocatore().setCfu(0);;
		
		this.partita6=new Partita();  //finita0 vinta0 cfu1
		
		this.partita7=new Partita();  //finita1 vinta1 cfu0
		this.partita7.setFinita();
		this.partita7.setStanzaCorrente(this.partita7.getStanzaVincente());
		this.partita7.getGiocatore().setCfu(0);
		
		this.partita8=new Partita();  //finita1 vinta0 cfu1
		this.partita8.setFinita();
		
		this.partita9=new Partita();  //finita0 vinta1 cfu1
		this.partita9.setStanzaCorrente(this.partita9.getStanzaVincente());
		
		this.partita10=new Partita(); //finita1 vinta1 cfu1
		this.partita10.setFinita();
		this.partita10.setStanzaCorrente(this.partita10.getStanzaVincente());
		
		this.partita11=new Partita();  //finita0 vinta0 cfu0
		this.partita11.getGiocatore().setCfu(0);
	}

	@Test
	public void testPartita1StanzaCorrenteDiversaDallaVincente() {
		assertEquals(false,this.partita1.vinta());
	}
	
	@Test 
	public void testPartita2StanzaCorrenteUgualeAllaVincente() {
		assertEquals(true,partita2.vinta());
	}
	
	@Test
	public void testPartita3StanzaCorrenteNull() {
		assertEquals(false,partita3.vinta());
	}
	
	@Test
	public void testPartita4finita1vinta0cfu0() {
		assertEquals(true,partita4.isFinita());
	}
	
	@Test
	public void testPartita5inita0vinta1cfu0() {
		assertEquals(true,partita5.isFinita());
	}
	
	@Test
	public void testPartita6finita0vinta0cfu1() {
		assertEquals(false,partita6.isFinita());
	}
	
	@Test
	public void testPartita7finita1vinta1cfu0() {
		assertEquals(true,partita7.isFinita());
	}
	
	@Test
	public void testPartita8finita1vinta0cfu1() {
		assertEquals(true,partita8.isFinita());
	}
	
	@Test
	public void testPartita9finita0vinta1cfu1() {
		assertEquals(true,partita9.isFinita());
	}
	
	@Test
	public void testPartita10finita1vinta1cfu1() {
		assertEquals(true,partita10.isFinita());
	}
	
	@Test
	public void testPartita11finita0vinta0cfu0() {
		assertEquals(true,partita11.isFinita());
	}

}