package com.mathiasruck.admin.catalogo.domain.validation.handler;

import java.util.List;

import com.mathiasruck.admin.catalogo.domain.exceptions.DomainException;
import com.mathiasruck.admin.catalogo.domain.validation.Error;
import com.mathiasruck.admin.catalogo.domain.validation.ValidationHandler;

public class ThrowValidationHandler implements ValidationHandler {

    @Override
    public ValidationHandler append(final Error anError) {
        throw DomainException.with(anError);
    }

    @Override
    public ValidationHandler append(final ValidationHandler aValidationHandler) {
        throw DomainException.with(aValidationHandler.getErrors());
    }

    @Override
    public ValidationHandler validate(final Validation aValidation) {
        try {
            aValidation.validate();
        } catch (DomainException e) {
            throw e;
        } catch (final Exception e) {
            throw DomainException.with(new Error(e.getMessage()));
        }
        return this;
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }
}
