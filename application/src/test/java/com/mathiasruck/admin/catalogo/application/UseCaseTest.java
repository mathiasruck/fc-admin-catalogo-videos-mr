package com.mathiasruck.admin.catalogo.application;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class UseCaseTest {

    @Test
    public void testCreateUseCase() {
       assertNotNull( new UseCase());
       assertNotNull( new UseCase().execute());
    }
}
