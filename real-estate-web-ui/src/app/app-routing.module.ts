import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { LandInputComponent } from './estate/land/land-input/land-input.component';
import { LandCardComponent } from './estate/land/land-card/land-card.component'
import { LandDetailComponent } from './estate/land/land-detail/land-detail.component';

const routes: Routes = [
  { path: 'signup', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'lands', component: LandInputComponent },
  { path: '', component: LandCardComponent },
  { path: 'lands/:id', component: LandDetailComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
