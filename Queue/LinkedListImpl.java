package Queue;

public class LinkedListImpl {

    public static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
        }

    }

    public static class queueLL {
        node head = null;
        node tail = null;
        int size = 0;

        public void add(int x) {
            node temp = new node(x);
            if (size == 0) {
                head = tail = temp;

            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        public int peek() {
            if (size == 0)
                return -1;

            return head.data;
        }

        public int remove() {
            if (size == 0)
                return -1;

            int x = head.data;
            head = head.next;
            size--;
            return x;

        }

        public void display() {
            if (size == 0)
                return;

            node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        queueLL q = new queueLL();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.display();
        // System.out.println(q.peek());
        q.remove();
        q.display();
        



    }

}
