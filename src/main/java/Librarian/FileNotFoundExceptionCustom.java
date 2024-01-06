package Librarian;

import java.io.IOException;

public class FileNotFoundExceptionCustom extends IOException {
    public FileNotFoundExceptionCustom(String message) {
        super(message);
    }
}
