package com.example.gene.dev.exercises;

public class ExerciseThree {

    public void launchThirdTask() {
        System.out.println("Kwerenda SQL\n\nSELECT a.first_name, a.middle_name, a.last_name, b.title, p.name\n" +
                "FROM authors a\n" +
                "         JOIN book_authors ba ON a.author_id = ba.author_id\n" +
                "         JOIN books b ON ba.book_id = b.book_id\n" +
                "         JOIN publishers p ON b.publisher_id = p.publisher_id\n" +
                "         JOIN book_genres bg ON b.book_id = bg.book_id\n" +
                "         JOIN genres g ON bg.genre_id = g.genre_id\n" +
                "ORDER BY g.genre;\n");
    }

}
