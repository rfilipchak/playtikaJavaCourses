package com.playtika.automation.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class PeopleStatistics {
    private static final Logger LOG
            = LoggerFactory.getLogger(PeopleStatistics.class);

    private final List<Person> people;

    public PeopleStatistics(List<Person> people) {
        if (people.isEmpty()){
            LOG.error("Can't count Statistics for empty list",
                    new IllegalArgumentException());
        }
        this.people = people;
    }

    public double peopleAvarageAge() {
        return people.stream()
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0);
    }

    public Person oldestPerson() {
        return people.stream()
                .max(Comparator.comparing(Person::getAge))
                .orElseThrow(() -> new IllegalArgumentException("Can't  count oldest for empty list"));
    }

    public long amountOfDaveNamedPersons() {
        return people.stream()
                .filter(person -> person.getName().equals("Dave"))
                .count();
    }

    public Map<Integer, Long> statisticsPeopleAgeCount() {
        return people.stream()
                .collect(Collectors.groupingBy(Person::getAge, counting()));
    }

    public String cityWithMaxPeople() {
        return people.stream().map(Person::getCity)
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey();
    }

    public Map<String, Double> statisticsAveragePeopleAgePerCity() {
        return people.stream().filter(p -> p.getAge() >= 18)
                .collect(groupingBy(Person::getCity,
                        averagingInt(Person::getAge)));
    }

}
