package com.juniorbarros.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Person extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String cpf;
    private String name;
    private String phone;

    public Person(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person)obj;
            EqualsBuilder builder = new EqualsBuilder();
            builder.append(getCpf(), person.getCpf());
            return builder.build();
        }
        return false;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = baseIdHashCodeBuilder();
        builder.append(cpf);
        return builder.build();
    }

}