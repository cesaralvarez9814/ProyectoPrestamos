import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators} from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginError:string="";
  styleImage = 'financing';
  loginForm=this.formBuilder.group({
    username:['',[Validators.required]],
    password: ['',Validators.required],
  })
  constructor(private formBuilder:FormBuilder, private router:Router) { }

  ngOnInit(): void {
  }

  get email(){
    return this.loginForm.controls.username;
  }

  get password()
  {
    return this.loginForm.controls.password;
  }

  login(){
    this.router.navigateByUrl('/inicio');
    this.loginForm.reset();
    
  }
  unsplashClass(): any {
    return {
      'min-height': '100%',
      background: `url("https://source.unsplash.com/random/1200x900?"${this.styleImage}) no-repeat center center`,
      'background-size': 'cover',
      position: 'relative',
    };
  }


}
