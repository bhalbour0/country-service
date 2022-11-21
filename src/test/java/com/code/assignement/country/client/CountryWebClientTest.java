package com.code.assignement.country.client;

import com.code.assignement.country.dto.FindCountriesItem;
import com.code.assignement.country.dto.response.FindCountriesResponse;
import com.code.assignement.country.dto.response.FindCountryByNameResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
class CountryWebClientTest {

    public static final String COUNTRY_NAME = "finland";
    @InjectMocks
    private CountryWebClient client;
    @Mock
    private WebClient webClient;

    @Test
    void findCountries() {
        // GIVEN
        ReflectionTestUtils.setField(client, "client", webClient);
        FindCountriesItem[] findCountriesItem = new FindCountriesItem[] {
                new FindCountriesItem()
        };

        WebClient.RequestHeadersUriSpec mock = mock(WebClient.RequestHeadersUriSpec.class);
        WebClient.RequestHeadersSpec mock2 = mock(WebClient.RequestHeadersSpec.class);
        WebClient.ResponseSpec mock3 = mock(WebClient.ResponseSpec.class);

        Mockito.when(webClient.get()).thenReturn(mock);
        Mockito.when(mock.uri(anyString())).thenReturn(mock2);
        Mockito.when(mock2.accept(ArgumentMatchers.<MediaType>any())).thenReturn(mock2);
        Mockito.when(mock2.retrieve()).thenReturn(mock3);
        Mockito.when(mock3.bodyToMono(FindCountriesItem[].class)).thenReturn(Mono.just(findCountriesItem));


        // WHEN
        Mono<FindCountriesResponse> response = client.findCountries();

        // THEN
        StepVerifier.create(response).expectNextMatches(elt -> Arrays.equals(elt.getCountries(), findCountriesItem)).expectComplete().verify();
    }

    @Test
    void findCountryByName() {
        // GIVEN
        ReflectionTestUtils.setField(client, "client", webClient);
        FindCountryByNameResponse[] findCountryByNameResponses = new FindCountryByNameResponse[] {
                new FindCountryByNameResponse()
        };

        WebClient.RequestHeadersUriSpec mock = mock(WebClient.RequestHeadersUriSpec.class);
        WebClient.RequestHeadersSpec mock2 = mock(WebClient.RequestHeadersSpec.class);
        WebClient.ResponseSpec mock3 = mock(WebClient.ResponseSpec.class);

        Mockito.when(webClient.get()).thenReturn(mock);
        Mockito.when(mock.uri(anyString(), anyString())).thenReturn(mock2);
        Mockito.when(mock2.accept(ArgumentMatchers.<MediaType>any())).thenReturn(mock2);
        Mockito.when(mock2.retrieve()).thenReturn(mock3);
        Mockito.when(mock3.bodyToMono(FindCountryByNameResponse[].class)).thenReturn(Mono.just(findCountryByNameResponses));


        // WHEN
        Mono<FindCountryByNameResponse> response = client.findCountryByName(COUNTRY_NAME);

        // THEN
        StepVerifier.create(response).expectNext(findCountryByNameResponses).expectComplete().verify();
    }
}