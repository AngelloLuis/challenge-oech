package com.example.controller;

import com.example.dto.ClienteDTO;
import com.example.model.Cliente;
import com.example.service.api.ClienteServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente/api/v1/")
@CrossOrigin("*")
public class ClienteRestController {


    @Autowired
    private ClienteServiceAPI clienteServiceAPI;

    @GetMapping(value = "/all")
    public List<ClienteDTO> getAll() throws Exception {
        return clienteServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public ClienteDTO find(@PathVariable String id) throws Exception {
        return clienteServiceAPI.get(id);
    }

    @PostMapping(value = "/save/{id}")
    public ResponseEntity<String> save(@RequestBody Cliente cliente, @PathVariable String id) throws Exception {
        if (id == null || id.length() == 0 || id.equals("null")) {
            id = clienteServiceAPI.save(cliente);
        } else {
            clienteServiceAPI.save(cliente, id);
        }
        return new ResponseEntity<String>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<ClienteDTO> delete(@PathVariable String id) throws Exception {
        ClienteDTO persona = clienteServiceAPI.get(id);
        if (persona != null) {
            clienteServiceAPI.delete(id);
        } else {
            return new ResponseEntity<ClienteDTO>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<ClienteDTO>(persona, HttpStatus.OK);
    }

}
