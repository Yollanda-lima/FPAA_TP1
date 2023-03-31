import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

// import javax.swing.event.SwingPropertyChangeSupport;
// import javax.swing.plaf.synth.SynthToolTipUI;

public class App {

    static long qtdDeTrocasBolha = 0;
    static long qtdDeCompBolha = 0;
    static long qtdDeTrocasSelecao = 0;
    static long qtdDeCompSelecao = 0;

    static long[] totalDeTrocaBolha = new long[50];
    static long[] totalDeCompBolha = new long[50];
    static long[] totalDeTrocaSelecao = new long[50];
    static long[] totalDeCompSelecao = new long[50];

    public static void main(String[] args) throws Exception {

        System.out.println("----------------Parte 1----------------");

        long total = 0;

        for (int i = 0; i < 50; i++) { // 50 vezes
        List<Integer> gerado = geraVetor(100_000), a = gerado; // 100_000 numeros
        a = new LinkedList<>(gerado);
        Integer[] x = gerado.toArray(new Integer[0]), y = a.toArray(new Integer[0]);
        selection(x, i);
        bubble(y, i);
        }

        mergeSort(totalDeCompBolha);
        System.out.println("BOLHA:");
        System.out.println("Comparacoes Bolha:");
        System.out
        .println("Menor: " + totalDeCompBolha[0] + " / Maior:" +
        totalDeCompBolha[totalDeCompBolha.length - 1]);
        for (int i = 0; i < totalDeCompBolha.length; i++) {
        total = +totalDeCompBolha[i];
        }
        System.out.println("Média: " + total / totalDeCompBolha.length);
        total = 0;

        mergeSort(totalDeTrocaBolha);
        System.out.println("Trocas Bolha:");
        System.out.println(
        "Menor: " + totalDeTrocaBolha[0] + " / Maior: " +
        totalDeTrocaBolha[totalDeTrocaBolha.length - 1]);
        for (int i = 0; i < totalDeTrocaBolha.length; i++) {
        total = +totalDeTrocaBolha[i];
        }
        System.out.println("Media: " + total / totalDeTrocaBolha.length);
        total = 0;

        System.out.println("----------------------------------------");

        mergeSort(totalDeCompSelecao);
        System.out.println("SELEÇÃO:");
        System.out.println("Comparacoes Selecao:");
        System.out.println(
        "Menor: " + totalDeCompSelecao[0] + " / Maior: " +
        totalDeCompSelecao[totalDeCompSelecao.length - 1]);
        for (int i = 0; i < totalDeCompSelecao.length; i++) {
        total = +totalDeCompSelecao[i];
        }
        System.out.println("Media: " + total / totalDeCompSelecao.length);
        total = 0;

        mergeSort(totalDeTrocaSelecao);
        System.out.println("Trocas Selecao:");
        System.out.println("Menor: " + totalDeTrocaSelecao[0] + " / Maior: "
        + totalDeTrocaSelecao[totalDeTrocaSelecao.length - 1]);
        for (int i = 0; i < totalDeTrocaSelecao.length; i++) {
        total = +totalDeTrocaSelecao[i];
        }
        System.out.println("Media: " + total / totalDeTrocaSelecao.length);

    //     System.out.println("----------------Parte 2----------------");

    //     // a

    //     // Cria um vetor de 10.000 posições
    //     int[] vetor = new int[10_000];

    //     for (int i = 0; i < vetor.length; i++) {
    //         vetor[i] = i;
    //     }

    //     // b

    //     // Gerar um valor aleatório
    //     Random random = new Random();
    //     int valorPesquisa = 0;
    //     valorPesquisa = random.nextInt(11_000); // 11_000

    //     // Pesquisar o valor
    //     boolean encontrado = false;
    //     for (int i = 0; i < 10_000; i++) {
    //         if (vetor[i] == valorPesquisa) {
    //             System.out.println("Valor encontrado na posição: " + i);
    //             encontrado = true;
    //             break;
    //         }
    //     }
    //     if (!encontrado) {
    //         System.out.println("Valor não encontrado. Registrando posição 10001.");
    //         System.out.println("Valor encontrado na posição: 10001");
    //     }

    //     // c

    //     // Criar um vetor de 1.000.000 posições
    //     int[] resultados = new int[1_000_000]; // 1_000_000

    //     // Repetir 1.000.000 vezes
    //     for (int j = 0; j < resultados.length; j++) {
    //         int[] vetorRepeticao = new int[10000];
    //         for (int i = 0; i < vetorRepeticao.length; i++) {
    //             vetorRepeticao[i] = i + 1;
    //         }

    //         // Pesquisar o valor
    //         int contador = 0;

    //         for (int i = 0; i < vetorRepeticao.length; i++) {
    //             if (vetorRepeticao[i] == valorPesquisa) {
    //                 contador++;
    //             }
    //         }

    //         // Armazenar o resultado
    //         resultados[j] = contador;
    //     }

    //     // d

    //     // Agrupar os resultados e contar

    //     int inicio = 0;
    //     int soma = 0;

    //     for (int i = 0; i < resultados.length; i++) {
    //         soma += resultados[i];
    //         if ((i + 1) % 500 == 0) {
    //             System.out.println(inicio + " - " + i + ": " + soma);
    //             inicio = i + 1;
    //             soma = 0;
    //         }
    //     }
    //     System.out.println(inicio + " - " + (resultados.length - 1) + ": " + soma);

     }

