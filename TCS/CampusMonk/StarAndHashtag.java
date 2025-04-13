package TCS.CampusMonk;

public class StarAndHashtag {

    static void question(String str){
        int n = str.length();

        int hashCount = 0 , starCount = 0;

        for(int i = 0; i<n; i++){
            if(str.charAt(i)=='#') hashCount++;
            else starCount++;
        }

        if(hashCount>starCount) System.out.println(hashCount-starCount);
        else if(  starCount>hashCount) System.out.println(starCount-hashCount);
        else System.out.println(0);
    }
    public static void main(String[] args) {

        String str = "###****";  //   * >  # = +ve int     
        question(str);

        
    }
    
}
