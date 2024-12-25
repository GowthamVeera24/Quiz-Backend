import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { CreateTestComponent } from './components/create-test/create-test.component';
import { AddQuestionComponent } from './components/add-question/add-question.component';
import { ViewTestQuestionsComponent } from './components/view-test-questions/view-test-questions.component';

const routes: Routes = [
  {path:"dashboard" , component:AdminDashboardComponent},
  {path:"create-test" , component:CreateTestComponent},
  {path:"add-question/:id" , component:AddQuestionComponent},
  {path:"view-test-questions/:id" , component:ViewTestQuestionsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
