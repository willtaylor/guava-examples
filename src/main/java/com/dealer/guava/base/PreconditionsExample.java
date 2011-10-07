package com.dealer.guava.base;

import static com.google.common.base.Preconditions.*;

import java.util.Date;

public class PreconditionsExample {

    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthday;
    
    public PreconditionsExample(String firstName, String middleName, String lastName, Date birthday) {
        // no error message
        this.firstName = checkNotNull(firstName);
        // simple error message
        this.lastName = checkNotNull(lastName, "lastName");
        // parameterized error message
        this.birthday = checkNotNull(birthday, "birthday: %s", birthday);
    }
    
}
