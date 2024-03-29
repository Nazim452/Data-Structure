package Stack;

public class ArrayInplem {

   
        public static class stak {
            private int[] arr = new int[5];
            int index = 0;

            void push(int x) {
                arr[index] = x;
                index++;

            }

            int pop() {
                if (index == 0) {
                    System.out.println("Empty stack");
                    return -1;
                }
                int top = arr[index - 1];
                arr[index - 1] = 0;
                index--;
                return top;
            }

            void display() {
                for (int i = 0; i < index; i++) {
                    System.out.print(arr[i] + " ");

                }
                System.out.println();
            }

            int peek() {
                if (index == 0) {
                    System.out.println("Empty stack");
                    return -1;
                }
                return arr[index - 1];
            }

            int size() {
                return index;
            }

            boolean isEmpty() {
                if (index == 0)
                    return true;
                return false;
            }

        }

        public static void main(String[] args) {
            stak st = new stak();
            st.push(3);
            st.push(12);
            st.push(45);
            st.push(89);
            st.display();
            // st.pop();
            // st.display();
            // System.out.println(st.size());
            // System.out.println(st.isEmpty());
            System.out.println(st.peek());

        }
    

}
