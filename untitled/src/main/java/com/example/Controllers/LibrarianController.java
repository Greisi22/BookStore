package com.example.Controllers;

import com.example.Model.Bills.BillFunctionalitiess;
import com.example.Model.Books.BookFunctionalities;
import com.example.Model.Books.Books;
import com.example.View.Login.LoginView;

public class LibrarianController {


    public boolean checkOutOfStock(Books bookSelected) {
        if (BillFunctionalitiess.checkOutOfStock(bookSelected)) {
            Books updatedbook = BillFunctionalitiess.updateQuantity(bookSelected);
            BookFunctionalities.UpdateBook(updatedbook);
            return true;
        }
        return false;
    }

}
