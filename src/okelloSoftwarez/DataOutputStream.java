package okelloSoftwarez;

import java.io.*;

public class DataOutputStream {
    public static void main(String[] args) throws IOException {
        try (java.io.DataOutputStream output = new java.io.DataOutputStream(new FileOutputStream("Student.dat"));
        )
        {
            output.writeUTF("Okello Enos");
            output.writeDouble(90);
            output.writeUTF("Douglas Kirimi");
            output.writeDouble(85.5);
            output.writeUTF("Beryl C#");
            output.writeDouble(70.1);

        }
        try (DataInputStream input = new DataInputStream(new FileInputStream("Student.dat"));
        )
        {
//            System.out.println(input.readUTF() + " " +input.readDouble());
//            System.out.println(input.readUTF() + " " +input.readDouble());
//            System.out.println(input.readUTF() + " " +input.readDouble());
//            System.out.println(input.readUTF() + " " +input.readDouble());
//            System.out.println(input.readUTF() + " " +input.readDouble());
            while (true)
                System.out.println(input.readUTF() + " " +input.readDouble());
        }
        catch (EOFException ex){
            System.out.println("All Data are Read");
        }
        catch (IOException et){
            et.printStackTrace();
        }
    }
}
