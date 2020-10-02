package com.bayanka.examen.soap.ws;


import com.bankaya.examen.test.pokemon.*;
import com.bayanka.examen.commons.exceptions.PokemonNotFoundException;
import com.bayanka.examen.services.PokemonService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.servlet.http.HttpServletRequest;

@Endpoint
@AllArgsConstructor
@Log4j2
public class PokemonEndpoint {

    private static final String NAMESPACE_URI = "http://bankaya.com/examen/test/pokemon";

    private final PokemonService pokemonService;

    private final HttpServletRequest request;



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAbilitiesRequest")
    @ResponsePayload
    public GetAbilitiesResponse getAbilities(@RequestPayload GetAbilitiesRequest soapRequest) {
        log.info("new request for: {}", soapRequest.getPokemon());
        GetAbilitiesResponse response = new GetAbilitiesResponse();
        try {
            response.getAbilities().addAll(pokemonService.getAbilities(soapRequest.getPokemon(), getClientIP(request)));
            response.setCode(200);
            response.setMessage("Success");
        } catch (PokemonNotFoundException e) {
            response.setCode(e.getErrorCode());
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBaseExperienceRequest")
    @ResponsePayload
    public GetBaseExperienceResponse getBaseExperience(@RequestPayload GetBaseExperienceRequest soapRequest) {
        log.info("new request get Base Experience for: {}", soapRequest.getPokemon());
        GetBaseExperienceResponse response = new GetBaseExperienceResponse();
        try {
            response.setBaseExperience(pokemonService.getBaseExperience(soapRequest.getPokemon(), getClientIP(request)));
            response.setCode(200);
            response.setMessage("Success");
        } catch (PokemonNotFoundException e) {
            response.setCode(e.getErrorCode());
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHeldItemsRequest")
    @ResponsePayload
    public GetHeldItemsResponse getHeldItems(@RequestPayload GetHeldItemsRequest soapRequest) {
        log.info("new request get Held_Items for: {}", soapRequest.getPokemon());
        GetHeldItemsResponse response = new GetHeldItemsResponse();
        try {
            response.getHeldItems().addAll(pokemonService.getHeldItems(soapRequest.getPokemon(), getClientIP(request)));
            response.setCode(200);
            response.setMessage("Success");
        } catch (PokemonNotFoundException e) {
            response.setCode(e.getErrorCode());
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
    @ResponsePayload
    public GetIdResponse getId(@RequestPayload GetIdRequest soapRequest) {
        log.info("new request get Id for: {}", soapRequest.getPokemon());
        GetIdResponse response = new GetIdResponse();
        try {
            response.setId(pokemonService.getId(soapRequest.getPokemon(), getClientIP(request)));
            response.setCode(200);
            response.setMessage("Success");
        } catch (PokemonNotFoundException e) {
            response.setCode(e.getErrorCode());
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameRequest")
    @ResponsePayload
    public GetNameResponse getName(@RequestPayload GetNameRequest soapRequest) {
        log.info("new request get Id for: {}", soapRequest.getPokemon());
        GetNameResponse response = new GetNameResponse();
        try {
            response.setName(pokemonService.getName(soapRequest.getPokemon(), getClientIP(request)));
            response.setCode(200);
            response.setMessage("Success");
        } catch (PokemonNotFoundException e) {
            response.setCode(e.getErrorCode());
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationAreaEncountersRequest")
    @ResponsePayload
    public GetLocationAreaEncountersResponse getLocationAreaEncounters(@RequestPayload GetLocationAreaEncountersRequest soapRequest) {
        log.info("new request get Id for: {}", soapRequest.getPokemon());
        GetLocationAreaEncountersResponse response = new GetLocationAreaEncountersResponse();
        try {
            response.setLocationAreaEncounters(pokemonService.getLocationArea(soapRequest.getPokemon(), getClientIP(request)));
            response.setCode(200);
            response.setMessage("Success");
        } catch (PokemonNotFoundException e) {
            response.setCode(e.getErrorCode());
            response.setMessage(e.getMessage());
        }
        return response;
    }

     private String getClientIP(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}
