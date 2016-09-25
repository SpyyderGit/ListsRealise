package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import interfaces.*;
import AList0.*;
import AList1.*;
import AList2.AList2;
import LLIst2.LList2;
import LList1.LList1;

@RunWith(value = Parameterized.class)
public class EListTest
{

	EList lst = null;

	@Parameters
	public static Collection<Object[]> data()
	{
		Object[][] data = new Object[][] { /*{ new AList0() }, { new AList1() }, { new AList2() }, { new LList1() },*/ {new LList2()}};
		return Arrays.asList(data);
	}

	public EListTest(EList lst)
	{
		this.lst = lst;
	}

	@Before
	public void setUp()
	{
		lst.clear();
	}

	// ======================================
	// clear
	// ======================================

	@Test
	public void testClear_0()
	{
		int[] ini = {};
		lst.init(ini);
		lst.clear();
		assertEquals(0, lst.size());
	}

	@Test
	public void testClear_1()
	{
		int[] ini = { 10 };
		lst.init(ini);
		lst.clear();
		assertEquals(0, lst.size());
	}

	@Test
	public void testClear_2()
	{
		int[] ini = { 10, 20 };
		lst.init(ini);
		lst.clear();
		assertEquals(0, lst.size());
	}

	@Test
	public void testClear_many()
	{
		int[] ini = { 10, 20, 34, 11, 77, 99, 27 };
		lst.init(ini);
		lst.clear();
		assertEquals(0, lst.size());
	}

	// ==================================================
	// -------- init array
	// ==================================================

