package com.mathiasruck.admin.catalogo.application;

import com.mathiasruck.admin.catalogo.domain.category.Category;

public class UseCase {
    public Category execute() {
        return Category.newCategory("name", "description", true);
    }
}