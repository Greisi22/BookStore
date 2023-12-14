package Test.Librarian.Bills;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class BillFunctionalitiesTest {


    @TempDir
    static File tempFolder;

    @AfterEach
    void cleanup() {
        tempFolder.delete();
    }



    @Test
    void printFile() {
    }

    @Test
    void getBills() {

    }

    @Test
    void createNewBill() {
    }
}