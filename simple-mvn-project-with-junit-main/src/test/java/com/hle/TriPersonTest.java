package com.hle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class TriPersonTest {
     @Test
        public void testSortPerson() {
                List<Person> people = new ArrayList<>();
                people.add(Person.builder().firstName("Hala").familyName(" Jalal").build());
                people.add(Person.builder().firstName("Marwan").familyName("Badr").build());
                people.add(Person.builder().firstName("Hala").familyName("Chadi").build());
                people.add(Person.builder().firstName("Bilal").familyName("Chadi").build());

                // Tri de la liste de personnes
                Collections.sort(people);

                assertThat(people.get(0))
                                .isEqualTo(Person.builder().firstName("Marwan").familyName("Badr").build());
                assertThat(people.get(1))
                                .isEqualTo(Person.builder().firstName("Bilal").familyName("Chadi").build());
                assertThat(people.get(2))
                                .isEqualTo(Person.builder().firstName("Hala").familyName("Chadi").build());
                assertThat(people.get(3))
                                .isEqualTo(Person.builder().firstName("Hala").familyName("Jalal").build());

        }

}
