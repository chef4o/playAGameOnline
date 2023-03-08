package com.example.pago;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.pago.domains.entities")
public class PagoApplication {
    public static void main(String[] args) {
        SpringApplication.run(PagoApplication.class, args);
    }

}
