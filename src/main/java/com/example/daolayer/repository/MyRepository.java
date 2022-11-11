package com.example.daolayer.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MyRepository {
    private final String sqlScript = read("myScript.sql");
    private final NamedParameterJdbcTemplate template;

    public MyRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        return template.queryForStream(sqlScript, Map.of("name", name)
                , (rs, row) -> rs.getString("product_name")).collect(Collectors.toList());
    }
}
