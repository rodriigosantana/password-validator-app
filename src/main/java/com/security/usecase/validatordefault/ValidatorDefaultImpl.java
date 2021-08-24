package com.security.usecase.validatordefault;

import com.security.domain.exception.PasswordException;

import javax.inject.Named;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Named
public class ValidatorDefaultImpl implements ValidatorDefault {

    private final int MINIMUM_SIZE = 9;
    private final String REGEX_NUMBER = "(?=[0-9])";
    private final String REGEX_CHARACTER_UPPERCASE = "(?=.*[A-Z])";
    private final String REGEX_CHARACTER_LOWERCASE = "(?=.*[a-z])";
    private final String REGEX_CHARACTER_SPECIAL = "(?=.*[!@#$%^&*()-+])";
    private final String REGEX_SPACE = "(?=\\S+$)";

    private final String MESSAGE_VALIDATION_NUMBER = "The password must contain at least one number.";
    private final String MESSAGE_VALIDATION_CHARACTER_UPPERCASE = "The password must contain at least one uppercase letter.";
    private final String MESSAGE_VALIDATION_CHARACTER_LOWERCASE = "The password must contain at least one lowercase letter.";
    private final String MESSAGE_VALIDATION_CHARACTER_SPECIAL = "The password must contain at least one special character.";
    private final String MESSAGE_VALIDATION_SPACE = "The password must not contain space.";
    private final String MESSAGE_VALIDATION_SIZE = "The password must contain at least #qtd-caracter# characters.";
    private final String MESSAGE_VALIDATION_REPEATED = "The password must not have repeated characters.";

    private String regex = new StringBuilder()
            .append("(?=.*[0-9])")
            .append("(?=.*[a-z])")
            .append("(?=.*[A-Z])")
            .append("(?=.*[!@#$%^&*()-+])")
            .append("(?=\\S+$)")
            .append(".{9,}")
            .toString();

    @Override
    public ValidatorDefaultResponse execute(final ValidatorDefaultRequest password) throws PasswordException {

        return ValidatorDefaultResponse.builder()
                .passwordIsValid(isFoundNumber(password) &&
                        isFoundCharacterUp(password) &&
                        isFoundCharacterLw(password) &&
                        isFoundCharacterSpecial(password) &&
                        isFoundCharacterSpace(password) &&
                        isFoundCharacterRepeated(password) &&
                        isCorrectSize(password)).build();

    }

    private boolean isFoundNumber(final ValidatorDefaultRequest password){

        return isFindRegex(password.getPassword(),
                REGEX_NUMBER,
                MESSAGE_VALIDATION_NUMBER);

    }

    private boolean isFoundCharacterUp(final ValidatorDefaultRequest password){

        return isFindRegex(password.getPassword(),
                REGEX_CHARACTER_UPPERCASE,
                MESSAGE_VALIDATION_CHARACTER_UPPERCASE);
    }

    private boolean isFoundCharacterLw(final ValidatorDefaultRequest password){

        return isFindRegex(password.getPassword(),
                REGEX_CHARACTER_LOWERCASE,
                MESSAGE_VALIDATION_CHARACTER_LOWERCASE);
    }

    private boolean isFoundCharacterSpecial(final ValidatorDefaultRequest password){

        return isFindRegex(password.getPassword(),
                REGEX_CHARACTER_SPECIAL,
                MESSAGE_VALIDATION_CHARACTER_SPECIAL);
    }

    private boolean isFoundCharacterSpace(final ValidatorDefaultRequest password){

        return isFindRegex(password.getPassword(),
                REGEX_SPACE,
                MESSAGE_VALIDATION_SPACE);
    }

    private boolean isFoundCharacterRepeated(final ValidatorDefaultRequest password){

        boolean result = true;

        int count = 0;
        for (int i = 0 ; i < (password.getPassword().length()-1); i++) {
            char find = password.getPassword().charAt(i);
            for (int j = i+1 ; j < password.getPassword().length(); j++) {
                if (password.getPassword().charAt(j) == find) count++;
            }
        }
        if (count > 0) result = false;

        if(result == false){
            throw new PasswordException(MESSAGE_VALIDATION_REPEATED);
        }

        return result;
    }

    private boolean isCorrectSize(final ValidatorDefaultRequest password){

        if(password.getPassword().length() < MINIMUM_SIZE){
            throw new PasswordException(MESSAGE_VALIDATION_SIZE.replace("#qtd-caracter#", ""+ MINIMUM_SIZE));
        }

        return true;
    }

    private boolean isFindRegex(String str,
                                String regex,
                                String mensageError){

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        boolean result = m.find();

        if(!result){
            throw new PasswordException(mensageError);
        }
        return result;

    }

}
