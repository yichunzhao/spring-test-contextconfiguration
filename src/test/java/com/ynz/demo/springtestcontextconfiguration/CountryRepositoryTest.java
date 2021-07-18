package com.ynz.demo.springtestcontextconfiguration;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CountryRepositoryTest {
    @Autowired
    private CountryRepository repository;

    @Test
    void shouldHavingMoreThan60Countries() {
        Iterable<Country> countries = repository.findAll();
        List<Country> countryList = new ArrayList<>();
        countries.forEach(countryList::add);

        assertThat(countryList, Matchers.hasSize(60));
    }

}