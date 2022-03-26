import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { ViewPatientsComponent } from './pages/admin/view-patients/view-patients.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { DocterDashboardComponent } from './pages/docter/docter-dashboard/docter-dashboard.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { PatientappointmentComponent } from './pages/patientappointment/patientappointment.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { SignupComponent } from './pages/signup/signup.component';
import { AdminGuard } from './services/admin.guard';
import { NormalGuard } from './services/normal.guard';

const routes: Routes = [
  {path:'signup',component: SignupComponent,pathMatch:'full'},
  {path:'login',component:LoginComponent,pathMatch:'full'},
  {path:'',component:HomeComponent,pathMatch:'full'},
  {path:'admin',component:DashboardComponent,canActivate:[AdminGuard],
children:[
  {path:'profile',component:ProfileComponent},
  {path:'',component:WelcomeComponent},
  {path:'Patients',component:ViewPatientsComponent}
]},
  {path:'docter',component:DocterDashboardComponent,pathMatch:'full', canActivate:[NormalGuard]},
  {path:'patient-appointment-form',component:PatientappointmentComponent},
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
