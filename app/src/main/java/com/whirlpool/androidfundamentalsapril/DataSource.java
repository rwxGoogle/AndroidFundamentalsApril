package com.whirlpool.androidfundamentalsapril;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roxanan on 05,May,2020
 */
class DataSource {
    List<String> getCars() {
        List<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Porsche");
        cars.add("Dacia");
        cars.add("VW");
        cars.add("Audi");
        cars.add("Tesla");
        cars.add("Toyota");
        cars.add("Mini");
        cars.add("Lada");
        cars.add("Citroen");
        cars.add("Renault");
        cars.add("Ferarri");
        cars.add("Maseratti");
        cars.add("Alfa romeo");
        cars.add("Lambo");
        cars.add("Ford");
        cars.add("Dacia");

        return cars;
    }

    List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(6);
        numbers.add(6);
        numbers.add(6);
        numbers.add(6);
        numbers.add(6);
        numbers.add(6);
        numbers.add(6);
        numbers.add(6);
        numbers.add(6);
        numbers.add(6);
        numbers.add(6);
        numbers.add(6);
        numbers.add(6);
        numbers.add(6);
        numbers.add(6);
        return numbers;
    }

    List<Person> getPersons() {
        List<Person> numbers = new ArrayList<>();
        Person person = new Person();
        person.name = "Roxana";
        person.age = "28";

        Person personTwo = new Person();
        personTwo.name = "Ionut";
        personTwo.age = "15";

        return numbers;
    }
}
