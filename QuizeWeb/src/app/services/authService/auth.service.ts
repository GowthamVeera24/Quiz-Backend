import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

   BASEURL :string="http://localhost:8080/api/auth";

  constructor(private httpClient:HttpClient) { }


  signup(signupDto:any):Observable<any>{
    return this.httpClient.post(`${this.BASEURL}/signup` , signupDto)
  }


  login(loginDto :any):Observable<any>{
    return this.httpClient.post(this.BASEURL+"/login",loginDto)
  }

 

}
