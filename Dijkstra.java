import java.util.*;

/**
 * Implementação do algoritmo de Dijkstra para encontrar a distância mínima
 * de um vértice de origem a todos os outros vértices em um grafo ponderado.
 */
public class Dijkstra {
    /**
     * Calcula as menores distâncias de um vértice de origem para todos os outros vértices.
     * 
     * @param grafo O grafo que contém os vértices e arestas.
     * @param origem O vértice de origem a partir do qual calcular as distâncias.
     * @return Uma lista com as menores distâncias para cada vértice.
     */
    public static List<Integer> calcularDistancias(Grafo grafo, int origem) {
        int numVertices = grafo.getNumVertices();
        List<Integer> distancias = new ArrayList<>(Collections.nCopies(numVertices, Integer.MAX_VALUE));
        PriorityQueue<int[]> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        // A distância para o vértice de origem é 0
        distancias.set(origem, 0);
        filaPrioridade.add(new int[]{origem, 0});

        // Executa enquanto houver vértices na fila de prioridade
        while (!filaPrioridade.isEmpty()) {
            int[] atual = filaPrioridade.poll();
            int verticeAtual = atual[0];
            int distanciaAtual = atual[1];

            // Para cada aresta adjacente ao vértice atual
            for (Aresta aresta : grafo.getAdjacencias(verticeAtual)) {
                int vizinho = aresta.getDestino();
                int novaDistancia = distanciaAtual + aresta.getPeso();

                // Relaxamento: verifica se encontrou uma distância menor
                if (novaDistancia < distancias.get(vizinho)) {
                    distancias.set(vizinho, novaDistancia);
                    filaPrioridade.add(new int[]{vizinho, novaDistancia});
                }
            }
        }
        return distancias;
    }
}
