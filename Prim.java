import java.util.PriorityQueue;

// Implementação do algoritmo de Prim para encontrar a Árvore Geradora Mínima (AGM)
public class Prim {
   
    public static int encontrarAGM(Grafo grafo) {
        int pesoTotal = 0;
        boolean[] visitado = new boolean[grafo.getNumVertices()];
        PriorityQueue<Aresta> fila = new PriorityQueue<>((a, b) -> Integer.compare(a.getPeso(), b.getPeso()));

        // Adiciona as arestas do vértice inicial (0) na fila de prioridade
        visitado[0] = true;
        fila.addAll(grafo.getAdjacencias(0));

        // Enquanto houver arestas na fila
        while (!fila.isEmpty()) {
            Aresta menorAresta = fila.poll(); // Remove a aresta com menor peso
            int destino = menorAresta.getDestino();

            // Ignora arestas que conectam vértices já visitados
            if (!visitado[destino]) {
                visitado[destino] = true; // Marca o vértice como visitado
                pesoTotal += menorAresta.getPeso();

                // Adiciona novas arestas conectadas ao vértice à fila
                for (Aresta aresta : grafo.getAdjacencias(destino)) {
                    if (!visitado[aresta.getDestino()]) {
                        fila.add(aresta);
                    }
                }
            }
        }
        return pesoTotal;
    }
}
