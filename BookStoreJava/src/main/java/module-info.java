module com.example.bookstorejava {
    requires javafx.controls;
    requires javafx.fxml;
//    requires junit;
    requires org.junit.jupiter.api;
    requires org.junit.jupiter.params;
    requires org.mockito;


    opens com.example.bookstorejava to javafx.fxml;
    exports com.example;
}