package TCSIPA;

public class ObjectSorting {

    public static class Student{
        int id;
        String name;
        double marks;
        public Student(int id, String name, double marks) {
            this.id = id;
            this.name = name;
            this.marks = marks;
        }

        @Override
        public String toString(){
            return "Id "+ id+
                " Name "+name+
                " Marks "+ marks;
        }
        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public double getMarks() {
            return marks;
        }
    }

    static void Mysort(Student []s){

        for(int i = 0; i<s.length; i++){

            for(int j = i+1; j<s.length; j++){

                // If i have to arrange on the basis of name

//                 | Result | Meaning                |
//                 | ------ | ---------------------- |
//                 | `< 0`  | str1 comes before str2 |
//                 | `> 0`  | str1 comes after str2  |
//                 | `0`    | both equal             |


                if(s[j].getName().compareTo(s[i].getName()) < 0){
                     Student temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }

                // if(s[j].getMarks()>s[i].getMarks()){
                //     Student temp = s[i];
                //     s[i] = s[j];
                //     s[j] = temp;
                // }
            }
        }

    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "John", 75.3);
        Student s2 = new Student(2, "Adam", 60);
        Student s3 = new Student(3, "Rachel", 79.6);
        Student s4 = new Student(4, "Dylan", 52);
        Student s5 = new Student(5, "Jamie", 81.9);

        Student[] s = new Student[] {s1, s2, s3, s4, s5};

        Mysort(s);
        for(int i = 0; i<s.length; i++){
            System.out.println(s[i]);
        }
        
    }
}
