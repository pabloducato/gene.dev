SELECT *
FROM authors
         JOIN book_authors ON authors.author_id = book_authors.author_id
         JOIN books ON book_authors.book_id = books.book_id
         JOIN publishers ON books.publisher_id = publishers.publisher_id
         JOIN book_genres ON books.book_id = book_genres.book_id
         JOIN genres ON book_genres.genre_id = genres.genre_id
ORDER BY genres.genre ASC;