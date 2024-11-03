package StudentGradeTracker;

import java.util.ArrayList;
class Grade {
    private ArrayList<Student> students;

    public Grade() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println("Student: " + student.getName());
            System.out.println("Grades: " + student.getGrades());
            System.out.println("Average: " + student.getAverage());
            System.out.println("Highest: " + student.getHighestnumber());
            System.out.println("Lowest: " + student.getLowestnumber());
            System.out.println();
        }
    }
}