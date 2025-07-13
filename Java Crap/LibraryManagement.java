abstract class Book {
    String title;
    String author;
    boolean isAvailable;

    Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    abstract void getDetails();
}

class PrintedBook extends Book {
    PrintedBook(String title, String author, boolean isAvailable) {
        super(title, author, isAvailable);
    }

    void getDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        if(isAvailable) System.out.println("Availability: " + "Available");
        else System.out.println("Availability: " + "Not Available");
    }
}

class EBook extends Book {
    EBook(String title, String author) {
        super(title, author, true);
    }

    void getDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

interface User {
    void borrowBook(Book book);
    void returnBook(Book book);
    void getBorrowedBooks();
}

class Student implements User {
    String ID;
    String name;

    Student(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    Book[] borrowed = new Book[3];

    public void borrowBook(Book book) {
        if(book.isAvailable) {
            for(int i=0; i<3; i++) {
                if(borrowed[i] == null) {
                    borrowed[i] = book;
                    book.isAvailable = false;
                    System.out.println(book.title + " is borrowed");
                    break;
                }
            }
            System.out.println("Borrowing more than 3 books is not allowed");
        } else {
            System.out.println(book.title + " was already borrwed");
        }
    }

    public void returnBook(Book book) {
        if(!book.isAvailable) {
            for(int i=0; i<3; i++) {
                if(borrowed[i] == book) {
                    borrowed[i] = null;
                    book.isAvailable = true;
                    System.out.println(book.title + " is returned");
                    break;
                }
            }
            System.out.println("Book wasn't borroed");
        } else {
            System.out.println(book.title + " is available for borrowing");}
    }

    public void getBorrowedBooks() {
        for(int i=0; i<3; i++) {
            if(borrowed[i] != null) {
                borrowed[i].getDetails();
            }
        }
    }
}

class Teacher implements User {
    String ID;
    String name;

    Teacher(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    Book[] borrowed = new Book[10];

    public void borrowBook(Book book) {
        if(book.isAvailable) {
            for(int i=0; i<10; i++) {
                if(borrowed[i] == null) {
                    borrowed[i] = book;
                    book.isAvailable = false;
                    System.out.println(book.title + " is borrowed");
                    break;
                }
            }
            System.out.println("Borrowing more than 3 books is not allowed");
        } else {
            System.out.println(book.title + " was already borrwed");
        }
    }

    public void returnBook(Book book) {
        if(!book.isAvailable) {
            for(int i=0; i<10; i++) {
                if(borrowed[i] == book) {
                    borrowed[i] = null;
                    book.isAvailable = true;
                    System.out.println(book.title + " is returned");
                    break;
                }
            }
            System.out.println("Book wasn't borroed");
        } else {
            System.out.println(book.title + " is available for borrowing");}
    }

    public void getBorrowedBooks() {
        for(int i=0; i<10; i++) {
            if(borrowed[i] != null) {
                borrowed[i].getDetails();
            }
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        System.out.println("Library Management System");
    }
}
