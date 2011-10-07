package com.dealer.guava.equalshashcode;

import static com.google.common.base.Objects.*;

import java.util.Date;

import com.google.common.base.Objects;

/**
 * An improved version of our {@link Before} class using Guava
 * 
 * @author Will Taylor
 *
 */
public class After {

    private String firstName;
    private String lastName;
    private Date birthday;

    public After(String firstName, String lastName, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(firstName, lastName, birthday);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        
        if ( this == obj ) {
            result = true;
        } else if ( obj instanceof After ) {
            After that = (After) obj;
            
            result = equal(this.firstName, that.getFirstName()) &&
                     equal(this.lastName, that.getLastName()) &&
                     equal(this.birthday, that.getBirthday());
        }
        
        return result;
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                      .add("firstName", firstName)
                      .add("lastName", lastName)
                      .add("birthday", birthday)
                      .toString();
    }

}
