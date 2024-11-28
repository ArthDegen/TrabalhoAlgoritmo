import java.util.ArrayList;
import java.util.List;

/**
 * Representa um grafo utilizando listas de adjacência.
 * Pode ser utilizado para algoritmos como Dijkstra, Kruskal e Prim.
 */
public class Grafo {
    private int numVertices;                 // Número de vértices no grafo
    private List<Aresta> arestas;            // Lista de todas as arestas do grafo
    private List<List<Aresta>> adjacencias;  // Lista de adjacências para cada vértice

    /**
     * Construtor para inicializar um grafo com um número específico de vértices.
     * 
     * @param numVertices Número de vértices no grafo.
     */
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.arestas = new ArrayList<>();
        this.adjacencias = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencias.add(new ArrayList<>()); // Inicializa a lista de adjacências
        }
    }

    /**
     * Adiciona uma aresta ao grafo, tanto na lista de arestas quanto na lista de adjacências.
     * 
     * @param origem Vértice de origem.
     * @param destino Vértice de destino.
     * @param peso Peso ou custo da aresta.
     */
    public void adicionarAresta(int origem, int destino, int peso) {
        Aresta aresta = new Aresta(origem, destino, peso);
        arestas.add(aresta);
        adjacencias.get(origem).add(aresta); // Adiciona à lista de adjacências
    }

    // Métodos para acessar as informações do grafo
    public int getNumVertices() {
        return numVertices;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public List<Aresta> getAdjacencias(int vertice) {
        return adjacencias.get(vertice);
    }
}
