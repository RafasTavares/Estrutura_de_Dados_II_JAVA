
package com.project.collection;

import java.util.Comparator;

public class Sort {

    private static Object[] qSortArray;
    
    @SuppressWarnings("rawtypes")
    private static Comparator comparador;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void selecao(Object[] a, Comparator c) {
        int iMenor;
        Object temp;

        for (int i = 0; i <= a.length - 2; i++) {
            iMenor = i;
            for (int k = i + 1; k <= a.length - 1; k++) {
                if (c.compare(a[k], a[iMenor]) < 0) {
                    iMenor = k;
                }
            }
            if (i != iMenor) {
                temp = a[i];
                a[i] = a[iMenor];
                a[iMenor] = temp;
            }
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void bolha(Object[] a, Comparator c) {
        int fim;
        Object temp;
        boolean troquei;

        fim = a.length - 1;
        do {
            troquei = false;
            for (int i = 0; i <= fim - 1; i++) {
                if (c.compare(a[i], a[i + 1]) > 0) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    troquei = true;
                }
            }
            fim--;
        } while (troquei);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void insercao(Object[] vetor, Comparator c) {
        int k;
        Object temp;

        for (int i = 0; i <= vetor.length - 1; i++) {
            k = i;
            temp = vetor[i];

            while ((k > 0) && (c.compare(temp, vetor[k - 1]) < 0)) {
                vetor[k] = vetor[k - 1];
                k--;
            }
            vetor[k] = temp;
        }
    }

    @SuppressWarnings("rawtypes")
    public static void quickSort(Object[] a, Comparator c) {
        qSortArray = a;
        comparador = c;
        qSort(0, qSortArray.length - 1);
        a = qSortArray;
    }

    private static void qSort(int primeiro, int ultimo) {
        int indicePivo;
        if (primeiro < ultimo) {
            indicePivo = Separar(qSortArray, primeiro, ultimo);
            qSort(primeiro, ultimo - 1);
            qSort(indicePivo + 1, ultimo);
        }
    }

    @SuppressWarnings("unchecked")
    private static int Separar(Object[] vetor, int inicio, int fim) {
        Object pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (comparador.compare(vetor[i], pivo) < 1) {
                i++;
            } else if (comparador.compare(pivo, vetor[f]) < 0) {
                f--;
            } else {
                Object troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }
    
}
