package okelloSoftwarez;

import java.util.ArrayList;

public class Course {
    private int numberOfStudents;
    private String courseName;
    private  ArrayList<String> students = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    /**
     * It adds a student to the array
     * @param student
     */
    public void addStudent(String student){
//        students[numberOfStudents] = student;
//        numberOfStudents++;
        students.add(student);

    }
    public int getNumberOfStudents() {
//        return numberOfStudents;
        return students.size();
    }

    public String getCourseName() {
        return courseName;
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    public ArrayList<String> print(){
        for (String stud:students)
            System.out.println(stud);
         return students;
    }

    //    public String[] getStudents() {
//        return students;
//    }
    public void dropStudent(String studentName){
        students.remove(studentName);
    }

}
