// package Stack;

// import java.util.*;

// public class DisplayStack {

//     static void disStackUsingArr(Stack<Integer> st) {
//         int n = st.size();

//         int[] arr = new int[n];
//         for (int i = 0; i < n; i++) {
//             arr[i] = st.pop();
//         }

//         for (int i = n - 1; i >= 0; i--) {
//             System.out.print(arr[i] + " ");
//         }
//     }

//     public static void display(Stack<Integer> st) {
//         if (st.size() == 0)
//             return;
//         int top = st.pop();
//         display(st);
//         System.out.print(top + " ");
//         st.push(top);
//     }

//     static void userInput() {
//         Stack<Integer> st1 = new Stack<>();
//         Scanner sc = new Scanner(System.in);
//         System.out.println("How many elem you wants");
//         int n = sc.nextInt();

//         System.out.println("Enter no of element");

//         for (int i = 1; i <= n; i++) {
//             int x = sc.nextInt();
//             st1.push(x);
//         }
//         System.out.println(st1);
//     }

//     static void pushAtIndex(Stack<Integer> st, int idx, int data) {
//         if (st.size() == 0) {
//             st.push(data);
//             return;
//         }
//         Stack<Integer> help = new Stack<Integer>();
//         while (st.size() > idx) {
//             help.push(st.pop());

//         }
//         st.push(data);

//         while (help.size() > 0) {

//             st.push(help.pop());

//         }
//         System.out.println(st);

//     }

//     static void displayUsingStack(Stack<Integer> st) {
//         Stack<Integer> rt = new Stack<>();

//         while (st.size() > 0) {
//             rt.push(st.pop());

//         }

//         while (rt.size() > 0) {
//             int x = rt.pop();
//             System.out.print(x + " ");
//             st.push(x);

//         }
//     }

//     static void displayreverse(Stack<Integer> st) {
//         if (st.size() == 0)
//             return;

//         int x = st.pop();
//         System.out.print(x + " ");
//         displayreverse(st);
//         st.push(x);

//     }

//     public static void main(String[] args) {
//         // userInput();

//         Stack<Integer> st = new Stack<>();
//         st.push(2);
//         st.push(3);
//         st.push(4);
//         st.push(5);
//         pushAtIndex(st, 2, 100);

//     }

// }
