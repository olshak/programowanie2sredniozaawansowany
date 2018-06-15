package immutability;

import java.util.*;

// 1. Stwórz klasę Person (prosta klasa z 2 polami – name, surname). Dodaj w niej getery i setery do obu pól.
// Zaimplementuj metody hashCode i equals.

public class Person {
    private String name;
    private String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }


    public static void main(String[] args) {
        // Następnie stwórz Set zawierający pracowników. Dodawaj różnych pracowników do tego zbioru.
        Set<Person> persons = new HashSet<>();

        Person annaKowalska = new Person("Anna", "Kowalska");
        Person gabrielKonowal = new Person("Gabriel", "Konował");
        Person personNotInSet = new Person("Anna", "Kowalska");

        persons.add(annaKowalska);
        persons.add(gabrielKonowal);

        // Co się stanie jak zawołasz na zbiorze metodę contains podając pracownika, który ma identyczne dane jak
        // pracownik wcześniej dodany?
        System.out.println(persons.contains(personNotInSet));

        // 2. Dodaj do zbioru z poprzedniego zadania pracownika o imieniu Jan i nazwisku Kowalski. Następnie
        // korzystając z setera zmień mu nazwisko na Nowak. Co się dzieje jak zawołasz metodę contains podając tego
        // samego pracownika? Wypisz na ekran dane pracownika, który znajduje się w zbiorze. Co zauważasz?
        Person janKowalski = new Person("Jan", "Kowalski");
        persons.add(janKowalski);
        janKowalski.setSurname("Nowak");
        System.out.println(persons.contains(janKowalski));
        System.out.println(persons);
    }
}
