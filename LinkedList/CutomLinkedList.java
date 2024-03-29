package LinkedList;

public class CutomLinkedList {
    public static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
        }
    }

    public static class LinkedList {
        node head = null;
        node tail = null;
        int size = 0;

        void display() {
            node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;

            }

        }

        void insertAthead(int data) {

            node temp = new node(data);
            if (head == null) {
                head = tail = temp;
                size++;
            } else {
                temp.next = head;
                head = temp;
                size++;
            }

        }

        void inertAtTail(int data) {

            node temp = new node(data);
            if (head == null) {
                head = tail = temp;
                size++;
            }

            else {
                tail.next = temp;
                tail = temp;
                size++;
            }

        }

        void insertAtIndex(int index, int data) {
            if (index < 0 || index > size) {
                // Handle invalid index
                return;
            }

            node t = new node(data);
            if (index == 0) {
                t.next = head;
                head = t;
                return;
            }
            node temp = head;

            for (int i = 1; i < index; i++) {
                temp = temp.next;

            }
            t.next = temp.next;
            temp.next = t;
            size++;

        }
        void deleteAt(int index){
            if(index<0 &&index>=size){
                System.out.println("Invalid index: " + index);
                return;
            }
            node temp  = head;

            if(index==0||head==null){
                head = head.next;
                size--;
                return;

            }

          else{
            for(int i = 1; i<index;i++){
                temp = temp.next;

            }
            temp.next = temp.next.next;
            size--;
          }
        }
    }

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        ll.inertAtTail(10);
        ll.inertAtTail(11);
        ll.inertAtTail(12);
        ll.inertAtTail(13);
        ll.deleteAt(0);

        ll.display();
        System.out.println();
        System.out.println(ll.size);

    }

}
