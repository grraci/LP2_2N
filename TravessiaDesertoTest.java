LP2_2N
======
/**Class with tests to the TravessiaDeserto.java" game
 * In english because I like to practice :P

 * made by Graciela Robert

 * @version X

 */


import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

	@RunWith(JUnit4.class)
	public class TravessiaDesertoTest {
	
		@BeforeClass
		public static void setUpBeforeClass(){
			System.out.println("Test...");
		}
	
		@AfterClass
	public static void tearDownAfterClass(){}
			private TravessiaDeserto td;
		@Before
	public void setUp(){
			td = new TravessiaDeserto();
			td.initGame();
			
	}
	@After
	public void tearDown(){
	}

	
	/*
	 * The following method tests the inicialization of the game
	 * */
	@Test
	public void testTravessia(){
		

		assertEquals("test position ",td.getPosition(),0);
		assertEquals("test fuel ",td.getFuel(),6);
		assertEquals("test map ",td.MAP_SIZE,10);
		
		
}
	/*The following method tests when the commands are turned into int 
	 * */
	@Test
	public void testTranslateCommand(){
			
		assertEquals(td.AVANCAR, td.translateCommand("Avancar"));
		assertEquals(td.VOLTAR, td.translateCommand("Voltar"));
		assertEquals(td.CARREGAR, td.translateCommand("Carregar"));
		assertEquals(td.DESCARREGAR, td.translateCommand("Descarregar"));
		assertEquals(td.AJUDA, td.translateCommand("Ajuda"));
		
}
	
	/*The following method tests the proccess "ProcessCommand"
	 *It confers if the method returns the value as it should when requested by the "player"
	 * */
	@Test
	public void tesProcessCommand_0(){
	
	int AVANCAR = td.AVANCAR;
	int VOLTAR = td.VOLTAR;
	int CARREGAR = td.CARREGAR;
	int DESCARREGAR = td.DESCARREGAR;
	int AJUDA = td.AJUDA;
	
	assertEquals(td.processCommand(td.AVANCAR), AVANCAR);
	assertEquals(td.processCommand(td.VOLTAR), VOLTAR);
	assertEquals(td.processCommand(td.CARREGAR), CARREGAR);
	assertEquals(td.processCommand(td.DESCARREGAR), DESCARREGAR);
	assertEquals(td.processCommand(td.AJUDA), AJUDA);
	
}
	
	/*
	 *The following method tests "Descarregar()"
	 */
	@Test
	public void testDescarregar(){
		int fuelTest = td.getFuel();
		int fuelInMap = td.getMapPos();
		
		
		td.descarregar();
		assertEquals(td.getFuel(), fuelTest-1);
		assertEquals(td.getMapPos(), fuelInMap+1);
		
		
}	
	/*
	 *The following method tests "Avancar()"
	 */
	@Test
	public void testAvancar(){

	int fuelTest = td.getFuel();
	int positionTest = td.getPosition();
	
	
	td.avancar();
		assertEquals(td.getFuel(), fuelTest-1);
		assertEquals(td.getPosition(), positionTest+1);
		
}
	
	/*
	 *The following method tests "Voltar()"
	 */
	@Test
	public void testVoltar(){

	int fuelTest = td.getFuel();
	int positionTest = td.getPosition();
	int InitialPosition = 0;
	
	
	td.voltar();
	assertEquals(td.getPosition(), InitialPosition);
	td.avancar();td.avancar();
	
	int fuelTest2 = td.getFuel();
	td.voltar();
	assertEquals(td.getFuel(), fuelTest2-1);

}
		
	/*
	 *he following method tests "carregar()"
	 */
	@Test
	public void testCarregar(){

	int fuelTest = td.getFuel();
	int positionTest = td.getPosition();
	int fuelInMap = td.getMapPos();
	
	int InitialPosition = 0;
	

	td.avancar();td.avancar();td.descarregar();

	
	int fuelTest2 = td.getFuel();
	int fuelInMap2 = td.getMapPos();
	td.carregar();
	assertEquals(td.getFuel(), fuelTest2+1);
	assertEquals(td.getMapPos(), fuelInMap2-1);
	
	/*testando com map[pos] vazio*/
	int fuelTest3 = td.getFuel();
	td.carregar();
	assertEquals(td.getFuel(), fuelTest3);


	
	/*
	 *The following method tests "ajuda()"
	 *Checking if "print" is returning the setted message int he algorithm
	 */
	@Test
	public void testAjuda(){
	String ajuda = "Comandos: Avancar, Voltar, Carregar, Descarregar e Ajuda";
	assertEquals(ajuda, td.ajuda());
	
	}
	
	/*
	 * The following method tests isGameOver()
	 * It's done a small test with a counter simulating a defeat
	 * and verifying is the method "isGameOver" returns true or false.
	 */
	@Test
	public void testIsGameOver(){
		
		for(int i = 0; i < 7; i++){
			td.avancar();
		}
		if((td.getFuel() == 0) && (td.getMapPos() == 0)){
			assertTrue(td.isGameOver());
			
		}else{
			assertFalse(td.isGameOver());
		}
			
	
	}
	
	
	/*
	 * The following method tests "isWinner()"O metodo abaixo testa método isWinner()
	 * The value of the position was setted to be tested
	 * */
	@Test
	public void testIsWinner(){

		//using set to test "isWinner"
		td.setPosition(10);
	
		assertTrue(td.isWinner());
		
		
	}		
	

	
}
