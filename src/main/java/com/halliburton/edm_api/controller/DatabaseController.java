// DatabaseController.java

package com.halliburton.edm_api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.halliburton.edm_api.service.DatabaseService;

@RestController
public class DatabaseController {
	@Autowired
    private DatabaseService databaseService;

    // Endpoint para realizar la conexión a la base de datos con las credenciales
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
    	
        try {
            databaseService.connectToDatabase(username, password);
            return "Conexión exitosa a la base de datos";
        } catch (Exception e) {
            return "Error al conectar a la base de datos: " + e.getMessage();
        }
    }

    // Endpoint para consultar cualquier tabla después de haber iniciado sesión
    @GetMapping("/query")
    public List<Map<String, Object>> query(@RequestParam String tableName) {
        return databaseService.queryTable(tableName);
    }

    // Endpoint para cerrar la conexión
    @GetMapping("/logout")
    public String logout() {
    	try {
            if (databaseService.isConnectionOpen()) {
                databaseService.closeConnection();
                return "Conexión cerrada";
            } else {
                return "No hay ninguna conexión activa";
            }
        } catch (Exception e) {
            return "Error al cerrar la conexión: " + e.getMessage();
        }
    }

}
