package zad4.service;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import zad4.exception.NoWomenException;
import zad4.model.Person;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static junit.framework.TestCase.assertSame;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class PersonServiceTest1 {

    private List<Person> peopleList;
    private PersonService personService;


    @Before
    public void setUp() {
        personService = new PersonService();
        peopleList = new ArrayList<>();
        peopleList.add(new Person("Jan", "Kowalski", "Warszawa", 50));
        peopleList.add(new Person("Janina", "Buczek", "Warszawa", 30));
        peopleList.add(new Person("Marian", "Lasek", "Kraków", 18));
        peopleList.add(new Person("Marcin", "Puczyk", "Poznań", 78));
        peopleList.add(new Person("Agnieszka", "Waligóra", "Kraków", 27));
        peopleList.add(new Person("Anna", "Walczyk", null, 22));
        peopleList.add(null);
    }

    @Test
    public void shouldReturnJaninaBuczek() throws NoWomenException {
        Person oldestWoman = personService.getOldestWoman(peopleList);
        TestCase.assertEquals(oldestWoman,peopleList.get(1));
    }

    @Test
    public void shouldThrowNoWomanException() {
        try{
            personService.getOldestWoman(null);
        } catch (Exception e) {
            Assertions.assertThat(e)
                    .isExactlyInstanceOf(NoWomenException.class)
                    .hasMessage("No woman have been found")
                    .hasNoCause()
                    .hasFieldOrProperty("message");
        }
    }
}