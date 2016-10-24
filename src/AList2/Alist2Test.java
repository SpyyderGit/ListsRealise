package AList2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Alist2Test
{

	@Test
	public void test1()
	{
		AList2 al = new AList2();
		int[] ini = { 2, 3, 4, 5 };
		al.init(ini);
		int[] actuals = new int[al.size()];
		int d = 0;
		for (int i : al)
		{
			actuals[d] = i;
			d++;
		}

		int[] expecteds = al.toArray();

		assertArrayEquals(expecteds, actuals);

	}

}
