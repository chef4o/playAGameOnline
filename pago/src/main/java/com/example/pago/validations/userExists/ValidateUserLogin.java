package com.example.pago.validations.userExists;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = UserLoginValidator.class)
public @interface ValidateUserLogin {
    String message() default "Username or Password is wrong.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
