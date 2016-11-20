package HTable;


public class HashTable {
    final int n = 197;
    Person[] pp = new Person[n];

    public void clear() {

        pp = new Person[n];
    }

    public int size() {
        int ret = 0;

        for (int i = 0; i < pp.length; i++) {
            if (pp[i] != null) {
                ret++;
            }
        }

        return ret;
    }

    public void add(Person p) {
        int i = p.hashCode() % n;
        while (i < 197 && pp[i] != null) {
            i++;
        }
        pp[i] = p;
    }

    public Person get(int code) {
        Person p = null;

        int i = code % 197;
        while (i < 197 && pp[i] != null && pp[i].hashCode() != code) {
            i++;
        }
        return pp[i];
    }
}
