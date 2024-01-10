package com.example;

public class Person {

    private int id;
    private String fullName;
    public Person(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {

        Person p= (Person) obj;
        return this.getId() == p.getId() && this.getFullName().equals(p.getFullName());
    }

    public String getFullName() {
        return fullName;
    }
}
