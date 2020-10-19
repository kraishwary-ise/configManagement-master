import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http'
import {Observable} from 'rxjs';
import { LoginUser } from '../models/login-user';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) {

}


public logInUser(user:LoginUser):Observable<any> {


 return this.http.post<any>("http://localhost:8080/api/LoginUsers",user)

}

isUserLogin() {

 let userEmail= sessionStorage.getItem('authenticateUser')

 return !(userEmail==null);

}

logOut() {

  sessionStorage.removeItem('authenticateUser')
}

}
