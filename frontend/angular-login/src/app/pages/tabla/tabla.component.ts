import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IPrestamo } from 'src/app/models/prestamo';
import { IRespTabla } from 'src/app/models/resptabla';
import { ITabla } from 'src/app/models/tabla';
import { PrestamosService } from 'src/app/services/prestamo.service';

@Component({
  selector: 'app-tabla',
  templateUrl: './tabla.component.html',
  styleUrls: ['./tabla.component.css']
})
export class TablaComponent implements OnInit {
  public cliente:String = '';
  public tabla={} as IRespTabla;
  public valores: ITabla[] =[];
  private sub: any;
  private id: number=0;
  userLoginOn:boolean=false;
  constructor(private prestamosService:PrestamosService,private router: Router,private route: ActivatedRoute,) { }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe((params) => {
      this.id= params['id'];
    });
    this.obtenerTabla();
  }
  obtenerTabla():void{
    this.prestamosService.getTabla(this.id).subscribe(
      (response) =>{
        this.tabla=response;
        this.valores = response.valores;
        this.cliente= this.tabla.nombreCliente
      }); 
  }
  regresar():void{
    this.router.navigateByUrl('/inicio');
  }


 

}
