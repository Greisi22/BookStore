package com.example.Model.Login;




import com.example.Model.Userss.Users;
import com.example.View.Librarian.FileNotFoundExceptionCustom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.constant.Constable;
import java.util.Arrays;
import java.util.List;

public class LogInFunctionalities {


   LogInFunctionalities logInFunctionalities ;

   public LogInFunctionalities(){

   }
    public LogInFunctionalities(LogInFunctionalities logInFunctionalities){
        this.logInFunctionalities = logInFunctionalities;
   }

    public Users checkUser(String usernametextFiled, String PassswrdField, String filePath) throws IOException {

        usernametextFiled = usernametextFiled.replaceAll("\\s+$", "");
        File file = new File(filePath);

        if (!file.exists()) {
            throw new FileNotFoundExceptionCustom("File does not exist");
        }

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream objis = new ObjectInputStream(fis);
        Users user;

        while (true) {
            try {
                user = ((Users) objis.readObject());

                if (usernametextFiled.equals(user.getFirstName()) && PassswrdField.equals(user.getPassword())) {
                    return user;
                }
            } catch (ClassNotFoundException | IOException e) {
                return null;
            }
        }
    }

    public  List<Constable> handleLogin(String usernametextFiled, String PassswrdField , String path) {
        try {
            if(logInFunctionalities == null){
                logInFunctionalities = new LogInFunctionalities();
            }
            Users isuser = logInFunctionalities.checkUser(usernametextFiled, PassswrdField, path);
            if (isuser == null) {
                return Arrays.asList(ResultType.INCORRECT_USER, "Incorrect Userername or password");
            } else {
                if (isuser.getAccesLevel().equals(AccessLevel.LIBRARIAN)) {
                    return Arrays.asList(ResultType.LIBRARIAN_LOGIN, isuser.getFirstName());
                } else if (isuser.getAccesLevel().equals(AccessLevel.MANAGER)) {
                    return Arrays.asList(ResultType.MANAGER_LOGIN, isuser.getFirstName());
                } else {
                    return Arrays.asList(ResultType.ADMIN_LOGIN, isuser.getFirstName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Arrays.asList(ResultType.TRY_AGAIN, "");
        }
    }







}
