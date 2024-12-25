import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzInputModule } from 'ng-zorro-antd/input';
import { AdminService } from '../../service/admin.service';
import {Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { NzNotificationService } from 'ng-zorro-antd/notification';

@Component({
  selector: 'app-create-test',
  standalone: true,
  imports: [ReactiveFormsModule,NzFormModule,NzButtonModule,NzInputModule],
  templateUrl: './create-test.component.html',
  styleUrl: './create-test.component.scss'
})
export class CreateTestComponent implements OnInit{


  testForm!:FormGroup;
  constructor(private fb:FormBuilder 
    , private adminService:AdminService
      , private router:Router,private message :NzMessageService
      ,private notification:NzNotificationService
  
  ){}
 
 
  ngOnInit(): void {
    this.testForm=this.fb.group({
      title:this.fb.control('' , Validators.required),
      description: this.fb.control('' , Validators.required),
      time:this.fb.control('',Validators.required)
    })
  }

  submitForm() {

    if(this.testForm.valid){

console.log(this.testForm.value)
      this.adminService.createTest(this.testForm.value).subscribe((res)=>{
        console.log(res)
        if(res!=null){
          //this.message.success('Test created Successfully !!! ' ,{nzDuration:5000})
          this.notification.error('SUCCESS' , `Test created Successfully` ,{nzDuration:5000})
          this.router.navigateByUrl("/admin/dashboard")
        }
      },error=>{
        console.log(error)
        //this.message.error('something went wrong !!! ' ,{nzDuration:5000})
        this.notification.error('ERROR' , `${error.error}` ,{nzDuration:5000})
  
      })

    }else {
      Object.values(this.testForm.controls).forEach(control => {
        if (control.invalid) {
          control.markAsDirty();
          control.updateValueAndValidity({ onlySelf: true });
        }
      });
    }

    
  }

}
