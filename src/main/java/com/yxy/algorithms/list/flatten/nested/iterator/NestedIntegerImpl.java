package com.yxy.algorithms.list.flatten.nested.iterator;

import java.util.ArrayList;
import java.util.List;

public class NestedIntegerImpl implements NestedInteger {
	
	private Integer val ;
	private List<NestedInteger> list = new ArrayList<NestedInteger>() ;
	
	public NestedIntegerImpl(){
		val = null ;
	}
	
	public NestedIntegerImpl(int value){
		val = value ;
	}
	
	@Override
	public boolean isInteger() {
		return val!=null;
	}
	
	
	public void setInteger(NestedInteger value) {
		val = value.getInteger() ;
	}
	
	public void addValToList(NestedInteger value) {
		list.add(value) ;
	}

	@Override
	public Integer getInteger() {
		return val;
	}

	@Override
	public List<NestedInteger> getList() {
		return val == null ? list : null ;
	}

}
