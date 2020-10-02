package com.bayanka.examen.commons.utils;

import com.bayanka.examen.commons.exceptions.PokemonNotFoundException;
import com.bayanka.examen.commons.dto.PokemonApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
@Log4j2
@AllArgsConstructor
public class PokemonApiRestClient {

    private final RestTemplate restTemplate;
    private final Environment env;


    public PokemonApiResponse getPokemonInfo(String pokemon) throws PokemonNotFoundException {
        try {
            String url = String.format(env.getProperty("pokemon.api.url"), pokemon);
            log.info("url: {}", url);
            log.info(restTemplate);
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", env.getProperty("rest.template.header.user-agent"));
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            ResponseEntity<PokemonApiResponse> result = restTemplate.exchange(url, HttpMethod.GET, entity, PokemonApiResponse.class);
            return result.getBody();
        }catch(HttpClientErrorException ex) {
            log.error("Error trying to find pokemon: {}", pokemon);
            throw new PokemonNotFoundException(404, "Pokemon not found");
        }

    }
}
