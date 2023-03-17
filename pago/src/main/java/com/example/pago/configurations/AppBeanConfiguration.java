package com.example.pago.configurations;

import com.example.pago.domains.dto.beans.LoggedUser;
import com.example.pago.domains.dto.models.seed.CountrySeedDto;
import com.example.pago.domains.dto.models.seed.TownSeedDto;
import com.example.pago.domains.entities.Country;
import com.example.pago.domains.entities.Town;
import com.example.pago.domains.enums.Gender;
import com.example.pago.domains.enums.Role;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class AppBeanConfiguration {
    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    @SessionScope
    public LoggedUser loggedUser() {
        return new LoggedUser();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate
                        .parse(mappingContext.getSource(),
                                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
        });

        modelMapper.addConverter(new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(MappingContext<String, LocalDateTime> mappingContext) {
                return LocalDateTime
                        .parse(mappingContext.getSource(),
                                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            }
        });
        modelMapper.addConverter(new Converter<String, Gender>() {
            @Override
            public Gender convert(MappingContext<String, Gender> mappingContext) {
                return Gender.valueOf(mappingContext.getSource().toUpperCase());
            }
        });

        modelMapper.addConverter(new Converter<String, Role>() {
            @Override
            public Role convert(MappingContext<String, Role> mappingContext) {
                return Role.valueOf(mappingContext.getSource().toUpperCase());
            }
        });

        modelMapper.addConverter(new Converter<Role, String>() {
            @Override
            public String convert(MappingContext<Role, String> mappingContext) {
                return mappingContext.getSource().toString().substring(0,1).toUpperCase()
                        +  mappingContext.getSource().toString().substring(1).toLowerCase();
            }
        });

        modelMapper
                .createTypeMap(CountrySeedDto.class, Country.class)
                .addMappings(isoCode -> isoCode.map(CountrySeedDto::getCode, Country::setIsoCode));

        modelMapper
                .createTypeMap(TownSeedDto.class, Town.class)
                .addMappings(name -> name.map(TownSeedDto::getCity, Town::setName))
                .addMappings(capital -> capital.map(TownSeedDto::getCapital, Town::setIsCapital));

        return modelMapper;
    }

}
