import static com.google.common.base.Predicates.*;
import static com.google.common.collect.Iterables.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;


/**
 * Shamelessly lifted from Ted Neward's NFJS talk "Busy Java Developer's Guide to Guava"
 * https://bitbucket.org/TedNeward/demos/src/2956e3232a33/NFJS2011/MinneapolisSpring/Guava/App.java
 *
 * @author Will Taylor
 *
 */
public class App {

    public static void main(String ... args) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        ImmutableList<Person> people = ImmutableList.of(new Person("Will", "Taylor", df.parse("1979-03-27"), "DDC"),
                                                        new Person("Jesse", "Kowalewitz", df.parse("1983-01-12"), "DDC"),
                                                        new Person("Eric", "Mayhew", df.parse("1910-09-09"), "DDC"),
                                                        new Person("Kevin", "Bourrillion", df.parse("1970-09-09"), "Google"),
                                                        new Person("John", "Doe", df.parse("1980-01-01"), null),
                                                        new Person("Jane", "Intern", df.parse("1993-05-05"), "DDC"));

        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.YEAR, -21);

        final Date magicBirthday = calendar.getTime();

        System.out.println("The old, boring way:");
        for ( Person person : people ) {
            if ( person != null && "DDC".equals(person.getEmployer()) &&
                 (magicBirthday.equals(person.getBirthday()) || magicBirthday.after(person.getBirthday())) ) {
                System.out.println(String.format("%s, have a beer!", person.getFirstName()));
            }
        }

        Predicate<Person> isEarthling = new Predicate<Person>() {
            @Override
            public boolean apply(Person person) {
                return "DDC".equals(person.getEmployer());
            }
        };

        Predicate<Person> isLegalAge = new Predicate<Person>() {
            @Override
            public boolean apply(Person person) {
                return magicBirthday.equals(person.getBirthday()) || magicBirthday.after(person.getBirthday());
            }
        };

        System.out.println("\nThe new hotness:");
        for ( Person person : filter(people, and(notNull(), isEarthling, isLegalAge)) ) {
            System.out.println(String.format("%s, have a beer!", person.getFirstName()));
        }
    }

}
