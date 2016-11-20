package HTable;


public class Person
{
	int id;
	String fName;
	String lName;
	int age;
	
	public Person(){}
	
	public Person(int id, String fName, String lName, int age)
	{
		init(id, fName, lName, age);
	}
	
	public void init(int id, String fName, String lName, int age) 
	{
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}
	
	@Override
	public String toString() 
	{
		return "Person [id=" + id + ", fName=" + fName + ", lName=" + lName + ", age=" + age + "]";
	}

	@Override
	public int hashCode()
	{
		return hCode(fName, lName);
//		return super.hashCode();
	}
	
	public static int hCode(String fName, String lName)
	{
		int ret = 0;
		
		for (int i = 0; i < fName.length(); i++)
		{
			ret += fName.charAt(i);
		}
		for(int i = 0; i < lName.length(); i++)
		{
			ret += lName.charAt(i);
		}
		
		return ret;
	}
}