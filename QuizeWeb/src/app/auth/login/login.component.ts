import { Component } from '@angular/core';
import { Router, RouterLink} from '@angular/router';
import {NzMessageService} from 'ng-zorro-antd/message';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzInputModule } from 'ng-zorro-antd/input';
import { AuthService } from '../../services/authService/auth.service';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { StorageService } from '../../services/storage/storage.service';
import { NzIconModule } from 'ng-zorro-antd/icon';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule,NzFormModule, NzButtonModule,RouterLink ,NzInputModule ,NzIconModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  passwordVisible=false;

constructor(private fb :FormBuilder
    , private router:Router,private message :NzMessageService
    ,private authService:AuthService
  ){}

  validateForm!:FormGroup;

  ngOnInit(): void {
   this.validateForm =this.fb.group({
    email :[null , [Validators.required , Validators.email]],
    password:[null , [Validators.required]]
     })
  }

  submitForm(){
   
      if (this.validateForm.valid) {
        

            this.authService.login(this.validateForm.value).subscribe(res=>{
              console.log(res)
        
            if(res.id != null){
                  this.message.success('Logged Successfully !!! ' ,{nzDuration:5000})
                  
                const user={
                  id:res.id ,
                  role:res.userRole
                }
                StorageService.saveUser(user)
                if(StorageService.isAdminLogged()){
                  this.router.navigateByUrl("/admin/dashboard")
                }else if(StorageService.isUserLogged()){
                  this.router.navigateByUrl("/user/dashboard")
                }


            }
         },error=>{
            console.log(error)
            this.message.success('Bad Credentials !!! ' ,{nzDuration:5000})
      
          })
          
        
      } else {
        Object.values(this.validateForm.controls).forEach(control => {
          if (control.invalid) {
            control.markAsDirty();
            control.updateValueAndValidity({ onlySelf: true });
          }
        });
      }

    }  

}
