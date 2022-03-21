package booksorter;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        TreeSet<Book> bookNameSet = new TreeSet<>();

        bookNameSet.add(new Book("A", 10, "A-writer", 1950));
        bookNameSet.add(new Book("C", 200, "B-writer", 1999));
        bookNameSet.add(new Book("E", 30, "C-writer", 2000));
        bookNameSet.add(new Book("D", 400, "D-writer", 1890));
        bookNameSet.add(new Book("B", 50, "E-writer", 1998));

        printBooks(bookNameSet);

        TreeSet<Book> bookPageNumSet = new TreeSet<>(Comparator.comparingInt(Book::getPageNum));
        bookPageNumSet.addAll(bookNameSet);
        printBooks(bookPageNumSet);
    }

    private static void printBooks(TreeSet<Book> bookSet) {
        for (Book book : bookSet) {
            System.out.println("Book Name: " + book.getBookName() + " Page Number: " + book.getPageNum());
        }
        System.out.println("---------------------------------");
    }
}
