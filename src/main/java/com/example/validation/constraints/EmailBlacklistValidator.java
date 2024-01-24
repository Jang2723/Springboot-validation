package com.example.validation.constraints;

import com.example.validation.constraints.annotations.EmailBlackList;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.Set;

public class EmailBlacklistValidator
        implements ConstraintValidator<EmailBlackList, String> {
    private Set<String> blacklist;

    @Override
    public void initialize(EmailBlackList annotation) {
        this.blacklist = new HashSet<>();
        for (String blocked : annotation.blacklist()){
            this.blacklist.add(blocked);
        }
    }

    @Override
    public boolean isValid(
            String value,
            ConstraintValidatorContext context
    ) {
        // value가 null인지 체크하고, (null이면 false)
        if (value == null) return false;
        // value에 @가 포함되어 있는지 확인하고 (아니면 false)
        if (!value.contains("@")) return false;
        // value를 @ 기준으로 자른 뒤, 제일 뒤가 'this.blacklist'에
        // 담긴 값이 아닌지 확인을 한다.
        String[] split = value.split("@");
        String domain = split[split.length - 1];
        return !blacklist.contains(domain);
    }
}
