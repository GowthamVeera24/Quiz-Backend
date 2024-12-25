import { Injectable } from '@angular/core';

const USER ="q_user";

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() { }

static saveUser(user:any):void{
    window.localStorage.removeItem(USER);
    window.localStorage.setItem(USER, JSON.stringify(user));
  }

  static getUser():any{
    return JSON.parse(<string>localStorage.getItem(USER))
  }

  static getUserId():string{
    const user =this.getUser();
    if(user == null)
      return '';
    return user.id;
  }

  static getUserRole():string{
    const user =this.getUser();
    if(user == null)
      return '';
    return user.role;
  }

  static isAdminLogged():boolean{
    const role:string=this.getUserRole();
    return role == "ADMIN";
  }

  static isUserLogged():boolean{
    const role:string=this.getUserRole();
    return role == "USER";
  }

  static logout(){
    window.localStorage.removeItem(USER)
  }

}
