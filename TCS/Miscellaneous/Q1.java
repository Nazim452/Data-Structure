package TCS.Miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class Q1 {

   
    static class Student {
        String name;
        int age;
        char grade;
        String gender;

        // Constructor
        Student(String name, int age, char grade, String gender) {
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.gender = gender;
        }
    }

    public static void main(String[] args) {
        // Create a list of students
        List<Student> students = new ArrayList<>();
        students.add(new Student("AAA", 21, 'A', "Female"));
        students.add(new Student("BBB", 22, 'B', "Male"));
        students.add(new Student("CCC", 24, 'C', "Female"));

        // 1. Find names of students who are older than 20 years
        StringBuilder names = new StringBuilder();
        List<Integer> femaleGrades = new ArrayList<>();
        
        for (Student student : students) {
            // Add names of students older than 20 years
            if (student.age > 20) {
                names.append(student.name).append(" ");
            }

            // Collect grades of female students for average calculation
            if (student.gender.equals("Female")) {
                femaleGrades.add((int) student.grade); // Convert grade to ASCII value
            }
        }

        // 2. Calculate the average ASCII value of grades for female students
        double averageGrade = 0;
        if (!femaleGrades.isEmpty()) {
            int sum = 0;
            for (int grade : femaleGrades) {
                sum += grade;
            }
            averageGrade = sum / (double) femaleGrades.size();
        }

        // Output the results
        System.out.println(names.toString().trim()); // Print names of students
        System.out.println((int) averageGrade); // Print average ASCII value of grades for females
    }
}
