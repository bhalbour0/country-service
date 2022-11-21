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

    private final String BASE_URL = "https://restcountries.com/v3.1";
    public static final String FIND_COUNTRY_ALL_URI = "/all";
    public static final String FIND_COUNTRY_BY_NAME_URI = "/name/{name}";

    private final WebClient client = WebClient.builder().baseUrl(BASE_URL).exchangeStrategies(ExchangeStrategies.builder().codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)).build()).build();

    /**
     * Get all countries from <a href="https://restcountries.com/">this api</a>.
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
     * Get a country by a name from <a href="https://restcountries.com/">this api</a>.
     * @param name name of the country
     * @return all countries
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
