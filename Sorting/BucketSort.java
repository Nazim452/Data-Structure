// package Sorting;

// import java.util.ArrayList;
// import java.util.Collections;
// // B C  TC - n+k   -- all bucket mr unifiorally elem aa jaye
// // // W c TC - n^2   -- jab ek hi bucket me all element aa jaye - worst case
// public class BucketSort {
    
//     static void bucketSort(float[]arr){
//         int n = arr.length;

//         // bucket    -- ke ansdar elem hai isliye inside the array make arraylist

//         ArrayList<Float>[]buckets = new ArrayList[n];

//         // create empty bucket

//         for(int i = 0; i<n; i++){
//             buckets[i] = new ArrayList<Float>();
//         }

//         // add elem into buckets

//         for(int i = 0; i<n; i++){
//             int bucketIndex = (int)arr[i]*n;
//             buckets[bucketIndex].add(arr[i]);

//         }

//         // sort each bucket individually

//         for(int i = 0; i<buckets.length; i++){
//             Collections.sort(buckets[i]);

//         }

//         // merge all bucket to get final sorted array

//         int index = 0;

//         for(int i = 0; i<buckets.length; i++){
//             ArrayList<Float> currBucket = buckets[i];

//             for(int j = 0; j<currBucket.size(); j++){
//                 arr[index++] = currBucket.get(j);
//             }
//         }

//     }
//     public static void main(String[] args) {
//         float []arr = { 0.42f, 0.65f, 0.32f, 0.12f, 0.45f};
//         bucketSort(arr);
//         for(float elem:arr){
//             System.out.print(elem+" ");
//         }
        
//     }
// }
