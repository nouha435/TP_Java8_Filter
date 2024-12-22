package com.hle;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {
      public static List<Person> filterByAddress(String address) {
        List<Person> mockPersonsDatabase = Arrays.asList(
                Person.builder().firstName("Alice").familyName("Doe").birthDate(LocalDate.of(1990, 5, 12))
                        .adress("123 Rue A").build(),
                Person.builder().firstName("Bob").familyName("Smith").birthDate(LocalDate.of(2005, 10, 15))
                        .adress("456 Rue B").build(),
                Person.builder().firstName("Charlie").familyName("Brown").birthDate(LocalDate.of(1985, 3, 9))
                        .adress("123 Rue A").build()
                    );

        Predicate<Person> hasAddress = person -> person.getAdress().equals(address);

        return mockPersonsDatabase.stream()
                .filter(hasAddress)
                .collect(Collectors.toList());
    }

    public static List<Person> filterAdults() {
        List<Person> mockPersonsDatabase = Arrays.asList(
                Person.builder().firstName("Alice").familyName("Doe").birthDate(LocalDate.of(1990, 5, 12))
                        .adress("123 Rue A").build(),
                Person.builder().firstName("Bob").familyName("Smith").birthDate(LocalDate.of(2005, 10, 15))
                        .adress("456 Rue B").build(),
                Person.builder().firstName("Charlie").familyName("Brown").birthDate(LocalDate.of(1985, 3, 9))
                        .adress("123 Rue A").build());

        Predicate<Person> isAdult = person -> person.calculateAge() >= 18;

        return mockPersonsDatabase.stream()
                .filter(isAdult)
                .collect(Collectors.toList());
    }
  public static Set<Person> removeHamzaWithoutIterator() {
        Set<Person> people = new HashSet<>();
        people.add(Person.builder().firstName("radia").familyName("alaa").build());
        people.add(Person.builder().firstName("abdellah").familyName("Hamza").build());
        people.add(Person.builder().firstName("zahra").familyName("Chama").build());

        for (Person person : people) {
            if (person.getFamilyName().equals("Hamza")) {
                people.remove(person); // Erreur ici
            }
        }
        return people;
    }

    public static Set<Person> removeHamzaUsingIterator() {
        Set<Person> people = new HashSet<>();
        people.add(Person.builder().firstName("radia").familyName("alaa").build());
        people.add(Person.builder().firstName("abdellah").familyName("Hamza").build());
        people.add(Person.builder().firstName("zahra").familyName("Chama").build());

        // Suppression avec iterator (sécurisé)
        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getFamilyName().equals("Hamza")) {
                iterator.remove(); // Suppression sécurisée
            }
        }
        return people;
    }

}


