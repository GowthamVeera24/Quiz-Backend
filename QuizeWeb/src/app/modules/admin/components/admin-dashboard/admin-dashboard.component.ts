import { Component, OnInit } from '@angular/core';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { AdminService } from '../../service/admin.service';
import { NzCardModule } from 'ng-zorro-antd/card';
import { NzFormModule } from 'ng-zorro-antd/form';
import { CommonModule } from '@angular/common';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
  imports: [NzCardModule,NzFormModule,CommonModule,NzButtonModule ,RouterLink],
  templateUrl: './admin-dashboard.component.html',
  styleUrl: './admin-dashboard.component.scss'
})
export class AdminDashboardComponent implements OnInit{

  tests:any = [];

  constructor(private notification:NzNotificationService
    , private adminService:AdminService
  ){}
  
  
  ngOnInit(): void {
    this.getAllTests()
  }


  getAllTests(){
    this.adminService.getAllTests().subscribe(res=>{
      console.log(res)
      this.tests=res
    })
  }

  getFormattedTime(time :any):string{

    const minutes=Math.floor(time/60);
    const seconds =time%60;
    return `${minutes}minutes ${seconds} seconds`;
  }


}
