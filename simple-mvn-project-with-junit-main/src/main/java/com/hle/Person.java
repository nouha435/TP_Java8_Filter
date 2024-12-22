package com.hle;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person implements Comparable<Person> { // Ajoutez l'implémentation de Comparable
    private String firstName;
    private String familyName;
    private LocalDate birthDate;
    private String adress;

    

    public int calculateAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    @Override
    public int compareTo(Person other) {
        // Comparer par nom de famille
        int lastNameComparison = this.familyName.compareTo(other.familyName);

        // Si les noms de famille sont différents, retourner le résultat de la comparaison
        if (lastNameComparison != 0) {
            return lastNameComparison;
        } else {
            // Si les noms de famille sont égaux, comparer par prénom
            return this.firstName.compareTo(other.firstName);
        }
    }
}


    


