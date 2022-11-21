package com.code.assignement.country.controller;

import com.code.assignement.country.CountryServiceApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;


@ContextConfiguration(classes=CountryServiceApplication.class)
@WebFluxTest
class CountryControllerIntegrationTest {

    @Autowired
    private WebTestClient client;


    @Test
    void findCountries() {

        this.client.get()
                .uri("/countries")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.countries").exists()
                .jsonPath("$.countries").isNotEmpty()
                .jsonPath("$.countries[0].name").exists()
                .jsonPath("$.countries[0].country_code").exists();

    }

    @Test
    void findCountryByName() {
        this.client.get()
                .uri("/countries/finland")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.name")
                .exists()
                .jsonPath("$.country_code")
                .isNotEmpty()
                .jsonPath("$.capital")
                .exists()
                .jsonPath("$.population")
                .exists()
                .jsonPath("$.flag_file_url")
                .exists();
    }
}