package com.example.fd.firstdecision.service;

import com.example.fd.firstdecision.exception.EmailAlreadyExistsException;
import com.example.fd.firstdecision.orm.Cliente;
import com.example.fd.firstdecision.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void existeEmail(Cliente cliente){

        if(this.clienteRepository.existsByEmail(cliente.getEmail())){
            throw new EmailAlreadyExistsException("Este e-mail já está em uso.");
        }
    }

    public boolean validarSenha(Cliente cliente){
        return cliente.getConfirmSenha();
    }

    public void salvarCliente(Cliente cliente){

        clienteRepository.save(cliente);
    }
}
