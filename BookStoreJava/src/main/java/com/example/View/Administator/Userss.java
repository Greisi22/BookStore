package com.example.View.Administator;


import com.example.Model.Bills.MyDate;
import com.example.Model.Login.AccessLevel;
import com.example.Model.Userss.UserFunctionalities;
import com.example.Model.Userss.UserService;
import com.example.Model.Userss.Users;
import com.example.View.Converters.AccessLevelStringConverter;
import com.example.View.Converters.MyDateStringConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.LongStringConverter;

import java.util.ArrayList;

public class Userss {

    static final String path = "src/main/java/com/example/EncodedInformation/Users.dat";

    public static TableColumn getFirstName() {
        return firstName;
    }

    private static TableColumn firstName;

    public static void ModUsers() {

        UserService userService = new UserService();
        //................................................................................................//
        ArrayList<Users> listBooks = new ArrayList<Users>();
        listBooks = userService.getUsers(path);


        TableView<Users> userTable = new TableView<Users>();
        ObservableList<Users> data = FXCollections.observableArrayList(listBooks);
        userTable.setItems(data);

        //........................................................................................................
        userTable.setEditable(true);

        //........................................................................................................

        firstName = new TableColumn("First Name");
        TableColumn lastName = new TableColumn("Last Name");
        TableColumn email = new TableColumn("Email");
        TableColumn birthday = new TableColumn("Birthday");
        TableColumn password = new TableColumn("Password");
        TableColumn salery = new TableColumn(" Salery");
        TableColumn phone = new TableColumn(" Phone");
        TableColumn accesLevel = new TableColumn("Acces Level");
        firstName.setId("firstname");
        firstName.setCellValueFactory(new PropertyValueFactory<Users, String>("firstName"));
        firstName.setCellFactory(TextFieldTableCell.forTableColumn());
        firstName.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<Users, String>>() {


            @Override
            public void handle(TreeTableColumn.CellEditEvent<Users, String> usersStringCellEditEvent) {

            }
        });
//		//.........................................................................
//	
        lastName.setCellValueFactory(new PropertyValueFactory<Users, String>("lastName"));
        lastName.setCellFactory(TextFieldTableCell.forTableColumn());
        lastName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Users, String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Users, String> event) {

               Users b1 = event.getRowValue();
                b1.setLastName(event.getNewValue());
                //   updateBook(b1);
            }

        });
        //.........................................................................
//		
        email.setCellValueFactory(new PropertyValueFactory<Users, String>("email"));
        email.setCellFactory(TextFieldTableCell.forTableColumn());
        email.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Users, String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Users, String> event) {

              Users b1 = event.getRowValue();
                b1.setEmail(event.getNewValue());
                // updateBook(b1);
            }

        });
//		//.........................................................................
//		
        birthday.setCellValueFactory(new PropertyValueFactory<Users, MyDate>("birthday"));
        birthday.setCellFactory(TextFieldTableCell.forTableColumn(new MyDateStringConverter()));
        birthday.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Users, MyDate>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Users, MyDate> event) {

               Users b1 = event.getRowValue();
                b1.setBirthday(event.getNewValue());


                UserFunctionalities.updateUsers(b1);
            }

        });

        password.setCellValueFactory(new PropertyValueFactory<Users, String>("password"));
        password.setCellFactory(TextFieldTableCell.forTableColumn());
        password.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Users, String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Users, String> event) {

                Users b1 = event.getRowValue();
                b1.setPassword(event.getNewValue());


                //   updateBook(b1);
            }

        });

        salery.setCellValueFactory(new PropertyValueFactory<Users, Long>("salery"));
        salery.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        salery.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Users, Long>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Users, Long> event) {

                Users b1 = event.getRowValue();
                b1.setSalery(event.getNewValue());
                ;


                UserFunctionalities.updateUsers(b1);
            }

        });

        phone.setCellValueFactory(new PropertyValueFactory<Users, String>("phone"));
        phone.setCellFactory(TextFieldTableCell.forTableColumn());
        phone.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Users, String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Users, String> event) {

               Users b1 = event.getRowValue();
                b1.setPhone(event.getNewValue());


                UserFunctionalities.updateUsers(b1);
            }

        });

        accesLevel.setCellValueFactory(new PropertyValueFactory<Users, AccessLevel>("accesLevel"));
        accesLevel.setCellFactory(TextFieldTableCell.forTableColumn(new AccessLevelStringConverter()));
        accesLevel.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Users, AccessLevel>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Users, AccessLevel> event) {

                Users b1 = event.getRowValue();
                b1.setAccesLevel(event.getNewValue());


                UserFunctionalities.updateUsers(b1);
            }

        });


        userTable.getColumns().addAll(firstName, lastName, email, birthday, password, salery, phone, accesLevel);

        Pane pane = new Pane();
        pane.getChildren().addAll(userTable);

        Scene scene = new Scene(pane);
        scene.getStylesheets().add("try.css");
        Stage stage1 = new Stage();

        stage1.setScene(scene);

        stage1.show();


    }

    static ArrayList<Users> newBooks1 = new ArrayList<Users>();

}
