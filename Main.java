import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Caminho dos arquivos de entrada
            String[] arquivos = {
                    "C:\\Users\\arthur.fonseca\\Downloads\\USA-road-d.BAY.gr",
                    "C:\\Users\\arthur.fonseca\\Downloads\\USA-road-d.COL.gr",
                    "C:\\Users\\arthur.fonseca\\Downloads\\USA-road-d.NY.gr"
            };

            for (String arquivo : arquivos) {
                System.out.println("Processando arquivo: " + arquivo);

                // Ler o grafo
                Grafo grafo = LeitorGrafo.lerArquivo(arquivo);

                // Dijkstra
                long inicio = System.nanoTime();
                int[] distancias = Dijkstra.calcularDistancias(grafo, 1); // Inicia no nó 1
                long fim = System.nanoTime();
                double tempoDijkstra = (fim - inicio) / 1e9;

                // Prim
                inicio = System.nanoTime();
                int custoPrim = Prim.calcularAGM(grafo);
                fim = System.nanoTime();
                double tempoPrim = (fim - inicio) / 1e9;

                // Krustal
                inicio = System.nanoTime();
                int custoKrustal = Krustal.calcularAGM(grafo);
                fim = System.nanoTime();
                double tempoKrustal = (fim - inicio) / 1e9;

                // Escrever resultados
                EscritorResultados.escreverResultados(
                        arquivo, grafo, distancias, tempoDijkstra, custoPrim, tempoPrim, custoKrustal, tempoKrustal
                );

                System.out.println("Resultados salvos para o arquivo: " + arquivo);
            }
        } catch (IOException e) {
            System.err.println("Erro ao processar arquivos: " + e.getMessage());
        }
    }
}
