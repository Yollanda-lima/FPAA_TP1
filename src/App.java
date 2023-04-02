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

    static int[] agrupamento = new int[10000];

    public static void main(String[] args) throws Exception {

        /**

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

        **/

         System.out.println("----------------Parte 2----------------");

         // a

         // Cria um vetor de 10.000 posições
         int[] vetor = new int[10000], vetorPosicao = new int[10001];

         for (int i = 0; i < vetor.length; i++) {
             vetor[i] = i;
         }

         // b

         // Gerar um valor aleatório
         Random random = new Random();
        int valorPesquisa = 0, k=0;


         // Pesquisar o valor
         boolean encontrado = false;
         for (int i = 0; i < 10000; i++) {
             k++;
             valorPesquisa = random.nextInt(11000)+1; // 11_000
             vetorPosicao[k] = pesquisarNumero(valorPesquisa, vetor);
         }


         // c

        for (int i = 0; i < 10000; i++) {
            agrupador(vetorPosicao[i]);
        }
         // Criar um vetor de 1.000.000 posições
         int inicio = 1, fim = 500; // 1_000_000

         // Repetir 1.000.000 vezes
         for (int j = 0; j < 21; j++) {
             System.out.println( inicio+ " - " + fim + ": " + agrupamento[j]);
             inicio = inicio + 500;
             fim = fim + 500;
         }
        System.out.println( 10501+ " - " + 11000 + ": " + 0);

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



        static int pesquisarNumero(int x, int [] vetor) {
            int cont = 0;
            for (cont = 0; cont < vetor.length; cont++) {
                if (vetor[cont] == x) {
                    return cont;
                }
            }
            return 10001;
        }



    static void agrupador(int posicao){
        int num = posicao;

        if (num >= 1 && num <= 500) {
            agrupamento[0] =+ num;
        }

        if (num >= 501 && num <= 1000) {
            agrupamento[1] =+ num;
        }

        if (num >= 1001 && num <= 1500) {
            agrupamento[2] =+ num;
        }

        if (num >= 1501 && num <= 2000) {
            agrupamento[3] =+ num;
        }

        if (num >= 2001 && num <= 2500) {
            agrupamento[4] =+ num;
        }

        if (num >= 2501 && num <= 3000) {
            agrupamento[5] =+ num;
        }

        if (num >= 3001 && num <= 3500) {
            agrupamento[6] =+ num;
        }

        if (num >= 3501 && num <= 4000) {
            agrupamento[7] =+ num;
        }

        if (num >= 4001 && num <= 4500) {
            agrupamento[8] =+ num;
        }

        if (num >= 4501 && num <= 5000) {
            agrupamento[9] =+ num;
        }

        if (num >= 5001 && num <= 5500) {
            agrupamento[10] =+ num;
        }

        if (num >= 5501 && num <= 6000) {
            agrupamento[11] =+ num;
        }

        if (num >= 6001 && num <= 6500) {
            agrupamento[12] =+ num;
        }

        if (num >= 6501 && num <= 7000) {
            agrupamento[13] =+ num;
        }

        if (num >= 7001 && num <= 7500) {
            agrupamento[14] =+ num;
        }

        if (num >= 7501 && num <= 8000) {
            agrupamento[15] =+ num;
        }

        if (num >= 8001 && num <= 8500) {
            agrupamento[16] =+ num;
        }

        if (num >= 8501 && num <= 9000) {
            agrupamento[17] =+ num;
        }

        if (num >= 9001 && num <= 9500) {
            agrupamento[18] =+ num;
        }

        if (num >= 9501 && num <= 10000) {
            agrupamento[19] =+ num;
        }

        if (num >= 10001 && num <= 10500) {
            agrupamento[20] =+ num;
        }

        if(num >= 10501 && num <= 11000){
            //print não tem
        }

    }
}

