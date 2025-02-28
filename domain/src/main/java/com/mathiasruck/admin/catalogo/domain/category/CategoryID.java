package com.mathiasruck.admin.catalogo.domain.category;

import java.util.Objects;
import java.util.UUID;

import com.mathiasruck.admin.catalogo.domain.Identifier;

public class CategoryID extends Identifier {
    protected final String value;

    private CategoryID(final String value) {
        Objects.requireNonNull(value, "'Value' should not be null");
        this.value = value;
    }

    public static CategoryID unique() {
        return CategoryID.from(java.util.UUID.randomUUID());
    }

    public static CategoryID from(final String anId) {
        return new CategoryID(anId);
    }

    public static CategoryID from(final UUID anId) {
        return new CategoryID(anId.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this ==o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CategoryID that = (CategoryID) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getValue());
    }
}
