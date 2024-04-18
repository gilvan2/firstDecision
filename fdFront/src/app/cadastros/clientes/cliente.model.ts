export class ClienteModel {
    id: string;
    nome: string;
    email: string;
    senha: string;
    confirmacaoSenha: string;
  
    constructor(nome: string, email: string, senha: string, confirmacaoSenha: string, id?: string) {
      this.id = id || '';
      this.nome = nome;
      this.email = email;
      this.senha = senha;
      this.confirmacaoSenha = confirmacaoSenha;
    }
  }