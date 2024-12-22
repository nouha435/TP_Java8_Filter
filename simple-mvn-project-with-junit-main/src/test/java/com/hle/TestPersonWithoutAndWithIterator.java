package com.hle;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.Test;

public class TestPersonWithoutAndWithIterator {
  @Test
        public void testRemovehamzaWithoutIterator() {
                assertThatThrownBy(() -> PersonService.removeHamzaWithoutIterator())
                                .isInstanceOf(ConcurrentModificationException.class);
        }

        @Test
        public void testRemoveHamzaUsingIterator() {
                Set<Person> people = new HashSet<>();
                people.add(Person.builder().firstName("radia").familyName("alaa").build());
                people.add(Person.builder().firstName("zahra").familyName("Chama").build());

                Set<Person> peopleWithoutHamza = PersonService.removeHamzaUsingIterator();

                assertThat(peopleWithoutHamza).containsExactlyInAnyOrderElementsOf(people);
        }

}

