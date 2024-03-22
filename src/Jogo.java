import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private static Random maquina = new Random();
    private static Jogador melhorJogador;
    private static long numeroJogadas = 0;

    public static int jogar(){
        numeroJogadas++;
        int opcao;

        do{
            opcao = Utils.scanInt("Faça sua jogada \n" +
                    "0 = pedra \n" +
                    "1 = papel \n" +
                    "2 = tesoura \n");
            if (opcao < 0 || opcao > 2){
                System.out.println("Opção invalida.");
            }
        }while (opcao <0 || opcao > 2);

        int resultadoMaquina = maquina.nextInt(3);

        if((opcao == 0 && resultadoMaquina == 1) ||
                (opcao == 1 && resultadoMaquina == 2) ||
                (opcao == 2 && resultadoMaquina== 0)) {
            return 1;
        } else if (opcao == resultadoMaquina) {
            return -1;
        }else{
            return 0;
        }
    }

    public static int jogar(int num){
        numeroJogadas++;
        System.out.println("Tente adivinhar um número de 0 a " + num);

        int numeroAleatorio = maquina.nextInt(num + 1);

        int palpite = Utils.scanInt("Digite o seu palpite: ");

        if (palpite == numeroAleatorio) {
            return 0;
        } else {
            return 1;
        }
    }

    public static Jogador getMelhorJogador() {
        return melhorJogador;
    }

    public static void setMelhorJogador(Jogador jogador) {
        melhorJogador = jogador;
    }

    public long getNumeroJogadas() {
        return numeroJogadas;
    }

    public void setNumeroJogadas(long numeroJogadas) {
        this.numeroJogadas = numeroJogadas;
    }
}