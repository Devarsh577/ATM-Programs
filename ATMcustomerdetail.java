import java.sql.*;
import java.util.*;
import static java.lang.System.*;

class ATMcustomerdetail{


public static void main(String args[]){

Connection con = null;
try{

Class.forName("com.mysql.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost/atmdemo","root","");


Statement stat=con.createStatement();

String cust_name,cust_accno,cust_dob,cust_contactno,cust_acctype;
int cust_pin,cust_amount,i=4;
Scanner sc=new Scanner(System.in);

out.println("Enter Customer Name");
cust_name=sc.next();

out.println("Enter Account Number");
cust_accno=sc.next();

out.println("Enter Customer Birth Date");
cust_dob=sc.next();

out.println("Enter Contact Number");
cust_contactno=sc.next();


out.print("Enter Security Pin");
if(i>=1){
cust_pin=sc.nextInt();
}
else{
out.print("enter valid pin");
}




out.println("Enter Account Type");
cust_acctype=sc.next();

out.println(" Deposit Amount");
cust_amount=sc.nextInt();

int result=stat.executeUpdate("insert into cust_detail values(NULL,'"+cust_name+ "','"+cust_accno+"','"+cust_dob + "','"+cust_contactno+"','"+i+ "', '" +cust_acctype+"','"+cust_amount+"',NOW())");

System.out.println("Insert Successfully...");

stat.close();
con.close();
}
catch(Exception ex)
{

System.out.println(ex);
}

}

}

 