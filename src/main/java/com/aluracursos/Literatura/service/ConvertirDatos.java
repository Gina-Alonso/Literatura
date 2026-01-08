package com.aluracursos.Literatura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertirDatos  implements IConvertirDatos{
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json.toString(), clase);
        }catch (JsonProcessingException e){
            System.out.println("Error al convertir Json a la clase");
            throw new RuntimeException(e);
        }
    }


}
