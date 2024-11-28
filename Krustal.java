package algoritmosgrafos;

import java.util.*;

/**
 * Classe que implementa o algoritmo de Kruskal para encontrar a Árvore Geradora Mínima (AGM).
 * O algoritmo trabalha ordenando as arestas por peso e utilizando uma estrutura Union-Find 
 * para garantir que o grafo não forme ciclos enquanto adiciona arestas à AGM.
 */
public class Krustal {

    /**
     * Calcula o custo total da Árvore Geradora Mínima (AGM) de um grafo.
     *
     * @param grafo O grafo de entrada, contendo os vértices e arestas.
     * @return O custo total da AGM.
     */
    public static int calcularAGM(Grafo grafo) {
        List<Aresta> arestas = grafo.getArestas(); // Obtém a lista de arestas do grafo
        Collections.sort(arestas); // Ordena as arestas pelo peso, em ordem crescente

        // Inicializa a estrutura Union-Find com o número de vértices do grafo
        UnionFind uf = new UnionFind(grafo.getVertices());
        int custoTotal = 0; // Armazena o custo total da AGM

        // Percorre as arestas ordenadas
        for (Aresta aresta : arestas) {
            // Verifica se a aresta conecta dois componentes diferentes
            if (uf.unir(aresta.origem, aresta.destino)) {
                custoTotal += aresta.peso; // Adiciona o peso da aresta ao custo total
            }
        }

        return custoTotal; // Retorna o custo total da AGM
    }
}

/**
 * Classe que implementa a estrutura de conjuntos disjuntos (Union-Find) com compressão
 * de caminho e união por rank, utilizada no algoritmo de Kruskal para evitar ciclos.
 */
class UnionFind {
    private final int[] pai;  // Array que armazena o "pai" de cada elemento
    private final int[] rank; // Array que armazena a "altura" de cada árvore

    /**
     * Construtor da classe UnionFind.
     * 
     * @param tamanho O número total de elementos (vértices) no grafo.
     */
    public UnionFind(int tamanho) {
        pai = new int[tamanho + 1]; // Cria o array pai com tamanho baseado nos vértices
        rank = new int[tamanho + 1]; // Inicializa o array rank com zeros

        // Inicializa cada elemento como seu próprio pai (representando um conjunto inicial)
        for (int i = 0; i <= tamanho; i++) {
            pai[i] = i;
        }
    }

    /**
     * Encontra o representante (ou raiz) do conjunto de um elemento.
     * Utiliza compressão de caminho para otimizar futuras operações.
     *
     * @param x O elemento cuja raiz será encontrada.
     * @return O representante (raiz) do conjunto do elemento.
     */
    public int encontrar(int x) {
        if (pai[x] != x) {
            pai[x] = encontrar(pai[x]); // Compressão de caminho: ajusta o pai diretamente à raiz
        }
        return pai[x];
    }

    /**
     * Une dois conjuntos distintos utilizando união por rank.
     * 
     * @param x Um elemento do primeiro conjunto.
     * @param y Um elemento do segundo conjunto.
     * @return True se os conjuntos foram unidos, False se já pertenciam ao mesmo conjunto.
     */
    public boolean unir(int x, int y) {
        int raizX = encontrar(x); // Raiz do conjunto de x
        int raizY = encontrar(y); // Raiz do conjunto de y

        // Se os dois elementos já estão no mesmo conjunto, não é necessário uni-los
        if (raizX == raizY) return false;

        // Une os conjuntos com base no rank (altura das árvores)
        if (rank[raizX] > rank[raizY]) {
            pai[raizY] = raizX; // Faz a raiz de Y apontar para a raiz de X
        } else if (rank[raizX] < rank[raizY]) {
            pai[raizX] = raizY; // Faz a raiz de X apontar para a raiz de Y
        } else {
            pai[raizY] = raizX; // Faz Y apontar para X e incrementa o rank de X
            rank[raizX]++;
        }
        return true; // A união foi realizada
    }
}
