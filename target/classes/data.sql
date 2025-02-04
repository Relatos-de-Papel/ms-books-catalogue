-- Inserts for Author
INSERT INTO authors (id, name) VALUES (1, 'Gabriel García Márquez');
INSERT INTO authors (id, name) VALUES (2, 'George Orwell');
INSERT INTO authors (id, name) VALUES (3, 'J.K. Rowling');

-- Inserts for Category
INSERT INTO categories (id, name) VALUES (1, 'Realismo Mágico');
INSERT INTO categories (id, name) VALUES (2, 'Distopía');
INSERT INTO categories (id, name) VALUES (3, 'Fantasía');

-- Inserts for Editorial
INSERT INTO editorials (id, name) VALUES (1, 'Editorial Sudamericana');
INSERT INTO editorials (id, name) VALUES (2, 'Secker & Warburg');
INSERT INTO editorials (id, name) VALUES (3, 'Bloomsbury Publishing');

-- Inserts for Book
INSERT INTO books (id, name, author_Id, category_Id, editorial_Id, unit_Price, ISBN, stock, is_Active, date_Published, ranking, type, visible)
VALUES (1, 'Cien años de soledad', 1, 1, 1, 22.50, '978-0307474728', 150, true, '1967-05-30', 5, 'Novela', true);

INSERT INTO books (id, name, author_Id, category_Id, editorial_Id, unit_Price, ISBN, stock, is_Active, date_Published, ranking, type, visible)
VALUES (2, '1984', 2, 2, 2, 18.99, '978-0451524935', 120, true, '1949-06-08', 5, 'Ficción', true);

INSERT INTO books (id, name, author_Id, category_Id, editorial_Id, unit_Price, ISBN, stock, is_Active, date_Published, ranking, type, visible)
VALUES (3, 'Harry Potter y la piedra filosofal', 3, 3, 3, 25.99, '978-0747532743', 200, true, '1997-06-26', 5, 'Fantasía', true);

-- Inserts for Review
INSERT INTO reviews (id, book_Id, user_Id, review, rank)
VALUES (1, 1, 101, 'Una obra maestra del realismo mágico.', '5');

INSERT INTO reviews (id, book_Id, user_Id, review, rank)
VALUES (2, 1, 102, 'Increíble narrativa, una historia única.', '5');

INSERT INTO reviews (id, book_Id, user_Id, review, rank)
VALUES (3, 2, 103, 'Impactante y actual, una lectura obligada.', '5');

INSERT INTO reviews (id, book_Id, user_Id, review, rank)
VALUES (4, 2, 104, 'Me hizo reflexionar sobre la sociedad.', '4');

INSERT INTO reviews (id, book_Id, user_Id, review, rank)
VALUES (5, 3, 105, 'Un clásico moderno, lleno de magia y aventura.', '5');
