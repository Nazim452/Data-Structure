package Queue;

public class ArrayImpleQueue {

    public static class queueArray {
        int[] arr = new int[5];
        int size = 0;
        int f = -1;
        int r = -1;

        public void add(int val) {
            if (f == -1) {
                r = f = 0;
                arr[0] = val;
            } else {
                arr[++r] = val;
                size++;
            }

        }

        public int remove() {
            if (size == 0)
                return -1;
            f++;
            size--;
            return arr[f - 1];

        }

        public int peek() {
            if (size == 0)
                return -1;
            return arr[f];
        }

        public void display() {
            if (size == 0)
                return;
            else {
                for (int i = f; i <= r; i++) {
                    System.out.print(arr[i] + " ");
                }

            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        queueArray q  = new queueArray();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
         //  rear - 5 4 3 2 1 - front

        q.display();
        System.out.println(q.peek());
        q.remove();
        q.display();

       

    }
}