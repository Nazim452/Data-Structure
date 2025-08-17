package LinkedList;

public class customtwo {
    public static class node{
        int data;
        node next;

        node(int data){
            this.data = data;

        }

    }

    
    public static class mylinkedlist{
        node head = null;
        node tail = null;
         int size = 0;

        void display(){
            node temp = head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
        }

        void insertAtIndex(int index ,int data){
            if(index<0 || index>size) return;
            node temp  = new node(data);

            // Insert at head
            if(index==0){
                temp.next = head;
                head = tail = temp;
                size++;
                return;


            }
            else {
                node t = head;
                for(int i= 1; i<index; i++){
                    t = t.next;

                }
                temp.next = t.next;
                t.next  = temp;
                size++;
            }

        }


        void deleteAtindex( int index){
            if(index<0 || index>size) return;
            // delete at head;
            if(index==0){
                head = head.next;
                size--;
                return;

            }
            else{
                node t = head;
                for(int i = 1; i<index; i++){
                    t = t.next;

                }
                t.next = t.next.next;
                size--;
            }
        }

        void inertAtTail(int data){
            node temp = new node(data);
            node  t = head;
            if(size==0){
                // Insert at head;
                temp.next = head;
                head = temp;
                size++;

            }
           else{
             while(t.next!=null){
                t = t.next;

            }
            t.next = temp;
            tail = temp;
            size++;
           }


        }



}
    public static void main(String[] args) {
     node a = new node(10);
     node b = new node(12);
     node c = new node(14);
     node d = new node(16);

     a.next = b;
     b.next = c;
     c.next  = d;


        
        
    }
}
