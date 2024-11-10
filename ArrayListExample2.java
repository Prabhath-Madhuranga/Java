import java.util.ArrayList;

public class ArrayListExample2 {
    public static void main(String[] args) {
        
        ArrayList<Person> personList = new ArrayList<>();

        
        Person person1 = new Person("John", 25);
        Person person2 = new Person("Alice", 30);
        Person person3 = new Person("Bob", 35);

        
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        
        Person retrievedPerson = personList.get(1);
        System.out.println("Person at index 1: " + retrievedPerson.getName() + ", " + retrievedPerson.getAge());

        Person newPerson = new Person("Mike", 40);
        personList.set(1, newPerson);
        System.out.println("Modified person at index 1: " + personList.get(1).getName() + ", " + personList.get(1).getAge());

        int size = personList.size();
        System.out.println("Size of the ArrayList: " + size);

       
        personList.remove(0);
        System.out.println("Size after removing an object: " + personList.size());

		
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i).getName() + ", " + personList.get(i).getAge());
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
