package com.mathiasruck.admin.catalogo.domain.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;


public class CategoryTest {

        @Test
        public void givenAValidParams_whenCallNewCategory_thenInstantiateACategory() {
            final var expectedName = "Filmes";
            final var expectedDescription = "A categoria mais assistida";
            final var expectedIsActive = true;
            final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

            assertNotNull(actualCategory);
            assertNotNull(actualCategory.getId());
            assertEquals(expectedName, actualCategory.getName());
            assertEquals(expectedDescription, actualCategory.getDescription());
            assertEquals(expectedIsActive, actualCategory.isActive());
            assertNotNull(actualCategory.getCreatedAt());
            assertNotNull(actualCategory.getUpdatedAt());
            assertNull(actualCategory.getDeletedAt());
        }
}
