package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bsTree.BsTree;

public class BsTreeTest
{

	BsTree t;

	@Before
	public void init()
	{
		t = new BsTree();
	}

	// ========== test for size ============
	@Test
	public void sizeZero()
	{
		int[] ini = {};
		t.init(ini);
		int expected = t.size();
		int actual = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void sizeOne()
	{
		int[] ini = { 1 };
		t.init(ini);
		int expected = t.size();
		int actual = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void sizeTwo()
	{
		int[] ini = { 1, 2 };
		t.init(ini);
		int expected = t.size();
		int actual = 2;
		assertEquals(expected, actual);
	}

	@Test
	public void sizeManyOod()
	{
		int[] ini = { 1, 2, 4, 5, 6, 3, 2, 4, -4, -7, 3 };
		t.init(ini);
		int expected = t.size();
		int actual = 11;
		assertEquals(expected, actual);
	}

	@Test
	public void sizeManyOtr()
	{
		int[] ini = { -1, -2, -4, -5, -6, -3, -2, -4, -4, -7, 3 };
		t.init(ini);
		int expected = t.size();
		int actual = 11;
		assertEquals(expected, actual);
	}
}
