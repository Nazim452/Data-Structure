package TCS.Miscellaneous;

import java.util.ArrayList;

import TCS.Miscellaneous.Q1.Student;
import TCS.Miscellaneous.Q2.student;

public class Q2 {

    // The grade is stored as a String (e.g., "A", "B", "C"), and you're attempting to cast it directly to an int, which is not valid because a String cannot be cast to an int directly.

    static class student {
        String name;
        int age;
        Character grade;
        String gender;

        student(String name, int age, Character grade, String gender) {
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.gender = gender;
        }

    }

    public static void main(String[] args) {
        ArrayList<student> students = new ArrayList<>();

        students.add(new student("AAA", 21, 'A', "Female"));
        students.add(new student("BBB", 22, 'B', "Male"));
        students.add(new student("CCC", 23, 'C', "Female"));

        // Student's name
        StringBuilder names = new StringBuilder();
        ArrayList<Integer> grades = new ArrayList();

        for(student st:students){
            if(st.age>20) names.append(st.name).append(" ");

           if(st.gender.equals("Female")) grades.add((int) st.grade);
        }


        int  sum = 0;
        for(int grade:grades){
            sum +=grade;
        }

        double average = 0;
        average = sum/ (double)grades.size();

        System.out.println("Name  of the girls , age >20  "+ names);
        System.out.println("AVerage  "+ average);

    }

}
