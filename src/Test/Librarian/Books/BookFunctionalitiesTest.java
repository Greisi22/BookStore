package Test.Librarian.Books;

import Librarian.Zh_Books;
import Librarian.BookFunctionalities;
import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookFunctionalitiesTest {
    @TempDir
    static File tempFolder;

    @AfterEach
    void cleanup() {
        tempFolder.delete();
    }

    @Test
    void testGetBooks() throws IOException {
        File tempFile = new File(tempFolder, "testBooks.dat");

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(tempFile))) {
            Zh_Books book1 = new Zh_Books("Book 1", "Author 1", 2023);
            Zh_Books book2 = new Zh_Books("Book 2", "Author 2", 2024);
            objectOutputStream.writeObject(book1);
            objectOutputStream.writeObject(book2);
        }

        ArrayList<Zh_Books> bookList;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(tempFile))) {
            bookList = new ArrayList<>();
            while (true) {
                try {
                    Zh_Books book = (Zh_Books) objectInputStream.readObject();
                    bookList.add(book);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        assertEquals(2, bookList.size());
        assertEquals("Book 1", bookList.get(0).getTitle());
        assertEquals("Author 2", bookList.get(1).getISBN());
        assertEquals(2024, bookList.get(1).getQuanity());
    }



}