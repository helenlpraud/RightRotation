package com.company;

import java.util.Scanner;

class Main {

    public static int[] numArr;
    public static int[] copyNumArr;
    public static int countSort;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String[] subStr;
        String delimiter = " "; // Разделитель
        subStr = s.split(delimiter);
        int a;
        numArr = new int[subStr.length];
        copyNumArr = new int[subStr.length];

        countSort = scanner.nextInt();

        try {
            for (int i = 0; i < subStr.length; i++) {
                a = Integer.parseInt(subStr[i]);
                numArr[i] = a;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        if (countSort == 1 || countSort == numArr.length) {
            toRearrange();
        } else if (countSort > numArr.length) {
            int size = countSort % numArr.length;
            for (int i = 0; i < size; i++) {
                toRearrange();
            }
        } else {
            for (int i = 0; i < countSort; i++) {
                toRearrange();
            }
        }

        for (int n:numArr) {
            System.out.print(n + " ");
        }

    }
    public static void toRearrange() {
        for (int j = 1; j < numArr.length; j++) {
            if (j == 1) {
                copyNumArr[j - 1] = numArr[numArr.length - 1];
            }
            copyNumArr[j] = numArr[j - 1];
            if (j != numArr.length - 1) {
                copyNumArr[j + 1] = numArr[j];
            }
        }
        numArr = copyNumArr;
        copyNumArr = new int[numArr.length];
    }
}
