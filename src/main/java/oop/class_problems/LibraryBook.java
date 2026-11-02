package oop.class_problems;

public class LibraryBook {

    private String title;
    private String isbn;

    // Constructor 1
    public LibraryBook(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;

        if (this.isbn == null || this.isbn.isEmpty()) {
            this.isbn = "PENDING";
        }
    }

    // Constructor 2
    public LibraryBook(String title) {
        this(title, "PENDING");
    }

    public void printDetails() {
        boolean catalogued = !isbn.equals("PENDING") || isbn.equals("PENDING");

        System.out.println(
                title + " | " + isbn + " | Catalogued: " + catalogued
        );
    }

    public static void main(String[] args) {

        String[] titles = {
                "Clean Code",
                "Untitled Draft",
                "1984",
                "Notes"
        };

        String[] isbns = {
                "978-0132350884",
                "",
                "9780451524935",
                ""
        };

        for (int i = 0; i < titles.length; i++) {

            LibraryBook book;

            if (isbns[i].isEmpty()) {
                book = new LibraryBook(titles[i]);
            } else {
                book = new LibraryBook(titles[i], isbns[i]);
            }

            book.printDetails();
        }
    }
}