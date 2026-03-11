package PYQ.TCS;
// Reframed & Simplified Problem Statement

// You are given:

// N students sitting in order (1 to N).

// An array M where M[i] represents marks of the i-th student.

// There are K re-evaluations.

// Each re-evaluation is of the form:
// X Y → Update marks of student at index X to Y.

// 🔴 Rule for Merit List

// After every re-evaluation:

// If two adjacent students have the same marks,
// then only the student sitting behind (right side) is removed from the merit list.

// This continues for all adjacent duplicates.

// 👉 Your task:
// After each re-evaluation, print the number of students remaining in the merit list.

// 🧠 Important Clarification

// We only check adjacent students.

// If:

// [3, 1, 2, 2, 2]

// Comparisons:

// 2 == 2 → remove the second one

// next 2 == 2 → remove again

// So only the first occurrence in consecutive duplicates survives.

// ✅ Example 1
// Input
// N = 5
// K = 2
// Marks = [1, 1, 2, 5, 2]

// Re-evaluations:
// 1 3
// 4 2
// 🔹 First Re-evaluation: (1 → 3)

// Updated array:

// [3, 1, 2, 5, 2]

// Check adjacent:

// 3 != 1
// 1 != 2
// 2 != 5
// 5 != 2

// No duplicates.

// ✔ Merit count = 5

// 🔹 Second Re-evaluation: (4 → 2)

// Updated array:

// [3, 1, 2, 2, 2]

// Check adjacent:

// 2 == 2 → remove 4th student
// 2 == 2 → remove 5th student

// Remaining:

// [3, 1, 2]

// ✔ Merit count = 3

// Output
// 5 3
// ✅ Example 2
// Input
// N = 6
// K = 1
// Marks = [2, 2, 2, 3, 3, 4]

// Re-evaluation:
// 5 4
// Updated array:
// [2, 2, 2, 3, 4, 4]

// Check duplicates:

// 2 == 2 → remove 2nd

// 2 == 2 → remove 3rd

// 4 == 4 → remove 6th

// Remaining:

// [2, 3, 4]

// ✔ Merit count = 3
import java.util.*;

public class StudentMarksEval {

    static int countMerit(int[] arr, int n) {
        int count = 1; // first student always included

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr[x - 1] = y;  // update

            System.out.print(countMerit(arr, n) + " ");
        }
    }
}
