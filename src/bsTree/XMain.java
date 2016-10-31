package bsTree;

public class XMain
{

	public static void main(String[] args)
	{
		BsTree t = new BsTree();
		// int[] ar = { 50, 25, 30, 11, 7, 12, 75, 90, 110, 13 };
		int[] ar = { 50, 25, 75 };
		t.init(ar);
		// t.add(7);
		// t.reverse();
		t.delete(50);

		// System.out.println(t.test(25).val);

		// t.add(38);
		// System.out.println(t.width());
		System.out.println("\n" + t.toString());
		// System.out.println("\n" + t.leafs());
		//
		// t.toString();
	}
}
