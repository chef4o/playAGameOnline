package com.example.pago.domains.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="avatars")
public class Avatar extends BaseEntity {
    private byte[] file;

    public Avatar() {
    }

    @Lob()
    @Column(columnDefinition="BLOB")
    public byte[] getFile() {
        return file;
    }

    public Avatar setFile(byte[] file) {
        this.file = file;
        return this;
    }
}
