package HTable;

import java.util.List;

public class PMain {
    public static void main(String[] args) {
        PersonDAO_Mock pd = new PersonDAO_Mock();
        List<Person> pp = pd.read();
        HashTable ht = new HashTable();

        System.out.println(pp.size());

        for (Person p : pp) {
            ht.add(p);
        }

        System.out.println(ht.size());

        int code = Person.hCode("Vasy", " de");
        Person p = ht.get(code);
        System.out.println(p);
    }
}
