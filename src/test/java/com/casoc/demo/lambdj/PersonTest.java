package com.casoc.demo.lambdj;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static ch.lambdaj.Lambda.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PersonTest {

    private List<Person> persons;
    private Person ann;
    private Person ben;
    private Person dave;

    @Before
    public void setUp() {
        persons = new ArrayList<Person>();

        ann = new Person();
        ann.setId(1);
        ann.setName("Ann");
        ann.setAge(28);
        ann.setGender("female");
        persons.add(ann);

        ben = new Person();
        ben.setId(2);
        ben.setName("Ben");
        ben.setAge(35);
        ben.setGender("male");
        persons.add(ben);

        dave = new Person();
        dave.setId(3);
        dave.setName("Dave");
        dave.setAge(25);
        dave.setGender("male");
        persons.add(dave);
    }

    @Test
    public void shouldPrintEachPersonName() {
        forEach(persons).printName();
        //JDK8 same implement
        persons.forEach(System.out::println);
    }

    @Test
    public void shouldReturnPersonNameJoinWithSymbol() {
        //default symbol is ", "
        assertThat(joinFrom(persons).getName(), is("Ann, Ben, Dave"));
        assertThat(joinFrom(persons,"|").getName(), is("Ann|Ben|Dave"));
        //JDK8 same implement
        assertThat(persons.stream().map(person -> person.getName()).collect(Collectors.joining("|")), is("Ann|Ben|Dave"));
    }

    @Test
    public void shouldReturnPersonsListBySelect() {
        assertThat(select(persons, having(on(Person.class).getAge(), greaterThan(33))), is(Lists.newArrayList(ben)));
        assertThat(select(persons, having(on(Person.class).getGender(), equalTo("male"))), is(Lists.newArrayList(ben, dave)));
        //JDK8 same implement
        assertThat(persons.stream().filter(person -> person.getAge() > 33)
                .collect(Collectors.toList()), is(Lists.newArrayList(ben)));
        assertThat(persons.stream().filter(person -> person.getGender().equals("male"))
                .collect(Collectors.toList()), is(Lists.newArrayList(ben, dave)));
    }

    @Test
    public void shouldReturnMaxAgePerson() {
        assertThat(selectMax(persons, on(Person.class).getAge()), is(ben));
    }

    @Test
    public void shouldReturnMaxAge() {
        assertThat(max(persons, on(Person.class).getAge()), is(35));
        assertThat(maxFrom(persons).getAge(), is(35));
    }

    @Test
    public void shouldReturnSumAgeOfAllPersons() {
        assertThat(sumFrom(persons).getAge(), is(88));
        assertThat(sum(persons, on(Person.class).getAge()), is(88));
        //JDK8 same implement
        assertThat(persons.stream().map(person -> person.getAge())
                .reduce((sum, age) -> sum + age).get(), is(88));
    }

    @Test
    public void shouldSortPersonsByAgeFromYoungToOld() {
        ArrayList<Person> sortList = Lists.newArrayList(persons);
        Collections.sort(sortList, (person1, person2) -> person1.getAge() - person2.getAge());
        assertThat(sort(persons, on(Person.class).getAge()), is(sortList));
    }

    @Test
    public void shouldReturnAgeList() {
        assertThat(extract(persons, on(Person.class).getAge()), is(Lists.newArrayList(28, 35, 25)));
        //JDK8 same implement
        assertThat(persons.stream().map(person -> person.getAge()).collect(Collectors.toList()),
                is(Lists.newArrayList(28, 35, 25)));
    }

    @Test
    public void shouldGroupByGender() {
        HashMap<String, Person> genderGroup = Maps.newHashMap();
        persons.forEach(person -> genderGroup.put(person.getGender(), person));
        assertThat(index(persons, on(Person.class).getGender()), is(genderGroup));
    }
}