import { TestBed, ComponentFixture } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { ClientesComponent } from './clientes.component';
import { Validators } from '@angular/forms';

describe('ClientesComponent', () => {
  let component: ClientesComponent;
  let fixture: ComponentFixture<ClientesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ClientesComponent],
      imports: [ReactiveFormsModule]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('Testando a inicialização do clienteForm, controles e validadores', () => {
    const formControls = component.clienteForm.controls;
    expect(formControls.nome).toBeDefined();
    expect(formControls.email).toBeDefined();
    expect(formControls.senha).toBeDefined();
    expect(formControls.confirmacaoSenha).toBeDefined();

    expect(formControls.nome.validator).toContain(Validators.required);
    expect(formControls.nome.validator).toContain(Validators.minLength(3));
    expect(formControls.nome.validator).toContain(Validators.maxLength(50));

    expect(formControls.email.validator).toContain(Validators.required);
    expect(formControls.email.validator).toContain(Validators.email);

    expect(formControls.senha.validator).toContain(Validators.required);
    expect(formControls.senha.validator).toContain(Validators.minLength(6));
    expect(formControls.senha.validator).toContain(Validators.maxLength(20));

    expect(formControls.confirmacaoSenha.validator).toContain(Validators.required);
  });
});
