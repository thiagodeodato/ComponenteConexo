/*
Nomes:	Thiago de Oliveira Deodato 			N10258938
		Guilherme Henrique dos Santos 		N10407663
		Vinicius Matheus da Silva Serafim 	N10150622
*/


import java.util.*;
import java.io.*;
import java.util.LinkedList;
import java.io.IOException;

public class Main {
    private int vertices;
    private LinkedList<Integer> adj[];
    public int numeroTesteAtual;
    String resposta;
    String respostaConvertida;
    boolean visitado[];

    // Construtor
    Main(int vertices){
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for(int i =0; i < vertices; i++){
            adj[i] = new LinkedList();
        }
        resposta = "";
        respostaConvertida = "";
        visitado = new boolean[vertices];
    }

    void adcionaAresta(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    int converteChar (char v){
        switch (v){
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            case 'i':
                return 8;
            case 'j':
                return 9;
            case 'k':
                return 10;
            case 'l':
                return 11;
            case 'm':
                return 12;
            case 'n':
                return 13;
            case 'o':
                return 14;
            case 'p':
                return 15;
            case 'q':
                return 16;
            case 'r':
                return 17;
            case 's':
                return 18;
            case 't':
                return 19;
            case 'u':
                return 20;
            case 'v':
                return 21;
            case 'w':
                return 22;
            case 'x':
                return 23;
            case 'y':
                return 24;
            case 'z':
                return 25;
            default:
                throw new IllegalStateException("Unexpected value: " + v);
        }
    }

    char converteInt (int v){
        switch (v){
            case 0:
                return 'a';
            case 1:
                return 'b';
            case 2:
                return 'c';
            case 3:
                return 'd';
            case 4:
                return 'e';
            case 5:
                return 'f';
            case 6:
                return 'g';
            case 7:
                return 'h';
            case 8:
                return 'i';
            case 9:
                return 'j';
            case 10:
                return 'k';
            case 11:
                return 'l';
            case 12:
                return 'm';
            case 13:
                return 'n';
            case 14:
                return 'o';
            case 15:
                return 'p';
            case 16:
                return 'q';
            case 17:
                return 'r';
            case 18:
                return 's';
            case 19:
                return 't';
            case 20:
                return 'u';
            case 21:
                return 'v';
            case 22:
                return 'w';
            case 23:
                return 'x';
            case 24:
                return 'y';
            case 25:
                return 'z';
            default:
                throw new IllegalStateException("Unexpected value: " + v);
        }
    }

    void buscaProfundidade(int y){
        if(!visitado[y]){
            visitado[y] = true;
            Iterator<Integer> i = adj[y].listIterator();
            resposta = resposta + Integer.toString(y);
            respostaConvertida = respostaConvertida + Character.toString(converteInt(y));
            while (i.hasNext()){
                int prox = i.next();
                if(!visitado[prox]){
                    buscaProfundidade(prox);
                }
            }
        }
    }

    String [] divideResposta (String respostaConvertida){
        String[] respostaDividida = respostaConvertida.split(" ");
        for(int i = 0; i < respostaDividida.length; i++){
            if(!respostaDividida[i].equals("")){
                char [] ordenado = respostaDividida[i].toCharArray();
                respostaDividida[i] = "";
                Arrays.sort(ordenado);
                for (int j = 0; j < ordenado.length; j++){
                    respostaDividida[i] = respostaDividida[i] + ordenado[j] + ",";
                }
            }
        }
        return respostaDividida;
    }


    void componentesConexos(){

        for(int y = 0; y < adj.length; y++){
            buscaProfundidade(y);
            resposta = resposta + " ";
            respostaConvertida = respostaConvertida + " ";
        }
        String[] respostaDividida = divideResposta(respostaConvertida);
        int componentesConectados = 0;
        System.out.println("Case #" + numeroTesteAtual + ":");
        for(int i = 0; i < respostaDividida.length; i++){
            if(!respostaDividida[i].equals("")){
                System.out.println(respostaDividida[i]);
                componentesConectados ++;
            }
        }
        System.out.println(componentesConectados + " connected components");
        System.out.println();

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numero = scan.nextLine();
        int numeroTestes = Integer.parseInt(numero);
       for(int i = 1; i <= numeroTestes; i++){
           String entrada = scan.nextLine();
           String[] entradaArray = entrada.split(" ");
           int qtdVertices = Integer.parseInt(entradaArray[0]);
           int qtdArestas = Integer.parseInt(entradaArray[1]);
           Main m = new Main(qtdVertices);
           m.numeroTesteAtual = i; // Numero de qual caso de teste esta sendo executado
           for (int j = 0; j < qtdArestas; j++){
                String arestas = scan.nextLine();
                String[] arestasArray = arestas.split(" ");
                m.adcionaAresta( (m.converteChar(arestasArray[0].charAt(0))), (m.converteChar(arestasArray[1].charAt(0))) );
           }
           m.componentesConexos();
        }
    }
}
