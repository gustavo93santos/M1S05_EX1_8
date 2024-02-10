public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Jogo!");

        Jogador j = new Jogador("Gustavo", 30, 0,0);

        System.out.println("Carga finalizada");
        System.out.println(j.toString());
        j.adicionaTentativa();
        j.adicionaPontos(5);
        System.out.println(j.toString());
    }
}

