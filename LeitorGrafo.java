package algoritmosgrafos;

import java.io.*;
import java.util.*;

public class LeitorGrafo {
    public static Grafo lerArquivo(String caminho) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        String linha;
        Grafo grafo = null;

        while ((linha = br.readLine()) != null) {
            if (linha.startsWith("p ")) {
                String[] partes = linha.split(" ");
                int vertices = Integer.parseInt(partes[2]);
                int arestas = Integer.parseInt(partes[3]);
                grafo = new Grafo(vertices, arestas);
            } else if (linha.startsWith("a ")) {
                String[] partes = linha.split(" ");
                int origem = Integer.parseInt(partes[1]);
                int destino = Integer.parseInt(partes[2]);
                int peso = Integer.parseInt(partes[3]);
                grafo.adicionarAresta(origem, destino, peso);
            }
        }
        br.close();
        return grafo;
    }
}
