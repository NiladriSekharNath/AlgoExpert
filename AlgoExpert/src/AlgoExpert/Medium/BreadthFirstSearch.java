package AlgoExpert.Medium;

import java.util.*;

public class BreadthFirstSearch {
	// Do not edit the class below except
	  // for the breadthFirstSearch method.
	  // Feel free to add new properties
	  // and methods to the class.
	  static class Node {
	    String name;
	    List<Node> children = new ArrayList<Node>();

	    public Node(String name) {
	      this.name = name;
	    }
	    //O(V+e)time |O(v) space
	    public List<String> breadthFirstSearch(List<String> array) {
	      Queue<Node>bfsQueue=new LinkedList<Node>();
	      Node start=this;
	      bfsQueue.add(start);
	      
	      while(!bfsQueue.isEmpty()) {
	    	  Node node = bfsQueue.remove();
	    	  array.add(node.name);
	    	  /*for(Node child:node.children) {
	    		  bfsQueue.add(child);
	    	  }*/
	    	  bfsQueue.addAll(node.children);
	      }
	      return array;
	    }

	    public Node addChild(String name) {
	      Node child = new Node(name);
	      children.add(child);
	      return this;
	    }
	  }

}
