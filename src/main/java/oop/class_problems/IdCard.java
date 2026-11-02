package oop.class_problems;

public class IdCard {

    String name;
    int booksIssued;

    IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {

        IdCard ravi = new IdCard("Ravi", 1);

        // Both references point to the same object
        IdCard duplicate = ravi;

        duplicate.booksIssued = 3;

        System.out.println(ravi.booksIssued);
        System.out.println(duplicate == ravi);

        // A separate object with the same values
        IdCard separate = new IdCard("Ravi", 3);

        System.out.println(separate == ravi);
    }
}
