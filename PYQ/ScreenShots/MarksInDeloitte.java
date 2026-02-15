public class MarksInDeloitte {
    public static void main(String[] args) {
        int math = 78;
        int bio = 90;
        int eng = 84;
        int hindi = 92;
        int social = 95;

        if(math<30 || bio<30|| eng<30|| hindi<30|| social<30){
            System.out.println("Fail");
            return;
        }

        double avg = (math+bio+eng+hindi+social)/500 *100;

        boolean jee = math>=90 && bio>=70 && avg>=80;

        boolean neet = bio>=90 && avg>=60;
        if(jee && neet){
            System.out.println("JEE"+" Neet");
            return;
        }

        if(jee) System.out.println(jee);
        if(neet) System.out.println("Neet");

    
        
    }
}
