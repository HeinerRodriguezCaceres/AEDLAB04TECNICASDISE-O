package Ejercicios;

import java.util.Random;

public class QuickSelect {
	public static void main(String[] args) {
        int[] arreglo1 = {4, 2, 7, 10, 4, 17};
        int k1 = 3;
        System.out.println(kMenor(arreglo1, k1));

        int[] arreglo2 = {4, 2, 7, 10, 4, 1, 6};
        int k2 = 5;
        System.out.println(kMenor(arreglo2, k2));

        int[] arreglo3 = {4, 2, 7, 1, 4, 6};
        int k3 = 1;
        System.out.println(kMenor(arreglo3, k3));

        int[] arreglo4 = {9, 2, 7, 1, 7};
        int k4 = 4;
        System.out.println(kMenor(arreglo4, k4));
    }

    public static int kMenor(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException("k fuera de rango");
        }
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    private static int quickSelect(int[] arr, int izquierda, int derecha, int k) {
        if (izquierda == derecha) {
            return arr[izquierda];
        }

        Random rand = new Random();
        int pivoteIndex = izquierda + rand.nextInt(derecha - izquierda + 1);
        pivoteIndex = particionar(arr, izquierda, derecha, pivoteIndex);

        if (k == pivoteIndex) {
            return arr[k];
        } else if (k < pivoteIndex) {
            return quickSelect(arr, izquierda, pivoteIndex - 1, k);
        } else {
            return quickSelect(arr, pivoteIndex + 1, derecha, k);
        }
    }

    private static int particionar(int[] arr, int izquierda, int derecha, int pivoteIndex) {
        int pivoteValor = arr[pivoteIndex];
        intercambiar(arr, pivoteIndex, derecha);
        int almacen = izquierda;

        for (int i = izquierda; i < derecha; i++) {
            if (arr[i] < pivoteValor) {
                intercambiar(arr, almacen, i);
                almacen++;
            }
        }

        intercambiar(arr, derecha, almacen);
        return almacen;
    }

    private static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
