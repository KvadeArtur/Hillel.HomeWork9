package com.kvart;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //1 Матрица умноженная на число

        int value = random.nextInt(10) + 1;
        int[][] matrix = new int[3][3];

        matrixValue(matrix, value);

        //2 Среднее арифметическое матрицы

        midle();

        //3 Сколько раз число встречается в матрице

        System.out.println("Введите число: ");
        int inVal = scanner.nextInt();

        inValue(inVal);

        //4 Строка с максимальной суммой элементов

        maxString();

        //5 Поменять местами строки матрицы

        int[][] matIndex = new int[5][3];
        int index1 = random.nextInt(matIndex.length);
        int index2 = random.nextInt(matIndex.length);
        change(matIndex, index1, index2);

        //6 Поменять местами столбцы матрицы

        int[][] matColumn = new int[3][5];
        int index11 = random.nextInt(matColumn[0].length);
        int index12 = random.nextInt(matColumn[0].length);
        changeColumn(matColumn, index11, index12);

        //7 Отсортировать матрицу

        matrixSort();

        //8 Повернуть матрицу на 90 градусов

        turn();

    }

    /*
    1. Написать метод который принимает матрицу и число.
    Умножить каждый элемент на число.
    */

    private static void matrixValue (int[][] matrix, int value) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10) + 1;
            }
        }
        System.out.println("Исходный массив: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("Число на которое умножаем: " + value);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] *= value;
            }
        }
        System.out.println("Умноженый массив: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /*
    2. Вывести среднее арифметическое матрицы случайных чисел
     */

    private static void midle () {
        int[][] matrix = new int[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10) + 1;
            }
        }
        System.out.println("\nИсходный массив: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        double midleMath = 0.0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                midleMath += matrix[i][j];
            }
        }
        int quantity = 0;
        for (int i = 0; i < matrix.length; i++) {
            quantity += matrix[i].length;
        }
        midleMath /= (double)quantity;
        midleMath = (Math.round(midleMath * 100.0) / 100.0);

        System.out.println("Среднее арефметическое: " + midleMath);
    }

    /*
    3. Задана матрица случайных чисел. Пользователь вводит число.
     Вывести сколько раз это число встречается в матрице
     */

    private static void inValue (int value) {
        int[][] matrix = new int[3][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        System.out.println("\nИсходный массив: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        int score = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == value) {
                    score++;
                }
            }
        }
        System.out.printf("Это число встречается %s раз", score);
    }

    /*
    4. Найти строку матрицы с максимальной суммой элементов
     */

    private static void maxString () {
        int[][] matrix = new int[5][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        System.out.println("\nИсходный массив: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        int max = 0;
        int sumS = 0;
        int sumM = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sumS += matrix[i][j];
            }
            if (sumM < sumS) {
                sumM = sumS;
                max = i + 1;
            }
            sumS = 0;
        }

        System.out.println("Строка с максимальной сумой елементов: " + max);
    }

    /*
    5. Написать метод который принимает матрицу и 2 индекса.
     Поменять местами строки матрицы с этими индексами
     */

    private static void change (int[][] matrix, int index1, int index2) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        System.out.println("\nИсходный массив: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println("Индексы: " + (index1 + 1) + ", " + (index2 + 1));
        int[] changeInd = matrix[index1];
        matrix[index1] = matrix[index2];
        matrix[index2] = changeInd;

        System.out.println("Массив с поменяными строками: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /*
    6. Написать метод который принимает матрицу и 2 индекса.
     Поменять местами столбцы матрицы с этими индексами
     */

    private static void changeColumn (int[][] matrix, int index1, int index2) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        System.out.println("\nИсходный массив: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println("Индексы: " + (index1 + 1) + ", " + (index2 + 1));

        int column = 0;
        for (int i = 0; i < matrix.length; i++) {
            column = matrix[i][index1];
            matrix[i][index1] = matrix[i][index2];
            matrix[i][index2] = column;
        }

        System.out.println("Массив с поменяными столбцами: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /*
    7*. Задана матрица случайных чисел. Отсортировать матрицу.
     */

    private static void matrixSort () {
        int[][] matrix = new int[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        System.out.println("\nИсходный массив: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
        }
        System.out.println("Отсортированный массив по строкам: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        int longer = matrix.length * matrix[0].length;
        int[] iSort = new int[longer];

        int is = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                iSort[is] = matrix[i][j];
                is++;
                if (is == iSort.length) {
                    break;
                }
            }
        }

        Arrays.sort(iSort);

        int iso = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = iSort[iso];
                iso++;
                if (iso == iSort.length) {
                    break;
                }
            }
        }

        System.out.println("Отсортированный массив: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /*
    8.* Повернуть матрицу на 90 градусов.
     */

    private static void turn () {
        int[][] matrix = new int[5][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        System.out.println("\nИсходный массив: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        int[][] turnMatrix = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < turnMatrix.length; i++) {
            for (int j = 0; j < turnMatrix[i].length; j++) {
                turnMatrix[i][j] = matrix[j][turnMatrix.length - 1 - i];
            }
        }

        System.out.println("\nПовернутый массив: ");
        for (int i = 0; i < turnMatrix.length; i++) {
            System.out.println(Arrays.toString(turnMatrix[i]));
        }
    }
}
