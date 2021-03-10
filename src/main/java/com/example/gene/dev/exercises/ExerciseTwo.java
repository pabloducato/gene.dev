package com.example.gene.dev.exercises;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExerciseTwo {

    private static int oldNumberLength = 0;

    public void launchSecondTask() {
        int perfectNumManifestation = 0;
        final List<Integer> numberList = new ArrayList<>();

        int allNumbers = (int) (((new Date().getTime() / 1000 % 60) + 1) * 1000);
        System.out.println("Zadanie nr 2");
        for (int i = 0; i < allNumbers; i++) {
            int target = generateRandomNumber();
            numberList.add(target);
            perfectNumManifestation = printDivisors(target, perfectNumManifestation);
        }

        System.out.println("Wygenerowano następujący ciąg liczb losowych: " + numberList);

        if (perfectNumManifestation != 0) {
            System.out.println("Wylosowano " + perfectNumManifestation + " liczb doskonałych, które stanowią " +
                    (double) perfectNumManifestation / allNumbers * 100 + " % spośród " + allNumbers + " liczb\n");
        } else {
            System.out.println("Nie wylosowano żadnych liczb doskonałych\n");
        }
    }

    private int printDivisors(int n, int perfectNumManifestation) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && n != i) {
                String input = i + " ";
                String[] numbers = input.split("\\s+");
                for (String number : numbers) {
                    int s = Integer.parseInt(number);
                    sum += s;
                }
            }
        }
        if (sum == n && sum != 0) {
            perfectNumManifestation += 1;
            System.out.println("###### Doskonała liczba " + n + " ###### -> Licznik: " + perfectNumManifestation);
        }
        return perfectNumManifestation;
    }

    private int generateRandomNumber() {

        int length = oldNumberLength == 1 ? 2 : (oldNumberLength == 2 ? 3 : (oldNumberLength == 3 ? 4 : (oldNumberLength == 4 ? 5 : 1)));

        oldNumberLength = length;

        StringBuilder actualNumber = new StringBuilder();
        for (int j = 0; j <= length; j++) {
            int[] digits = Long.toString(System.currentTimeMillis()).chars().map(c -> c - '0').toArray();
            actualNumber.append(digits[digits.length - length - j]);
        }

        return Integer.parseInt(String.valueOf(actualNumber));
    }

}
