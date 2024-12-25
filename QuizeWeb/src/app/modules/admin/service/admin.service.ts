import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


const BASE_URL="http://localhost:8080/api";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private httpClient:HttpClient) { }

  createTest(testDto: any):Observable<any>{
    return this.httpClient.post(BASE_URL + "/test" , testDto)
  }

  getAllTests():Observable<any>{
    return this.httpClient.get(BASE_URL + "/test/getAllTests")
  }

  addQuestion(testId:number, questionDto:any):Observable<any>{
    return this.httpClient.post(BASE_URL+ `/test/question/${testId}` , questionDto)
  }

}
