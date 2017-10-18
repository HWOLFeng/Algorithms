package search;

import java.util.Scanner;

public class BinarySearch
{

    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid-1, x);
            return binarySearch(arr, mid+1, r, x);
        }
        return -1;
    }

    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int numb = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            numb = scanner.nextInt();
            arr[i] = numb;
        }
        int x = 2;
        int result = ob.binarySearch(arr,0,n-1,x);
        if (result == -1)
            System.out.println("元素不存在");
        else
            System.out.println("元素的index为 "+result);
    }
}
