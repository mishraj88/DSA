package com.mishrjyo.dsa.sorting;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {7,8,3,1,2,0, -10,-5,11};

        System.out.println("Array length: "+arr.length);
        System.out.println("Printing before sorting:");
        printArray(arr);
        //bubbleSort(arr);
        selectionSort(arr);
        System.out.println("\nPrinting after sorting: ");
        printArray(arr);
        //IntStream stream = Arrays.stream(arr);
    }

    private static void bubbleSort(int[] arr) {
        //we are going to run n-1 loops = we don't need n loops
        //as we are going to compare arr[i] with arr[i+1], and  at most (n-1)th element with nth element.
        //which could be done in n-1 loops at most
        System.out.println("\nBubble Sort:");
        for(int i=0; i< arr.length - 1; i++){
            for(int j=0; j < arr.length-i-1; j++){
                //swap in each comparison if satisfies the check
                if(arr[j]> arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }

    private static void selectionSort(int[] arr){

        //it picks an element from the beginning of array
        // and picks it as the smallest.
        //with each iteration - it tries to find the smallest element
        //it could place at that index.
        //so in every iteration, starting from 0 index - it would place the
        //smallest element for that position

        //comparison would be done with elements at each index
        //but swapping would be done only once.
        //before each iteration, the elements would be sorted in the sub-array
        // till the previous index
        System.out.println("\nSelection sort");
        for(int i=0; i< arr.length -1; i++){
            int smallestValPos = i;
            for(int j = i+1; j< arr.length; j++){
                if(arr[j] < arr[smallestValPos]){
                    smallestValPos = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallestValPos];
            arr[smallestValPos] = temp;
        }

    }

    private static void printArray(int[] arr) {
        IntStream stream = Arrays.stream(arr);
        //stream.forEach(System.out::print);
        final String PREFIX = "[";
        final String SUFFIX = "]";
        //stream.forEach(i -> System.out.print(i+ " , "));
        //since stream is Closed , you can't use it again.
        //need to recerate the stream
        String str = Arrays.stream(arr).mapToObj(e -> String.valueOf(e)).
                collect(Collectors.joining(",", PREFIX, SUFFIX));

        System.out.println("sorted Array: "+str);

    }
}
