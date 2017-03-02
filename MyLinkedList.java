package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */

public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		this.size=0;
		// TODO: Implement this method
		this.head=new LLNode<E>();
		this.tail=new LLNode<E>();
		this.head.next=this.tail;
		this.tail.prev=this.head;	
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element==null)
		{
			throw new NullPointerException("invalid ");
		}
		
	LLNode<E> n=new LLNode<E>(element);
	LLNode<E> i=tail.prev;
	tail.prev=n;
	i.next=n;
	n.prev=i;
	n.next=tail;
	
	size++;
	return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index<0 ||index>size-1)
		{
			throw new  IndexOutOfBoundsException();
		}
		LLNode<E> check=head;
		for(int i=0;i<=index;i++)
		{
			check=check.next;
		}
		
		return check.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Invalid element input!!");
		}
		if((index<0 ||index>size-1) && (index != 0 || size != 0))
		{
			throw new  IndexOutOfBoundsException(" the wrong input!!");
		}
		LLNode<E> ne=new LLNode<E>(element);
		LLNode<E> icheck=head;
		for(int i=0;i<=index-1;i++)
		{
			icheck=icheck.next;
		}
		ne.next=icheck.next;
		icheck.next=ne;
		ne.next.prev=ne;
		ne.prev=icheck;
		size++;
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index<0||index>size-1)
		{
			throw  new IndexOutOfBoundsException("wrong index value");
		}
		LLNode<E> start=head;
		for(int i=0;i<=index;i++)
		{
			start=start.next;
		}
		E val=start.data;
		LLNode<E> pre=start.prev;
		LLNode<E> nex=start.next;
		nex.prev=start.prev;
		pre.next=start.next;
		/*
		start.next.prev=start.prev;
		start.prev.next=start.next;
		*/
		size--;
		return val;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index<0||index>size-1)
		{
			throw  new IndexOutOfBoundsException("wrong index value");
		}
		if (element == null) {
			throw new NullPointerException("Invalid element input!!");
		}
		LLNode<E> start=head;
		for(int i=0;i<=index;i++)
		{
			start=start.next;
		}
		E val=start.data;
		start.data=element;
		
		return val;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode()
	{
		this.data=null;
		this.next=null;
		this.prev=null;
	}

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
