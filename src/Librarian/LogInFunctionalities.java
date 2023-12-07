package Librarian;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LogInFunctionalities {



    public  D_Users checkUser(String usernametextFiled, String PassswrdField, String filePath) throws IOException {

        usernametextFiled = usernametextFiled.replaceAll("\\s+$", "");
        File file = new File(filePath);

        if (!file.exists()) {
            throw new FileNotFoundExceptionCustom("File does not exist");
        }

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream objis = new ObjectInputStream(fis);
        D_Users user;
        while (true) {
            try {
                user = ((D_Users) objis.readObject());
                if (usernametextFiled.equals(user.getFirstName()) && PassswrdField.equals(user.getPassword())) {
                    return user;
                }
            } catch (ClassNotFoundException | IOException e) {
                return null;
            }
        }
    }




}
