package com.proyectoSerenity.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonReader {
    public static <T> T leer(String ruta, Class<T> tipo) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File archivo = new File("src/test/resources/" + ruta);
            return mapper.readValue(archivo, tipo);
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo JSON");
        }
    }
}
