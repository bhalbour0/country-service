package com.code.assignement.country.dto.response;

import com.code.assignement.country.dto.FindCountriesItem;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DTO for findCountries API Response.
 */
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FindCountriesResponse {

    private FindCountriesItem[] countries;

}
