package HTable;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class HashT
{

	@Test
	public void testAdd()
	{
		HashTable htl = new HashTable();
		PersonDAO_Mock pdb = new PersonDAO_Mock();
		ArrayList<Person> pp = pdb.read();
		for (Person p : pp)
		{
			htl.add(p);
		}
		int expSize = 130;
		int actSize = htl.size();
		assertEquals(expSize, actSize);
		for (Person p : pp)
		{
			Person resieved = htl.get(p.hashCode());
			boolean exp = true;
			boolean act = p.equals(resieved);
			assertEquals(exp, act);
		}

	}

}
