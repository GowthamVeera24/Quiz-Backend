import { Component, OnInit } from '@angular/core';
import {Router, RouterLink, RouterLinkActive} from '@angular/router';
import {  ReactiveFormsModule } from '@angular/forms';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { StorageService } from '../services/storage/storage.service';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    RouterLink,ReactiveFormsModule,
    RouterLinkActive,NzButtonModule , CommonModule
  
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit {

  isAdminLogged:boolean= StorageService.isAdminLogged();
  isUserLogged:boolean =StorageService.isUserLogged();
  
   
  constructor(private router :Router ) {}

  ngOnInit(): void {
    this.router.events.subscribe(event=>{
      this.isAdminLogged = StorageService.isAdminLogged();
      this.isUserLogged=StorageService.isUserLogged();
     })
  }

  logout(){
    StorageService.logout()
    this.router.navigateByUrl("login")
  }

 


}