    // Algoritmo de ordenação SelectionSort
    public static void selection(Integer[] arr, int pos) {
        qtdDeCompSelecao = 0;
        qtdDeTrocasSelecao = 0;
        int tam = arr.length;
        for (int i = 0; i < tam - 1; i++) {
            int index = i;
            for (int j = i + 1; j < tam; j++) {
                qtdDeCompSelecao++;
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            qtdDeTrocasSelecao++;
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        totalDeTrocaSelecao[pos] = qtdDeTrocasSelecao;
        totalDeCompSelecao[pos] = qtdDeCompSelecao;
    }

    // Algoritmo de ordenação MergeSort
    public static void bubble(Integer arr[], int pos) {
        qtdDeTrocasBolha = 0;
        qtdDeCompBolha = 0;
        int aux = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                qtdDeCompBolha++;
                if (arr[j] > arr[j + 1]) {
                    qtdDeTrocasBolha++;
                    aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }
        totalDeTrocaBolha[pos] = qtdDeTrocasBolha;
        totalDeCompBolha[pos] = qtdDeCompBolha;
    }

    public static List<Integer> geraVetor(int numbersNeeded) throws Exception {
        List<Integer> novo = new LinkedList<Integer>();
        for (int i = 0; i < numbersNeeded; i++) {
            novo.add(i + 1);
        }
        Collections.shuffle(novo);
        return novo;
    }

    // Para ordenar o vetor
    private static void mergeSort(long[] vetor) {
        int elementos = 1;
        int inicio, meio, fim;
        int tamanho = vetor.length;
        while (elementos < tamanho) {
            inicio = 0;

            while (inicio + elementos < tamanho) {
                meio = inicio + elementos;
                fim = inicio + 2 * elementos;

                if (fim > tamanho)
                    fim = tamanho;

                intercala(vetor, inicio, meio, fim);

                inicio = fim;
            }
            elementos = elementos * 2;
        }

    }

    // Para intercalar os vetores
    private static void intercala(long[] vetor, int inicio, int meio, int fim) {
        long novoVetor[] = new long[fim - inicio];
        int i = inicio;
        int m = meio;
        int pos = 0;

        while (i < meio && m < fim) {

            if (vetor[i] <= vetor[m]) {
                novoVetor[pos] = vetor[i];
                pos = pos + 1;
                i = i + 1;

            } else {
                novoVetor[pos] = vetor[m];
                pos = pos + 1;
                m = m + 1;
            }
        }

        while (i < meio) {
            novoVetor[pos] = vetor[i];
            pos = pos + 1;
            i = i + 1;
        }

        while (m < fim) {
            novoVetor[pos] = vetor[m];
            pos = pos + 1;
            m = m + 1;
        }

        for (pos = 0, i = inicio; i < fim; i++, pos++) {
            vetor[i] = novoVetor[pos];
        }
    }
}
