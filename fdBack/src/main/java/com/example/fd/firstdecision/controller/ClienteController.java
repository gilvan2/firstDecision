package com.example.fd.firstdecision.controller;

import com.example.fd.firstdecision.orm.Cliente;
import com.example.fd.firstdecision.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("cliente/registrar")
    public ResponseEntity<String> registrarCliente(@RequestBody Cliente cliente) {

        if(clienteService.validarSenha(cliente)){
            return ResponseEntity.badRequest().body("A senha e a confirmação de senha não correspondem.");
        }

        if(clienteService.existeEmail(cliente)){
            return ResponseEntity.badRequest().body("Este e-mail já está em uso.");
        }

        clienteService.salvarCliente(cliente);

        return ResponseEntity.ok("Usuário registrado com sucesso.");
    }

}
