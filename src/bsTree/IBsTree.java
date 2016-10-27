package bsTree;

public interface IBsTree
{
	void clear();

	void add(int val);

	void init(int[] ini);

	int size();

	int[] toArray();

	String toString();

	int nodes();

	int leaves();

	int height();

	int[] width();

	void reverse();

	void delete(int p);
}
