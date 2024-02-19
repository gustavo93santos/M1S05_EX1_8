import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private static Jogador melhorJogador;
    private static long numeroJogadas = 0;

    public static boolean jogar(){

        numeroJogadas++;

        Random maquina = new Random();
        Scanner entrada = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("Faça sua jogada \n" +
                    "0 = pedra \n" +
                    "1 = papel \n" +
                    "2 = tesoura \n");
            opcao = Integer.parseInt(entrada.nextLine());
            if (opcao <0 || opcao > 2){
                System.out.println("Opção invalida.");
            }
        }while (opcao <0 || opcao > 2);

        entrada.close();

        if((opcao == 0 && maquina.nextInt(3) == 1) ||
                (opcao == 1 && maquina.nextInt(3) == 2) ||
                (opcao == 2 && maquina.nextInt(3) == 0))
        {
            return false;
        }else{
            return true;
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


//Crie a Classe Jogo, essa classe vai ter o jogo em si, o jogo consiste em um pedra papel e tesoura,
// que o jogador deve inserir a sua jogada e o sistema irá retorna se ele ganhou ou não.

//O Jogo deve estar em um método jogar().

//O Jogo deve ter o atributo, melhor jogador(melhorJogador) e deve ter o número de vezes
// que o jogo foi jogado (numeroJogadas).

//Cada vez que um jogador ganha ele deve receber mais um ponto, cada tentativa adiciona ao numero de tentativas.