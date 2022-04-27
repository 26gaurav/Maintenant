import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router'; 
import { LoginComponent } from './pages/login/login.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { ErrorComponent } from './components/error/error.component';
import { SignupComponent } from './pages/signup/signup.component';
import { HomeComponent } from './pages/home/home.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { AddComplaintComponent } from './pages/add-complaint/add-complaint.component';
import { UpdateComplaintComponent } from './pages/update-complaint/update-complaint.component';
import { ViewComplaintsComponent } from './pages/view-complaints/view-complaints.component';
import { CrudWorkersComponent } from './pages/crud-workers/crud-workers.component';
import { AddWorkerComponent } from './pages/add-worker/add-worker.component';
import { ViewWorkersComponent } from './pages/view-workers/view-workers.component';
import { AdminComplaintsComponent } from './pages/admin-complaints/admin-complaints.component';
import { MapWorkersComponent } from './pages/map-workers/map-workers.component';
import { WorkerDashboardComponent } from './pages/worker-dashboard/worker-dashboard.component';
import { AuthGuard } from './auth.guard';

const routes: Routes=[
  { path: '', component: HomeComponent  },
  { path:'signup', component: SignupComponent, pathMatch: 'full'},
  { path: 'login', component: LoginComponent,  pathMatch: 'full' },
  { path: 'admin', component: DashboardComponent, pathMatch: 'full', canActivate: [AuthGuard]},
  { path: 'user-dashboard', component: UserDashboardComponent, pathMatch: 'full', canActivate: [AuthGuard]},
  { path: 'add-complaint', component: AddComplaintComponent, pathMatch: 'full', canActivate: [AuthGuard]},
  { path: 'update-complaint/:id', component: UpdateComplaintComponent, pathMatch: 'full', canActivate: [AuthGuard]},
  { path: 'view-complaints', component: ViewComplaintsComponent, pathMatch: 'full', canActivate: [AuthGuard]},
  { path: 'crud-workers', component: CrudWorkersComponent, pathMatch: 'full', canActivate: [AuthGuard]},
  { path: 'add-worker', component: AddWorkerComponent, pathMatch: 'full', canActivate: [AuthGuard]},
  { path: 'view-workers', component: ViewWorkersComponent, pathMatch: 'full', canActivate: [AuthGuard]},
  { path: 'admin-complaints', component: AdminComplaintsComponent, pathMatch: 'full', canActivate: [AuthGuard]},
  { path: 'map-workers/:id', component: MapWorkersComponent, pathMatch: 'full', canActivate: [AuthGuard]},
  { path: 'worker-dashboard', component: WorkerDashboardComponent, pathMatch: 'full', canActivate: [AuthGuard]},
  { path:'**', component: ErrorComponent}
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
