package com.example.validation.constraints.annotations;


import com.example.validation.constraints.EmailWhitelistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Target: 어디에 붙일 수 있는지
@Target(ElementType.FIELD)
// Retention: 언제까지 어노테이션이 남아있는지
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailWhitelistValidator.class)
public @interface EmailWhitelist {
    String message() default "Email not in whitelist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