	@Test
	public void testInitEmpty()
	{
		int[] expecteds = {};
		lst.init(expecteds);
		int[] actuals = {};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testInit_0()
	{
		int[] expecteds = { 0 };
		lst.init(expecteds);
		int[] actuals = { 0 };
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testInit_01()
	{

		int[] expecteds = { 0, 1 };
		lst.init(expecteds);
		int[] actuals = { 0, 1 };
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testInitMany_1()
	{

		int[] expecteds = { 0, 1, 3, 6, 7, 8, -1, 6, -1 };
		lst.init(expecteds);
		int[] actuals = { 0, 1, 3, 6, 7, 8, -1, 6, -1 };
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testInitMany_2()
	{
		int[] expecteds = { 0, 1, -3, -6, -7, -8, -1, 6, -1 };
		lst.init(expecteds);
		int[] actuals = { 0, 1, -3, -6, -7, -8, -1, 6, -1 };
		assertArrayEquals(expecteds, actuals);
	}

	// ===================================================
	// ----------- test on size
	// ===================================================

	@Test
	public void testSize_0()
	{

		int expecteds = lst.size();
		int actuals = 0;
		assertEquals(expecteds, actuals);
	}

	@Test
	public void testSize_1()
	{

		int[] ar = { 1 };
		lst.init(ar);
		int expecteds = lst.size();
		int actuals = 1;
		assertEquals(expecteds, actuals);
	}

	@Test
	public void testSize_12()
	{

		int[] ar = { 1, 2 };
		lst.init(ar);
		int expecteds = lst.size();
		int actuals = 2;
		assertEquals(expecteds, actuals);
	}

	@Test
	public void testSizeMany_1()
	{

		int[] ar = { 0, 1, 3, 6, 7, 8, -1, 6, -1 };
		lst.init(ar);
		int expecteds = lst.size();
		int actuals = 9;
		assertEquals(expecteds, actuals);
	}

	@Test
	public void testSizeMany_2()
	{

		int[] ar = { 0, 1, -3, -6, -7, -8, -1, 6, -1 };
		lst.init(ar);
		int expecteds = lst.size();
		int actuals = 9;
		assertEquals(expecteds, actuals);
	}

	// ================================================
	// ----------- test toArray -----------------------
	// ================================================

	@Test
	public void testToArrayEmpty()
	{

		int[] tmp = {};
		lst.init(tmp);
		int[] expecteds = lst.toArray();
		int[] actuals = {};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testToArray_0()
	{

		int[] tmp = { 0 };
		lst.init(tmp);
		int[] expecteds = lst.toArray();
		int[] actuals = { 0 };
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testToArray_01()
	{

		int[] tmp = { 0, 1 };
		lst.init(tmp);
		int[] expecteds = lst.toArray();
		int[] actuals = { 0, 1 };
		assertArrayEquals(expecteds, actuals);

	}

	@Test
	public void testToArrayMany_1()
	{

		int[] tmp = { 1, 3, 6, 7, 8, -1, 6, -1 };
		lst.init(tmp);
		int[] exp = { 1, 3, 6, 7, 8, -1, 6, -1 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testToArrayMany_2()
	{

		int[] tmp = { 0, 1, 3, -6, -7, -8, -1, 6, -1 };
		lst.init(tmp);
		int[] expecteds = lst.toArray();
		int[] actuals = { 0, 1, 3, -6, -7, -8, -1, 6, -1 };
		assertArrayEquals(expecteds, actuals);
	}

	// ==========================================================
	// ------------ addArrSatrt
	// ==========================================================

//	@Test
//	public void testaddArrStartEmpty()
//	{
//
//		int[] ini = {};
//		lst.init(ini);
//		int[] tmp = { 2 };
//		lst.addStart(tmp);
//		int[] exp = { 2 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}
//
//	@Test
//	public void testaddArrStart_0()
//	{
//
//		int[] ini = { 0 };
//		lst.init(ini);
//		int[] tmp = { 2 };
//		lst.addStart(tmp);
//		int[] exp = lst.toArray();
//		int[] act = { 2, 0 };
//		assertArrayEquals(exp, act);
//	}
//
//	@Test
//	public void testaddArrStart_1()
//	{
//
//		int[] ini = { 1 };
//		lst.init(ini);
//		int[] tmp = { 2 };
//		lst.addStart(tmp);
//		int[] exp = { 2, 1 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}
//
//	@Test
//	public void testaddArrStartMany_1()
//	{
//
//		int[] ini = { 10, -211, -2, -333, -21, -30 };
//		lst.init(ini);
//		int[] tmp = { 1, 2, -3, -6, -5 };
//		lst.addStart(tmp);
//		int[] exp = { -5, -6, -3, 2, 1, 10, -211, -2, -333, -21, -30 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}
//
//	@Test
//	public void testaddArrStartMany_2()
//	{
//
//		int[] ini = { 10, 211, -2, 333, 21, 30 };
//		lst.init(ini);
//		int[] tmp = { 1, 2, 3, 6, 5 };
//		lst.addStart(tmp);
//		int[] exp = { 5, 6, 3, 2, 1, 10, 211, -2, 333, 21, 30 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}
//
//	// ==================================================
//	// ------------- test addArrEnd
//	// ==================================================
//
//	@Test
//	public void testaddArrEndEmpty()
//	{
//
//		int[] ini = {};
//		lst.init(ini);
//		int[] tmp = { 2 };
//		lst.addEnd(tmp);
//		int[] exp = { 2 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}
//
//	@Test
//	public void testaddArrEnd_0()
//	{
//
//		int[] ini = { 0 };
//		lst.init(ini);
//		int[] tmp = { 2 };
//		lst.addEnd(tmp);
//		int[] exp = lst.toArray();
//		int[] act = { 0, 2 };
//		assertArrayEquals(exp, act);
//	}
//
//	@Test
//	public void testaddArrEnd_1()
//	{
//
//		int[] ini = { 1 };
//		lst.init(ini);
//		int[] tmp = { 2 };
//		lst.addEnd(tmp);
//		int[] exp = { 1, 2 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}
//
//	@Test
//	public void testaddArrEndMany_1()
//	{
//
//		int[] ini = { 10, -211, -2, -333, -21, -30 };
//		lst.init(ini);
//		int[] tmp = { 1, 2, -3, -6, -5 };
//		lst.addEnd(tmp);
//		int[] exp = { 10, -211, -2, -333, -21, -30, 1, 2, -3, -6, -5 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}
//
//	@Test
//	public void testaddArrEndMany_2()
//	{
//
//		int[] ini = { 10, 211, -2, 333, 21, 30 };
//		lst.init(ini);
//		int[] tmp = { 1, 2, 3, 6, 5 };
//		lst.addEnd(tmp);
//		int[] exp = { 10, 211, -2, 333, 21, 30, 1, 2, 3, 6, 5 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}
//
//	// ================================================
//	// ----------- test addArrPos ----------------------
//	// ================================================
//
//	@Test
//	public void testaddArrPosEmpty()
//	{
//
//		int[] ini = {};
//		lst.init(ini);
//		int[] tmp = { 2 };
//		lst.addPos(0, tmp);
//		int[] exp = { 2 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}
//
//	@Test
//	public void testaddArrPos_0()
//	{
//
//		int[] ini = { 0 };
//		lst.init(ini);
//		int[] tmp = { 2 };
//		lst.addPos(1, tmp);
//		int[] exp = lst.toArray();
//		int[] act = { 0, 2 };
//		assertArrayEquals(exp, act);
//	}
//
//	@Test
//	public void testaddArrPos_1()
//	{
//
//		int[] ini = { 1 };
//		lst.init(ini);
//		int[] tmp = { 2 };
//		lst.addPos(1, tmp);
//		int[] exp = { 1, 2 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}
//
//	@Test
//	public void testaddArrPosMany_1()
//	{
//
//		int[] ini = { 10, 211, -2, -333, -21, -30 };
//		lst.init(ini);
//		int[] tmp = { 1, 2, -3, -6, -5 };
//		lst.addPos(2, tmp);
//		int[] exp = { 10, 211, 1, 2, -3, -6, -5, -2, -333, -21, -30 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}
//
//	@Test
//	public void testaddArrPosMany_2()
//	{
//
//		int[] ini = { 10, 211, -2, 333, 21, 30 };
//		lst.init(ini);
//		int[] tmp = { 1, 1, 1, 1, 1, 1, 1, 11 };
//		lst.addPos(2, tmp);
//		int[] exp = { 10, 211, 1, 1, 1, 1, 1, 1, 1, 11, -2, 333, 21, 30 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}

	// ================================================
	// ----------- test addStart ----------------------
	// ================================================

	@Test
	public void testaddStartEmpty()
	{

		int[] ini = {};
		lst.init(ini);
		lst.addStart(2);
		int[] exp = { 2 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testaddStart_0()
	{

		int[] ini = { 0 };
		lst.init(ini);
		lst.addStart(2);
		int[] exp = lst.toArray();
		int[] act = { 2, 0 };
		assertArrayEquals(exp, act);
	}

	@Test
	public void testaddStart_1()
	{

		int[] ini = { 1 };
		lst.init(ini);
		lst.addStart(2);
		int[] exp = { 2, 1 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testaddStartMany_1()
	{

		int[] ini = { 10, -211, -2, -333, -21, -30 };
		lst.init(ini);
		lst.addStart(-99);
		int[] exp = { -99, 10, -211, -2, -333, -21, -30 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testaddStartMany_2()
	{

		int[] ini = { 10, 211, -2, 333, 21, 30 };
		lst.init(ini);
		lst.addStart(-99);
		int[] exp = { -99, 10, 211, -2, 333, 21, 30 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	// ===========================================================
	// ------ test addEnd
	// ===========================================================

	@Test
	public void testaddEndEmpty()
	{

		int[] ini = {};
		lst.init(ini);
		lst.addEnd(2);
		int[] exp = { 2 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testaddEnd_0()
	{

		int[] ini = { 0 };
		lst.init(ini);
		lst.addEnd(2);
		int[] exp = { 0, 2 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testaddEnd_1()
	{

		int[] ini = { 1 };
		lst.init(ini);
		lst.addEnd(2);
		int[] exp = { 1, 2 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testaddEndMany_1()
	{
		int[] ini = { 10, -1, -2, -9, -2, -3 };
		lst.init(ini);
		lst.addEnd(-5);
		int[] exp = { 10, -1, -2, -9, -2, -3, -5 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testaddEndMany_2()
	{

		int[] ini = { 10, 211, -2, 333, 21, 30 };
		lst.init(ini);
		lst.addEnd(-99);
		int[] exp = { 10, 211, -2, 333, 21, 30, -99 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	// ================================================
	// ------------ test AddPos -----------------------
	// ================================================

	@Test
	public void testaddPosEmpty()
	{

		int[] ini = {};
		lst.init(ini);
		lst.addPos(0, 1);
		int[] exp = { 1 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testaddPos_0()
	{

		int[] ini = { 0 };
		lst.init(ini);
		lst.addPos(0, 1);
		int[] exp = { 1, 0 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testaddPos_1()
	{

		int[] ini = { 1 };
		lst.init(ini);
		lst.addPos(0, 3);
		int[] exp = { 3, 1 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testaddPosMany_1()
	{

		int[] ini = { 10, -211, -2, -333, -21, -30 };
		lst.init(ini);
		lst.addPos(3, 99);
		int[] exp = { 10, -211, -2, 99, -333, -21, -30 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testaddPosMany_2()
	{

		int[] ini = { 10, 211, -2, 333, 21, 30 };
		lst.init(ini);
		lst.addPos(2, -99);
		int[] exp = { 10, 211, -99, -2, 333, 21, 30 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	// =================================================
	// ------------ test DelStart ---------------------
	// ================================================

	@Test(expected = Exception.class)
	public void testdelStartEmpty()
	{

		int[] ini = {};
		lst.init(ini);
		lst.delStart();
	}

	@Test
	public void testdelStart_0()
	{

		int[] ini = { 0 };
		lst.init(ini);
		int exp = 0;
		int act = lst.delStart();
		assertEquals(exp, act);
	}

	@Test
	public void testdelStart_1()
	{

		int[] ini = { 1 };
		lst.init(ini);
		int exp = 1;
		int act = lst.delStart();
		assertEquals(exp, act);
	}

	@Test
	public void testdelStartMany_1()
	{

		int[] ini = { 10, -211, -2, -333, -21, -30 };
		lst.init(ini);
		int exp = 10;
		int act = lst.delStart();
		assertEquals(exp, act);
	}

	@Test
	public void testdelStartMany_2()
	{

		int[] ini = { 10, 211, 2, 333, 21, -30 };
		lst.init(ini);
		int exp = 10;
		int act = lst.delStart();
		assertEquals(exp, act);
	}

	// =================================================
	// ------------ test DelEnd ---------------------
	// ================================================

	@Test(expected = IllegalArgumentException.class)
	public void testdelEndEmpty()
	{

		int[] ini = {};
		lst.init(ini);
		lst.delEnd();
	}

	@Test
	public void testdelEnd_0()
	{

		int[] ini = { 0 };
		lst.init(ini);
		int exp = 0;
		int act = lst.delEnd();
		assertEquals(exp, act);
	}

	@Test
	public void testdelEnd_1()
	{

		int[] ini = { 1 };
		lst.init(ini);
		int exp = 1;
		int act = lst.delEnd();
		assertEquals(exp, act);
	}

	@Test
	public void testdelEndMany_1()
	{

		int[] ini = { 10, -211, -2, -333, -21, -30 };
		lst.init(ini);
		int exp = -30;
		int act = lst.delEnd();
		assertEquals(exp, act);
	}

	@Test
	public void testdelEndMany_2()
	{

		int[] ini = { 10, 211, 2, 333, 21, -30 };
		lst.init(ini);
		int exp = -30;
		int act = lst.delEnd();
		assertEquals(exp, act);
	}

	// =================================================
	// ------------ test DelPos ---------------------
	// ================================================

	@Test(expected = IllegalArgumentException.class)
	public void testdelPosEmpty()
	{

		int[] ini = {};
		lst.init(ini);
		lst.delPos(0);
	}

	@Test
	public void testdelPos_0()
	{

		int[] ini = { 0 };
		lst.init(ini);
		int exp = 0;
		int act = lst.delPos(0);
		assertEquals(exp, act);
	}

	@Test
	public void testdelPos_1()
	{

		int[] ini = { 1 };
		lst.init(ini);
		int exp = 1;
		int act = lst.delPos(0);
		assertEquals(exp, act);
	}

	@Test
	public void testdelPosMany_1()
	{

		int[] ini = { 10, -211, -2, -333, -21, -30 };
		lst.init(ini);
		int exp = -333;
		int act = lst.delPos(3);
		assertEquals(exp, act);
	}

	@Test
	public void testdelPosMany_2()
	{

		int[] ini = { 10, 211, 2, 333, 21, -30 };
		lst.init(ini);
		int exp = 2;
		int act = lst.delPos(2);
		assertEquals(exp, act);
	}

	// =================================================
	// ------------ test min ---------------------
	// ================================================

//	@Test(expected = IllegalArgumentException.class)
//	public void testminEmpty()
//	{
//
//		int[] ini = {};
//		lst.init(ini);
//		lst.min();
//	}
//
//	@Test
//	public void testmin_0()
//	{
//
//		int[] ini = { 0 };
//		lst.init(ini);
//		int exp = 0;
//		int act = lst.min();
//		assertEquals(exp, act);
//	}
//
//	@Test
//	public void testmin_1()
//	{
//
//		int[] ini = { 1 };
//		lst.init(ini);
//		int exp = 1;
//		int act = lst.min();
//		assertEquals(exp, act);
//	}
//
//	@Test
//	public void testminMany_1()
//	{
//
//		int[] ini = { -400, -211, -2, -333, -21, -50 };
//		lst.init(ini);
//		int exp = -400;
//		int act = lst.min();
//		assertEquals(exp, act);
//	}
//
//	@Test
//	public void testminMany_2()
//	{
//
//		int[] ini = { 10, 211, 2, 333, 21, -30 };
//		lst.init(ini);
//		int exp = -30;
//		int act = lst.min();
//		assertEquals(exp, act);
//	}
//
//	// =================================================
//	// ------------ test max ---------------------
//	// ================================================
//	@Test(expected = IllegalArgumentException.class)
//	public void testmaxEmpty()
//	{
//
//		int[] ini = {};
//		lst.init(ini);
//		lst.max();
//	}
//
//	@Test
//	public void testmax_0()
//	{
//
//		int[] ini = { 0 };
//		lst.init(ini);
//		int exp = 0;
//		int act = lst.max();
//		assertEquals(exp, act);
//	}
//
//	@Test
//	public void testmax_1()
//	{
//
//		int[] ini = { 1 };
//		lst.init(ini);
//		int exp = 1;
//		int act = lst.max();
//		assertEquals(exp, act);
//	}
//
//	@Test
//	public void testmaxMany_1()
//	{
//
//		int[] ini = { 10, -211, -2, -333, -21, -30 };
//		lst.init(ini);
//		int exp = 10;
//		int act = lst.max();
//		assertEquals(exp, act);
//	}
//
//	@Test
//	public void testmaxMany_2()
//	{
//
//		int[] ini = { 10, 211, 2, 333, 21, -30 };
//		lst.init(ini);
//		int exp = 333;
//		int act = lst.max();
//		assertEquals(exp, act);
//	}
//
//	// =================================================
//	// ------------ test minInd---------------------
//	// ================================================
//
//	@Test(expected = IllegalArgumentException.class)
//	public void testminIndEmpty()
//	{
//
//		int[] ini = {};
//		lst.init(ini);
//		lst.minInd();
//	}
//
//	@Test
//	public void testminInd_0()
//	{
//
//		int[] ini = { 0 };
//		lst.init(ini);
//		int exp = 0;
//		int act = lst.minInd();
//		assertEquals(exp, act);
//	}
//
//	@Test
//	public void testminInd_1()
//	{
//
//		int[] ini = { 1 };
//		lst.init(ini);
//		int exp = 0;
//		int act = lst.minInd();
//		assertEquals(exp, act);
//	}
//
//	@Test
//	public void testminIndMany_1()
//	{
//
//		int[] ini = { 10, -211, -2, -333, -21, -30 };
//		lst.init(ini);
//		int exp = 3;
//		int act = lst.minInd();
//		assertEquals(exp, act);
//	}
//
//	@Test
//	public void testminIndMany_2()
//	{
//
//		int[] ini = { 10, 211, 2, 333, 21, -30 };
//		lst.init(ini);
//		int exp = 5;
//		int act = lst.minInd();
//		assertEquals(exp, act);
//	}
//
//	// =================================================
//	// ------------ test maxInd---------------------
//	// ================================================
//
//	@Test(expected = IllegalArgumentException.class)
//	public void testmaxIndEmpty()
//	{
//
//		int[] ini = {};
//		lst.init(ini);
//		lst.maxInd();
//	}
//
//	@Test
//	public void testmaxInd_0()
//	{
//
//		int[] ini = { 0 };
//		lst.init(ini);
//		int exp = 0;
//		int act = lst.maxInd();
//		assertEquals(exp, act);
//	}
//
//	@Test
//	public void testmaxInd_1()
//	{
//
//		int[] ini = { 1 };
//		lst.init(ini);
//		int exp = 0;
//		int act = lst.maxInd();
//		assertEquals(exp, act);
//	}
//
//	@Test
//	public void testmaxIndMany_1()
//	{
//
//		int[] ini = { 10, -211, -2, -333, -21, -30 };
//		lst.init(ini);
//		int exp = 0;
//		int act = lst.maxInd();
//		assertEquals(exp, act);
//	}
//
//	@Test
//	public void testmaxIndMany_2()
//	{
//
//		int[] ini = { 10, 211, 2, 333, 21, -30 };
//		lst.init(ini);
//		int exp = 3;
//		int act = lst.maxInd();
//		assertEquals(exp, act);
//	}
//
//	// =================================================
//	// ------------ test set---------------------
//	// ================================================
//	@Test
//	public void testsetEmpty()
//	{
//
//		int[] ini = {};
//		lst.init(ini);
//		lst.set(0, 1);
//	}
//
//	@Test
//	public void testset_0()
//	{
//
//		int[] ini = { 0 };
//		lst.init(ini);
//		lst.set(0, 1);
//		int[] exp = { 1 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}
//
//	@Test
//	public void testset_1()
//	{
//
//		int[] ini = { 1 };
//		lst.init(ini);
//		lst.set(0, 3);
//		int[] exp = { 3 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}
//
//	@Test
//	public void testsetMany_1()
//	{
//
//		int[] ini = { 10, -211, -2, -333, -21, -30 };
//		lst.init(ini);
//		lst.set(3, 99);
//		int[] exp = { 10, -211, -2, 99, -21, -30 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}
//
//	@Test
//	public void testsetMany_2()
//	{
//
//		int[] ini = { 10, 211, -2, 333, 21, 30 };
//		lst.init(ini);
//		lst.set(2, -99);
//		int[] exp = { 10, 211, -99, 333, 21, 30 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}
//
//	// =================================================
//	// ------------ test get---------------------
//	// ================================================
//
//	@Test(expected = Exception.class)
//	public void testgetEmpty()
//	{
//
//		int[] ini = {};
//		lst.init(ini);
//		lst.get(0);
//	}
//
//	@Test
//	public void testget_0()
//	{
//
//		int[] ini = { 0 };
//		lst.init(ini);
//		int exp = 0;
//		int act = lst.get(0);
//		assertEquals(exp, act);
//	}
//
//	@Test
//	public void testget_1()
//	{
//		int[] ini = { 1 };
//		lst.init(ini);
//		int exp = 1;
//		int act = lst.get(0);
//		assertEquals(exp, act);
//	}
//
//	@Test
//	public void testgetMany_1()
//	{
//		int[] ini = { 10, -211, -2, -333, -21, -30 };
//		lst.init(ini);
//		int exp = -2;
//		int act = lst.get(2);
//		assertEquals(exp, act);
//	}
//
//	@Test
//	public void testgetMany_2()
//	{
//
//		int[] ini = { 10, 211, 2, 333, 21, -30 };
//		lst.init(ini);
//		int exp = 211;
//		int act = lst.get(1);
//		assertEquals(exp, act);
//	}
//
//	// ============================================================
//	// ------ ���� �� ������
//	// ============================================================
//
//	@Test
//	public void testReverseEmpty()
//	{
//		int[] arr = {};
//		lst.init(arr);
//		lst.reverse();
//		int[] exp = {};
//		int[] act = {};
//		assertArrayEquals(exp, act);
//	}
//
//	@Test
//	public void testReverseManyOod()
//	{
//		int[] arr = { 0, 3, 8, 0, 9, -9, -1 };
//		lst.init(arr);
//		lst.reverse();
//	}
//
//	@Test
//	public void testReverseManyEvan()
//	{
//
//		int[] arr = { 0, 3, -8, 0, -9, -9, -1 };
//		lst.init(arr);
//		lst.reverse();
//		int[] actuals = { -1, -9, -9, 0, -8, 3, 0 };
//		int[] expecteds = lst.toArray();
//		assertArrayEquals(expecteds, actuals);
//	}
//
//	@Test
//	public void testReverseOne()
//	{
//		int[] arr = { 0 };
//		lst.init(arr);
//		lst.reverse();
//		int[] exp = { 0 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}
//
//	@Test
//	public void testReverseTwo()
//	{
//		int[] arr = { 0, 1 };
//		lst.init(arr);
//		lst.reverse();
//		int[] exp = { 1, 0 };
//		int[] act = lst.toArray();
//		assertArrayEquals(exp, act);
//	}
//
//	// ============================================================
//	// ------ test revers
//	// ============================================================
//	@Test
//	public void testhalfReversEmpty()
//	{
//		int[] exp = {};
//		lst.init(exp);
//		lst.halfRevers();
//		int[] act = {};
//		assertArrayEquals(exp, act);
//
//	}
//
//	@Test
//	public void testhalfReversOne()
//	{
//		int[] arr = { 1 };
//		lst.init(arr);
//		lst.halfRevers();
//		int[] expecteds = { 1 };
//		int[] actuals = lst.toArray();
//		assertArrayEquals(expecteds, actuals);
//	}
//
//	@Test
//	public void testhalfReversManyOod()
//	{
//		int[] arr = { 4, 2, 3, 2, 7, 5 };
//		lst.init(arr);
//		lst.halfRevers();
//		int[] expecteds = { 2, 7, 5, 4, 2, 3 };
//		int[] actuals = lst.toArray();
//		assertArrayEquals(expecteds, actuals);
//
//	}
//
//	@Test
//	public void testhalfReversManyEvan()
//	{
//		int[] arr = { 0, 3, -8, 0, -9, -9, -1, -6 };
//		lst.init(arr);
//		lst.halfRevers();
//		int[] expecteds = { -9, -9, -1, -6, 0, 3, -8, 0 };
//		int[] actuals = lst.toArray();
//		assertArrayEquals(expecteds, actuals);
//	}
//
//	@Test
//	public void testhalfReversTwo()
//	{
//		int[] arr = { 0, 1 };
//		lst.init(arr);
//		lst.halfRevers();
//		int[] expecteds = { 1, 0 };
//		int[] actuals = lst.toArray();
//		assertArrayEquals(expecteds, actuals);
//	}
//
//	// ============================================================
//	// ------ test sort
//	// ============================================================
//	@Test
//	public void testsortEmpty()
//	{
//		int[] arr = {};
//		lst.init(arr);
//		lst.sort();
//		int[] res = {};
//		assertArrayEquals(arr, res);
//
//	}
//
//	@Test
//	public void testsortManyOod()
//	{
//		int[] arr = { 0, 3, 8, 0, 9, 9, -1, -6 };
//		lst.init(arr);
//		lst.sort();
//		int[] expecteds = { -6, -1, 0, 0, 3, 8, 9, 9 };
//		int[] actuals = lst.toArray();
//		assertArrayEquals(expecteds, actuals);
//
//	}
//
//	@Test
//	public void testsortManyEvan()
//	{
//		int[] arr = { 0, 3, -8, 0, -9, -9, -1, -6 };
//		lst.init(arr);
//		lst.sort();
//		int[] expecteds = { -9, -9, -8, -6, -1, 0, 0, 3 };
//		int[] actuals = lst.toArray();
//		assertArrayEquals(expecteds, actuals);
//	}
//
//	@Test
//	public void testsortOne()
//	{
//		int[] arr = { 0 };
//		lst.init(arr);
//		lst.sort();
//		int[] expecteds = { 0 };
//		int[] actuals = lst.toArray();
//		assertArrayEquals(expecteds, actuals);
//	}
//
//	@Test
//	public void testsortTwo()
//	{
//		int[] arr = { 0, 1 };
//		lst.init(arr);
//		lst.sort();
//		int[] expecteds = { 0, 1 };
//		int[] actuals = lst.toArray();
//		assertArrayEquals(expecteds, actuals);
//	}
}