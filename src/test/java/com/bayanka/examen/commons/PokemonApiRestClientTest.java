package com.bayanka.examen.commons;

import com.bayanka.examen.ExamenApplication;
import com.bayanka.examen.commons.dto.PokemonApiResponse;
import com.bayanka.examen.commons.exceptions.PokemonNotFoundException;
import com.bayanka.examen.commons.utils.PokemonApiRestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {ExamenApplication.class, RestTemplateAutoConfiguration.class})
public class PokemonApiRestClientTest {

    @Autowired private  PokemonApiRestClient pokemonApiRestClient;


    @Test
    void testPokemonApiRestResponseWhenPokemonExists() throws PokemonNotFoundException {
       PokemonApiResponse res=  pokemonApiRestClient.getPokemonInfo("pikachu");
        Assertions.assertNotNull(res);
    }

    @Test
    void testPokemonApiRestResponseWhenPokemonDoesntExist() {
        PokemonNotFoundException ex = assertThrows(PokemonNotFoundException.class, () ->
            pokemonApiRestClient.getPokemonInfo("noname")
        );
       assertNotNull(ex);
       assertEquals(404, ex.getErrorCode());
    }


}
