import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] cartas = new int[7];
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Valores das cartas");
            System.out.println("2 - Método Bubblesort");
            System.out.println("3 - Método Selectionsort");
            System.out.println("4 - Método InserctionSort");
            System.out.println("5 - Método de Quicksort");
            System.out.println("6 - Método de Heapsort");
            System.out.println("7 - Método de Mergesort");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Informe os valores das 7 cartas (de 1 a 13):");
                    for (int i = 0; i < 7; i++) {
                        System.out.print("Carta " + (i + 1) + ": ");
                        cartas[i] = scanner.nextInt();
                    }
                    break;
                case 2:
                    bubbleSort(cartas.clone());
                    break;
                case 3:
                    selectionSort(cartas.clone());
                    break;
                case 4:
                    insertionSort(cartas.clone());
                    break;
                case 5:
                    quickSort(cartas.clone(), 0, 6);
                    break;
                case 6:
                    heapSort(cartas.clone());
                    break;
                case 7:
                    mergeSort(cartas.clone(), 0, 6);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    // Função para imprimir um array de inteiros
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Método de ordenação Bubblesort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp;
        boolean swapped;
        System.out.println("Método Bubblesort:");
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            printArray(arr);
            if (!swapped) {
                break;
            }
        }
    }

    // Método de ordenação Selectionsort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        System.out.println("Método Selectionsort:");
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            printArray(arr);
        }
    }

    // Método de ordenação Insertionsort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        System.out.println("Método Insertionsort:");
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            printArray(arr);
        }
    }

    // Método de ordenação Quicksort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Função auxiliar para particionar o array no Quicksort
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        printArray(arr);
        return i + 1;
    }

    // Método de ordenação Heapsort
    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        System.out.println("Método Heapsort:");
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
            printArray(arr);
        }
    }

    // Função auxiliar para construir um heap
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    // Método de ordenação Mergesort
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    // Função auxiliar para mesclar dois subarrays no Mergesort
    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        printArray(arr);
    }
}
