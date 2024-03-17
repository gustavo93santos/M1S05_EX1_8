import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Jogo!");
        List<Jogador> jogadores = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        cargaDadosTestes(jogadores);

        String nome;
        int idade;
        System.out.println("Carga inicial finalizada");

        System.out.println("Bem vindo ao cadastro do jogador");
        do {
            System.out.print("Nome: ");
            nome = entrada.nextLine();
            if(existeJogador(jogadores, nome)){
                System.out.println("Jogador com mesmo nome ja registrado, por favor insira um novo nome");
            }else{
                break;
            }
        }while (true);
        System.out.println("Idade: ");
        idade = Integer.parseInt(entrada.nextLine());
        Jogador ativo = new Jogador(nome,idade,0,0);

        jogadores.add(ativo);
        System.out.println("Bem-vindo ao jogo de adivinhação!");
        System.out.println("Você se sente confortavel em tentar um nume de 1 ate quanto? digite o limite superior abaixo.");

        if(Jogo.jogar(entrada.nextInt())){
            System.out.println("Parabens você venceu");
            ativo.adicionaPontos(1);
            ativo.adicionaTentativa();
        }else{
            System.out.println("Infelizmente você perdeu");
            ativo.adicionaTentativa();
        }

        ordenaRanking(jogadores);
        Jogo.setMelhorJogador(jogadores.getFirst());
        System.out.println("melhor jogador " + Jogo.getMelhorJogador().getNome());
        exibeRanking(jogadores);
    }

    public static boolean existeJogador(List<Jogador> jogadores, String nome){
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equalsIgnoreCase(nome)){
                return true;
            }
        }
        return false;
    }

    public static void ordenaRanking(List<Jogador> jogadores) {
        jogadores.sort(Comparator.comparingLong(Jogador::getPontuacao).reversed());
    }

    public static void exibeRanking(List<Jogador> jogadores) {
        for (int i = 0; i < 10; i++) {
            Jogador j =  jogadores.get(i);
            System.out.println(j.getNome() + " - " + (i+1));
        }
    }



    public static void cargaDadosTestes(List<Jogador> jogadores){
        jogadores.add(new Jogador("Leonardo", 30, 0,2));
        jogadores.add(new Jogador("Andre", 30, 0,3));
        jogadores.add(new Jogador("Gustavo", 30, 1,2));
        jogadores.add(new Jogador("4", 30, 0,2));
        jogadores.add(new Jogador("5", 30, 0,3));
        jogadores.add(new Jogador("6", 30, 0,2));
        jogadores.add(new Jogador("7", 30, 0,2));
        jogadores.add(new Jogador("8", 30, 0,3));
        jogadores.add(new Jogador("9", 30, 0,2));
        jogadores.add(new Jogador("10", 30, 0,2));
        jogadores.add(new Jogador("0", 30, 0,2));
    }
}

