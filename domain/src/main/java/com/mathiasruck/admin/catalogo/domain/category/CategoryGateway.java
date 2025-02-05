package com.mathiasruck.admin.catalogo.domain.category;

import java.util.Optional;

import com.mathiasruck.admin.catalogo.domain.pagination.Pagination;

public interface CategoryGateway {

    Category create(Category aCategory);

    void deleteById(CategoryID anId);

    Optional<Category> findById(CategoryID anId);

    Category update(Category aCategory);

    Pagination<Category> findAll(CategorySearchQuery aQuery);


}
