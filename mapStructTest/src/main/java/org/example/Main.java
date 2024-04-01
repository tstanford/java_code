package org.example;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstname("Tim");
        person.setSurname("Stanford");

        PersonMapper mapper = PersonMapper.instance;

        PersonRequest personRequest = mapper.personToPersonRequest(person);
    }
}