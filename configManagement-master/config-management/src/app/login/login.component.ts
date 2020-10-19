import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginUser } from '../models/login-user';
import { LoginService } from '../service/login.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginUser = new LoginUser()
  msg=""


  constructor(private loginService:LoginService,private router:Router) {




  }

  ngOnInit() {

  }


  logiInUser() {


  this.loginService.logInUser(this.loginUser).subscribe(response=> {


    this.router.navigate(['/usecase'])
    sessionStorage.setItem('authenticateUser',response.userEmail)
    this.msg="";
  },
  error=> {
    console.log("error");
    this.msg="Bad Credentails. please enter valid email and password";
  })

}
}

