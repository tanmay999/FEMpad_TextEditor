package spelling;

import java.util.List;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size=0;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should convert the 
	 * string to all lower case before you insert it. 
	 * 
	 * This method adds a word by creating and linking the necessary trie nodes 
	 * into the trie, as described outlined in the videos for this week. It 
	 * should appropriately use existing nodes in the trie, only creating new 
	 * nodes when necessary. E.g. If the word "no" is already in the trie, 
	 * then adding the word "now" would add only one additional node 
	 * (for the 'w').
	 * 
	 * @return true if the word was successfully added or false if it already exists
	 * in the dictionary.
	 */
	public boolean addWord(String word)
	{
	    //TODO: Implement this method.
		if(word==null)
		{
			return false;
		}
		String lower=word.toLowerCase();
		TrieNode node1=root;
		for(int i=0;i<lower.length();i++)
		{
			Character c=lower.charAt(i);
			if(node1.getValidNextCharacters().contains(c))
			{
				node1=node1.getChild(c);
			}
			else
			{
				node1=node1.insert(c);
			}
		}
		
		if(node1.endsWord()==false)
		{
			node1.setEndsWord(true);
			size++;
			return true;
		}
		
	    return false;
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    //TODO: Implement this method
	    return size;
	}
	
	
	/** Returns whether the string is a word in the trie, using the algorithm
	 * described in the videos for this week. */
	@Override
	public boolean isWord(String s) 
	{
	    // TODO: Implement this method
		
		String k=s.toLowerCase();
		TrieNode node2 =root;
		for(int i=0;i<k.length();i++)
		{
			char c1=k.charAt(i);
			if(node2.getValidNextCharacters().contains(c1))
					{
				node2=node2.getChild(c1);
					}
			else
			{
				return false;
			}		
		}
	if(node2.endsWord()==true)
		{
			node2.getText();
			return true;
		}
		
		
return false;
	}

	/** 
     * Return a list, in order of increasing (non-decreasing) word length,
     * containing the numCompletions shortest legal completions 
     * of the prefix string. All legal completions must be valid words in the 
     * dictionary. If the prefix itself is a valid word, it is included 
     * in the list of returned words. 
     * 
     * The list of completions must contain 
     * all of the shortest completions, but when there are ties, it may break 
     * them in any order. For example, if there the prefix string is "ste" and 
     * only the words "step", "stem", "stew", "steer" and "steep" are in the 
     * dictionary, when the user asks for 4 completions, the list must include 
     * "step", "stem" and "stew", but may include either the word 
     * "steer" or "steep".
     * 
     * If this string prefix is not in the trie, it returns an empty list.
     * 
     * @param prefix The text to use at the word stem
     * @param numCompletions The maximum number of predictions desired.
     * @return A list containing the up to numCompletions best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 LinkedList<String > ans=new LinkedList<String>();
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	 
    	 int csize=0;
    	 TrieNode node3=root;
    	 String preLower=prefix.toLowerCase();
    	 for(int i=0;i<preLower.length();i++)
    	 {
    		 Character c2=preLower.charAt(i);
    		 if(node3.getValidNextCharacters().contains(c2))
    		 {
    			 node3=node3.getChild(c2);
    		 }
    		 else
    		 {
    			 return ans;
    		 }
    	 }
    	 if(node3.endsWord()==true)
    			 {
    		 ans.add(node3.getText());
    		
    		 csize++;
    			 }
    	
    	 LinkedList<Character> validchar=new LinkedList<Character>(node3.getValidNextCharacters());
    	 
    	 List<TrieNode> q =new LinkedList<TrieNode>();
    	 
    	 
    	 for(int i=0;i<validchar.size();i++)
    	 {
    		 char c4=validchar.get(i);
    		 q.add(node3.getChild(c4));
    		
    	 }
    	 while(q.isEmpty()==false && csize<numCompletions)
    	 {
    		 TrieNode n=q.remove(0);
    		 if(n.endsWord()==true)
    		 {
    			 ans.add(n.getText());
    			 csize++;
    			 }
    		LinkedList<Character > j=new LinkedList<Character>(n.getValidNextCharacters());
    		for(int f=0;f<j.size();f++)
    		{
    		      char c7=j.get(f);
    		      q.add(n.getChild(c7));
    		}
    	 }
         return ans;
     }

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	

	
}