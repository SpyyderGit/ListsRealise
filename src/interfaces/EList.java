package interfaces;

import java.util.Arrays;

public interface EList
{
	public void clear();

	public void init(int[] ini);

	public int size();

	public int[] toArray();

	public void addStart(int val);

	public void addEnd(int val);

	public void addPos(int pos, int val);

	public void addStart(int arr[]);

	public void addEnd(int arr[]);

	public void addPos(int pos, int arr[]);

	public int delStart();

	public int delEnd();

	public int delPos(int pos);

	public int min();

	public int max();

	public int minInd();

	public int maxInd();

	public void set(int pos, int val);

	public int get(int val);

	public void reverse();

	public void halfRevers();

	public void sort();
}
