package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
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

	@Test
	public void testAdd_0()
	{
		int[] ar = {};
		int val = 4;
		int[] ex = { 4 };
		t.init(ar);
		t.add(val);
		assertArrayEquals(ex, t.toArray());
	}

	@Test
	public void testAdd_1()
	{
		int[] ar = { 4 };
		int val = 6;
		int[] ex = { 4, 6 };
		t.init(ar);
		t.add(val);
		assertArrayEquals(ex, t.toArray());
	}

	@Test
	public void testAdd_2()
	{
		int[] ar = { 5, 3 };
		int val = 4;
		int[] ex = { 3, 4, 5 };
		t.init(ar);
		t.add(val);
		assertArrayEquals(ex, t.toArray());
	}

	@Test
	public void testAdd_Many()
	{
		int[] ar = { 3, 7, 12, 9, 2 };
		int val = 4;
		int[] ex = { 2, 3, 4, 7, 9, 12 };
		t.init(ar);
		t.add(val);
		assertArrayEquals(ex, t.toArray());
	}

	// =============== init ======================

	@Test
	public void testInit_0()
	{
		int[] ar = {};
		int[] ex = null;
		t.init(ar);
		assertArrayEquals(ex, t.toArray());
	}

	@Test
	public void testInit_1()
	{
		int[] ar = { 5 };
		int[] ex = { 5 };
		t.init(ar);
		assertArrayEquals(ex, t.toArray());
	}

	@Test
	public void testInit_2()
	{
		int[] ar = { 4, 3 };
		int[] ex = { 3, 4 };
		t.init(ar);
		assertArrayEquals(ex, t.toArray());
	}

	@Test
	public void testInit_Many()
	{
		int[] ar = { 5, 8, 3, 9, 15 };
		int[] ex = { 3, 5, 8, 9, 15 };
		t.init(ar);
		assertArrayEquals(ex, t.toArray());
	}
	// ============= toArray ===========================

	@Test
	public void testToArray_0()
	{
		int[] ar = {};
		int[] ex = null;
		t.init(ar);
		assertArrayEquals(ex, t.toArray());
	}

	@Test
	public void testToArray_1()
	{
		int[] ar = { 5 };
		int[] ex = { 5 };
		t.init(ar);
		assertArrayEquals(ex, t.toArray());
	}

	@Test
	public void testToArray_2()
	{
		int[] ar = { 4, 3 };
		int[] ex = { 3, 4 };
		t.init(ar);
		assertArrayEquals(ex, t.toArray());
	}

	@Test
	public void testToArray_Many()
	{
		int[] ar = { 5, 8, 3, 9, 15 };
		int[] ex = { 3, 5, 8, 9, 15 };
		t.init(ar);
		assertArrayEquals(ex, t.toArray());
	}

	// ========================= toString =================

	@Test(expected = NullPointerException.class)
	public void testToString_Null()
	{
		int[] ar = null;
		String ex = null;
		t.init(ar);
		assertEquals(ex, t.toString());
	}

	@Test(expected = NullPointerException.class)
	public void testToString_0()
	{
		int[] ar = {};
		String ex = null;
		t.init(ar);
		assertEquals(ex, t.toString());
	}

	@Test
	public void testToString_1()
	{
		int[] ar = { 5 };
		String ex = "5, ";
		t.init(ar);
		assertEquals(ex, t.toString());
	}

	@Test
	public void testToString_2()
	{
		int[] ar = { 5, 6 };
		String ex = "5, 6, ";
		t.init(ar);
		assertEquals(ex, t.toString());
	}

	@Test
	public void testToString_Many()
	{
		int[] ar = { 5, 8, 3, 9, 15 };
		String ex = "3, 5, 8, 9, 15, ";
		t.init(ar);
		assertEquals(ex, t.toString());
	}

	// =================== leaves ========================

	@Test(expected = NullPointerException.class)
	public void testLeaves_Null()
	{
		int[] ar = null;
		t.init(ar);
		assertEquals(0, t.leaves());
	}

	@Test
	public void testLeaves_0()
	{
		int[] ar = {};
		t.init(ar);
		assertEquals(0, t.leaves());
	}

	@Test
	public void testLeaves_1()
	{
		int[] ar = { 5 };
		t.init(ar);
		assertEquals(1, t.leaves());
	}

	@Test
	public void testLeaves_2l()
	{
		int[] ar = { 5, 1 };
		t.init(ar);
		assertEquals(1, t.leaves());
	}

	@Test
	public void testLeaves_2r()
	{
		int[] ar = { 1, 5 };
		t.init(ar);
		assertEquals(1, t.leaves());
	}

	@Test
	public void testLeaves_Many()
	{
		int[] ar = { 10, 5, 15, 22, 1, 6 };
		t.init(ar);
		assertEquals(3, t.leaves());
	}

	// ================== Nodes ==============================

	@Test(expected = NullPointerException.class)
	public void testCountNodes_Null()
	{
		int[] ar = null;
		t.init(ar);
		assertEquals(0, t.nodes());
	}

	@Test
	public void testCountNodes_0()
	{
		int[] ar = {};
		t.init(ar);
		assertEquals(0, t.nodes());
	}

	@Test
	public void testCountNodes_1()
	{
		int[] ar = { 5 };
		t.init(ar);
		assertEquals(0, t.nodes());
	}

	@Test
	public void testCountNodes_2l()
	{
		int[] ar = { 5, 1 };
		t.init(ar);
		assertEquals(1, t.nodes());
	}

	@Test
	public void testCountNodes_2r()
	{
		int[] ar = { 1, 5 };
		t.init(ar);
		assertEquals(1, t.nodes());
	}

	@Test
	public void testCountNodes_Many()
	{
		int[] ar = { 10, 5, 15, 22, 1, 6, 4 };
		t.init(ar);
		assertEquals(4, t.nodes());
	}

	// ========================= Height ===========================

	@Test(expected = NullPointerException.class)
	public void testHeigth_Null()
	{
		int[] ar = null;
		t.init(ar);
		assertEquals(0, t.height());
	}

	@Test
	public void testHeigth_0()
	{
		int[] ar = {};
		t.init(ar);
		assertEquals(0, t.height());
	}

	@Test
	public void testHeigth_1()
	{
		int[] ar = { 4 };
		t.init(ar);
		assertEquals(1, t.height());
	}

	@Test
	public void testHeigth_2()
	{
		int[] ar = { 4, 7 };
		t.init(ar);
		assertEquals(2, t.height());
	}

	@Test
	public void testHeigth_many()
	{
		int[] ar = { 10, 5, 15, 22, 1, 6, 4 };
		t.init(ar);
		assertEquals(4, t.height());
	}

	// ============== width ========================

	@Test(expected = NullPointerException.class)
	public void testWidth_Null()
	{
		int[] ar = null;
		t.init(ar);
		assertEquals(0, t.width());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWidth_0()
	{
		int[] ar = {};
		t.init(ar);
		assertEquals(0, t.width());
	}

	@Test
	public void testWidth_1()
	{
		int[] ar = { 4 };
		t.init(ar);
		assertEquals(1, t.width());
	}

	@Test
	public void testWidth_2()
	{
		int[] ar = { 4, 7, 3 };
		t.init(ar);
		assertEquals(2, t.width());
	}

	@Test
	public void testWidth_many()
	{
		int[] ar = { 10, 5, 15, 22, 1, 6, 4 };
		t.init(ar);
		assertEquals(3, t.width());
	}

	// ========= Тесты на удаление из дерева ======================

	// ---------- Проверка на null ----------------------

	@Test(expected = NullPointerException.class)
	public void testDel_Null()
	{
		int[] ar = null;
		t.init(ar);
		t.delete(5);
		int[] actuals = null;
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);

	}

	// ------- Пустое дерево -----------------

	@Test
	public void testDel_Emty()
	{
		int[] ar = {};
		t.init(ar);
		t.delete(5);
		int[] actuals = null;
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// ------------- Удаление листов ---------------

	// --------- Листья слева, левая ветка
	@Test
	public void testDel_LeavesLeftLeft()
	{
		int[] ar = { 50, 25, 30, 11, 12, 7, 75, 90, 110, 70 };
		t.init(ar);
		t.delete(7);
		int[] actuals = { 11, 12, 25, 30, 50, 70, 75, 90, 110 };
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// --------- Листья слева, левая ветка
	@Test
	public void testDel_LeavesLeftRight()
	{
		int[] ar = { 50, 25, 30, 11, 12, 13, 7, 75, 90, 110, 70 };
		t.init(ar);
		t.delete(13);
		int[] actuals = { 7, 11, 12, 25, 30, 50, 70, 75, 90, 110 };
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// ----------- Листья справа -----------

	@Test
	public void testDel_LeavesRight()
	{
		int[] ar = { 50, 25, 30, 11, 12, 7, 75, 90, 110, 70 };
		t.init(ar);
		t.delete(110);
		int[] actuals = { 7, 11, 12, 25, 30, 50, 70, 75, 90 };
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// --------- Листья справа, левая ветка
	@Test
	public void testDel_LeavesRightLeft()
	{
		int[] ar = { 50, 25, 30, 11, 12, 13, 7, 75, 90, 110, 70 };
		t.init(ar);
		t.delete(70);
		int[] actuals = { 7, 11, 12, 13, 25, 30, 50, 75, 90, 110 };
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// --------- Листья справа, правая ветка
	@Test
	public void testDel_LeavesRightRight()
	{
		int[] ar = { 50, 25, 30, 11, 12, 13, 7, 75, 90, 110, 70 };
		t.init(ar);
		t.delete(110);
		int[] actuals = { 7, 11, 12, 13, 25, 30, 50, 70, 75, 90 };
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// Узел с одним правым потомком-листом

	@Test
	public void testDel_NodeRightLeaf()
	{
		int[] ar = { 50, 25, 30, 11, 12, 13, 7, 75, 90, 110, 70 };
		t.init(ar);
		t.delete(90);
		int[] actuals = { 7, 11, 12, 13, 25, 30, 50, 70, 75, 110 };
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// Узел с одним левым потомком-листом

	@Test
	public void testDel_NodeLeftLeaf()
	{
		int[] ar = { 50, 25, 30, 11, 12, 13, 7, 75, 90, 110, 70, 60 };
		t.init(ar);
		t.delete(70);
		int[] actuals = { 7, 11, 12, 13, 25, 30, 50, 60, 75, 90, 110 };
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// Узел с одним левым потомком-листом

	@Test
	public void testDel_NodeLeft_RLeaf()
	{
		int[] ar = { 50, 25, 30, 11, 12, 13, 7, 75, 90, 110, 70, 60 };
		t.init(ar);
		t.delete(12);
		int[] actuals = { 7, 11, 13, 25, 30, 50, 60, 70, 75, 90, 110 };
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// Узел с одним левым потомком-листом
	@Test
	public void testDel_NodeLeft_LLeaf()
	{
		int[] ar = { 50, 25, 30, 11, 12, 13, 7, 75, 90, 110, 70, 60, 6 };
		t.init(ar);
		t.delete(6);
		int[] actuals = { 7, 11, 12, 13, 25, 30, 50, 60, 70, 75, 90, 110 };
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// Узел с правым и левым потомком-листом
	@Test
	public void testDel_NodeLeft_Leaf()
	{
		int[] ar = { 50, 25, 30, 11, 12, 13, 7, 75, 90, 110, 70, 60, 6 };
		t.init(ar);
		t.delete(80);
		int[] actuals = { 6, 7, 11, 12, 13, 25, 30, 50, 60, 70, 75, 90, 110 };
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// Удаление вершины, если один узел без потомков
	@Test(expected = NullPointerException.class)
	public void testDel_RootWithoutChild()
	{
		int[] ar = { 50 };
		t.init(ar);
		t.delete(50);
		int[] actuals = null;
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// Удаление вершины c левым потомком
	@Test
	public void testDel_RootWithLeftChild()
	{
		int[] ar = { 50, 25 };
		t.init(ar);
		t.delete(50);
		int[] actuals = { 25 };
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// Удаление вершины c правым потомком
	@Test
	public void testDel_RootWithRightChild()
	{
		int[] ar = { 50, 75 };
		t.init(ar);
		t.delete(50);
		int[] actuals = { 75 };
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// Удаление вершины c правым потомком (Доработать)
	@Ignore
	@Test
	public void testDel_RootWithChildren()
	{
		int[] ar = { 50, 75, 25 };
		t.init(ar);
		t.delete(50);
		int[] actuals = { 25, 75 };
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// Удаление вершины c правым потомком (Доработать)
	@Ignore
	@Test
	public void testDel_RootWithRTree()
	{
		int[] ar = { 50, 75, 60, 80 };
		t.init(ar);
		t.delete(50);
		int[] actuals = { 60, 75, 80 };
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// Удаление вершины c левым деревом (Доработать)
	@Ignore
	@Test
	public void testDel_RootWithLTree()
	{
		int[] ar = { 50, 25, 20, 30 };
		t.init(ar);
		t.delete(50);
		int[] actuals = { 20, 25, 30 };
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// Удаление вершины c правым и левым деревом (Доработать)
	// Проверка черех equals
	@Ignore
	@Test
	public void testDel_RootWithLRTree()
	{
		int[] ar = { 50, 25, 30, 11, 12, 13, 7, 75, 90, 110, 70, 60, 6, 80 };
		t.init(ar);
		t.delete(50);
		int[] actuals = { 30, 25, 11, 12, 13, 7, 75, 90, 110, 70, 60, 6, 80 };
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// Удаление узла с 2-мя деревьями слева
	@Test
	public void testDel_NodeWithLRTrees()
	{
		int[] ar = { 50, 25, 30, 11, 12, 13, 7, 75, 90, 110, 70, 60, 6, 80 };
		t.init(ar);
		t.delete(25);
		int[] actuals = { 7, 11, 12, 13, 25, 30, 50, 70, 75, 90, 110 };
		int[] expecteds = t.toArray();
		assertArrayEquals(expecteds, actuals);
	}

	// Итератор

	@Test
	public void testDel_TreeIter()
	{
		int[] ar = { 50, 25, 30, 11, 12, 13, 7, 75, 90, 110, 70 };
		t.init(ar);
		int[] actuals = new int[ar.length];
		int[] expecteds = t.toArray();
		int ind = 0;

		for (int i : expecteds)
		{
			actuals[ind++] = i;
		}

		assertArrayEquals(expecteds, actuals);
	}
}
