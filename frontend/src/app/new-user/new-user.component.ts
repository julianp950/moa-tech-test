import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  UntypedFormControl,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User, UsersService } from '../users.service';
import { Role, RoleService } from '../role.service';

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.scss'],
})
export class NewUserComponent {
  myForm: FormGroup = this.formBuilder.group({
    name: new UntypedFormControl('', Validators.required),
    age: new UntypedFormControl('', Validators.required),
    phone: new UntypedFormControl(''),
    address: new UntypedFormControl(''),
    email: new UntypedFormControl('', Validators.email),
    userName: new UntypedFormControl('', Validators.required),
    password: new UntypedFormControl('', Validators.required),
    role: new UntypedFormControl('', Validators.required),
  });
  user?: User;
  roles: Role[] = [];
  id: number = 0;
  permissions: any = {
    create: localStorage.getItem("create"),
    update: localStorage.getItem("update"),
    delete: localStorage.getItem("delete")
  }

  ngOnInit() {
    this.getRoles();
    this.route.params.subscribe((params) => {
      this.id = +params['id'];
    });

    if (this.id) this.getUser(this.id);
  }

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private usersService: UsersService,
    private roleService: RoleService,
    private route: ActivatedRoute
  ) {}

  onSubmit(myForm: FormGroup): void {
    if (myForm.valid) {
      let selectedRole = this.roles.find(
        (role) => (role.id = myForm.value.role)
      );
      let user: any = {
        name: myForm.value.name,
        age: myForm.value.age,
        phone: myForm.value.phone,
        address: myForm.value.address,
        email: myForm.value.email,
        userName: myForm.value.userName,
        password: myForm.value.password,
        role: selectedRole,
      };
      if (!this.id) {
        this.usersService.postUser(user).subscribe({
          next: (v) => console.log(v),
          error: (e) => console.error(e),
          complete: () => this.router.navigate(['/users']),
        });
      } else {
        user.id = this.id;
        this.usersService.putUser(user, this.id).subscribe({
          next: (v) => console.log(v),
          error: (e) => console.error(e),
          complete: () => this.router.navigate(['/users']),
        });
      }
    }
  }

  onCancel(): void {
    this.router.navigate(['/users']);
  }

  getRoles(): void {
    this.roleService.getAll().subscribe((res) => {
      this.roles = res;
    });
  }

  getUser(id: number): void {
    this.usersService.getUserById(id).subscribe((res) => {
      this.user = res;
      this.myForm.patchValue({
        name: res.name,
        age: res.age,
        phone: res.phone,
        address: res.address,
        email: res.email,
        userName: res.userName,
        role: res.role.id,
      });
    });
  }
}
