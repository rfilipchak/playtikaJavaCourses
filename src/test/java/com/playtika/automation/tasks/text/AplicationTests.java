package com.playtika.automation.tasks.text;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

public class AplicationTests {

    @DataProvider(name = "users")
    public Iterator<Object> allUsers() {

        return Arrays.<Object>asList("Petya", "Roman", "Vasil").iterator();
    }

    @Test(dataProvider = "users",
            invocationCount = 5,
            //expectedExceptions = {NullPointerException.class},
           // expectedExceptionsMessageRegExp = "IGNOGE",
            threadPoolSize = 3,
           // dependsOnGroups = "gorup Id",
            alwaysRun = false)

    public void throwsNothing(String user) {
        System.out.println(Thread.currentThread().getId() + ": " + user);
    }
}
