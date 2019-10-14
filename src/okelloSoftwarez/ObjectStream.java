package okelloSoftwarez;

import java.io.*;

public class ObjectStream {
        public static void main(String[] args) throws IOException {
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Student1.dat"));
            )
            {
                output.writeUTF("Okello Enos");
                output.writeDouble(90);
                output.writeObject(new java.util.Date());
                output.writeUTF("Douglas Kirimi");
                output.writeDouble(85.5);
                output.writeObject(new java.util.Date());
                output.writeUTF("Beryl C#");
                output.writeDouble(70.1);
                output.writeObject(new java.util.Date());

            }
//            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("Student.dat"));
              try (   ObjectInputStream input =
                         new ObjectInputStream(new FileInputStream("Student.dat"));
            )
            {
//            System.out.println(input.readUTF() + " " +input.readDouble());
//            System.out.println(input.readUTF() + " " +input.readDouble());
//            System.out.println(input.readUTF() + " " +input.readDouble());
//            System.out.println(input.readUTF() + " " +input.readDouble());
//            System.out.println(input.readUTF() + " " +input.readDouble());
                while (true)
                    System.out.println(input.readUTF() + " " +input.readDouble() + " " + input.readObject());
            }
            catch (EOFException ex){
                System.out.println("All Data are Read");
            }
            catch (IOException et){
                et.printStackTrace();
            }
            catch (ClassNotFoundException cf){
                cf.printStackTrace();
            }
        }
    }

