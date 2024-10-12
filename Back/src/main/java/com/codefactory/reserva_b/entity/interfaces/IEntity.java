package com.codefactory.reserva_b.entity.interfaces;

public interface IEntity {
    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    @Override
    String toString();
}
