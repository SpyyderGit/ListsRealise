package lexicTree;

public class XLTree
{

	public static void main(String[] args)
	{
		LTree t = new LTree();
		t.add("abba");
		t.add("rek");
		t.add("abur");
		t.add("asbbrek");
		t.add("reresk");
		System.out.println(t.size());

		t.toList();
		t.del("abba");
		t.toList("a");
	}
}
