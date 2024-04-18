package com.example.fd.firstdecision.service;

import com.example.fd.firstdecision.orm.Cliente;
import com.example.fd.firstdecision.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public boolean existeEmail(Cliente cliente){
        if(this.clienteRepository.existsByEmail(cliente.getEmail())){
            return true;
        }else{
            return false;
        }
    }

    public boolean validarSenha(Cliente cliente){
        return cliente.getConfirmSenha();
    }

    public void salvarCliente(Cliente cliente){

        clienteRepository.save(cliente);
    }
}
