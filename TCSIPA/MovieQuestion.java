package TCSIPA;
// Problem Statement

// Create a class Movie with the below attributes:

// movieName - String
// company   - String
// genre     - String
// budget    - int

// Write necessary getters, setters, and constructors.

// Create a class Solution and implement the static method:

// getMovieByGenre(Movie[] arr, String genre)

// This method will take:

// an array of Movie objects
// a genre String

// as parameters.

// The method should return another array of movie objects where:

// the genre matches with the original movie object's genre attribute
// comparison should be case-insensitive

// Before calling the getMovieByGenre() method in the main method:

// read values for four Movie objects
// read one genre string

// Then call the method and:

// print "High Budget Movie" if movie budget is greater than 80000000
// otherwise print "Low Budget Movie"
// Sample Input
// aaa
// Marvel
// Action
// 250000000
// bbb
// Marvel
// Comedy
// 25000000
// ccc
// Marvel
// Comedy
// 2000000
// ddd
// Marvel
// Action
// 300000000


// Action
// Sample Output
// High Budget Movie
// High Budget Movie
import java.util.Scanner;

// My Approach_________________________________________________


// public class MovieQuestion {
//     static class Movie {
//         String movieName;
//         String companyName;
//         String genere;
//         int budget;

//         public Movie(String movieName, String companyName, String genere, int budget) {
//             this.movieName = movieName;
//             this.companyName = companyName;
//             this.genere = genere;
//             this.budget = budget;
//         }

//         public String getMovieName() {
//             return movieName;
//         }

//         public String getCompanyName() {
//             return companyName;
//         }

//         public void setMovieName(String movieName) {
//             this.movieName = movieName;
//         }

//         public void setCompanyName(String companyName) {
//             this.companyName = companyName;
//         }

//         public void setGenere(String genere) {
//             this.genere = genere;
//         }

//         public void setBudget(int budget) {
//             this.budget = budget;
//         }

//         public String getGenere() {
//             return genere;
//         }

//         public int getBudget() {
//             return budget;
//         }
//     }

//     static Movie[] getMoviesByGenre(Movie[] m, String genre){
//         Movie[] ans = null;
//         for(int i = 0; i<m.length; i++){
//             if(m[i].getGenere().equalsIgnoreCase(genre)){

//             }
//         }
//         return ans;

//     }



    




//     public static void main(String[] args) {
//         Scanner sc  = new Scanner(System.in);
//         // 4 - Test cases;

//       Movie[] m = new Movie[4];

//       for(int i = 0; i<m.length; i++){
//         String a = sc.nextLine();
//         String b = sc.nextLine();
//         String c = sc.nextLine();
//         int d = sc.nextInt(); sc.nextLine();

//         m[i] = new Movie(a , b , c, d);

//       }
//       String genre = sc.nextLine(); 
//       String[] res = getMoviesByGenre(m, genre);


//     }

// }




// CHatGPT aproach________________________________________




public class MovieQuestion {

    // Movie Class
    static class Movie {

        private String movieName;
        private String company;
        private String genre;
        private int budget;

        public Movie(String movieName, String company,
                     String genre, int budget) {

            this.movieName = movieName;
            this.company = company;
            this.genre = genre;
            this.budget = budget;
        }

        public String getMovieName() {
            return movieName;
        }

        public String getCompany() {
            return company;
        }

        public String getGenre() {
            return genre;
        }

        public int getBudget() {
            return budget;
        }
    }

    // Solution Class
   

        public static Movie[] getMovieByGenre(Movie[] arr, String genre) {

            int count = 0;

            // Count matching movies
            for (int i = 0; i < arr.length; i++) {

                if (arr[i].getGenre().equalsIgnoreCase(genre)) {
                    count++;
                }
            }

            Movie[] result = new Movie[count];

            int k = 0;

            // Store matching movies
            for (int i = 0; i < arr.length; i++) {

                if (arr[i].getGenre().equalsIgnoreCase(genre)) {

                    result[k++] = arr[i];
                }
            }

            return result;
        }
    

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of test cases.
        Movie[] arr = new Movie[4];

        for (int i = 0; i < 4; i++) {

            String movieName = sc.nextLine();
            String company = sc.nextLine();
            String genre = sc.nextLine();
            int budget = sc.nextInt(); sc.nextLine();

            arr[i] = new Movie(movieName, company,
                    genre, budget);
        }

        String searchGenre = sc.nextLine();

        Movie[] result =getMovieByGenre(arr, searchGenre);

        for (int i = 0; i < result.length; i++) {

            if (result[i].getBudget() > 80000000) {

                System.out.println("High Budget Movie");

            } else {

                System.out.println("Low Budget Movie");
            }
        }
    }
}