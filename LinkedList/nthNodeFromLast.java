package LinkedList;
// import java.util.*;



public class nthNodeFromLast {
    public static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
        }
    }
      public static int findLength(node head) {
        int length = 0;
        node current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }
    public static int nthNodeFromlast(node head,int number){
        int length = findLength(head);
        if(number<0||number>=length){
            System.out.print("Invalid number ");
            return number;
        }
        node slow = head;
        node fast = head;
        for(int i = 1; i<=number;i++){
            fast  = fast.next;
        }

        while (fast!=null) {

            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;

    }
    public static void main(String[] args) {
        // LinkedList<Integer> ll = new LinkedList<>();
        // ll.addLast(12);
        // ll.addLast(13);
        // ll.addLast(14);
        // ll.addLast(15);
        // ll.addLast(16);
        // System.out.println(ll);

        node a = new node(10);
        node b = new node(11);
        node c = new node(12);
        node d = new node(13);
        a.next = b;   // 'a' ke node me 'b' ka address
        b.next = c;
        c.next = d;

        System.out.println( nthNodeFromlast(a, 4));
       
        


        
    }
    
}
