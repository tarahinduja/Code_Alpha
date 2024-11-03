package StudentGradeTracker;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Grade grade=new Grade();
        while (true){
            System.out.println(" 1:Add Student");
            System.out.println("2:Add Grade");
            System.out.println("3:Display All Student");
            System.out.println("4:Exit");
            System.out.println("Choose an option");
            int option=scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1:
                    System.out.println("Enter Student Name");
                    String name=scanner.nextLine();
                    Student student=new Student(name);
                    grade.addStudent(student);
                    break;
                case 2:
                    System.out.println("Enter Student Name");
                    name=scanner.nextLine();
                    student=grade.findStudentByName(name);
                    if(student!= null){
                        System.out.println("Enter Grade");
                        int grades=scanner.nextInt();
                        student.addGrade(grades);
                    }
                    else {
                        System.out.println("Student Not Found");
                    }
                    break;
                case 3:
                    grade.displayAllStudents();
                    break;
                case 4:
                    System.out.println("Exit");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
        }
    }
