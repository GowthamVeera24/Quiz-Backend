import { NzNotificationService } from 'ng-zorro-antd/notification';
import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../service/admin.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzInputModule } from 'ng-zorro-antd/input';

@Component({
  selector: 'app-add-question',
  standalone: true,
  imports: [NzFormModule ,ReactiveFormsModule,NzButtonModule,NzInputModule],
  templateUrl: './add-question.component.html',
  styleUrl: './add-question.component.scss'
})
export class AddQuestionComponent implements OnInit{


  id!:number;
  questionForm!:FormGroup;

  constructor(private adminService:AdminService
    ,private router:Router
    ,private route:ActivatedRoute
    ,private notification:NzNotificationService
    ,private fb:FormBuilder
  ){}
  
  
  ngOnInit(): void {
   
    this.id= this.route.snapshot.params["id"]
    this.questionForm = this.fb.group({
      questionText:this.fb.control('' , Validators.required),
      optionA:this.fb.control('' , Validators.required),
      optionB:this.fb.control('' , Validators.required),
      optionC:this.fb.control('' , Validators.required),
      optionD:this.fb.control('' , Validators.required),
      correctOption:this.fb.control('' , Validators.required),
    })
  }


  submitForm() {
    

    if(this.questionForm.valid){

      console.log(this.questionForm.value)
            this.adminService.addQuestion(this.id, this.questionForm.value).subscribe((res)=>{
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
            Object.values(this.questionForm.controls).forEach(control => {
              if (control.invalid) {
                control.markAsDirty();
                control.updateValueAndValidity({ onlySelf: true });
              }
            });
          }
      


    }

}
