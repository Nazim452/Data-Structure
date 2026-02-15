package PYQ.Zoho;
// Problem Explained in Very Easy Words

// You have:

// N cities numbered from 1 to N

// Some cities have intercity bus terminus

// Those cities are given in an array intercity[]

// For every city, you must calculate:

// Distance to the nearest city that has an intercity terminus

// Finally:

// Return the maximum among those minimum distances.

// 🧠 What Does "Distance" Mean?

// Distance = difference between city numbers.

// Example:

// City 3
// Intercity city 1 → distance = |3 - 1| = 2
// Intercity city 5 → distance = |3 - 5| = 2
// Nearest = 2

// 🔍 Example Given
// N = 5
// intercity = {1, 5}


// Cities:

// 1 2 3 4 5


// Intercity at:

// 1 and 5


// Now check each city:

// City	Nearest Intercity	Distance
// 1	1	0
// 2	1	1
// 3	1 or 5	2
// 4	5	1
// 5	5	0

// Maximum distance = 2

// 🎯 What Is the Real Question?

// We want:

// The city that is farthest from any intercity terminus.

// Return that maximum minimum distance.

// 🚀 Important Insight (Very Powerful)

// Instead of checking every city with every intercity (which is slow),
// we can use this trick:

// Sort intercity array.

// Then the maximum distance will be:

// Distance from first city to first intercity

// Distance from last city to last intercity

// Half of the largest gap between two consecutive intercity cities

// 🧠 Why Half of Gap?

// Suppose:

// intercity = {1, 10}


// Gap = 9

// The city in the middle (5 or 6) is farthest.

// Maximum distance = gap / 2
public class NearestArrayCity {
    static void question(int n ,  int [] interCity){
        int ans = Integer.MIN_VALUE;
      
        for(int i =1; i<=n; i++){
            int minDistance = Integer.MAX_VALUE;
            for(int j = 0; j<interCity.length; j++){
                int dis = Math.abs(interCity[j]-i);
                minDistance = Math.min(minDistance,dis);
                
                
            }
            ans = Math.max(ans,minDistance);
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1,5};
        question(n, arr);
        
    }
}
