package Iterators;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import interfaces.EList;

public class Alist0Test
{

	// AList2 al = new AList2();
	// AList1 al = new AList1();
	// AList0 al = new AList0();

	LList1 al = new LList1();

	@Test
	public void testIterManyNull()
	{
		int[] ini = null;
		al.init(ini);
		int[] actuals = new int[al.size()];
		int[] expecteds = al.toArray();
		int d = 0;

		for (int i : al)
		{
			actuals[d] = i;
			d++;
		}
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testIterManyEmpty()
	{
		int[] ini = {};
		al.init(ini);
		int[] actuals = new int[al.size()];
		int[] expecteds = al.toArray();
		int d = 0;

		for (int i : al)
		{
			actuals[d] = i;
			d++;
		}
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testIterManyOne()
	{
		int[] ini = { 0 };
		al.init(ini);
		int[] actuals = new int[al.size()];
		int[] expecteds = al.toArray();
		int d = 0;

		for (int i : al)
		{
			actuals[d] = i;
			d++;
		}
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testIterMany1()
	{
		int[] ini = { -2, -3, 4, 5, 4, 5, 6, 7 };
		al.init(ini);
		int[] actuals = new int[al.size()];
		int[] expecteds = al.toArray();
		int d = 0;

		for (int i : al)
		{
			actuals[d] = i;
			d++;
		}
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testIterMany2()
	{
		int[] ini = { -2, -3, -4, -5, -4, -5, 6, 7 };
		al.init(ini);
		int[] actuals = new int[al.size()];

		int[] expecteds = al.toArray();
		int d = 0;

		for (int i : al)
		{
			actuals[d++] = i;

		}
		assertArrayEquals(expecteds, actuals);
	}
}
