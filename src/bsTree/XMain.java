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
		int[] ar = { 50, 25, 30, 11, 7, 12, 75, 90, 110, 13, 70, 35, 28 };

		t.init(ar);
		t.delete(50);
		 System.out.println(t.toString());
	}
}
