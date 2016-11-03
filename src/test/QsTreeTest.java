package test;

import static org.junit.Assert.*;

import org.junit.Test;

import QsTree.QsTree;

public class QsTreeTest
{

	QsTree t = new QsTree();

	// ============== add =====================
	@Test(expected = NullPointerException.class)
	public void testAddNull()
	{
		int[] ini = null;
		t.init(ini);
		t.add(5);
	}

	@Test
	public void testAddEmpty()
	{
		int[] ini = {};
		t.init(ini);
		t.add(5);
		String expected = "5, ";
		String actual = t.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testAddZero()
	{
		int[] ini = {};
		t.init(ini);
		t.add(0);
		String expected = "0, ";
		String actual = t.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testAddOne()
	{
		int[] ini = {};
		t.init(ini);
		t.add(1);
		String expected = "1, ";
		String actual = t.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testAddMany_1()
	{
		int[] ini = { -50, 25, -45, -47, -185, -48, -46, 1, -30, -60 };
		t.init(ini);
		t.add(10);
		String expected = "-185, -60, -50, -48, -47, -46, -45, -30, 1, 10, 25, ";
		String actual = t.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testAddMany_2()
	{
		int[] ini = { 50, 25, 45, 47, 185, 48, 46, 1, -30, -60 };
		t.init(ini);
		t.add(10);
		String expected = "-60, -30, 1, 10, 25, 45, 46, 47, 48, 50, 185, ";
		String actual = t.toString();
		assertEquals(expected, actual);
	}

	// ============ init =======================

	@Test(expected = NullPointerException.class)
	public void testinitNull()
	{
		int[] ini = null;
		t.init(ini);

	}

	@Test
	public void testinitEmpty()
	{
		int[] ini = {};
		t.init(ini);
		String expected = "";
		String actual = t.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testinitZero()
	{
		int[] ini = { 0 };
		t.init(ini);
		String expected = "0, ";
		String actual = t.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testinitOne()
	{
		int[] ini = { 1 };
		t.init(ini);
		String expected = "1, ";
		String actual = t.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testinitMany_1()
	{
		int[] ini = { -50, 25, -45, -47, -185, -48, -46, 1, -30, -60 };
		t.init(ini);
		String expected = "-185, -60, -50, -48, -47, -46, -45, -30, 1, 25, ";
		String actual = t.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testinitMany_2()
	{
		int[] ini = { 50, 25, 45, 47, 185, 48, 46, 1, -30, -60 };
		t.init(ini);
		String expected = "-60, -30, 1, 25, 45, 46, 47, 48, 50, 185, ";
		String actual = t.toString();
		assertEquals(expected, actual);
	}

	// ================ size ============================

	@Test(expected = NullPointerException.class)
	public void testsizeNull()
	{
		int[] ini = null;
		t.init(ini);
		t.size();
	}

	@Test
	public void testsizeEmpty()
	{
		int[] ini = {};
		t.init(ini);
		int expected = 0;
		int actual = t.size();
		assertEquals(expected, actual);
	}

	@Test
	public void testsizeZero()
	{
		int[] ini = { 0 };
		t.init(ini);
		int expected = 1;
		int actual = t.size();
		assertEquals(expected, actual);
	}

	@Test
	public void testsizeOne()
	{
		int[] ini = { 1 };
		t.init(ini);
		int expected = 1;
		int actual = t.size();
		assertEquals(expected, actual);
	}

	@Test
	public void testsizeMany_1()
	{
		int[] ini = { -50, 25, -45, -47, -185, -48, -46, 1, -30, -60 };
		t.init(ini);
		int expected = 10;
		int actual = t.size();
		assertEquals(expected, actual);
	}

	@Test
	public void testsizeMany_2()
	{
		int[] ini = { 50, 25, 45, 47, 185, 48, 46, 1, -30, -60 };
		t.init(ini);
		int expected = 10;
		int actual = t.size();
		assertEquals(expected, actual);
	}

}
