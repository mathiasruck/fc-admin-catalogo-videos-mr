package com.mathiasruck.admin.catalogo.domain.category;

import static java.time.Instant.now;

import java.time.Instant;

import com.mathiasruck.admin.catalogo.domain.AggreateRoot;
import com.mathiasruck.admin.catalogo.domain.validation.ValidationHandler;

public class Category extends AggreateRoot<CategoryID> {
    private String name;
    private String description;
    private boolean isActive;

    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Category(CategoryID anId,
            final String aName,
            final String aDescription,
            final boolean isActive,
            final Instant aCreationDate,
            final Instant aUpdateDate,
            final Instant aDeleteDate
    ) {
        super(anId);
        this.name = aName;
        this.description = aDescription;
        this.isActive = isActive;
        this.createdAt = aCreationDate;
        this.updatedAt = aUpdateDate;
        this.deletedAt = aDeleteDate;
    }

    public static Category newCategory(final String aName, final String aDescription, final boolean isActive) {
        return new Category(
                CategoryID.unique(),
                aName,
                aDescription,
                isActive,
                now(),
                now(),
                isActive ? null : now()
        );
    }

    @Override
    public void validate(ValidationHandler handler) {
        new CategoryValidator(this, handler).validate();
    }

    public Category activate() {
        this.deletedAt = null;
        this.isActive = true;
        this.updatedAt = now().plusSeconds(5);
        return this;
    }

    public Category deactivate() {
        if (getDeletedAt() == null) {
            this.deletedAt = now().plusSeconds(1);
        }
        this.isActive = false;
        this.updatedAt = now().plusSeconds(1);
        return this;
    }



    public CategoryID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return isActive;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public Category update(final String aName, final String aDescription, final boolean isActive) {
        this.name = aName;
        this.description = aDescription;
        if(isActive){
            activate();
        }else {
            deactivate();
        }
        this.updatedAt = now();
        return this;


    }
}
