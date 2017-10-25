package com.playtika.automation.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersonStats {
    private static final Logger LOG
            = LoggerFactory.getLogger(PersonStats.class);
    public static void main(String[] args) throws IOException {

        List<Person> personsList = Arrays.asList(
                new Person("Dave", 34, "Kiev"),
                new Person("Dave", 32, "Kiev"),
                new Person("Dave1", 32, "Malin"),
                new Person("Dave4", 31, "Malin"),
                new Person("Dave5", 35, "Malin"),
                new Person("Dave", 32, "Kiev"),
                new Person("Dave6", 32, "Kiev"),
                new Person("Dave7", 17, "Malin"),
                new Person("Ivan", 10, "Oslo"),
                new Person("Sem", 37, "Oslo")
        );


        PeopleStatistics action = new PeopleStatistics(personsList);
        PeopleStatistics forEmptyList = new PeopleStatistics(Collections.EMPTY_LIST);

        LOG.info(String.valueOf(action.statisticsAveragePeopleAgePerCity()));
        LOG.info(String.valueOf(action.amountOfDaveNamedPersons()));
        LOG.info(action.cityWithMaxPeople());
        LOG.info(String.valueOf(action.oldestPerson().getAge()));
        LOG.info(String.valueOf(action.peopleAvarageAge()));
        LOG.info(String.valueOf(action.statisticsPeopleAgeCount()));
    }
}
