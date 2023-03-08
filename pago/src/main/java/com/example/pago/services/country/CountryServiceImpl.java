package com.example.pago.services.country;

import com.example.pago.domains.dto.models.seed.CountrySeedDto;
import com.example.pago.domains.entities.Country;
import com.example.pago.repositories.CountryRepository;
import com.example.pago.utils.validation.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static com.example.pago.constant.filePaths.COUNTRIES_JSON_FILE;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.countryRepository = countryRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void dbImport() throws IOException {
        if (!dbExists()) {
            Arrays.stream(gson.fromJson(readFileContent(), CountrySeedDto[].class))
                    .filter(validationUtil::isValid)
                    .map(countrySeedDto -> modelMapper.map(countrySeedDto, Country.class))
                    .forEach(countryRepository::saveAndFlush);
        }
    }

    @Override
    public boolean dbExists() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readFileContent() throws IOException {
        return Files.readString(Path.of(COUNTRIES_JSON_FILE));
    }
}
