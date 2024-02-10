public class Jogador {
    public String nome;
    public int idade;
    public long pontuacao = 0;
    public long numeroTentativas = 0;

    public void adicionaPontos(long pontos){
        this.pontuacao += pontos;
    }
    public void perdePontos(long pontos){
        this.pontuacao -= pontos;
    }
    public void adicionaTentativa(){
        this.numeroTentativas++;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontuacao=" + pontuacao +
                ", numeroTentativas=" + numeroTentativas +
                '}';
    }
}
//Primeiramente crie a Classe Jogador.
//Cada vez que um jogo for instanciado devemos ter um novo objeto jogador.
//O Jogador deve ter os métodos: adicionaPontos, perdePontos, adicionaTentativa.