package zad4.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import zad4.exception.NoWomenException;
import zad4.exception.WrongSexException;
import zad4.model.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class PersonServiceTest {

    private PersonService personService;
    private List<Person> peopleList;

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
        assertSame(peopleList.get(1), oldestWoman);
//        assertTrue(peopleList.get(1) == oldestWoman);
    }


    @Test
    public void shouldReturnAverageAgeOf37() {
        int result = personService.getAverageAge(peopleList);
        assertEquals(37, result, 0);
    }

    @Test
    public void shouldReturnAverageMensAgeOf48() {
        int result = personService.getMensAverageAge(peopleList);
        assertEquals(48, result, 0);
    }
    @Test
    public void shouldReturnAverageWomenAgeOf26() {
        int result = personService.getWomenAverageAge(peopleList);
        assertEquals(26, result, 0);
    }

    @Test
    public void shouldReturnAverageSexAgeOf26() {
        int result = personService.getSexAverageAge(peopleList, "woman");
        assertEquals(26, result, 0);
    }

    @Test
    public void shouldReturnWarsawAndCracow() {
        List<String> expectedCities = Arrays.asList(peopleList.get(0).getCity(), peopleList.get(2).getCity());
        List<String> resultCities = personService.getCitiesWithHighestPopulation(peopleList);
        assertEquals(expectedCities,resultCities);
    }

    @Test
    public void shouldReturnWarsawCracowAndPoznan() {
        List<String> expectedCities = Arrays.asList(peopleList.get(0).getCity(), peopleList.get(2).getCity(), peopleList.get(3).getCity());
        List<String> resultCities = personService.getUniqueCities(peopleList);
        assertEquals(expectedCities,resultCities);
    }

    @Test
    public void shouldThrowNoWomenException() {
        Exception e = assertThrows(NoWomenException.class, () -> personService.getOldestWoman(null));
        Assertions.assertThat(e)
                .isExactlyInstanceOf(NoWomenException.class)
                .hasMessage("No woman have been found")
                .hasNoCause()
                .hasFieldOrProperty("message");
    }

    @Test
    public void shouldThrowWrongProvidedSexException() {
        Exception e = assertThrows(WrongSexException.class, () -> personService.getSexAverageAge(peopleList, null));
        Assertions.assertThat(e)
                .isExactlyInstanceOf(WrongSexException.class)
                .hasMessage("Wrong or null provided sex")
                .hasNoCause()
                .hasFieldOrProperty("message");
    }


}