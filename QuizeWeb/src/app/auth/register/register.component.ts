import { FormBuilder, FormGroup, ReactiveFormsModule,NonNullableFormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router, RouterLink} from '@angular/router';
import {NzMessageService} from 'ng-zorro-antd/message';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzInputModule } from 'ng-zorro-antd/input';
import { AuthService } from '../../services/authService/auth.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule,NzFormModule, NzButtonModule,RouterLink ,NzInputModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent implements OnInit{



  constructor(private fb :NonNullableFormBuilder
    , private router:Router,private message :NzMessageService
    ,private authService:AuthService
  ){}

  validateForm!:FormGroup;

  ngOnInit(): void {
   this.validateForm =this.fb.group({
    email :[null , [Validators.required , Validators.email]],
    password:[null , [Validators.required]],
    name: this.fb.control('', [Validators.required])
   })
  }



  submitForm(){

    if (this.validateForm.valid) {


    this.authService.signup(this.validateForm.value).subscribe((res)=>{
      console.log(this.validateForm.value)
      console.log(res)
      this.message.success('Signup Successfull ..' , {nzDuration:5000})
      this.router.navigateByUrl("/login")

    },(error :any) =>{
      this.message.error('User already Exists ..', {nzDuration:5000})
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


  resetForm(e: MouseEvent): void {
    e.preventDefault();
    this.validateForm.reset();
  }
  

}
