public class EveryXthSum {

//    There are N kids sitting in a circle, numbered from 1 to N in clockwise order.
// A parcel is passed from one kid to the next in a clockwise direction, starting from kid 1.

// You are given:

// N → number of kids

// X → number of passes

// Your task is to find the position of the kid who gets the parcel after X passes.

// 📥 Input Format

// The first line contains two integers N and X, separated by a space.

// 📤 Output Format

// Print one integer: the position of the kid who has the parcel after X passes.

// 🔒 Constraints

// 1 ≤ N ≤ 100000

// 1 ≤ X ≤ 10000

// 🧪 Sample Input 1
// 10 15

// Sample Output 1
// 6

// Explanation

// Kids are sitting in a circle:

// 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 10 → (back to 1)


// Starting from kid 1, after 15 passes, the parcel reaches kid 6.

// 🧪 Sample Input 2
// 35 50

// Sample Output 2
// 16


    static void question2(int n , int x){
        System.out.println((x%n)+1);
    }

    public static void main(String[] args) {
        question2(10, 15);
        question2(35, 50);
    }
    
}





// You’re saying:

// “If I subtract N from X and then add 1, I still get the correct answer. So why do we even need modulus?”

// For some inputs, your method works.
// Example:

// N = 10, X = 15
// X - N = 5
// 5 + 1 = 6 ✅ (correct)


// So your thinking is not wrong. It’s just incomplete.

// Where Your Logic Breaks ❌ (Very Important)

// Your approach assumes that:

// X - N is enough


// But what if X is much larger than N?

// Example 1
// N = 10, X = 25


// Your method:

// X - N = 15
// 15 + 1 = 16 ❌ (invalid, kids are only 1–10)


// Correct logic:

// 25 % 10 = 5
// 5 + 1 = 6 ✅

// Example 2 (Extreme case)
// N = 10, X = 105


// Your method:

// 105 - 10 = 95
// 95 + 1 = 96 ❌


// Correct logic:

// 105 % 10 = 5
// 5 + 1 = 6 ✅

// 🔑 Core Insight (This is the “Aha” Moment)

// Subtracting N once only works if:

// N < X < 2N


// But modulus does this repeatedly:

// X % N  ==  X - (k × N)


// where k is:

// k = how many full rounds happened

// Why Modulus Is the Correct Tool 🎯

// Think of kids sitting in a circle as cycles:

// Every N passes → one full circle

// Extra passes → determine final position

// Modulus gives:

// “How many steps are left after completing all full circles?”

// That’s exactly what we need.

// Mathematical Perspective (Interview Gold)

// You want:

// Final position = 1 + (number of effective passes)


// Effective passes are:

// X % N


// So:

// Position = (X % N) + 1


// Special case:

// If X % N == 0 → Position = N

// Efficiency Angle (Why Interviewers Care)
// Your approach

// Needs repeated subtraction if X is large

// Risk of wrong answers

// Not scalable

// Modulus approach

// Works for any size of X

// O(1) time

// Mathematically correct

// Industry-standard solution

// How You Should Say This in an Interview 🧠✨

// “Subtracting N once only works when X is less than 2N. Since X can be much larger, we use modulus to remove all full circular rotations in one step and get the remaining effective passes. That’s why modulus is the mathematically correct and scalable solution.”

// Final One-Line Summary

// Subtraction handles one round. Modulus handles infinite rounds.