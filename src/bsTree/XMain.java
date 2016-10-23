package bsTree;

public class XMain
{

	public static void main(String[] args)
	{
		BSTree tree = new BSTree();

		int[] ar = { 5, 5, 6, 5, 6, 7, 9 };
		tree.init(ar);
		tree.print();
		System.out.println("size: " + tree.size());
	}

}
