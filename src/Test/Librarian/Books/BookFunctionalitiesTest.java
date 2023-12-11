package Test.Librarian.Books;

import Librarian.Zh_Books;
import Librarian.BookFunctionalities;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookFunctionalitiesTest {


    @Rule
    File tempFolder1;

    @Test
    public void testGetBookss() throws IOException {
        File tempFile = new File( tempFolder1 ,"testBooks.dat");

        // Serialize objects into the temporary file
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(tempFile));
        Zh_Books book1 = new Zh_Books("Book 1", "Author 1", 2023);
        Zh_Books book2 = new Zh_Books("Book 2", "Author 2", 2024);
        objectOutputStream.writeObject(book1);
        objectOutputStream.writeObject(book2);
        objectOutputStream.close();

        // Call getBooks method to read from the temporary file
        ArrayList<Zh_Books> bookList = new ArrayList<>();
        BookFunctionalities.getBooks(bookList, tempFile.getAbsolutePath());

        // Assertions
        assertEquals(2, bookList.size());
        assertEquals("Book 1", bookList.get(0).getTitle());
        assertEquals("Author 2", bookList.get(1).getISBN());
        assertEquals(2024, bookList.get(1).getQuanity());
        ArrayList<Zh_Books> bookList1 = new ArrayList<>();

        File tempFile1 = new File( tempFolder1 ,"testBooks.dat");
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(new FileOutputStream(tempFile1));
        BookFunctionalities.getBooks(bookList, tempFile.getAbsolutePath());
        assertEquals(2, bookList.size());
    }


}