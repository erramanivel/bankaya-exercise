package com.bayanka.examen.services.impl;

import com.bankaya.examen.test.pokemon.Ability;
import com.bankaya.examen.test.pokemon.HeldItem;
import com.bayanka.examen.commons.exceptions.PokemonNotFoundException;
import com.bayanka.examen.commons.dto.PokemonApiResponse;
import com.bayanka.examen.commons.utils.PokemonApiRestClient;
import com.bayanka.examen.repositories.domains.Request;
import com.bayanka.examen.repositories.RequestRepository;
import com.bayanka.examen.services.PokemonService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@AllArgsConstructor
@Log4j2
public class PokemonServiceImpl implements PokemonService {


    private final PokemonApiRestClient pokemonApiRestClient;
    private final RequestRepository requestRepository;

    @Override
    public List<Ability> getAbilities(String pokemon, String ipAddress) throws PokemonNotFoundException {
        List<Ability> abilities = new ArrayList<>();
        PokemonApiResponse result = pokemonApiRestClient.getPokemonInfo(pokemon);
        result.getAbilities().forEach(ability -> {
            Ability ab = new Ability();
            ab.setName(ability.getAbility().get("name"));
            ab.setUrl(ability.getAbility().get("url"));
            ab.setIsHidden(ability.isHidden());
            ab.setSlot(ability.getSlot());
            abilities.add(ab);
        });
        log.info(abilities);
        generateRequestRecord(ipAddress,"abilities");
        return abilities;
    }

    @Override
    public Integer getBaseExperience(String pokemon, String ipAddress) throws PokemonNotFoundException {
        PokemonApiResponse result = pokemonApiRestClient.getPokemonInfo(pokemon);
        log.info("BaseExperience: {} for pokemon: {}", result.getBaseExperience(), pokemon);
        generateRequestRecord(ipAddress,"base_experience");
        return result.getBaseExperience();
    }

    @Override
    public List<HeldItem> getHeldItems(String pokemon, String ipAddress) throws PokemonNotFoundException {
        List<HeldItem> heldItems = new ArrayList<>();
        PokemonApiResponse result = pokemonApiRestClient.getPokemonInfo(pokemon);
        result.getHeldItems().forEach(hi -> {
            HeldItem heldItem = new HeldItem();
            heldItem.setName(hi.getItem().get("name"));
            heldItem.setUrl(hi.getItem().get("url"));
            heldItems.add(heldItem);
        });
        generateRequestRecord(ipAddress,"held_items");

        return heldItems;

    }

    @Override
    public Integer getId(String pokemon, String ipAddress) throws PokemonNotFoundException {
        PokemonApiResponse result = pokemonApiRestClient.getPokemonInfo(pokemon);
        log.info("Id: {} for pokemon: {}", result.getId(), pokemon);
        generateRequestRecord(ipAddress,"id");
        return result.getId();
    }

    @Override
    public String getName(String pokemon, String ipAddress) throws PokemonNotFoundException {
        PokemonApiResponse result = pokemonApiRestClient.getPokemonInfo(pokemon);
        log.info("Name: {} for pokemon: {}", result.getName(), pokemon);
        generateRequestRecord(ipAddress,"name");
        return result.getName();
    }

    @Override
    public String getLocationArea(String pokemon, String ipAddress) throws PokemonNotFoundException {
        PokemonApiResponse result = pokemonApiRestClient.getPokemonInfo(pokemon);
        log.info("Location URL: {} for pokemon: {}", result.getLocationAreaEncounters(), pokemon);
        generateRequestRecord(ipAddress,"location_area_encounters");
        return result.getLocationAreaEncounters();
    }

    private void generateRequestRecord(String ipAddress, String method){
        log.info("Saving new request from {} address for method: {}", ipAddress, method);
        requestRepository.save(Request.builder()
                .originIp(ipAddress)
                .requestMethod(method)
                .requestDate(new Date())
                .build());
    }

}
