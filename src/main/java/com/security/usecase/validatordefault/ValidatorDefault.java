package com.security.usecase.validatordefault;

import com.security.domain.exception.PasswordException;

public interface ValidatorDefault {

    ValidatorDefaultResponse execute(final ValidatorDefaultRequest password) throws PasswordException;

}
