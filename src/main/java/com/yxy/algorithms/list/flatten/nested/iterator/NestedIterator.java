package com.yxy.algorithms.list.flatten.nested.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
/**
 * 341. Flatten Nested List Iterator My Submissions QuestionEditorial Solution
	Total Accepted: 8295 Total Submissions: 27878 Difficulty: Medium
	Given a nested list of integers, implement an iterator to flatten it.
	
	Each element is either an integer, or a list -- whose elements may also be integers or other lists.
	
	Example 1:
	Given the list [[1,1],2,[1,1]],
	
	By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
	
	Example 2:
	Given the list [1,[4,[6]]],
	
	By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 * @author xianyiye
 * @date 06/22/2016
 * 
 * Copy from:
 * https://leetcode.com/discuss/96316/simple-java-solution-using-a-stack-with-explanation
 */
// 11 ms
public class NestedIterator implements Iterator<Integer> {

	 Stack<NestedInteger> stack = new Stack<>();
	    public NestedIterator(List<NestedInteger> nestedList) {
	        for(int i = nestedList.size() - 1; i >= 0; i--) {
	            stack.push(nestedList.get(i));
	        }
	    }

	    @Override
	    public Integer next() {
	        return stack.pop().getInteger();
	    }

	    @Override
	    public boolean hasNext() {
	        while(!stack.isEmpty()) {
	            NestedInteger curr = stack.peek();
	            if(curr.isInteger()) {
	                return true;
	            }
	            stack.pop();
	            for(int i = curr.getList().size() - 1; i >= 0; i--) {
	                stack.push(curr.getList().get(i));
	            }
	        }
	        return false;
	    }

	@Override
	public void remove() {
		// No need to implement
	}
	
	
	public static void main(String[] args){
		List<NestedInteger> list = new ArrayList<NestedInteger>() ;
		
		NestedIntegerImpl item1 = new NestedIntegerImpl() ;
		item1.addValToList(new NestedIntegerImpl(1));
		item1.addValToList(new NestedIntegerImpl(2));
		
		NestedIntegerImpl item2 = new NestedIntegerImpl(3) ;
		
		NestedIntegerImpl item3 = new NestedIntegerImpl() ;
		item3.addValToList(new NestedIntegerImpl(4));
		item3.addValToList(new NestedIntegerImpl(5));
		
		list.add(item1);
		list.add(item2);
		list.add(item3);
		
		NestedIterator i = new NestedIterator(list);
		while (i.hasNext()) {
			System.out.print(i.next());
		}
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

