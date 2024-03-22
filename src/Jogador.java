public class Jogador {
    private String nome;
    private int idade;
    private long pontuacao;
    private long numeroTentativas;

    public Jogador(String nome, int idade, long pontuacao, long numeroTentativas) {
        this.nome = nome;
        this.idade = idade;
        this.pontuacao = pontuacao;
        this.numeroTentativas = numeroTentativas;
    }

    public void adicionaPontos(long pontos){
        this.pontuacao += pontos;
    }
    public void perdePontos(long pontos){
        this.pontuacao -= pontos;
    }
    public void adicionaTentativa(){
        this.numeroTentativas++;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }

    public void setIdade(int idade) { this.idade = idade; }

    public long getPontuacao() { return pontuacao; }

    public void setPontuacao(long pontuacao) { this.pontuacao = pontuacao; }

    public long getNumeroTentativas() { return numeroTentativas;    }

    public void setNumeroTentativas(long numeroTentativas) { this.numeroTentativas = numeroTentativas; }

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