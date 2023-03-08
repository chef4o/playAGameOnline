package com.example.pago.utils.validation;

public interface ValidationUtil {
    <E> boolean isValid(E entity);
    <T extends Enum<T>> boolean enumContains(Class<T> enumerator, String value);
}
