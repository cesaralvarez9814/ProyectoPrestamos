import { Component, OnDestroy, OnInit } from '@angular/core';
import { UntypedFormBuilder, UntypedFormControl, UntypedFormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ICliente } from 'src/app/models/cliente';
import { IMonto } from 'src/app/models/monto';
import { IPlazo } from 'src/app/models/plazo';
import { AlertService } from 'src/app/services';
import { PrestamosService } from 'src/app/services/prestamo.service';

@Component({
  selector: 'app-prestamo',
  templateUrl: './prestamo.component.html',
  styleUrls: ['./prestamo.component.css']
})
export class PrestamoComponent implements OnInit {
  public clientes: ICliente[] = [];
  public montos: IMonto[] = [];
  public plazos: IPlazo[] = [];
  userLoginOn:boolean=false;
  public prestamosForm: UntypedFormGroup;
  
  constructor(private prestamosService:PrestamosService, private fb: UntypedFormBuilder,private router: Router,private alertService:AlertService) {
    this.prestamosForm=this.fb.group({
      cliente: new UntypedFormControl(0, [Validators.required, Validators.min(1)]),
      plazo: new UntypedFormControl(0, [Validators.required, Validators.min(1)]),
      monto: new UntypedFormControl(0, [Validators.required, Validators.min(1)]),
    });
   }

  ngOnInit(): void {
    this.inicializarForm();
    this.obtenerClientes();
    this.obtenerMontos();
    this.obtenerPlazos();
  }
  
  obtenerClientes():void{
    this.prestamosService.getClientes().subscribe(
      (response) =>{
        this.clientes=response;
      }); 
  }
  obtenerMontos():void{
    this.prestamosService.getMontos().subscribe(
      (response) =>{
        this.montos=response;
      }); 
  }
  obtenerPlazos():void{
    this.prestamosService.getPlazos().subscribe(
      (response) =>{
        this.plazos=response;
      }); 
  }
  guardar():void{
    const data ={
      cliente: this.clientes.find((e) => e.id == this.prestamosForm.value.cliente),
      plazo: this.plazos.find((e) => e.id == this.prestamosForm.value.plazo),
      monto: this.montos.find((e) => e.id == this.prestamosForm.value.monto),
      fechaPrestamo: "",
      id: 0
    }
    this.prestamosService.guardar(data).subscribe({
      error: err => alert(err),
      complete: () =>{
        this.router.navigate(['/inicio'])
        this.alertService.success('Prestamo Creado Con Exito');
      } 

    });
      
    
  }
  inicializarForm():void{
  }
  public resetForm() {
    this.prestamosForm.controls["cliente"].setValue(0);
    this.prestamosForm.controls["plazo"].setValue(0);
    this.prestamosForm.controls["monto"].setValue(0);
  }
  public regresar() {
    this.router.navigateByUrl('/inicio');
    this.prestamosForm.reset();
  }
 

}
