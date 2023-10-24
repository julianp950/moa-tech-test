import { Component, HostListener } from '@angular/core';
import { LoginService } from '../login.service';
import {
  FormBuilder,
  FormGroup,
  UntypedFormBuilder,
  UntypedFormControl,
  UntypedFormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../users.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  hide = true;
  myForm: FormGroup = this.formBuilder.group({
    userName: new UntypedFormControl('', Validators.required),
    password: new UntypedFormControl('', Validators.required),
    rememberMe: new UntypedFormControl(''),
  });
  errorLogin: boolean = false;
  user?: User;

  constructor(
    private loginService: LoginService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit() {
    if (localStorage.getItem('rememberMe')) {
      this.myForm.patchValue({
        userName: localStorage.getItem('userName'),
        password: localStorage.getItem('password'),
        rememberMe: localStorage.getItem('rememberMe')
      });
    }
  }

  onSubmit(): void {
    if (this.myForm.value.rememberMe) {
      localStorage.setItem('rememberMe', this.myForm.value.rememberMe);
      localStorage.setItem('userName', this.myForm.value.userName);
      localStorage.setItem('password', this.myForm.value.password);
    } else {
      localStorage.removeItem('rememberMe');
      localStorage.removeItem('userName');
      localStorage.removeItem('password');
    }
    this.loginService
      .login(this.myForm.value.userName, this.myForm.value.password)
      .subscribe((res) => {
        if (res != '') {
          const user = JSON.parse(res);
          if (user.token.length > 10) {
            this.setLocalStorage(user);
            this.router.navigate(['/users']);
          } else {
            this.errorLogin = true;
          }
        } else {
          this.errorLogin = true;
        }
      });
  }

  @HostListener('keyup.enter') onKeyupEnter() {
    this.onSubmit();
  }

  setLocalStorage(user: any): void {
    localStorage.setItem('token', user.token);
    localStorage.setItem('userId', user.id);
    localStorage.setItem('userFullName', user.name);
    localStorage.setItem('create', user.role.create);
    localStorage.setItem('update', user.role.update);
    localStorage.setItem('delete', user.role.delete);
  }
}
