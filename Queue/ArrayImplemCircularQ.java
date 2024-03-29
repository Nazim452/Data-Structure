package Queue;

// import java.util.Deque;
// import java.util.LinkedList;

// import java.util.*;
public class ArrayImplemCircularQ {
    public static class cir_Arr_List {
        int[] arr = new int[5];
        int size = 0;
        int n = arr.length;
        int f = -1;
        int r = -1;

        public void add(int val) throws Exception {
            if (size == n) {
                throw new Exception("Queue is full");

            } else if (r == -1) {
                f = r = 0;
                arr[0] = val;

            } else if (r < n - 1) {
                arr[++r] = val;
            } else if (r == n - 1) {
                r = 0;
                arr[0] = val;
            }
            size++;

        }

        public int remove() throws Exception {
            if (size == 0) {
                throw new Exception("Queue is empty");
            } else {
                int x = arr[f];
                if (f == n - 1)
                    f = 0;
                else
                    f++;
                size--;
                return x;

            }
        }

        public int peek() throws Exception {
            if (size == 0) {
                throw new Exception("Queue is empty");
            }
            return arr[f];

        }

        public void display() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return;
            } else if (f < r) {
                for (int i = f; i <= r; i++) {
                    System.out.print(arr[i] + " ");
                }
            }

            else { // f>r

                for (int i = f; i < n; i++) {
                    System.out.print(arr[i] + " ");
                }

                for (int i = 0; i <= r; i++) {
                    System.out.print(arr[i] + " ");
                }

            }
            System.out.println();
        }

    }

    public static void main(String[] args) throws Exception {
        cir_Arr_List q = new cir_Arr_List();
        // Deque<Integer> dq = new LinkedList<>(); 

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        q.display();  // 1 2 3 4 5
        q.remove();
        q.remove();
        q.remove();
        q.display();   // 3 4 5

        q.add(12);
        q.add(24); // 12 24 3 4 5
        // // 3 4 5 12 24
        q.display();
     
       

    }

}
