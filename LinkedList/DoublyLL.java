package LinkedList;

public class DoublyLL {
    public static class node {
        int data;
        node next;
        node prev;

        node(int data) {
            this.data = data;

        }
    }

    public static void display(node random) { // lasst elem is not print
        node temp = random;
        while (temp.prev != null) {
            temp = temp.prev;

        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static node insertAtHead(node head, int x) {
        node t = new node(x);
        t.next = head;
        head.prev = t;
        head = t;

        return t;
    }

    public static void insertAtIndex(node head, int index, int x) {
        node s = head;
        for (int i = 1; i < index; i++) {
            s = s.next;
        }
        node t = new node(x);
        node r = s.next;
        // s t r
        s.next = t;
        t.prev = s;
        t.next = r;
        r.prev = t;

    }

    public static void deleteAtIndex(node head, int index) {
        node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        if (temp.next != null)
            temp.next.prev = temp;

    }

    static void insertAtTail(node head, int x) {
        node temp = head;
        while (temp.next != null) {
            temp = temp.next;

        }
        node t = new node(x);
        temp.next = t;
        t.prev = temp;
    }
    // public static boolean isPalindrome(node head){
    // node h = head;

    // // find tail
    // node t = head;

    // while(t.next!=null){
    // t = t.next;
    // }
    // while(h!=t){

    // if(h.data!=t.data) return false;

    // if(h.next!=null){
    // h = h.next;
    // }
    // if(t.prev!=null){
    // t = t.prev;

    // }

    // }
    // return true;

    // }
    public static boolean isPalindrome(node head) {
        node h = head;
        node t = head;

        // Find the tail
        while (t.next != null) {
            t = t.next;
        }

        // Check for palindrome
        // The line h.prev != t.next in the while loop condition is significant for
        // ensuring that the pointers h and t do not cross each other while traversing
        // the doubly linked list.
        while (h != null && t != null && h != t) {
            if (h.data != t.data)
                return false;

            h = h.next;
            t = t.prev;
        }
        return true;
    }

    public static void main(String[] args) {
        node a = new node(1);
        node b = new node(2);
        node c = new node(2);
        node d = new node(1);
        node e = new node(7);

        a.prev = null;
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        d.next = e;
        e.next = null;
        // d.next = e; // Connect d to e
        // e.next = null;
        display(d);
        System.out.println(isPalindrome(a));
        ;
        // insertAtHead(a, 90);
        // display(d);
        // insertAtIndex(a, 4,89);
        deleteAtIndex(a, 2);
        // insertAtTail(a, 15);
        display(d);

    }

}
