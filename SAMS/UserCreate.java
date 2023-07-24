import java.util.Scanner;
import java.util.scanner;
public class UserCreate {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String user=scan.nextLine();
        LoginAccount log=LoginAccount.createAccount(user);
        log.getDetails();
        
    }

    
}
