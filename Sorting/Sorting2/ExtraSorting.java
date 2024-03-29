package Sorting.Sorting2;

public class ExtraSorting { 
    static boolean is_Possible(int[]arr, int k, int min_dis_allow){
        int kids_place = 1;
        int last_kid = arr[0];

        for(int i =1; i<arr.length; i++){

            if(arr[i]-last_kid>=min_dis_allow){
                kids_place++;
                last_kid= arr[i];
            }
        }
        if(kids_place>=k) return true;
        return false;

    }
    static int raceTrack(int[]arr, int k){
        if(k>arr.length) return -1;

        int st =0, end = (int)1e9;
        int ans = -1;
        while(st<=end){
            int mid = st+(end-st)/2;

            if(is_Possible(arr,k,mid)){
                ans = mid;
                st = mid+1;
            }else{
                end = mid-1;
            }

        }

        return ans;

    }
    static boolean is_Division_Possible2(int[]arr, int m, int max_cho_allowed){
        int no_of_stud=1;
        int choc = 0;

        for(int i =0; i<arr.length; i++){
            if(arr[i]>max_cho_allowed) return false;

            if(choc+arr[i]<=max_cho_allowed){
                choc = choc+arr[i];

            }else{
                no_of_stud++;
                choc = arr[i];

            }
        }
        if(no_of_stud>m) return false;

        return true;

    }
    static int distribute_Choclate2(int[]arr, int m){
        int st =0, end = (int)1e9;
        int ans =0;

        while(st<=end){
            int mid = st+(end-st)/2;

            if(is_Division_Possible2(arr, m, mid)){
                ans = mid;
                end = mid-1;
            }else{
                st = mid+1;
            }
        }
        return ans;

    }
    static boolean is_Division_Possible(int[]arr, int m, int max_cho_allowed){
        int no_of_stud = 1;
        int choc=0;

        for(int i =0; i<arr.length; i++){
            if(arr[i]>max_cho_allowed)  return false;

            if(choc+arr[i]<=max_cho_allowed) {
                choc=choc+arr[i];
            }else{
                no_of_stud++;
                choc=arr[i];
            }
        }
        if(no_of_stud>m) return false;

        return true;        
    }
    static int distribute_Choclate(int[]arr, int m){
        int st =1, end = (int)1e9, ans = 0;

        while(st<=end){
            int mid = st+(end-st)/2;

            if(is_Division_Possible(arr, m, mid)){
                ans = mid;
                end = mid-1;

            }else{
                st = mid+1;
            }
        }
        return ans;
    }
    static int peakElement(int[]arr){
        int n = arr.length;
        int st =0, end = arr.length-1;

        while(st<=end){
            int mid = (st)+(end-st)/2;

            if  (mid==0||  arr[mid]>arr[mid-1]  &&  mid==n-1|| arr[mid]>arr[mid+1]) return mid;

            else if(arr[mid]<arr[mid+1]){
                st = mid+1;
            }else{
                end = mid-1;

            }
        }


        return -1;
    }
    static int pickIndex(int[]arr){
        int st =0, end = arr.length-1;
        int ans = -1;

        while(st<=end){
            int mid = st+(end-st)/2;

            if(arr[mid]<arr[mid+1]){
                ans = mid+1;
                st = mid+1;
            }else{
                end =mid-1;
            }
        }

        return ans;
    } 
    static boolean serch2D_2(int[][]arr, int target){
        int n =arr.length, m = arr[0].length;

        int i =0, j = m-1;

        while(i<n && j>=0){
            if(arr[i][j]==target) return true;

            if(arr[i][j]< target){
                i++;
            }else{
                j--;
            }
        }
        

        return false;
    }
    static boolean serch2D(int[][]arr, int target){
        int n = arr.length;
        int m = arr[0].length;

        int st =0, end = m*n-1;
        while(st<=end){
            int mid = st+(end-st)/2;
            

            int mid_elem= arr[mid/m][mid%m];
            if(mid_elem==target) return true;

            if(target<mid_elem){
                end = mid-1;
            }else{
                st = mid+1;
            }
        }


        return false;

    }

// FIND TARGET ELEM IN SORTED ARRAY - DUPLIATE PREAENT

   static int tarIndex_dup(int[]arr, int target){
      int st =0, end =arr.length-1;

      while(st<=end){
        int mid = st+(end-st)/2;
        if(arr[mid]==target) return mid;

        else if(arr[st]==arr[mid]  && arr[end]==mid){
            st++;
            end--;
        }
        else if(arr[mid]<=arr[end]){    // mid to end sorted, '=' if mid==end ,then 
                                                 // also pivot no pres btw mid-end
            if(target>arr[mid]  && target<=arr[end]){
                st = mid+1;
            }else{
                end = mid-1;
            }
        
        }else{                 // st to mid sorted
            if(target>=arr[st]  &&target<arr[mid]){
                end = mid-1;
            }else{
                st = mid+1;
            }

        }
      }


    return -1;
   }

   


// FIND TARGET ELEM IN SORTED ARRAY - NOT DUPLIATE PREAENT

    static int tarIndex(int[]arr, int target){
        
        int n = arr.length;
        int st = 0, end =n-1;

        while(st<=end){
            int mid = st+(end-st)/2;

            if(arr[mid]== target) return mid;

            else if(arr[mid]<arr[end]){   // mid to end sorted
                if(target>arr[mid]&& target<=arr[end]){
                    
                    st = mid+1;

                }else{
                    end = mid-1;
                }

            }else{                    // st to mid sorted
                if(target>=arr[st] && target<arr[mid]){
                   
                    end = mid-1;
                }else{
                    st = mid+1;
                }


            }
        }

        return -1;

    }
    
    static int minINdex(int[]arr){
        int ans = -1;


        int st =0, end = arr.length-1;
        while(st<=end){
            int mid = st+(end-st)/2;

            if(arr[mid]>arr[arr.length-1]){
                st = mid+1;
            }else {
                ans = mid;
                end = mid-1;

            }
                

            

        }

        return ans;
    }

    public static void main(String[] args) {
        // int[]arr = { 3,4,5,6,1,2};
        // System.out.println(minINdex(arr));
        
        // int[]arr = { 3,4,5,1,2};
        // System.out.println(tarIndex(arr, 1));

        // int[]arr = { 1,1,1,2,2,3,1};
        // System.out.println(tarIndex_dup(arr, 1));

        // int[][]arr = {{1,3,5,7},{10,11,16,20},{ 23,30,34,60}};
        // System.out.println(serch2D(arr, 12));

        // int[][]arr = { {2,4,6,8}, {5,6,7,20}, { 7,11,13,25}, { 12,14,17,30}};
        // System.out.println(serch2D_2(arr, 13));

        // int[]arr = { 1,2,3,4,5,3,1,0};
        // System.out.println(pickIndex(arr));

        // int[]arr = { 1 ,2,1,3,5,6,4};
        // System.out.println(peakElement(arr));

        
        int[]arr = { 1,2,4,8,9};
        System.out.println(raceTrack(arr, 3));
    }
    
}
