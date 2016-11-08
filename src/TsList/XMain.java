package TsList;
public class XMain
{
	public static void main(String[] args)
	{
		int[] ar = { 50, 11, 24, 15, 30, 55, 60, 65};

		TrTree tr = new TrTree();

		tr.init(ar);
		
		System.out.println(tr.size());

		System.out.println();
		System.out.println(tr.toString());
		
	}
}
