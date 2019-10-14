package okelloSoftwarez;
import java.util.Scanner;
import java.io.File;
public class ReadFile {
    public static void main(String[] args) throws Exception{
        File file = new File("Score.txt");
        Scanner input = new Scanner(file);

        while (input.hasNext()){
            String fName = input.next();
            String mName = input.next();
            String lName = input.next();
            String score = input.next();

            System.out.println(fName + " " + mName + " " + lName + " " + score);

        }
        input.close();
    }
}
