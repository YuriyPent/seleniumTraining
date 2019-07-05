package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import utilities.CSV;

import java.util.List;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
    private String name;
    private String email;
    private String phone;

    //  This is our test method
    @Test
    public void newAccountTest() {
        System.out.println("NEW RECORD: " + name + " " + email + " " + phone);
//        if (phone.equals("7894561230")) {
//            Assert.fail();
//        }

    }

    //    This annotated method is designed to pass parameters into the class via constructor
    @Parameterized.Parameters
    public static List<String[]> getData() {
        return CSV.get("src/resources/UserAccounts.csv.csv");

    }

    //    Constructor that passes parameters to the test method
    public NewAccountDDT(
            String name,
            String email,
            String phone,
            String gender,
            String password,
            String country,
            String weeklyEmail,
            String montlyEmail,
            String ocasionalEmail) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
