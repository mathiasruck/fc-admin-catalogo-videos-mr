package com.mathiasruck.admin.catalogo.domain;

public class AggreateRoot<ID extends Identifier> extends Entity<ID> {

    protected AggreateRoot(final ID id) {
        super(id);
    }
}
