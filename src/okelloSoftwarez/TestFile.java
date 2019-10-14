package okelloSoftwarez;

import java.io.*;
public class TestFile {
    public static void main(String[] args) throws IOException{
        File file = new File("Score.txt");
        if (file.exists()){
            System.out.println("File already exists");
            System.exit(1);
        }
        PrintWriter output = new PrintWriter(file);

        output.print("Okello E Otieno  ");
        output.println(90);
        output.print("Eva C Odhiambo  ");
        output.println(79);
        output.print("Micky O Sipit ");
        output.println(58);

        output.close();


    }
}
