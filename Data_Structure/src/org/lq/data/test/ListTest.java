package org.lq.data.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.lq.data.list.List;

public class ListTest {
	private List<String> list;

	@Before
	public void setUp() throws Exception {
		list = new List<String>();
	}

	@Test
	public void testAppend() {
		list.append("aaa");
		list.append("bbb");
		list.append("ccc");
		System.out.println(list.size());
		System.out.println(list.toString());
		list.remove("bbb");
		System.out.println(list);
		list.insert(1, "abc");
		list.insert(2, "1a");
		System.out.println(list);
		list.end();
		System.out.println(list.getElement());
		list.front();
		System.out.println(list.getElement());
		list.next();
		list.next();
		list.prev();
		System.out.println(list.getElement());
		System.out.println("---------");
		for(list.front();list.currPos()<list.size();list.next()){
			System.out.println(list.getElement());
		}
		
	}

}
