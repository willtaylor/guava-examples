package com.dealer.guava.base;

import java.util.Date;

import org.junit.Test;


public class PreconditionsTest {

    @Test
    public void middleNameCanBeNull() {
        new PreconditionsExample("Will", null, "Taylor", new Date());
    }
    
    @Test(expected=NullPointerException.class)
    public void firstNameCannotBeNull() {
        try {
            new PreconditionsExample(null, null, "Taylor", new Date());
        } catch ( NullPointerException e ) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    @Test(expected=NullPointerException.class)
    public void lastNameCannotBeNull() {
        try {
            new PreconditionsExample("Will", null, null, new Date());
        } catch ( NullPointerException e ) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    @Test(expected=NullPointerException.class)
    public void birthdayCannotBeNull() {
        try {
            new PreconditionsExample("Will", null, "Taylor", null);
        } catch ( NullPointerException e ) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
