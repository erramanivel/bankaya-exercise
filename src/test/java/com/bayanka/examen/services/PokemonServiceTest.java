package com.bayanka.examen.services;

import com.bankaya.examen.test.pokemon.Ability;
import com.bankaya.examen.test.pokemon.HeldItem;
import com.bayanka.examen.ExamenApplication;
import com.bayanka.examen.commons.exceptions.PokemonNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {ExamenApplication.class, RestTemplateAutoConfiguration.class})
public class PokemonServiceTest {

    @Autowired
    private  PokemonService pokemonService;

    @Test
    void testGetAbilitiesWithSuccessPokemon() throws PokemonNotFoundException {
        List<Ability> res = pokemonService.getAbilities("pikachu", "localhost");
        Assertions.assertNotNull(res);
    }

    @Test
    void testGetAbilitiesWithFailPokemon()  {
        PokemonNotFoundException ex = assertThrows(PokemonNotFoundException.class, () ->
                pokemonService.getAbilities("noname", "localhost")
        );
        assertNotNull(ex);
        assertEquals(404, ex.getErrorCode());
    }

    @Test
    void testGetBaseExperienceWithSuccessPokemon() throws PokemonNotFoundException {
        Integer res = pokemonService.getBaseExperience("pikachu", "localhost");
        Assertions.assertNotNull(res);
    }

    @Test
    void testGetBaseExperienceWithFailPokemon()  {
        PokemonNotFoundException ex = assertThrows(PokemonNotFoundException.class, () ->
                pokemonService.getBaseExperience("noname", "localhost")
        );
        assertNotNull(ex);
        assertEquals(404, ex.getErrorCode());
    }

    @Test
    void testGetHeldItemsWithSuccessPokemon() throws PokemonNotFoundException {
        List<HeldItem> res = pokemonService.getHeldItems("pikachu", "localhost");
        Assertions.assertNotNull(res);
    }

    @Test
    void testGetHeldItemsWithFailPokemon()  {
        PokemonNotFoundException ex = assertThrows(PokemonNotFoundException.class, () ->
                pokemonService.getHeldItems("noname", "localhost")
        );
        assertNotNull(ex);
        assertEquals(404, ex.getErrorCode());
    }

    @Test
    void testGetIdWithSuccessPokemon() throws PokemonNotFoundException {
        Integer res = pokemonService.getId("pikachu", "localhost");
        Assertions.assertNotNull(res);
    }

    @Test
    void testGetIdWithFailPokemon()  {
        PokemonNotFoundException ex = assertThrows(PokemonNotFoundException.class, () ->
                pokemonService.getId("noname", "localhost")
        );
        assertNotNull(ex);
        assertEquals(404, ex.getErrorCode());
    }

    @Test
    void testGetNameWithSuccessPokemon() throws PokemonNotFoundException {
        String res = pokemonService.getName("pikachu", "localhost");
        Assertions.assertNotNull(res);
    }

    @Test
    void testGetNameWithFailPokemon()  {
        PokemonNotFoundException ex = assertThrows(PokemonNotFoundException.class, () ->
                pokemonService.getName("noname", "localhost")
        );
        assertNotNull(ex);
        assertEquals(404, ex.getErrorCode());
    }

    @Test
    void testGetLocationAreaEncountersWithSuccessPokemon() throws PokemonNotFoundException {
        String res = pokemonService.getLocationArea("pikachu", "localhost");
        Assertions.assertNotNull(res);
    }

    @Test
    void testGetLocationAreaEncountersWithFailPokemon()  {
        PokemonNotFoundException ex = assertThrows(PokemonNotFoundException.class, () ->
                pokemonService.getLocationArea("noname", "localhost")
        );
        assertNotNull(ex);
        assertEquals(404, ex.getErrorCode());
    }

}
