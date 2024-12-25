import { Routes } from '@angular/router';
import { RegisterComponent } from './auth/register/register.component';
import { LoginComponent } from './auth/login/login.component';

export const routes: Routes = [
    {path :"register" , component:RegisterComponent},
    {path :"login" , component:LoginComponent},
    {path:"admin" , loadChildren:()=> import('./modules/admin/admin.module').then(m=>m.AdminModule)},
    {path:"user"  , loadChildren:()=> import('./modules/user/user.module').then(m=>m.UserModule)}
];
