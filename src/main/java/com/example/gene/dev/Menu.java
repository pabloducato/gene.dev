package com.example.gene.dev;

import com.example.gene.dev.exercises.ExerciseOne;
import com.example.gene.dev.exercises.ExerciseThree;
import com.example.gene.dev.exercises.ExerciseTwo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public boolean launchMenu() {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz zadanie do uruchomienia\n1 - Uruchomienie zadania nr 1\n2 - Uruchomienie " +
                "zadania nr 2\n3 - Uruchomienie zadania nr 3\n4 - Wyjście z programu");
        try {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ExerciseOne exerciseOne = new ExerciseOne();
                    exerciseOne.launchFirstTask();
                    break;
                case 2:
                    ExerciseTwo exerciseTwo = new ExerciseTwo();
                    exerciseTwo.launchSecondTask();
                    break;
                case 3:
                    ExerciseThree exerciseThree = new ExerciseThree();
                    exerciseThree.launchThirdTask();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Wpisano nieprawidłową liczbę\n");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Wpisano niedozwolony znak\n");
        }
        return quit;
    }

}
