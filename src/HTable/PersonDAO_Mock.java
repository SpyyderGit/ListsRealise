
package HTable;

import java.util.ArrayList;

public class PersonDAO_Mock {
    ArrayList<Person> pp = new ArrayList<>();

    public PersonDAO_Mock() {
        pp.add(new Person(1, "Vasia", "Pep", 11));
        pp.add(new Person(2, "Petya", "Kurkin", 145));
        pp.add(new Person(3, "Asya", "Petrova", 98));
        pp.add(new Person(4, "Gena", "Bukin", 15));
        pp.add(new Person(5, "Kolya", "Mukin", 65));
        pp.add(new Person(6, "Elya", "Kakiyan", 56));
        pp.add(new Person(7, "Ulya", "Jopan", 12));
        pp.add(new Person(8, "Astafiy", "Lastochkin", 89));

    }

    public ArrayList<Person> read() {
        return pp;
    }
}
