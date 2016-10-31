package bsTree;

public class XMain
{

	public static void main(String[] args)
	{
		BsTree t = new BsTree();
		int[] ar = { 50, 25, 30, 11, 12, 13, 7, 75, 90, 110, 70 };
		t.init(ar);
		// t.add(7);
		// t.reverse();
		t.delete(110);

		// System.out.println(t.test(25).val);

		// t.add(58);
		// System.out.println(t.width());
		System.out.println("\n" + t.toString());
		// System.out.println("\n" + t.leafs());
		//
		// t.toString();
	}
}
