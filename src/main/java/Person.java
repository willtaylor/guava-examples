import static com.google.common.base.Objects.*;
import static com.google.common.base.Preconditions.*;

import java.io.Serializable;
import java.util.Date;

import com.google.common.base.Objects;


/**
 * Shamelessly lifted from Ted Neward's NFJS talk "Busy Java Developer's Guide to Guava"
 * https://bitbucket.org/TedNeward/demos/src/2956e3232a33/NFJS2011/MinneapolisSpring/Guava/Person.java
 *
 * @author Will Taylor
 *
 */
public final class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String firstName;
    private final String lastName;
    private final long birthday;
    private final String employer;
    private Integer hashCode = null;

    public Person(final String firstName, final String lastName, final Date birthday, final String employer) {
        this.firstName = checkNotNull(firstName, "firstName cannot be null");
        this.lastName = checkNotNull(lastName, "lastName cannot be null");
        this.birthday = checkNotNull(birthday, "birthday cannot be null").getTime();
        this.employer = employer;
    }

    @Override
    public boolean equals(final Object obj) {
        boolean result = false;
        
        if ( this == obj ) {
            result = true;
        } else {
            if ( obj instanceof Person ) {
                final Person that = (Person) obj;
                
                result = equal(this.firstName, that.getFirstName()) &&
                         equal(this.lastName, that.getLastName()) &&
                         equal(this.birthday, that.getBirthday().getTime()) &&
                         equal(this.employer, that.getEmployer());
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return toStringHelper(this).add("firstName", firstName)
                                  .add("lastName", lastName)
                                  .add("birthday", birthday)
                                  .add("employer", employer)
                                  .toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthday() {
        return new Date(birthday);
    }

    public String getEmployer() {
        return employer;
    }

    @Override
    public int hashCode() {
        if ( hashCode == null ) {
            hashCode = Objects.hashCode(firstName, lastName, birthday, employer);
        }

        return hashCode;
    }

}
