LP2_2N
======
import java.util.Scanner;

public class TravessiaDeserto {


		private int posicao;
		private int fuel;
		private int[] mapa;

	    private Scanner sc = new Scanner(System.in);

	    public static final int MAX_FUEL = 6;
		public static final int MAP_SIZE = 10;
		public static final int ERRO = -1;
		public static final int AJUDA = 0;
		public static final int CARREGAR = 1;
		public static final int DESCARREGAR = 2;
		public static final int VOLTAR = 3;
		public static final int AVANCAR = 4;

		public static void main(String[] args)
		{
			(new TravessiaDeserto()).run(args);
	    }

		public void run(String[] args)
		{
			inicializaJogo();
			do{
				printStatus();
				printPrompt();
				int cmd = getCommand( sc.next() );
				processCommand(cmd);
	        } while (!isGameOver());

			System.out.println(getEndMessage());
		}

		public int getPosicao(){
	        

	        return posicao;
		}
		
public int getFuel(){
	        

	        return fuel;
		}
public int getMapa(){
    

    return mapa[MAP_SIZE];
}
	   
		public String getEndMessage()
		{
	        if (isWinner())
	            return "Voce GANHOU!";
			else
	            return "Voce perdeu.";
		}

		public boolean isGameOver()
		{
	        if (isWinner())
	            return true;
			if (fuel == 0 && mapa[posicao] == 0)
	            return true;
			return false;
		}

		public boolean isWinner()
		{
			return posicao == mapa.length;
		}

		public void inicializaJogo()
		{
			fuel = MAX_FUEL;
			posicao = 0;
			mapa = new int[MAP_SIZE];
		}

		public void printStatus()
		{
	        System.out.println(String.format("Voce está na posição %d.", posicao));
			System.out.println(String.format("Você tem %d unidades de combustível.",fuel));
			if (posicao > 0)
	            System.out.println(String.format("Nesta posicao existem %d unidades de combustivel.",fuel));
		}

	    public void printPrompt()
	    {
			System.out.print("Comando ('help' para ajuda): ");
		}

		public int getCommand(String command)
		{
	        String cmd = command.toLowerCase();

			if (cmd.equals("avancar"))
				return AVANCAR;
			if (cmd.equals("voltar"))
				return VOLTAR;
			if (cmd.equals("carregar"))
				return CARREGAR;
			if (cmd.equals("descarregar"))
				return DESCARREGAR;
			if (cmd.equals("help"))
				return AJUDA;

	        return ERRO;
		}

		public void processCommand(int cmd) {
			switch (cmd) {
				case AJUDA:
					ajuda();
					break;
				case VOLTAR:
					voltar();
					break;
				case AVANCAR:
					avancar();
					break;
				case CARREGAR:
					carregar();
					break;
				case DESCARREGAR:
					descarregar();
					break;
				default:
					System.out.print("Comando Invalido");
			}
		}

		public void ajuda()
		{
	        System.out.println("avancar voltar carregar descarregar ajuda");
		}

		public void avancar()
		{
			if (fuel > 0 ) {
				fuel--;
				posicao++;
	        }
		}

		public void voltar()
		{
			if (fuel > 0 && posicao > 0) {
	            fuel--;
				posicao--;
	        }

			if (posicao == 0) {
				fuel = MAX_FUEL;
			}
	    }

	    public void carregar()
	    {
			if (fuel < MAX_FUEL && mapa[posicao] > 0 ) {
				mapa[posicao]--;
				fuel++;
	        }
		}

		public void descarregar()
		{
			if (fuel> 0) {
				mapa[posicao]++;
				fuel--;
	        }
		
			

			
			
	}
	
	
}
