package com.playtika.homeWorks.homeWork4;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PersonMain {
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
        //PeopleStatistics forEmptyList = new PeopleStatistics(Collections.EMPTY_LIST);

        System.out.println(action.statisticsAveragePeopleAgePerCity());
        System.out.println(action.amountOfDaveNamedPersons());
        System.out.println(action.cityWithMaxPeople());
        System.out.println(action.oldestPerson().getAge());
        System.out.println(action.peopleAvarageAge());
        System.out.println(action.statisticsPeopleAgeCount());
    }
}
