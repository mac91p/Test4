package zad4.model;

public class Person {

    private String firstName;
    private String lastName;
    private String city;
    private int age;

    public Person(String firstName, String lasyName, String city, int age) {
        this.firstName = firstName;
        this.lastName = lasyName;
        this.city = city;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lasyName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}
