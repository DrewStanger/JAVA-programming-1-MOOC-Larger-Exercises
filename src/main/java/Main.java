
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        UserInterface userInterface = new UserInterface(scanner);
        
        userInterface.readInput();
        System.out.println(userInterface);
        userInterface.pointsToGrade();
        
        
    }
}
