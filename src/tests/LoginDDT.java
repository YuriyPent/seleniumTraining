package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Excel;

public class LoginDDT {

    @Test(dataProvider = "getData")
    public void loginTest(String name, String email, String password){
        System.out.println("NEW RECORD: " + name + " " + email + " " + password);
    }

    @DataProvider
    public Object[][] getData(){
        return Excel.get("src/resources/UserLogin.xls.xls");
    }
}
