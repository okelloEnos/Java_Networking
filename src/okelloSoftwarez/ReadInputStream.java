package okelloSoftwarez;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadInputStream {
    public static void main(String[] args) throws IOException {
        try(FileInputStream input = new FileInputStream("Okello.dat") ;)
        {
            int value;
            while ((value = input.read()) != -1){
                System.out.print(value + " ");
            }
        }
    }
}
