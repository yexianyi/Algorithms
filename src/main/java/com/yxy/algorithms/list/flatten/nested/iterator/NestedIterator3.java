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
 * https://leetcode.com/discuss/101968/share-my-java-neat-solution-8ms
 */
// 8 ms
public class NestedIterator3 implements Iterator<Integer> {

	NestedInteger nextInt;
    Stack<Iterator<NestedInteger>> stack;

    public NestedIterator3(List<NestedInteger> nestedList) {
        stack = new Stack<Iterator<NestedInteger>>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return nextInt != null ? nextInt.getInteger() : null; //Just in case
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) stack.pop();
            else if ((nextInt = stack.peek().next()).isInteger()) return true;
            else stack.push(nextInt.getList().iterator());
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
		
		NestedIterator3 i = new NestedIterator3(list);
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

