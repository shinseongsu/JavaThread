package com.example2.ch3;

/**
 *  final로 지정된 메소드 값을 변경할 수 없는 메소드
 */
public final class Person {
    private final String name;
    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return "[ Person: name = " + name + ", address = " + address + " ]";
    }
}
