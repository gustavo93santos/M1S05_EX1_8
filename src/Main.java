import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Jogador> jogadores = new ArrayList<>();
        cargaDadosTestes(jogadores);
        Jogador ativo;

        do {
            ativo = login(jogadores);
            menuJogos(jogadores, ativo);

        } while (Utils.scanInt("Deseja Finalizar o programa? \n" +
                "1 - Sim\n" +
                "2 - Não") != 1);
    }

    public static void menuJogos(List<Jogador> jogadores, Jogador ativo){
        int opcaoJogo=-1;
        do {
            Utils.pula2linhas();
            System.out.println("Seleção de Jogos");
            System.out.println("Jogos disponiveis:");
            System.out.println("1 - Jogo de adivinhar numeros");
            System.out.println("2 - Jogo de pedra-papel-tesoura");
            System.out.println("0 - Voltar ao Login");
            opcaoJogo = Utils.scanInt("Qual jogo deseja jogar?");

            switch (opcaoJogo){
                case 0:
                    ativo = null;
                    return;
                case 1:
                    Utils.pula2linhas();
                    System.out.println("Bem vindo ao jogo de adivinhação");
                    System.out.println("Nele você define o nivel do desafio, você deve escolher quantas opções terão disponiveis para escolha.");
                    String tmp = "Você se sente confortavel em tentar um numero de 1 ate quanto? digite o limite superior abaixo.";
                    do {
                        atualizaRank(Jogo.jogar(Utils.scanInt(tmp)), ativo, jogadores);
                    } while (!menuPosJogo(jogadores));
                    break;
                case 2:
                    Utils.pula2linhas();
                    System.out.println("Bem vindo ao jogo de pedra, papel e tesoura");
                    atualizaRank(Jogo.jogar(), ativo, jogadores);
                    do {
                        atualizaRank(Jogo.jogar(), ativo, jogadores);
                    } while (!menuPosJogo(jogadores));
                    break;
                default:
                    Utils.pula2linhas();
                    System.out.println("Opção digitada invalida");
            }
        }while(true);
    }

    public static void atualizaRank(int status, Jogador ativo, List<Jogador> jogadores){
        ativo.adicionaTentativa();
        Utils.pula2linhas();

        if (status == 0 ){
            System.out.println("Parabéns você ganhou.");
            ativo.adicionaPontos(1);
            System.out.println("Parece que pontos foram adicionados a sua conta!!");
        } else if (status == 1) {
            System.out.println("Infelizmente você perdeu, mais sorte na proxima.");
            System.out.println("Ei parece que você perdeu alguns pontos.");
        }else{
            System.out.println("Você empatou, mais sorte na proxima.");
        }
        ordenaRanking(jogadores);
        Jogo.setMelhorJogador(jogadores.getFirst());
    }

    public static boolean menuPosJogo (List<Jogador> jogadores){
        do {
            Utils.pula2linhas();
            String menuString = "Qual das seguintes opções você deseja seguir:\n" +
                    "1 - Ver ranking completo\n" +
                    "2 - Ver top 10\n" +
                    "3 - Jogar novamente\n" +
                    "0 - Encerrar o Jogo";
            int opcao = Utils.scanInt(menuString);

            switch (opcao){
                case 0:
                    return true;
                case 1:
                    exibeRanking(jogadores, jogadores.size());
                    break;
                case 2:
                    exibeRanking(jogadores, 10);
                    break;
                case 3:
                    return false;
                default:
                    System.out.println("Opção invalida");
            }
        }while (true);
    }
    public static Jogador login(List<Jogador> jogadores){

        System.out.println("Bem vindo ao Login, entre com os dados abaixo para logar ou ser cadastrado.");
        String nome = Utils.scanString("Nome:");
        Jogador jogador = existeJogador(jogadores, nome);

        if(jogador != null){
            System.out.println("Jogador localizado, Login realizado com sucesso.");
            return jogador;
        }
        System.out.println("Jogador não foi localizado, seguindo com o cadastro");
        int idade = Utils.scanInt("Idade: ");

        jogador = new Jogador(nome,idade,0,0);
        jogadores.add(jogador);
        System.out.println("Novo jogador " + jogador.getNome() + " cadastrado com sucesso.");
        return jogador;
    }

    public static Jogador existeJogador(List<Jogador> jogadores, String nome){
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equalsIgnoreCase(nome)){
                return jogador;
            }
        }
        return null;
    }

    public static void ordenaRanking(List<Jogador> jogadores) {
        jogadores.sort(Comparator.comparingLong(Jogador::getPontuacao).reversed());
    }

    public static void exibeRanking(List<Jogador> jogadores, int pos) {
        for (int i = 0; i < pos; i++) {
            Jogador j =  jogadores.get(i);
            System.out.println(i+1 + " - Jogador: " + j.getNome() + " Pontuação: " + j.getPontuacao() + " Tentativas: " + j.getNumeroTentativas());
        }
    }

    public static void cargaDadosTestes(List<Jogador> jogadores){
        jogadores.add(new Jogador("1", 30, 1,2));
        jogadores.add(new Jogador("2", 30, 0,3));
        jogadores.add(new Jogador("Gustavo", 30, 0,2));
        jogadores.add(new Jogador("4", 30, 0,2));
        jogadores.add(new Jogador("5", 30, 0,3));
        jogadores.add(new Jogador("6", 30, 0,2));
        jogadores.add(new Jogador("7", 30, 0,2));
        jogadores.add(new Jogador("8", 30, 0,3));
        jogadores.add(new Jogador("9", 30, 0,2));
        jogadores.add(new Jogador("10", 30, 0,2));
        jogadores.add(new Jogador("11", 30, 0,2));
    }
}