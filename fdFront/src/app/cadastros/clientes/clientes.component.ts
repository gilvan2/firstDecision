import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ClienteModel } from './cliente.model';
import { ClienteService } from './cliente.service';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {
  clienteForm: FormGroup;

  novoCliente: ClienteModel = new ClienteModel('', '', '', '');
  mensagem: string = '';

  constructor(private formBuilder: FormBuilder, private clienteService: ClienteService) {
    this.clienteForm = this.formBuilder.group({
      nome: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]],
      email: ['', [Validators.required, Validators.email]],
      senha: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(20)]],
      confirmacaoSenha: ['', Validators.required],
      
    });
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.registrarCliente()
  }

  registrarCliente(): void {
    if (this.clienteForm && this.clienteForm.valid) {
      const novoCliente: ClienteModel = {
        id: '', 
        nome: this.clienteForm.get('nome')?.value,
        email: this.clienteForm.get('email')?.value,
        senha: this.clienteForm.get('senha')?.value,
        confirmacaoSenha: this.clienteForm.get('confirmacaoSenha')?.value
      };
      console.log("Novo Cliente -",novoCliente)
  
      this.clienteService.registrarCliente(novoCliente).subscribe(
        () => {
          console.log('Cliente registrado com sucesso.');
          
        },
        error => {
          console.error('Erro ao registrar cliente:', error);
          
        }
      );
    }
  }
}