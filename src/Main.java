public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Jogo!");

        Jogador j = new Jogador();
        j.nome = "Gustavo";
        j.idade = 30;

        System.out.println("Carga finalizada");
        System.out.println(j.toString());
        j.adicionaTentativa();
        j.adicionaPontos(5);
        System.out.println(j.toString());
    }
}

