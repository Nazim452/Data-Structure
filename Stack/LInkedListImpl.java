package Stack;

public class LInkedListImpl {
    public static class node{
        int data;
        node next;
        node(int  data){
            this.data = data;
        }

    }
    public static class llstack{
        node head = null;
        int size = 0;
        
        void push(int x){
            node temp = new node(x);
            temp.next = head;
            head = temp;
            size++;
        }

        int pop(){
            if(size==0){
                System.out.println("empty stack");
                return -1;
            }
            int x = head.data;
            head = head.next;
            size--;
            return x;
            
        }
        int  size(){
            return   size;
        }
        int peek(){
             if(size==0){
                System.out.println("empty stack");
                return -1;
            }
            return head.data;


        }
        void displ(node head){
            if(head==null) return;
            displ(head.next);
            System.out.print(head.data+" ");
        }
        void displayREcursively(){
            displ(head);
            System.out.println();

        }

    }
    public static void main(String[] args) {
        System.out.println("Nazim");
        llstack st = new llstack();
        st.push(3);
        st.push(12);
        st.push(45);
        st.push(89);
        st.displayREcursively();
        

        st.pop();
        st.displayREcursively();
        // System.out.println(st.size());
    //    System.out.println(st.isEmpty());
        System.out.println(st.peek());
        
    }
    
}
