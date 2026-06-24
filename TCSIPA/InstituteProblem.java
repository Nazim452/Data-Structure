// package TCSIPA;
// // Problem Statement

// // Create a class Institution with below attributes:

// // institutionId - int
// // institutionName - String
// // noOfStudentsPlaced - int
// // noOfStudentsCleared - int
// // location - String
// // grade - String

// // Write getters, setters and constructors for the above class.

// // Create class Solution with main method. Implement two static methods -

// // findNumClearancedByLoc
// // updateInstitutionGrade

// // in Solution class.

// // findNumClearancedByLoc method:

// // This method will take two input parameters -

// // array of Institution objects
// // string parameter location

// // The method will return the sum of the noOfStudentsCleared attribute from institution objects for the location passed as parameter.

// // If no institution with the given location is present in the array of institution objects, then the method should return 0.

// // updateInstitutionGrade method:

// // This method will take a String parameter institutionName, along with the array of Institution objects.

// // The method will return the institution object, if the input String parameter matches with the institutionName attribute of the institution object.

// // Before returning the object, the grade should be arrived based on the rating calculation mentioned below.

// // This grade value should be assigned to the object.

// // If any of the above conditions are not met, then the method should return null.

// // Grade Calculation
// // rating = (noOfStudentsPlaced * 100) / noOfStudentsCleared

// // If the rating > 80, then grade should be "A".

// // Else, then grade should be "B".

// // Note
// // No institution object would have the same value for institutionName attribute.
// // All institution object would have the noOfStudentsPlaced value lesser than noOfStudentsCleared value.
// // All the searches should be case insensitive.

// // The above mentioned static methods should be called from the main method.

// // Output Conditions
// // For findNumClearancedByLoc method

// // The main method should print the noOfClearance as it is, if the returned value is greater than 0,

// // or it should print:

// // There are no cleared students in this particular location
// // For updateInstitutionGrade method

// // The main method should print the institutionName and grade of the returned Institution object.

// // The institutionName and grade should be concatenated with :: while printing.

// // Example:

// // TCS::A

// // where TCS is the institution name and A is the grade.

// // If the returned value is null then it should print:

// // No Institute is available with the specified name
// // Input

// // Before calling these static methods in main,

// // use Scanner object to read the values of four Institution objects referring attributes in the above mentioned attribute sequence (except grade attribute).

// // Next, read the value for location and institutionName.

// // Sample Input
// // 111
// // Amrita
// // 5000
// // 10000
// // Chennai

// // 222
// // Karunya
// // 16000
// // 20000
// // Coimbatore

// // 333
// // AppleTech
// // 10000
// // 12000
// // Chennai

// // 444
// // Aruna
// // 6000
// // 10000
// // Chennai

// // Chennai
// // Karunya
// import java.util.Scanner;

// public class InstituteProblem {

//     static class Intitution {
//         int instituteId;
//         String instituteName;
//         int noOfStudent;
//         int noOfStudentCleared;
//         int noOfStudnetPlaced;
//         String location;
//         String grade;

//         public int getInstituteId() {
//             return instituteId;
//         }

//         public void setInstituteId(int instituteId) {
//             this.instituteId = instituteId;
//         }

//         public void setInstituteName(String instituteName) {
//             this.instituteName = instituteName;
//         }

//         public void setNoOfStudent(int noOfStudent) {
//             this.noOfStudent = noOfStudent;
//         }

//         public void setNoOfStudentCleared(int noOfStudentCleared) {
//             this.noOfStudentCleared = noOfStudentCleared;
//         }

//         public void setNoOfStudnetPlaced(int noOfStudnetPlaced) {
//             this.noOfStudnetPlaced = noOfStudnetPlaced;
//         }

//         public void setLocation(String location) {
//             this.location = location;
//         }

//         public void setGrade(String grade) {
//             this.grade = grade;
//         }

//         public String getInstituteName() {
//             return instituteName;
//         }

//         public int getNoOfStudent() {
//             return noOfStudent;
//         }

//         public int getNoOfStudentCleared() {
//             return noOfStudentCleared;
//         }

//         public int getNoOfStudnetPlaced() {
//             return noOfStudnetPlaced;
//         }

//         public String getLocation() {
//             return location;
//         }

//         public String getGrade() {
//             return grade;
//         }

//         public Intitution(int instituteId, String instituteName, int noOfStudent, int noOfStudentCleared,
//                 int noOfStudnetPlaced, String location, String grade) {
//             this.instituteId = instituteId;
//             this.instituteName = instituteName;
//             this.noOfStudent = noOfStudent;
//             this.noOfStudentCleared = noOfStudentCleared;
//             this.noOfStudnetPlaced = noOfStudnetPlaced;
//             this.location = location;
//             this.grade = grade;
//         }

//     }

//     static class Solution {
//         static int findNumClearanceBYLOC(Intitution[] arr, String location) {
//             int ans = 0;
//             for (int i = 0; i < arr.length; i++) {
//                 if (arr[i].getLocation().equals(location)) {
//                     ans += arr[i].getNoOfStudentCleared();
//                 }
//             }

//             return ans;

//         }

//         static Intitution[] UpdateInstitiionGrade(Intitution[] arr, String institutionName) {

//             int count = 0;
//             for (int i = 0; i < arr.length; i++) {
//                 if (arr[i].getInstituteName().equalsIgnoreCase(institutionName))
//                     count++;
//             }

