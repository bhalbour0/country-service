package com.code.assignement.country.client;

import com.code.assignement.country.dto.FindCountriesItem;
import com.code.assignement.country.dto.response.FindCountriesResponse;
import com.code.assignement.country.dto.response.FindCountryByNameResponse;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Web client for countries.
 */
public class CountryWebClient {

    public final int MEMORY_SIZE = 16 * 1024 * 1024;
    private final String BASE_URL = "https://restcountries.com/v3.1";
    public final String FIND_COUNTRY_ALL_URI = "/all";
    public final String FIND_COUNTRY_BY_NAME_URI = "/name/{name}";

    private final WebClient client = WebClient.builder()
            .baseUrl(BASE_URL)
            .exchangeStrategies(ExchangeStrategies.builder()
                    .codecs(codecs -> codecs.defaultCodecs()
                            .maxInMemorySize(MEMORY_SIZE))
                    .build())
            .build();

    /**
     * Get all countries from <a href="https://restcountries.com/">this website</a>.
     * @return all countries
     */
    public Mono<FindCountriesResponse> findCountries() {
        return this.client.get()
                .uri(FIND_COUNTRY_ALL_URI)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(FindCountriesItem[].class)
                .map(findCountriesItems -> FindCountriesResponse.builder().countries(findCountriesItems).build());
    }

    /**
     * Get a country by a name from <a href="https://restcountries.com/">this website</a>.
     * @param name name of the country
     * @return a country
     */
    public Mono<FindCountryByNameResponse> findCountryByName(String name) {
        return this.client.get()
                .uri(FIND_COUNTRY_BY_NAME_URI, name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(FindCountryByNameResponse[].class)
                .map(findCountriesItems -> findCountriesItems[0]);
    }


}
