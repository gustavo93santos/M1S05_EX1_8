import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Jogo!");

        List jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Leonardo", 30, 10,2));
        jogadores.add(new Jogador("Andre", 30, 15,3));
        jogadores.add(new Jogador("Gustavo", 30, 5,2));
        System.out.println("Carga finalizada");

        ordenaLista(jogadores);
    }

    public static void ordenaLista(List jogadores) {
        jogadores.sort(Comparator.comparingLong(Jogador::getPontuacao).reversed());
        jogadores.forEach(System.out::println);
    }
}

