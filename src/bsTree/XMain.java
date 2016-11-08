package bsTree;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.LinkedList;

import AList0.AList0;
import Iterators.LList1;

public class XMain
{

	public static void main(String[] args)
	{
		BsTree t = new BsTree();
		BsTree t1 = new BsTree();
		int[] ar = { 50, 25, 30, 11, 7, 12, 75, 90, 110, 13, 70, 35, 28 };
		// int[] ar1 = { 50, 25, 30, 11, 7, 12, 75, 90, 110, 13, 70, 35, 28 };

		t.init(ar);
		t1.init(ar);

		t.delete(25);

		if (t.equals(t1))
		{
			System.out.println("correct");
		}
		else
		{
			System.out.println("incorrect");
		}

		System.out.println(t.toString());
		System.out.println(t1.toString());
	}
}
