package com.example.gene.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class Application {

    private static int roomId = 0;
    private static int perfectNumManifestation = 0;
    private static int oldNumberLength = 0;
    public static List<Integer> numberList = new ArrayList<>();
    static boolean quit = false;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        do {
            menu();
        } while (!quit);
    }

    private static void menu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz zadanie do uruchomienia");
        System.out.println("1 - Uruchomienie zadania nr 1");
        System.out.println("2 - Uruchomienie zadania nr 2");
        System.out.println("3 - Uruchomienie zadania nr 3");
        System.out.println("4 - Wyjście z programu");

        try {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    firstTask();
                    break;
                case 2:
                    secondTask();
                    break;
                case 3:
                    thirdTask();
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

    }

    //zadanie nr 1
    private static void firstTask() {
        roomId = 0;

        int[] taskIndexArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] startHourArray = {8, 8, 9, 9, 12, 12, 11, 8, 12};
        int[] endHourArray = {10, 11, 11, 11, 14, 13, 13, 11, 13};

        ArrayList<Meeting> resultMeetingArray = new ArrayList<>();

        for (int i = 0; i < taskIndexArray.length; i++) {
            Meeting meeting = new Meeting();
            meeting.setMeetingId(taskIndexArray[i]);
            meeting.setStartHour(startHourArray[i]);
            meeting.setEndHour(endHourArray[i]);
            resultMeetingArray.add(meeting);
        }

        System.out.println("Zadanie nr 1");
        System.out.println("Zajęcia, które należy rozplanować: ");
        for (Meeting meeting : resultMeetingArray) {
            System.out.println("Indeks: " + meeting.getMeetingId() + " -> " + "Godziny: " + meeting.getStartHour() +
                    " - " + meeting.getEndHour());
        }
        System.out.println("");

        while (resultMeetingArray.size() > 0) {
            maxMeetings(resultMeetingArray, roomId);
            roomId++;
        }

        System.out.println("Minimalna, wymagana liczba sal, aby obsłużyć podane spotkania wynosi: " + roomId + "\n");
    }

    public static void maxMeetings(ArrayList<Meeting> meetings, int roomId) {

        meetings.sort(Comparator.comparingInt(Meeting::getEndHour));

        ArrayList<Meeting> selectedMeetings = new ArrayList<>();
        int currentEndTime = -1;
        for (Meeting currentMeeting : meetings) {
            if (currentMeeting.getStartHour() >= currentEndTime) {
                selectedMeetings.add(currentMeeting);
                currentEndTime = currentMeeting.getEndHour();
            }
        }

        System.out.println("Zaplanowane spotkania w sali nr: " + roomId);
        for (Meeting selectedMeeting : selectedMeetings) {
            System.out.println("Indeks: " + selectedMeeting.getMeetingId() + " -> " + "Godziny: " +
                    selectedMeeting.getStartHour() + " - " + selectedMeeting.getEndHour());
        }

        meetings.removeAll(selectedMeetings);
    }

    //zadanie nr 2
    private static void secondTask() {
        perfectNumManifestation = 0;

        int incrementationValue = 1000;
        int allNumbers = (int) (((new Date().getTime() / 1000 % 60) + 1) * incrementationValue);
        System.out.println("Zadanie nr 2");
        for (int i = 0; i < allNumbers; i++) {
            int target = generateRandomNumber();
            numberList.add(target);
            printDivisors(target);
        }

        System.out.println("Wygenerowano następujący ciąg liczb losowych: " + numberList);

        if (perfectNumManifestation != 0) {
            System.out.println("Wylosowano " + perfectNumManifestation + " liczb doskonałych, które stanowią " +
                    (double) perfectNumManifestation / allNumbers * 100 + " % spośród " + allNumbers + " liczb\n");
        } else {
            System.out.println("Nie wylosowano żadnych liczb doskonałych\n");
        }

    }

    private static void printDivisors(int n) {
        //System.out.println("Liczba: " + n);
        String input;
        String[] numbers;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && n != i) {
                input = i + " ";
                numbers = input.split("\\s+");
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
        //System.out.println("Suma jej dzielników mniejszych od niej: " + sum + "\n");
    }

    private static int generateRandomNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int length = 0;

        if (oldNumberLength == 1) {
            length = 2;
        } else if (oldNumberLength == 2) {
            length = 3;
        } else if (oldNumberLength == 3) {
            length = 4;
        } else if (oldNumberLength == 4) {
            length = 5;
        } else {
            length = 1;
        }

        oldNumberLength = length;
        Random generator = new Random();

        StringBuilder actualNumber = new StringBuilder();
        for (int j = 0; j <= length; j++) {
            actualNumber.append(generator.nextInt(numbers.size()));
        }

        return Integer.parseInt(String.valueOf(actualNumber));
    }

    // zadanie nr 3
    private static void thirdTask() {
        System.out.println("Kwerenda SQL\n");
        System.out.println("SELECT *\n" +
                "FROM authors\n" +
                "         JOIN book_authors ON authors.author_id = book_authors.author_id\n" +
                "         JOIN books ON book_authors.book_id = books.book_id\n" +
                "         JOIN publishers ON books.publisher_id = publishers.publisher_id\n" +
                "         JOIN book_genres ON books.book_id = book_genres.book_id\n" +
                "         JOIN genres ON book_genres.genre_id = genres.genre_id\n" +
                "ORDER BY genres.genre ASC;");
        System.out.println("");
    }

}
