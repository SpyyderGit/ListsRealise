package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import AList0.*;
import AList1.*;
import AList2.*;
import LLIst2.LList2;
import LList1.LList1;
import interfaces.*;

@RunWith(value = Parameterized.class)
public class EListExtra
{
	EList lst = null;

	@Parameters
	public static Collection<Object[]> data()
	{
		Object[][] data = new Object[][] { { new AList0() }, { new AList1() }, { new AList2() }, { new LList1() }};
		return Arrays.asList(data);
	}

	public EListExtra(EList lst)
	{
		this.lst = lst;
	}

	@Before
	public void clearArr()
	{
		lst.clear();
	}

	// =============================================================
	// Проверка балансирования при инициализации (нужно для AList2)
	// =============================================================

	@Test
	public void testInitBalanceManyOdd()
	{
		int[] ini = { 10, 211, 2, 333, 21, 30, 78, 63, 23, 20, 2, 55, 77, 11, 23, 20, 2, 55, 77, 11 };
		lst.init(ini);
		assertEquals(20, lst.size());
		int[] exp = { 10, 211, 2, 333, 21, 30, 78, 63, 23, 20, 2, 55, 77, 11, 23, 20, 2, 55, 77, 11 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testInitBalanceManyEvan()
	{
		int[] ini = { -10, 211, -2, 333, -21, 30, -78, 63, -23, -20, -2, 55, 77, 11, 23, 20, 2, 55, 77, 11 };
		lst.init(ini);
		assertEquals(20, lst.size());
		int[] exp = { -10, 211, -2, 333, -21, 30, -78, 63, -23, -20, -2, 55, 77, 11, 23, 20, 2, 55, 77, 11 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	// ====================================================================================
	// Проверка выхода за границы при инициализации (нужно для AList1 и
	// AList2)
	// ====================================================================================

	@Test
	public void testInitEndOfArrManyOdd()
	{
		int[] ini = { 10, 211, 2, 333, 21, 30, 78, 63, 23, 16, 10, 211, 2, 333, 4, 2, 333, 4, 2, 333, 4, 6, 10, 211, 2,
				333, 21, 30, 78, 63, 23, 16, 10, 211, 2, 333, 4, 2, 333, 4, 2, 333, 4, 6 };
		lst.init(ini);
		assertEquals(44, lst.size());
		int[] exp = { 10, 211, 2, 333, 21, 30, 78, 63, 23, 16, 10, 211, 2, 333, 4, 2, 333, 4, 2, 333, 4, 6, 10, 211, 2,
				333, 21, 30, 78, 63, 23, 16, 10, 211, 2, 333, 4, 2, 333, 4, 2, 333, 4, 6 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	// =================================================
	// Валится при отработке всех тестов, после resize
	// =================================================
	@Test
	public void testInitEndOfArrManyEvan()
	{
		int[] ini = { -10, -211, -2, -333, -21, -30, -78, -63, -23, -16, -10, -211, -2, -333, -4, -2, -333, -4, -2,
				-333, -4, -6, -10, -211, -2, -333, -21, -30, -78, -63, -23, 16, 10, 211, 2, 333, 4, 2, 333, 4, 2, 333,
				4, 6 };
		lst.init(ini);
		assertEquals(44, lst.size());
		int[] exp = { -10, -211, -2, -333, -21, -30, -78, -63, -23, -16, -10, -211, -2, -333, -4, -2, -333, -4, -2,
				-333, -4, -6, -10, -211, -2, -333, -21, -30, -78, -63, -23, 16, 10, 211, 2, 333, 4, 2, 333, 4, 2, 333,
				4, 6 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	// =============================================================
	// ------ балансировка при добавлении данных в конец
	// =============================================================

	@Test
	public void testaddArrOddEnd()
	{
		int[] ini = { 10, 211, 2, 333, 21, 30, 78, 63, 23 };
		lst.init(ini);
		int[] tmp = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		lst.addEnd(tmp);
		assertEquals(18, lst.size());
		int[] exp = { 10, 211, 2, 333, 21, 30, 78, 63, 23, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testaddArrEvanEnd()
	{
		int[] ini = { -10, -211, -2, -333, -21, -30, 78, 63, 23 };
		lst.init(ini);
		int[] tmp = { 1, -1, -1, -1, -1, -1, -1, -1, 1 };
		lst.addEnd(tmp);
		assertEquals(18, lst.size());
		int[] exp = { -10, -211, -2, -333, -21, -30, 78, 63, 23, 1, -1, -1, -1, -1, -1, -1, -1, 1 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	// =============================================================
	// ------ выход за границы при добавлении данных в конец
	// =============================================================

	@Test
	public void testaddArrEndOddOut()
	{
		int[] ini = { 10, 211, 2, 333, 21, 30, 78, 63, 23, 16, 10, 211, 2, 333, 21, 30, 78, 63, 23, 16, 10, 211, 2, 333,
				21, 30, 78, 63, 23, 16 };
		lst.init(ini);
		int[] tmp = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		lst.addEnd(tmp);
		assertEquals(39, lst.size());
		int[] exp = { 10, 211, 2, 333, 21, 30, 78, 63, 23, 16, 10, 211, 2, 333, 21, 30, 78, 63, 23, 16, 10, 211, 2, 333,
				21, 30, 78, 63, 23, 16, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testaddArrEndEvanOut()
	{
		int[] ini = { -10, -211, -2, -333, -21, -30, -78, -63, -23, -16, -10, -211, -2, -333, 21, 30, 78, 63, 23, 16,
				10, 211, 2, 333, 21, 30, 78, 63, 23, 16 };
		lst.init(ini);
		int[] tmp = { 1, 1, -1, -1, -1, -1, -1, -1, -1 };
		lst.addEnd(tmp);
		assertEquals(39, lst.size());
		int[] exp = { -10, -211, -2, -333, -21, -30, -78, -63, -23, -16, -10, -211, -2, -333, 21, 30, 78, 63, 23, 16,
				10, 211, 2, 333, 21, 30, 78, 63, 23, 16, 1, 1, -1, -1, -1, -1, -1, -1, -1 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	// =============================================================
	// ------ балансировка при добавлении данных в начало
	// =============================================================

	@Test
	public void testaddArrStartOddEnd()
	{
		int[] ini = { 10, 211, 2, 333, 21, 30, 78, 63, 23 };
		lst.init(ini);
		int[] tmp = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		lst.addStart(tmp);
		assertEquals(18, lst.size());
		int[] exp = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 211, 2, 333, 21, 30, 78, 63, 23 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testArrStartEvanEnd()
	{
		int[] ini = { -10, -211, -2, -333, -21, -30, 78, 63, 23 };
		lst.init(ini);
		int[] tmp = { 1, -1, -1, -1, -1, -1, -1, -1, 1 };
		lst.addStart(tmp);
		assertEquals(18, lst.size());
		int[] exp = { 1, -1, -1, -1, -1, -1, -1, -1, 1, -10, -211, -2, -333, -21, -30, 78, 63, 23 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	// =============================================================
	// ------ выход за границы при добавлении данных в начало
	// =============================================================

	@Test
	public void testaddArrStartOddOut()
	{
		int[] ini = { 10, 211, 2, 333, 21, 30, 78, 63, 23, 16, 10, 211, 2, 333, 21, 30, 78, 63, 23, 16, 10, 211, 2, 333,
				21, 30, 78, 63, 23, 16 };
		lst.init(ini);
		int[] tmp = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		lst.addStart(tmp);
		assertEquals(39, lst.size());
		int[] exp = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 211, 2, 333, 21, 30, 78, 63, 23, 16, 10, 211, 2, 333, 21, 30, 78,
				63, 23, 16, 10, 211, 2, 333, 21, 30, 78, 63, 23, 16 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testaddArrStartEvanOut()
	{
		int[] ini = { -10, -211, -2, -333, -21, -30, -78, -63, -23, -16, -10, -211, -2, -333, 21, 30, 78, 63, 23, 16,
				10, 211, 2, 333, 21, 30, 78, 63, 23, 16 };
		lst.init(ini);
		int[] tmp = { 1, 1, -1, -1, -1, -1, -1, -1, -1 };
		lst.addStart(tmp);
		assertEquals(39, lst.size());
		int[] exp = { -1, -1, -1, -1, -1, -1, -1, 1, 1, -10, -211, -2, -333, -21, -30, -78, -63, -23, -16, -10, -211,
				-2, -333, 21, 30, 78, 63, 23, 16, 10, 211, 2, 333, 21, 30, 78, 63, 23, 16 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	// =============================================================
	// ------ балансировка при добавлении данных на позицию
	// =============================================================

	@Test
	public void testaddArrPosOddBal()
	{
		int[] ini = { 10, 211, 2, 333, 21, 30, 78, 63, 23 };
		lst.init(ini);
		int[] tmp = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		lst.addPos(3, tmp);
		assertEquals(18, lst.size());
		int[] exp = { 10, 211, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 333, 21, 30, 78, 63, 23 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testaddArrPosEvanBal()
	{
		int[] ini = { -10, -211, -2, -333, -21, -30, 78, 63, 23 };
		lst.init(ini);
		int[] tmp = { 1, 1, -1, -1, -1, -1, -1, -1, -1 };
		lst.addPos(3, tmp);
		assertEquals(18, lst.size());
		int[] exp = { -10, -211, -2, 1, 1, -1, -1, -1, -1, -1, -1, -1, -333, -21, -30, 78, 63, 23 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	// =============================================================
	// ------ выход за границы при добавлении данных на позицию
	// =============================================================

	@Test
	public void testaddArrPosOddOut()
	{
		int[] ini = { 10, 211, 2, 333, 21, 30, 78, 63, 23, 16, 10, 211, 2, 333, 21, 30, 78, 63, 23, 16, 10, 211, 2, 333,
				21, 30, 78, 63, 23, 16 };
		lst.init(ini);
		int[] tmp = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		lst.addPos(3, tmp);
		assertEquals(39, lst.size());
		int[] exp = { 10, 211, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 333, 21, 30, 78, 63, 23, 16, 10, 211, 2, 333, 21, 30, 78,
				63, 23, 16, 10, 211, 2, 333, 21, 30, 78, 63, 23, 16 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test
	public void testaddArrPosEvanOut()
	{
		int[] ini = { -10, -211, -2, -333, -21, -30, -78, -63, -23, -16, -10, -211, -2, -333, 21, 30, 78, 63, 23, 16,
				10, 211, 2, 333, 21, 30, 78, 63, 23, 16 };
		lst.init(ini);
		int[] tmp = { 1, 1, -1, -1, -1, -1, -1, -1, -1 };
		lst.addPos(3, tmp);
		assertEquals(39, lst.size());
		int[] exp = { -10, -211, -2, 1, 1, -1, -1, -1, -1, -1, -1, -1, -333, -21, -30, -78, -63, -23, -16, -10, -211,
				-2, -333, 21, 30, 78, 63, 23, 16, 10, 211, 2, 333, 21, 30, 78, 63, 23, 16 };
		int[] act = lst.toArray();
		assertArrayEquals(exp, act);
	}

}
