package com.code.assignement.country.controller;

import com.code.assignement.country.client.CountryWebClient;
import com.code.assignement.country.dto.response.FindCountriesResponse;
import com.code.assignement.country.dto.response.FindCountryByNameResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * Spring Controller for countries.
 */
@RestController
@RequestMapping("/countries")
@CrossOrigin
public class CountryController {
    private final CountryWebClient webClient = new CountryWebClient();

    /**
     * Get all countries from <a href="https://restcountries.com/">this website</a>.
     * @return all countries
     */
    @GetMapping
    public Mono<FindCountriesResponse> findCountries() {

        return webClient.findCountries();

    }

    /**
     * Get a country by a name from <a href="https://restcountries.com/">this website</a>.
     * @param name name of the country
     * @return a country
     */
    @GetMapping("/{name}")
    public Mono<FindCountryByNameResponse> findCountryByName(@PathVariable String name) {

        return webClient.findCountryByName(name);

    }
}
