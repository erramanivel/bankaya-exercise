package com.bayanka.examen.commons.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonApiResponse implements Serializable {


    private List<PokemonAbility> abilities;
    @JsonProperty("base_experience")
    private Integer baseExperience;
    @JsonProperty("held_items")
    private List<PokemonHeldItem> heldItems;
    private Integer id;
    private String name;
    @JsonProperty("location_area_encounters")
    private String locationAreaEncounters;
}
