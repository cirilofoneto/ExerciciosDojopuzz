import java.util.Random;
import java.util.Scanner;

public class JogoDeTenis {

	public static int sorteio() {

		int jogo = 0;
		Random sorteio = new Random();
		jogo = sorteio.nextInt(10);

		return jogo;

	}

	public static void desempate() {

		int desempateJogo1 = 0;
		int desempateJogo2 = 0;

		int jogo = sorteio();

		// Bloco para desempente.
		while (desempateJogo1 != 2 || desempateJogo2 != 2) {

			jogo = sorteio();
			if (jogo >= 0 && jogo <= 4) {
				desempateJogo1++;
				desempateJogo2 = 0;
			} else if (jogo >= 5 && jogo <= 9) {
				desempateJogo1 = 0;
				desempateJogo2++;
			}

			if (desempateJogo1 == 2) {
				System.out.println("Jogador 1 ganha SET após empate no game");
			} else if (desempateJogo2 == 2) {
				System.out.println("Jogador 2  ganha SET após empate no game");
			}
		}
	}

	public static void main(String[] args) {

		/*
		 * Neste problema você deverá implementar as regras de um jogo de tênis simples
		 * (apenas dois jogadores).
		 * 
		 * As regras de um jogo de tênis tem diversos detalhes, mas para simplificar o
		 * problema, você deve implementar apenas as regras de um game:
		 * 
		 * Em uma game cada jogador pode ter a seguinte pontuação: 0, 15, 30, ou 40; Os
		 * jogadores sempre começam com 0 pontos; Se o jogador possui 40 pontos e ganha
		 * a disputa, ele vence o game; Se ambos jogadores atingem 40 pontos, ocorre um
		 * empate (deuce); Estando em empate, o jogador que ganhar a bola seguinte está
		 * em vantagem (advantage); Se um jogador em vantagem ganha novamente a bola,
		 * ele vence o game; Se um jogador estiver em vantagem e o outro ganhar a bola,
		 * volta a ocorrer o empta (deuce). Caso tenha tempo e vontade de melhorar o seu
		 * código, você pode implementar mais regras do tênis (serviço, sets, tie-break,
		 * etc). Mais informações sobre as regras
		 * 
		 */
		Scanner pega = new Scanner(System.in);

		int ponto = 15;
		int inicio = 0;
		int jogador1 = 0;
		int jogador2 = 0;
		int desempateJogo1 = 0;
		int desempateJogo2 = 0;

		desempate();
		
		System.out.println("Digite: \n 1 - Inicio de Jogo\n 2 - Fim");
		inicio = pega.nextInt();
		
		

		while (inicio == 1) {

			int jogo = sorteio();
			System.out.println("Jogo Sorteado" + jogo);


			if (jogo >= 0 && jogo <= 4) {
				jogador1 = jogador1 + ponto;
				System.out.println("PONTOS JOGADOR 1: " + jogador1);
			
				if (jogador1 == 45 && jogador2 == 45) {
					System.out.println("Empate. ");
					desempate();
				} else if (jogador1 >= 45) {
					System.out.println("Jogador 1 ganhou o set sem empate");
					inicio = 2;
					System.exit(0);
					
				}
			}


			// Jogador 2;

			else if (jogo >= 5 && jogo <= 9) {
				jogador2 = jogador2 + ponto;
				System.out.println("PONTOS JOGADOR 2: " + jogador2);
				
				if (jogador1 == 45 && jogador2 == 45) {
					System.out.println("Empate. ");
					desempate();
				} else if (jogador2 >= 45) {
					System.out.println("Jogador 2 ganhou o set sem empate");
					inicio = 2;
					System.exit(0);
				}
			}

			
			System.out.println("Digite: 1 - Inicio de Novo Game \n 2 - Fim do Jogo");
			inicio = pega.nextInt();
		}

		System.out.println("Jogo acabou");

	}
}