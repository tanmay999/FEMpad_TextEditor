/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		try
		{
		shortList.remove(20);
		fail("index out of bound!");
		}
		catch(IndexOutOfBoundsException e)
		{
			
		}
		try {
			longerList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		/*for(int i=0;i<10;i++)
		{
			int b=longerList.remove(i);
			assertEquals("check the correctness:",i,b);
			assertEquals("check the size:",9,longerList.size());
			
		}*/
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
	   try{
		   shortList.add(null);
		   fail("check added value is null or not");
		   
	   }
	   catch (NullPointerException e)
	   {
		   
	   }
	   boolean state=emptyList.add(0);
	   assertEquals("check the state :",true,state);
	   assertEquals("check the value added",(Integer)0,emptyList.get(0));	
	   assertEquals("check size",1,emptyList.size());
	   
	   
	  boolean  state1=emptyList.add(1);
	   assertEquals("check the state :",true,state1);
	   assertEquals("check the value added",(Integer)1,emptyList.get(1));	
	   assertEquals("check size",2,emptyList.size());
	   
	   
	   
	   }

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("emptylist size:",0,emptyList.size());
		assertEquals("shortlist size:",2,shortList.size());
		assertEquals("longerList size:",LONG_LIST_LENGTH,longerList.size());
		assertEquals("list1 size",3,list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try
		{
			shortList.add(0,null);
		}
		catch(NullPointerException e)
		{
			
		}
		
		try{
			shortList.add(2,"C");
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e)
		{
			
		}
		try
		{
			longerList.add(-1,10);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e)
		{
			
		}
		try
		{
			longerList.add(LONG_LIST_LENGTH,10);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e)
		{
			
		}
		longerList.add(4,10);
		assertEquals("check val at index",(Integer)10,longerList.get(4));
		//assertEquals("check size",LONG_LIST_LENGTH,longerList.size());
		shortList.add(1,"X");
		assertEquals("check val",(String)"X",shortList.get(1));
		assertEquals("check size",3,shortList.size());
		
			
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try
		{
			shortList.add(0,null);
		}
		catch(NullPointerException e)
		{
			
		}
		
		try{
			shortList.add(3,"C");
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e)
		{
			
		}
		try {
			longerList.set(-1, 10);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
	
		longerList.set(3,19);
		assertEquals("check the old value:",(Integer)19,longerList.get(3));
		
	    assertEquals("check size:",10,longerList.size());
	    shortList.set(1, "C");
		assertEquals("AddAtIndex: check value is correct ", (String)"C", shortList.get(1));
		assertEquals("AddAtIndex: check size is correct", 2, shortList.size());
	}
	
	
	// TODO: Optionally add more test methods.
	
}
