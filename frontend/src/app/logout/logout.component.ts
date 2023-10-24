import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.scss']
})
export class LogoutComponent {
  constructor (private router: Router) {}

  ngOnInit() {
    localStorage.removeItem('userId');
    localStorage.removeItem('token');
    localStorage.removeItem('userFullName');
    localStorage.removeItem('create');
    localStorage.removeItem('update');
    localStorage.removeItem('delete');
    this.router.navigate(['/login']);
  }
}
