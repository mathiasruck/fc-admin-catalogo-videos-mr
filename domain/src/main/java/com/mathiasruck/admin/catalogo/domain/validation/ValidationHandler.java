package com.mathiasruck.admin.catalogo.domain.validation;

import java.util.List;

public interface ValidationHandler {

    ValidationHandler append(Error anError);
    ValidationHandler append(ValidationHandler aValidationHandler);
    ValidationHandler validate(Validation aValidation);

    default boolean hasErrors() {
        return  getErrors() != null && !getErrors().isEmpty();
    }

    List<Error> getErrors();

    interface Validation {
        void validate();
    }
}
