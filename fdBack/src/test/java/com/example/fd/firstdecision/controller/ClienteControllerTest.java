package com.example.fd.firstdecision.controller;

import com.example.fd.firstdecision.exception.EmailAlreadyExistsException;
import com.example.fd.firstdecision.orm.Cliente;
import com.example.fd.firstdecision.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegistrarCliente_EmailNaoExistente() {
        Cliente cliente = new Cliente();
        cliente.setEmail("test@example.com");

        when(clienteService.validarSenha(cliente)).thenReturn(true);
        doNothing().when(clienteService).existeEmail(cliente);
        doNothing().when(clienteService).salvarCliente(cliente);

        ResponseEntity<String> response = clienteController.registrarCliente(cliente);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Usuário registrado com sucesso.", response.getBody());
        verify(clienteService, times(1)).validarSenha(cliente);
        verify(clienteService, times(1)).existeEmail(cliente);
        verify(clienteService, times(1)).salvarCliente(cliente);
    }

    @Test
    void testRegistrarCliente_EmailExistente() {
        Cliente cliente = new Cliente();
        cliente.setEmail("test@example.com");

        when(clienteService.validarSenha(cliente)).thenReturn(true);
        doThrow(EmailAlreadyExistsException.class).when(clienteService).existeEmail(cliente);

        ResponseEntity<String> response = clienteController.registrarCliente(cliente);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Este e-mail já está em uso.", response.getBody());
        verify(clienteService, times(1)).validarSenha(cliente);
        verify(clienteService, times(1)).existeEmail(cliente);
        verify(clienteService, never()).salvarCliente(cliente);
    }

    @Test
    void testRegistrarCliente_SenhaInvalida() {
        Cliente cliente = new Cliente();
        cliente.setEmail("test@example.com");

        when(clienteService.validarSenha(cliente)).thenReturn(false);

        ResponseEntity<String> response = clienteController.registrarCliente(cliente);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("A senha e a confirmação de senha não correspondem.", response.getBody());
        verify(clienteService, times(1)).validarSenha(cliente);
        verify(clienteService, never()).existeEmail(cliente);
        verify(clienteService, never()).salvarCliente(cliente);
    }
}