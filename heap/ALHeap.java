//Barak Zhou
//APCS PD 8
//HW #40
//2014-05-18

/*****************************************************
 * class ALHeap  ---  skeleton
 * Implements a min heap using an ArrayList as underlying container
 * 
 * TASK:
 * Implement all methods
 * Add helpers as necessary
 * Classify runtime of each method
 *****************************************************/

import java.util.ArrayList;


public class ALHeap {

    //instance vars
    private ArrayList<Integer> _heap; //underlying container
    

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	_heap = new ArrayList<Integer>();
    }//O(1)



    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	return _heap.isEmpty();
    }//O(1)



    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public void add( Integer addVal ) 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	_heap.add(addVal);
	int node = _heap.size() - 1;
	//Keeps swapping with parent until min heap condition is met
	while (node > 0 && _heap.get( getParent(node) ) > _heap.get(node)) {
	    swap(_heap, node, getParent(node));
	    node = getParent(node);
	    }
    }//O(n)



    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin() 
    {
     	/*** YOUR IMPLEMENTATION HERE ***/
	if (_heap.size() == 0) return null;
	return _heap.get(0);
    }//O(1)



    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMin() 
    {
     	/*** YOUR IMPLEMENTATION HERE ***/
	if (_heap.size() == 0) return null;
	Integer min = peekMin();
	//put last element in front
	_heap.set( 0, _heap.get( _heap.size()-1) );
	_heap.remove( _heap.size()-1);
	arrangeMinOrder(_heap, 0);
	return min;
    }//O(n)



    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    //private int minChildPos( int pos ) 
    // {
    // 	/*** YOUR IMPLEMENTATION HERE ***/
    // What does this do...?
    // }//O(?)



    //~~~~~~~~~~~~~~~v~  MISC HELPERS ~v~~~~~~~~~~~~~~~

    // perhaps a SWAPPER... ?
	public void swap(ArrayList<Integer> a, int i1, int i2) {
	Integer i = a.get(i1);
	a.set(i1, a.get(i2));
	a.set(i2, i);
    }
    
    //get parent, left, right
    public int getParent(int i) {
	return (i-1) / 2;
    }
    public int getLeft(int i){
	return (2*i) + 1;
    }

    public int getRight(int i){
	return (2*i) + 2;
    }
    
    //Fix the array
    //Find the smallest among node 0 (or i, the parent), left and right.
    //If the parent > left or right, swap with the larger one and recurse.
    //Postcondition: _heap is valid
    public void arrangeMinOrder( ArrayList<Integer> a, int i) {
	//keep track of indices
	int left = getLeft(i);
	int right = getRight(i);
	int smallest = 0;
	
	if ( left<=a.size()-1 && a.get(left) < a.get(i) ) smallest = left;
	else smallest = i;
	
	if ( right<=a.size()-1 && a.get(right) < a.get(smallest) ) smallest = right;
	
	if ( i != smallest ) {
	    swap (a, i, smallest);
	    arrangeMinOrder(a, smallest);
	} 
    }

    // perhaps a minOf(Integer,Integer)... ?

    //~~~~~~~~~~~~~~~^~  MISC HELPERS ~^~~~~~~~~~~~~~~~



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
    public String toString() 
    {
     	/*** YOUR IMPLEMENTATION HERE ***/
	return toString(0);
    }//O(?)
    public String toString(int parent) {
	if (isEmpty()) return null;
	String retstr = "";
	retstr = retstr + _heap.get(parent);
	int left = getLeft(parent);
	int right = getRight(parent);
	if (left <= _heap.size() -1 && right <= _heap.size()-1) return retstr + toString(left) + toString(right);
	else if (left <= _heap.size() -1) return retstr + toString(left);
	else if (right <= _heap.size() -1) return retstr + toString(right);
	return retstr;
    }





    //main method for testing
	public static void main( String[] args ) {

	ALHeap pile = new ALHeap();

	pile.add(2);
	System.out.println(pile);
	pile.add(4);
	System.out.println(pile);
	pile.add(6);
	System.out.println(pile);
	pile.add(8);
	System.out.println(pile);
	pile.add(10);
	System.out.println(pile);
	pile.add(1);
	System.out.println(pile);
	pile.add(3);
	System.out.println(pile);
	pile.add(5);
	System.out.println(pile);
	pile.add(7);
	System.out.println(pile);
	pile.add(9);
	System.out.println(pile);

	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
    }//end main()

}//end class ALHeap