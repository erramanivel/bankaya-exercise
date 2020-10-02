package com.bayanka.examen.services;

import com.bankaya.examen.test.pokemon.Ability;
import com.bankaya.examen.test.pokemon.HeldItem;
import com.bayanka.examen.commons.exceptions.PokemonNotFoundException;

import java.util.List;

public interface PokemonService {

    List<Ability> getAbilities(String pokemon, String ipAddress) throws PokemonNotFoundException;

    Integer getBaseExperience(String pokemon, String ipAddress) throws PokemonNotFoundException;

    List<HeldItem> getHeldItems(String pokemon, String ipAddress) throws PokemonNotFoundException;

    Integer getId(String pokemon, String ipAddress) throws PokemonNotFoundException;

    String getName(String pokemon, String ipAddress) throws PokemonNotFoundException;

    String getLocationArea(String pokemon, String ipAddress) throws PokemonNotFoundException;



}
