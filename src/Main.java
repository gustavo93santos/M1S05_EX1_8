import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Jogo!");

        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Leonardo", 30, 10,2));
        jogadores.add(new Jogador("Andre", 30, 15,3));
        jogadores.add(new Jogador("Gustavo", 30, 11,2));
        jogadores.add(new Jogador("4", 30, 4,2));
        jogadores.add(new Jogador("5", 30, 5,3));
        jogadores.add(new Jogador("6", 30, 6,2));
        jogadores.add(new Jogador("7", 30, 7,2));
        jogadores.add(new Jogador("8", 30, 8,3));
        jogadores.add(new Jogador("9", 30, 9,2));
        jogadores.add(new Jogador("10", 30, 10,2));
        jogadores.add(new Jogador("0", 30, 0,2));
        System.out.println("Carga finalizada");

        ordenaRanking(jogadores);
        exibeRanking(jogadores);
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
}

