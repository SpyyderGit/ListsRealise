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
		int[] ar = { 50, 40, 43, 45, 42, 46, 35, 38, 37, 30, 54, 53, 60, 58, 66 };

		t.init(ar);
		t.delete(50);

		// System.out.println(t.test(50).val);
		System.out.println(t.toString());
	}
}
