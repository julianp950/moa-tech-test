import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { UsersDisplayComponent } from './users-display/users-display.component';
import { NewUserComponent } from './new-user/new-user.component';
import { LogoutComponent } from './logout/logout.component';
import { canActivate } from './authguard.guard';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent, canActivate: [canActivate] },
  { path: 'users', component: UsersDisplayComponent, canActivate: [canActivate]  },
  { path: 'users/new', component: NewUserComponent, canActivate: [canActivate]  },
  { path: 'users/:id', component: NewUserComponent, canActivate: [canActivate]  },
];
@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes), CommonModule],
  exports: [RouterModule],
})
export class AppRoutingModule {}
