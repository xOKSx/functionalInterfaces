package ru.tunkoff.fintech.qa;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int size = 10;
        int mod;
        while (true) {
            System.out.println("Введите модификатор:");
            if (scanner.hasNextInt()) {
                mod = scanner.nextInt();
                break;
            } else {
                System.out.println("Неверный формат числа. Требуется тип integer.");
                scanner.nextLine();
            }
        }

        int[] array1 = getArray(
                size,
                mod,
                Integer::sum);
        System.out.println(Arrays.toString(array1));

        int[] array2 = getArray(
                size,
                mod,
                (index, modifier) -> index * modifier);
        System.out.println(Arrays.toString(array2));

        int[] array3 = getArray(
                size,
                mod,
                (index, modifier) -> {
                    if (index % 2 == 0) {
                        return index / 2 + modifier;
                    } else {
                        return index * index - modifier;
                    }
                });
        System.out.println(Arrays.toString(array3));

        /*
        Формирует массив, в котором все числа приравнены к нулю, кроме тех,
        которые делятся нацело на модификатор.
         */
        int[] array4 = getArray(
                size,
                mod,
                (index, modifier) -> {
                    if (index % modifier == 0) {
                        return index;
                    } else {
                        return 0;
                    }
                });
        System.out.println(Arrays.toString(array4));

        /*
        Формирует массив, в котором каждый элемент представляет собой значение модификатора,
        умноженное на разность индекса элемента и модуля модификатора.
         */
        int[] array5 = getArray(
                size,
                mod,
                (index, modifier) -> modifier * (index - Math.abs(modifier)));
        System.out.println(Arrays.toString(array5));

        scanner.close();
    }

    public static int[] getArray(final int size, final int modifier, final ArrayElementMaker<Integer> maker) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = maker.process(i, modifier);
        }
        return array;
    }
}
