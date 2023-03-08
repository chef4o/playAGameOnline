package com.example.pago.utils.validation;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtilImpl implements ValidationUtil {
    private final Validator validation = Validation
            .buildDefaultValidatorFactory()
            .getValidator();
    @Override
    public <E> boolean isValid(E entity) {
        return validation.validate(entity).isEmpty();
    }

    @Override
    public <T extends Enum<T>> boolean enumContains(Class<T> enumerator, String value) {
        for (T c : enumerator.getEnumConstants()) {
            if (c.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
