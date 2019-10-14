package okelloSoftwarez;


public class TestCourse {
    public static void main(String[] args) {
        Course course1 = new Course("Data Structures");

        course1.addStudent("Okello Enos");
        course1.addStudent("Bijuma Jamal");
        course1.addStudent("Jane Cheryl");

        course1.dropStudent("Jane Cheryl");

        System.out.println("Number of Registered Students for "+ course1.getCourseName() +" : " + course1.getNumberOfStudents());

            System.out.println(course1.print());
        }
}

