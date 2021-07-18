package com.ynz.demo.springtestcontextconfiguration;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CountryController {
    private final CountryRepository repository;

    @GetMapping("countries")
    Iterable<Country> getAllCountries(){
        return repository.findAll();
    }

}
