import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient,router:Router) { }

  SignUp(user:User){
    return this.http.post("http://localhost:8080/addUser",user);
  }

  login(user:User){
    return this.http.post("http://localhost:8080/authenticate",user);
  }
  GetToken(){
    return localStorage.getItem('token')||'';
  }


  IsLoggedIn(){
    return localStorage.getItem('token')!=null;
  }



}