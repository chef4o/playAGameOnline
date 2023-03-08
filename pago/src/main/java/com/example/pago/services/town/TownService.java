package com.example.pago.services.town;

import com.example.pago.domains.entities.Town;
import com.example.pago.services.init.DatabaseInitService;

public interface TownService extends DatabaseInitService {
    Town getTownByName(String name);
}
