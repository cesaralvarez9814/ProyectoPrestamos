import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  userLoginOn:boolean=false;
  constructor( private router:Router) { }

  ngOnInit(): void {
    
  }

  logout()
  {
    this.router.navigate(['/inicio'])
  }

}
