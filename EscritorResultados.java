import java.io.*;
import java.util.Arrays;

public class EscritorResultados {
    public static void escreverResultados(
            String arquivoEntrada, Grafo grafo, int[] distancias, double tempoDijkstra,
            int custoPrim, double tempoPrim, int custoKruskal, double tempoKruskal
    ) throws IOException {
        String nomeSaida = arquivoEntrada.replace(".gr", "-resultados.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeSaida))) {
            bw.write("Resultados para o arquivo: " + arquivoEntrada);
            bw.newLine();
            bw.write("Número de vértices: " + grafo.getVertices());
            bw.newLine();
            bw.write("Número de arestas: " + grafo.getArestas().size());
            bw.newLine();

            // Resultados de Dijkstra
            bw.write("\n[Dijkstra]");
            bw.newLine();
            bw.write("Tempo de execução: " + tempoDijkstra + " segundos");
            bw.newLine();
            bw.write("Distâncias mínimas do nó 1: " + Arrays.toString(distancias));
            bw.newLine();

            // Resultados de Prim
            bw.write("\n[Prim]");
            bw.newLine();
            bw.write("Tempo de execução: " + tempoPrim + " segundos");
            bw.newLine();
            bw.write("Custo da AGM: " + custoPrim);
            bw.newLine();

            // Resultados de Kruskal
            bw.write("\n[Kruskal]");
            bw.newLine();
            bw.write("Tempo de execução: " + tempoKruskal + " segundos");
            bw.newLine();
            bw.write("Custo da AGM: " + custoKruskal);
            bw.newLine();
        }
    }
}
