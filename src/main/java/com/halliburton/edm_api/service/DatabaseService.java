package com.halliburton.edm_api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Service
public class DatabaseService {

    // JdbcTemplate que usaremos para las consultas
    private JdbcTemplate jdbcTemplate;
    private boolean connectionOpen = false;
    
 // Propiedades obtenidas desde application.properties
    @Value("${spring.datasource.url}")
    private String url;

    // Método para establecer la conexión y el DataSource
    public void connectToDatabase(String username, String password) {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName("oracle.jdbc.OracleDriver");

        HikariDataSource dataSource = new HikariDataSource(config);
        jdbcTemplate = new JdbcTemplate(dataSource);  // Usamos el DataSource para crear JdbcTemplate
        connectionOpen = true;
    }

    // Método para ejecutar una consulta en cualquier tabla
    public List<Map<String, Object>> queryTable(String tableName) {
        String query = "SELECT * FROM " + tableName;
        return jdbcTemplate.queryForList(query);
    }

    // Método para cerrar la conexión (se puede llamar cuando termine la sesión)
    public void closeConnection() {
        if (jdbcTemplate != null && jdbcTemplate.getDataSource() != null) {
            try {
                ((HikariDataSource) jdbcTemplate.getDataSource()).close();
                connectionOpen = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    // Método para verificar si la conexión está abierta
    public boolean isConnectionOpen() {
        return connectionOpen;
    }
}
