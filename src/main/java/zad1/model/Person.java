package zad1.model;


public class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


    @Override
    public int compareTo(Person o) {
        int result = firstName.compareTo(o.firstName);
        if(result == 0)
            result = lastName.compareTo(o.lastName);
        return result;
    }
}
