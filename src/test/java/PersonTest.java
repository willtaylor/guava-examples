import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;


public class PersonTest {

    @Test
    public void newInstanceCorrectlyCreated() {
        Date date = new Date();
        Person person = new Person("firstName", "lastName", date, "employer");
        assertThat(person.getFirstName(), is(equalTo("firstName")));
        assertThat(person.getLastName(), is(equalTo("lastName")));
        assertThat(person.getBirthday(), is(equalTo(date)));
        assertThat(person.getEmployer(), is(equalTo("employer")));
    }

    @Test(expected=NullPointerException.class)
    public void nullFirstNameThrowsException() {
        try {
            new Person(null, "lastName", new Date(), "employer");
        } catch ( NullPointerException e ) {
            assertThat(e.getMessage(), is(equalTo("firstName cannot be null")));
            throw e;
        }
    }

    @Test(expected=NullPointerException.class)
    public void nullLastNameThrowsException() {
        try {
            new Person("firstName", null, new Date(), "employer");
        } catch ( NullPointerException e ) {
            assertThat(e.getMessage(), is(equalTo("lastName cannot be null")));
            throw e;
        }
    }

    @Test(expected=NullPointerException.class)
    public void nullBirthdayNameThrowsException() {
        try {
            new Person("firstName", "lastName", null, "employer");
        } catch ( NullPointerException e ) {
            assertThat(e.getMessage(), is(equalTo("birthday cannot be null")));
            throw e;
        }
    }

    @Test
    public void nullEmployerIsAllowed() {
        Date date = new Date();
        Person person = new Person("firstName", "lastName", date, null);
        assertThat(person.getFirstName(), is(equalTo("firstName")));
        assertThat(person.getLastName(), is(equalTo("lastName")));
        assertThat(person.getBirthday(), is(equalTo(date)));
        assertThat(person.getEmployer(), is(nullValue()));
    }

}
