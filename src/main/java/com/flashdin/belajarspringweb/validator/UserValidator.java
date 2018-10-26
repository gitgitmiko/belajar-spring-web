package com.flashdin.belajarspringweb.validator;

import com.flashdin.belajarspringweb.entity.UserPass;
import com.flashdin.belajarspringweb.service.UserPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserPassService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserPass.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserPass userpass = (UserPass) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (userpass.getUsername().length() < 6 || userpass.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(userpass.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (userpass.getPassword().length() < 8 || userpass.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!userpass.getPasswordConfirm().equals(userpass.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}