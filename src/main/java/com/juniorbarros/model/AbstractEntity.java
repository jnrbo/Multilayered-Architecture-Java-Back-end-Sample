package com.juniorbarros.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by juniorbarros on 24/08/2017.
 */

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    protected EqualsBuilder baseIdEqualsBuilder(AbstractEntity entity) {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(id, entity.getId());
        return builder;
    }

    protected HashCodeBuilder baseIdHashCodeBuilder() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(id);
        return builder;
    }

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();

    @Override
    public String toString() {
        return new ToStringBuilder(this).build();
    }
}