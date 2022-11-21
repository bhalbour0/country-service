package com.code.assignement.country.dto.response;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
/**
 * DTO for findCountryByName API Response.
 */
@JsonPropertyOrder({ "name", "country_code", "capital", "population", "flag_file_url" })
public class FindCountryByNameResponse {
    private String name;

    private String countryCode;

    private String capital;

    private Integer population;

    private String flagFileUrl;

    @JsonSetter("cca2")
    public void setCountryCode(String countryCode){
        this.countryCode = countryCode;
    }

    @JsonGetter("country_code")
    public String getCountryCode(){
        return this.countryCode;
    }

    @JsonGetter("flag_file_url")
    public String getFlagFileUrl(){
        return this.flagFileUrl;
    }

    @JsonProperty("name")
    public void setName(Map<String,Object> name){
        this.name = (String)name.get("common");
    }

    public String getName() {
        return this.name;
    }

    public String getCapital() {
        return this.capital;
    }

    public Integer getPopulation() {
        return this.population;
    }

    @JsonSetter("flags")
    private void setFlagFileUrl(Map<String,Object> flags) {
        this.flagFileUrl = (String)flags.get("png");
    }

    @JsonProperty("capital")
    private void setCapital(List<String> capitals) {
        this.capital = capitals.get(0);
    }

}
