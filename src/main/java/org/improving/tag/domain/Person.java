package org.improving.tag.domain;

import java.util.Date;
import java.util.Scanner;

public class Person {
    private String name;
    private String dateOfBirth;
    private String address;
    private String city;
    private String state;
    private Integer zip;

    public Person() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        this.name = scanner.nextLine();
        System.out.print("Please enter your date of birth: ");
        this.dateOfBirth = scanner.nextLine();
        System.out.print("Please enter your city: ");
        this.city = scanner.nextLine();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Integer getZip() {
        return zip;
    }
}
