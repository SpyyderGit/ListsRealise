package bsTree;

public class XMain
{

	public static void main(String[] args)
	{
		BsTree t = new BsTree();
		int[] ar = { 10, 5, 15, 22, 1, 6, 4 };
		t.init(ar);
		// t.add(7);
		t.reverse();
		// t.delete(4);

		// t.add(58);
		// System.out.println(t.height());
		System.out.println("\n" + t.toString());
		// System.out.println("\n" + t.leafs());
		//
		// t.toString();
	}
}
