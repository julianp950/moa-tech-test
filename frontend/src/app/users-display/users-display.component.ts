import { Component, OnInit } from '@angular/core';
import { User, UsersService } from '../users.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-users-display',
  templateUrl: './users-display.component.html',
  styleUrls: ['./users-display.component.scss'],
})
export class UsersDisplayComponent implements OnInit {
  users: User[] = [];
  permissions: any = {
    create: localStorage.getItem("create"),
    update: localStorage.getItem("update"),
    delete: localStorage.getItem("delete")
  }
  currentUser: number = Number(localStorage.getItem("userId"));

  constructor(private usersService: UsersService, private router: Router) {}

  ngOnInit() {
    this.getUsers();
  }

  editUser(id: number) {
    this.router.navigate([`/users/${id}`]);
  }

  getUsers(): void {
    this.usersService.getAll().subscribe((res) => {
      this.users = res;
    });
  }

  addNewUser(): void {
    this.router.navigate(['/users/new']);
  }

  deleteUser(id: number) {
    this.usersService.deleteUser(id);
  }
}
