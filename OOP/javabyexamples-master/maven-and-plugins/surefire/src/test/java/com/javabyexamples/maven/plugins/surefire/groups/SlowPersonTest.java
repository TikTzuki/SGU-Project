package com.javabyexamples.maven.plugins.surefire.groups;

import com.javabyexamples.maven.plugins.surefire.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(SlowTest.class)
public class SlowPersonTest {

    private Person person = new Person();

    @Test
    public void run() {
        String result = person.runTenLaps();

        Assert.assertEquals("Running ten laps", result);
    }
}