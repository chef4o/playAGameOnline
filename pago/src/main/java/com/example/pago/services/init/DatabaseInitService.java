package com.example.pago.services.init;

import java.io.IOException;

public interface DatabaseInitService {
    void dbImport() throws IOException;
    boolean dbExists();
    String readFileContent() throws IOException;
}
