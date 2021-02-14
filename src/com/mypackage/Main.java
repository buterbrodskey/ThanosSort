package com.mypackage;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr0 = {2, 94, 12, 22, 66, 10, 99, 0};
        int[] arr1 = {};
        int[] arr2 = {2, 94, 12, 22, 66, 10, 99};
        int[] arr3 = {2,1,1,1,1,1,1};


        ThanosSort(arr0, 0, arr0.length);
        for (int i : arr0) {
            System.out.print(i + " ");
        }

        System.out.println();

        ThanosSort(arr1, 0, arr1.length);
        for (int i : arr1) {
            System.out.print(i + " ");
        }

        System.out.println();

        ThanosSort(arr2, 0, arr2.length);
        for (int i : arr2) {
            System.out.print(i + " ");
        }

        System.out.println();

        ThanosSort(arr3, 0, arr3.length);
        for (int i : arr3) {
            System.out.print(i + " ");
        }
    }

    public static void ThanosSort(int[] arr, int l, int r) {
        if (arr.length == 0) {
            return;
        }

        boolean isSorted = true;

        int[] temp = Arrays.copyOfRange(arr, l, r);

        int avg = 0;
        for (int i = l; i < r; i++) {
            avg += arr[i];
        }
        avg /= (r - l);

        int l_edge = l, r_edge = r - 1;

        for (int i = 0; i < (r - l); i++) {
            if (temp[i] <= avg) {
                arr[l_edge] = temp[i];
                l_edge++;

                isSorted = temp[i] == avg ? isSorted : false; // на случай, если все элементы в подмассиве окажутся равными

            } else {
                arr[r_edge] = temp[i];
                r_edge--;
                isSorted = false;
            }
        }
        if (temp.length == 2 || temp.length == 1) {
            return;
        }
        if (isSorted) { return; }
        ThanosSort(arr, l, l_edge);
        ThanosSort(arr, l_edge, r);
    }
}
