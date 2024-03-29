package String;

public class Direction {
    
    static float direction(String path) {
        float ans = 0;
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            if (ch == 'W')
                x--;
            else if (ch == 'E')
                x++;
            else if (ch == 'N')
                y++;
            else
                y--;
        }
        int x1 = x * x, y1 = y * y;

        ans = (float) Math.sqrt(x1 + y1);
        return ans;
    }

    public static void main(String[] args) {
        String str ="WNEENESENNN";
        System.out.println(direction(str));
        
    }
}
