package com.code.assignement.country.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;
/**
 * DTO for a single item returned by findCountries API.
 */
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "name", "country_code" })
public class FindCountriesItem {

    private String name;

    private String countryCode;

    @JsonProperty("name")
    public void setName(Map<String,Object> name){
        this.name = (String)name.get("common");
    }

    @JsonSetter("cca2")
    public void setCountryCode(String countryCode){
        this.countryCode = countryCode;
    }

    @JsonGetter("country_code")
    public String getCountryCode(){
        return this.countryCode;
    }

    public String getName() {
        return this.name;
    }
}


