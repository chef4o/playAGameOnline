package com.example.pago.validations.matchingPasswords;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

public class PasswordMatcher implements ConstraintValidator<PasswordMatch, Object> {

    private String password;
    private String rePass;
    private String message;

    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        this.password = constraintAnnotation.password();
        this.rePass = constraintAnnotation.rePass();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);

        Object passwordValue = beanWrapper.getPropertyValue(this.password);
        Object rePassValue = beanWrapper.getPropertyValue(this.rePass);

        if (passwordValue != null && passwordValue.equals(rePassValue)) {
            return true;
        }

        constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(this.rePass)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
