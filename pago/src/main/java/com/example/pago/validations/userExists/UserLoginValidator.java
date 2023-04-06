package com.example.pago.validations.userExists;

import com.example.pago.domains.dto.bindings.UserLoginDto;
import com.example.pago.domains.dto.models.UserDto;
import com.example.pago.services.user.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UserLoginValidator implements ConstraintValidator<ValidateUserLogin, UserLoginDto> {
    private final UserService userService;

    @Autowired
    public UserLoginValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(ValidateUserLogin constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginDto userLoginDto, ConstraintValidatorContext constraintValidatorContext) {
        UserDto current = this.userService.getUser(userLoginDto);

        return current.exists()
                && current.getPassword().equals(userLoginDto.getPassword());
    }
}
