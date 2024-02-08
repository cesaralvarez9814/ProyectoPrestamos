import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IPrestamo } from 'src/app/models/prestamo';
import { PrestamosService } from 'src/app/services/prestamo.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  public prestamos: IPrestamo[]=[];
  public prestamosrep:IPrestamo[]=[];
  userLoginOn:boolean=false;
  public page: number=0;
  constructor(private prestamosService:PrestamosService,private router: Router) { }

  ngOnInit(): void {
    
    this.obtenerPrestamos();
  }
  obtenerPrestamos():void{
    this.prestamosService.getPrestamos().subscribe(
      (response) =>{
        this.prestamos=response;
        this.prestamosrep=response;
      }); 
  }
  agregarPrestamo():void{
    this.router.navigateByUrl('/agregar-prestamo');
  }

  filtrar(name: any):void{ //Filtrar por nombre
    this.prestamos=this.prestamosrep;
    this.prestamos= this.prestamos.filter(s => s.nombreCliente.toUpperCase().includes(name.value.toUpperCase()));
  }
 

}
