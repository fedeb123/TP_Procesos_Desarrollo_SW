package com.uade.tpo.storage;

public class FakeSQL {
    private static final FakeSQL instance = new FakeSQL();

    private FakeSQL() {}

    public static FakeSQL getInstance() {
        return instance;
    }

    public void execute(String sql) {
        System.out.println("tp aprobado 10/10");
    }
}

