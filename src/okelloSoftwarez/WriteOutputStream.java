package okelloSoftwarez;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteOutputStream {
    public static void main(String[] args) throws IOException {
        try (FileOutputStream output = new FileOutputStream("Okello.dat");) {
            for (int i = 0; i < 20; i++)
                output.write(i);

        }
        try (FileInputStream input = new FileInputStream("Okello.dat");) {
            int value;
            while ((value = input.read()) != -1) {
                System.out.print(value + " ");
            }

        }
    }
}
