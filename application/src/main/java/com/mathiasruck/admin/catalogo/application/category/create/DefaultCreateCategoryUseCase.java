package com.mathiasruck.admin.catalogo.application.category.create;

import java.util.Objects;

import com.mathiasruck.admin.catalogo.domain.category.Category;
import com.mathiasruck.admin.catalogo.domain.category.CategoryGateway;
import com.mathiasruck.admin.catalogo.domain.validation.handler.ThrowValidationHandler;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase {

    private final CategoryGateway categoryGateway;

    public DefaultCreateCategoryUseCase(final CategoryGateway aCategoryGateway) {
        this.categoryGateway = Objects.requireNonNull(aCategoryGateway);
    }

    @Override
    public CreateCategoryOutput execute(final CreateCategoryCommand aCommand) {
        final var aCategory = Category.newCategory(aCommand.name(), aCommand.description(), aCommand.isActive());
        aCategory.validate(new ThrowValidationHandler());

        return CreateCategoryOutput.from(this.categoryGateway.create(aCategory));
    }
}
