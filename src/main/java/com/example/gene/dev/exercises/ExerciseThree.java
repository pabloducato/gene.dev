package com.example.gene.dev.exercises;

public class ExerciseThree {

    public void launchThirdTask() {
        System.out.println("Kwerenda SQL\n");
        System.out.println("SELECT *\n" +
                "FROM authors\n" +
                "         JOIN book_authors ON authors.author_id = book_authors.author_id\n" +
                "         JOIN books ON book_authors.book_id = books.book_id\n" +
                "         JOIN publishers ON books.publisher_id = publishers.publisher_id\n" +
                "         JOIN book_genres ON books.book_id = book_genres.book_id\n" +
                "         JOIN genres ON book_genres.genre_id = genres.genre_id\n" +
                "ORDER BY genres.genre ASC;\n");
    }

}
