import java.util.*;
import static java.lang.System.*;
import java.sql.*;

class ATMdemo {

    public static void main(String args[]) {
        Connection con = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/atmdemo", "root", "");

            Statement stat = con.createStatement();

            int balance = 0, withdraw, pin = 0, custid = 0;

            Scanner sc = new Scanner(System.in);

            out.println("Enter custid ");

            custid = sc.nextInt();

            while (true) {

                out.println("Automated Teller Machine");
                out.println("Choose 1 for Withdraw");
                out.println("Choose 2 for Change Pin");
                out.println("Choose 3 for Check balance");
                out.println("Choose 4 for Exit");
                out.println("Choose the Operation you want to perform");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:

                        String sql = "select * from cust_detail where cust_id='" + custid + "' ";
                        ResultSet rs = stat.executeQuery(sql);
                        while (rs.next()) {
                            balance = rs.getInt("cust_amount");
                        }

                        System.out.print("Enter money to be withdrawal:");

                        withdraw = sc.nextInt();

                        if (balance >= withdraw) {

                            balance = balance - withdraw;
                            System.out.println("Please collect your money:" + "Thanks You.....");
                        } else {

                            System.out.println("Insufficient Balance");
                        }
                        System.out.println("");
                        break;

                    case 2:
                        out.println("Enter Your New Pin");
                        pin = sc.nextInt();
                        int result = stat.executeUpdate(
                                "update cust_detail set cust_pin='" + pin + "' where cust_id='" + custid + "' ");
                        out.println("Your Security Pin is Successfully Change");

                        stat.close();
                        con.close();
                        break;

                    case 3:

                        out.println("Your Balance is " + balance);
                        out.println(" ");
                        break;

                    case 4:
                        exit(0);
                }

            }

        } catch (Exception e) {
            out.println(e);
        }

    }

}
