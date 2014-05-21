//Barak Zhou
//APCS PD8
//HW #42
//2014-05-20

/**
 * HeapSort
 * 
 * The best and worst case scenarios are both
 * nlog(n) complexity, that may differ by a
 * constant.
 *
 * **4/20: O(1) memory consumption
 */

import java.util.Arrays;

public class HeapSort {
    /* work from last time*/
    public Integer[] sort( Integer[] data ) {
	int size = data.length;
	Integer[] retArr = new Integer[size];
	ALHeap heap = new ALHeap();
	
	// construct heap
	for (Integer i : data) heap.add(i);
	
	//keep removeMin(), so data is sorted
	for (int i=0; i<size; i++) retArr[i] = heap.removeMin();
	
	return retArr;
    }
    /**/
    
    public Integer[] inPlaceSort( Integer[] data ) {
	data = heapify(data);
	
	//sort by adding elements to the front
	for (int i=data.length-1; i>0; i--) { //i is the heapsize, on the right of the sorted
	    swap(data, 0, i);
	    int n = 0; //keep track of the swapping index
	    while (true) {
		int left = (2*n)+1;
		int right = (2*n)+2;
		
		/*no left child?*/
		if (left >= i) break; //no left child, and cannot have right child according to heap
		
		/*no right child?*/
		if (right >= i) { //no right child, check left
		    if (left >= i) break;
		    else if (data[left] > data[n]) swap(data, left, n);
		    break;
		}
		
		if (data[left] > data[n]) {
		    /*only swap and continue swapping on the smaller child*/
		    /*there's a Chinese proverb for this somewhere...*/
		    if (data[left] > data[right]) {
			swap(data, left, n);
			n = left;
			continue;
		    }
		    else {
			swap(data, right, n);
			n = right;
			continue;
		    }
		}
		else { //left > n
		    if (data[right] > data[n]) {
			swap(data, right, n);
			n = right;
			continue;
		    }
		    else break;
		}
		
	    }
	}

	return data;
    } 

    public Integer[] heapify( Integer[] data ) {
	for (int i=1; i<data.length; i++) {
	    int n = i; //index of inserted int, basically heap/array divider
	    while (n > 0) {
		int parent = (n-1)/2;
		//if (data[n] < data[parent])
		if (data[n] > data[parent]) { //child < parent
		    swap(data, n, parent);
		    n = parent;
		}
		else break; //if parent is smaller then finish
	    }
	}
	return data;
    }

    public void swap(Integer[] arr, int i1, int i2) {
	Integer x = arr[i1];
	arr[i1] = arr[i2];
	arr[i2] = x;
    }

    public static void main(String[] args) {
	HeapSort hs = new HeapSort();
	
	Integer[] a = new Integer[] {4, 3, 2, 1, 5, 6};
	Integer[] b = new Integer[] {4, 1, 2, 3, 6, 5};

	System.out.println(Arrays.toString(hs.sort(a)));
	System.out.println(Arrays.toString(hs.sort(b)));
	
	Integer[] bh = hs.heapify(b);

	System.out.println(Arrays.toString(hs.inPlaceSort(bh)));
    }

}
