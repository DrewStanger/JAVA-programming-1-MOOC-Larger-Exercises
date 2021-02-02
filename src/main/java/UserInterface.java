
import java.util.ArrayList;
import java.util.Scanner;



//class to take user input and manipulate it.
public class UserInterface {
    private Scanner scanner;
    private ArrayList<Integer> scores;
    
    public UserInterface(Scanner scanner){
        this.scanner = new Scanner(System.in);
        this.scores = new ArrayList<>();
    }

    public ArrayList returnArrayList(){
        return this.scores;
    }
    
    public void readInput(){
        // read the user input
        System.out.println("Enter point totals, -1 stops:");
        while(true){
            int points = Integer.valueOf(scanner.nextLine());
            // enter the stop clause, errornous inputs are ignored.
            if(points == -1){
                break;
            }
            // make sure the values are between 0 and 100 
            if (points >= 0 && points <=100){
                // add to ArrayList for later use.
                this.scores.add(points);
            }
        }
    }
    
    public double average(int sum, int counter){
        double average = (1.0)*sum/counter;
        return average;
    }
    
    public double pointAverageAll(){
        //calculates the average for every legal value inputted.
        int sum = 0;
        int counter = 0;
        // sum all values of the ArrayList
        for(int score:scores){
            sum += score;
            counter++;
        }
        return this.average(sum,counter);
    }
    
    public double pointAveragePassingGrade(){
        //calculates the average for every legal value 50 and larger.
        int sum = 0;
        int counter = 0;
         // sum all values that are 50+
        for(int score:scores){
            if(score >=50){
                sum += score;
                counter++;
            }
        }
        return this.average(sum,counter);
    }
    
    public double passPercentage(){
        //prints the pass percentage
        double counter =0;
        double total = 0;
        for(int score:scores){
            if(score >=50){
                counter++;
            }
            total++;
        }
        double percentage = 1.0 * (100*(counter/total));
        return percentage;
    }
    
    public String passingGradeHelper(){
        // to determine if pointAveragePassingGrade() returns a value or NaN and returns either - or the average value
        double average = this.pointAveragePassingGrade();
        if (Double.isNaN(average)){
            return "-";
        }
        return Double.toString(average);
    }
    
    public void pointsToGrade(){
        // this coverts the numerical points to a grade 0 - 5.
        GradeDistribution gradeDist = new GradeDistribution(scores);
        gradeDist.scoreToGradeConvertor();
        System.out.println(gradeDist);
    }

    public String toString(){
        return "Point average (all): " + this.pointAverageAll() + "\n" +
                "Point average(passing): " + this.passingGradeHelper() + "\n" +
                "Pass percentage: " +  this.passPercentage();
        
    }
    
}
