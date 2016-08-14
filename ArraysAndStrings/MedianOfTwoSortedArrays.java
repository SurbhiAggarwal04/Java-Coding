package ArraysAndStrings;

import java.util.Scanner;

public class MedianOfTwoSortedArrays
{
    public static void main(String[] args) 
    {
        /*Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of elements in arrays");
        int N = scan.nextInt();
        int[] arr1 = new int[ N ];
        int[] arr2 = new int[ N ];
        System.out.println("Enter "+ N +" elements of array 1");
        for (int i = 0; i < N; i++)
            arr1[i] = scan.nextInt();
        System.out.println("Enter "+ N +" elements of array 2");
        for (int i = 0; i < N; i++)
            arr2[i] = scan.nextInt();*/
    	int[] arr1=new int[]{1,2,3,4,5,6};
    	int[] arr2=new int[]{7,8,9,10};
    	//double med = median(arr1, arr2);
    	int k=(arr1.length+arr2.length)/2;
    	double med=median(arr1,0,arr1.length,arr2,0,arr2.length,k);
        System.out.println("Median = "+ med);
     }
     public static double median(int[] arr1, int[] arr2)
     {
         int N = arr1.length;
         return median(arr1, 0, arr1.length , arr2, 0, arr2.length);
     }
     
     public static double median(int[] arr1,int l1,int m,int[] arr2,int l2,int n, int k)
     {
    	 System.out.println("array 1");
    	 for(int i=l1;i<m;i++)
    	 {
    		 System.out.println(arr1[i]);
    	 }
    	 System.out.println("array 2");
    	 for(int i=l2;i<n;i++)
    	 {
    		 System.out.println(arr2[i]);
    	 }
    	 System.out.println("k "+k);
    	 if (m>n) {return median(arr2,0,n,arr1,0,m,k);}
         
         if (m==0) { return arr2[l2+k-1];}
         if (k==0) { return Math.min(arr1[l1],arr2[l2]);}
         int pa = Math.min(k/2,m);
         int pb = l2+k-pa;
         int pb2=k-pa;
         System.out.println("pa "+pa+" value "+arr1[pa]);
         System.out.println("pb "+pb+" value "+arr2[pb]);

         if (arr1[pa]<=arr2[pb]) {return median(arr1,pa,m,arr2,0,n,k-pa);}
         
         return median(arr1,0,m,arr2,pb,n,k-pb2);
     }
     public static double median(int[] arr1, int l1, int h1, int[] arr2, int l2, int h2)
     {
         int mid1 = (h1 + l1 ) / 2;
         int mid2 = (h2 + l2 ) / 2;
 
         if(h1==l1 && h2==l2)
        	 return ((arr1[h1]+arr2[h2])/2);
         if (h1 - l1 == 1 && h2-l2==1)
             return (Math.max(arr1[l1] , arr2[l2]) + Math.min(arr1[h1] , arr2[h2]))/2;
         else if (arr1[mid1] > arr2[mid2])
             return median(arr1, l1, mid1 , arr2, mid2 , h2);    
         else
             return median(arr1, mid1 , h1, arr2, l2 , mid2 );    
     }     
}