//             Intitution[] ans = new Intitution[count];
//             int k = 0;
//             for (int i = 0; i < arr.length; i++) {

//                 double rating = (arr[i].getNoOfStudnetPlaced() * 100) / (arr[i].getNoOfStudentCleared());

//                 if (arr[i].getInstituteName().equalsIgnoreCase(institutionName) && rating > 80) {
//                     arr[i].setGrade("A");
//                     ans[k++] = arr[i];

//                 } else if (arr[i].getInstituteName().equalsIgnoreCase(institutionName) && rating < 80) {
//                     arr[i].setGrade("B");
//                     ans[k++] = arr[i];

//                 }
//             }

//             if (ans.length > 0)
//                 return ans;
//             return null;
//         }

//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         Intitution[] arr = new Intitution[4];
//         for (int i = 0; i < arr.length; i++) {
//             // int instituteId; a
//             // String instituteName;b
          
//             // int noOfStudnetPlaced;c
//             // int noOfStudentCleared;d
//             // String location;
//             // String grade;
//             int a = sc.nextInt();
//             sc.nextLine();
//             String b = sc.nextLine();
           
//             int c = sc.nextInt();
//             sc.nextLine();
//             int d = sc.nextInt();
//             sc.nextLine();
//             String f = sc.nextLine();
           

//             arr[i] = new Intitution(a, b, c, d, e, f, g);

//         }

//         String location = sc.nextLine();
//         String instituteName = sc.nextLine();


        




//         int ans = Solution.findNumClearanceBYLOC(arr, location);
//         if (ans > 0) {
//             System.out.println(ans);
//         } else {
//             System.out.println("There are no cleared students in this particular location.");
//         }

//     }

// }










// ChatGPT___________________________________________




package TCSIPA;

import java.util.Scanner;

public class InstituteProblem {

    static class Institution {

        private int institutionId;
        private String institutionName;
        private int noOfStudentsPlaced;
        private int noOfStudentsCleared;
        private String location;
        private String grade;

        // Constructor
        public Institution(int institutionId, String institutionName,
                           int noOfStudentsPlaced, int noOfStudentsCleared,
                           String location, String grade) {

            this.institutionId = institutionId;
            this.institutionName = institutionName;
            this.noOfStudentsPlaced = noOfStudentsPlaced;
            this.noOfStudentsCleared = noOfStudentsCleared;
            this.location = location;
            this.grade = grade;
        }

        // Getters
        public int getInstitutionId() {
            return institutionId;
        }

        public String getInstitutionName() {
            return institutionName;
        }

        public int getNoOfStudentsPlaced() {
            return noOfStudentsPlaced;
        }

        public int getNoOfStudentsCleared() {
            return noOfStudentsCleared;
        }

        public String getLocation() {
            return location;
        }

        public String getGrade() {
            return grade;
        }

        // Setters
        public void setInstitutionId(int institutionId) {
            this.institutionId = institutionId;
        }

        public void setInstitutionName(String institutionName) {
            this.institutionName = institutionName;
        }

        public void setNoOfStudentsPlaced(int noOfStudentsPlaced) {
            this.noOfStudentsPlaced = noOfStudentsPlaced;
        }

        public void setNoOfStudentsCleared(int noOfStudentsCleared) {
            this.noOfStudentsCleared = noOfStudentsCleared;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    static class Solution {

        // Method 1
        public static int findNumClearancedByLoc(Institution[] arr, String location) {

            int maxCleared = 0;

            for (int i = 0; i < arr.length; i++) {

                if (arr[i].getLocation().equalsIgnoreCase(location)) {

                    if (arr[i].getNoOfStudentsCleared() > maxCleared) {
                        maxCleared = arr[i].getNoOfStudentsCleared();
                    }
                }
            }

            return maxCleared;
        }

        // Method 2
        public static Institution updateInstitutionGrade(Institution[] arr, String institutionName) {

            for (int i = 0; i < arr.length; i++) {

                if (arr[i].getInstitutionName().equalsIgnoreCase(institutionName)) {

                    double rating =
                            ((double) arr[i].getNoOfStudentsPlaced() * 100)
                                    / arr[i].getNoOfStudentsCleared();

                    if (rating > 80) {
                        arr[i].setGrade("A");
                    } else {
                        arr[i].setGrade("B");
                    }

                    return arr[i];
                }
            }

            return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Institution[] arr = new Institution[4];

        // Input for 4 institutions
        for (int i = 0; i < arr.length; i++) {

            int id = sc.nextInt();
            sc.nextLine();

            String name = sc.nextLine();

            int placed = sc.nextInt();
            sc.nextLine();

            int cleared = sc.nextInt();
            sc.nextLine();

            String location = sc.nextLine();

            arr[i] = new Institution(
                    id,
                    name,
                    placed,
                    cleared,
                    location,
                    ""
            );
        }

        String location = sc.nextLine();
        String institutionName = sc.nextLine();

        // Method 1 call
        int result = Solution.findNumClearancedByLoc(arr, location);

        if (result > 0) {
            System.out.println(result);
        } else {
            System.out.println("There are no cleared students in this particular location");
        }

        // Method 2 call
        Institution ans = Solution.updateInstitutionGrade(arr, institutionName);

        if (ans != null) {
            System.out.println(ans.getInstitutionName() + "::" + ans.getGrade());
        } else {
            System.out.println("No Institute is available with the specified name");
        }

        sc.close();
    }
}
