package com.mathiasruck.admin.catalogo.application.category.create;

import com.mathiasruck.admin.catalogo.domain.category.Category;
import com.mathiasruck.admin.catalogo.domain.category.CategoryID;

public record CreateCategoryOutput(
        CategoryID id
) {
    public static CreateCategoryOutput from(Category aCategory) {
        return new CreateCategoryOutput(aCategory.getId());
    }

}
