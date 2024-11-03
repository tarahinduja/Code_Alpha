package StudentGradeTracker;

import java.util.ArrayList;

class Student {
    private String name;
    private ArrayList<Integer> grades;
    public Student(String name){
        this.name= name;
        this.grades=new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public void addGrade(int grade){
        grades.add(grade);
    }
    public ArrayList<Integer> getGrades(){
        return grades;
    }
    public double getAverage(){
        int sum=0;
        for (int grade:grades) {
            sum += grade;
        }
            return grades.size() > 0 ? (double) sum / grades.size() : 0.0;
    }
    public int getHighestnumber(){
        int highest= Integer.MIN_VALUE;
        for (int grade:grades){
            if(grade>highest) {
                highest = grade;
            }
        }
        return highest;
    }
    public int getLowestnumber(){
        int lowest= Integer.MAX_VALUE;
        for (int grade:grades){
            if(grade<lowest){
                lowest=grade;
            }
        }
        return lowest;
    }
}
