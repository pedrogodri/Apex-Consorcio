import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalhesFornecedorComponent } from './detalhes-fornecedor.component';

describe('DetalhesFornecedorComponent', () => {
  let component: DetalhesFornecedorComponent;
  let fixture: ComponentFixture<DetalhesFornecedorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DetalhesFornecedorComponent]
    });
    fixture = TestBed.createComponent(DetalhesFornecedorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
