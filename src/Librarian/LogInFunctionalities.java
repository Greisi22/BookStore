package Librarian;

import Administator.View;
import Menager.view;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;s
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.constant.Constable;
import java.util.Arrays;
import java.util.List;

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

    public static List<Constable> handleLogin(TextField usernametextFiled, PasswordField PassswrdField) {
        try {
            LogInFunctionalities logInFunctionalities = new LogInFunctionalities();
            D_Users isuser = logInFunctionalities.checkUser(usernametextFiled.getText(), PassswrdField.getText(), "src/EncodedInformation/Users.dat");
            if (isuser == null) {
                return Arrays.asList(ResultType.INCORRECT_USER, "Incorrect Userername or password");
            } else {
                if (isuser.getAccesLevel().equals(Zh_accessLevel.LIBRARIAN)) {
                    return Arrays.asList(ResultType.LIBRARIAN_LOGIN, isuser.getFirstName());
                } else if (isuser.getAccesLevel().equals(Zh_accessLevel.MANAGER)) {
                    return Arrays.asList(ResultType.MANAGER_LOGIN, isuser.getFirstName());
                } else if (isuser.getAccesLevel().equals(Zh_accessLevel.ADMINISTRATOR)) {
                    return Arrays.asList(ResultType.ADMIN_LOGIN, isuser.getFirstName());
                } else {
                    return Arrays.asList(ResultType.TRY_AGAIN, "Try Again");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Arrays.asList(ResultType.TRY_AGAIN, "");
        }
    }




}
