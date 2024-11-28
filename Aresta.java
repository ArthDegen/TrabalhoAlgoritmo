/**
 * Representa uma aresta de um grafo, conectando dois vértices com um peso associado.
 */
public class Aresta {
    private int origem;  // Vértice de origem
    private int destino; // Vértice de destino
    private int peso;    // Peso ou custo da aresta

    /**
     * Construtor da classe Aresta.
     * 
     * @param origem Vértice de origem.
     * @param destino Vértice de destino.
     * @param peso Peso ou custo associado à aresta.
     */
    public Aresta(int origem, int destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    // Getters e setters para acessar os atributos da aresta
    public int getOrigem() {
        return origem;
    }

    public int getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }
}
