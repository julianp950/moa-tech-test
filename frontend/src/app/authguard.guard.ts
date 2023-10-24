import { ActivatedRouteSnapshot, CanActivateChildFn, CanActivateFn, Router, RouterStateSnapshot } from '@angular/router';
import { LoginService } from './login.service';
import { inject } from '@angular/core';
import { catchError, map, of } from 'rxjs';

export const canActivate: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
) => {
  const authService = inject(LoginService);
  const router = inject(Router);

  let token: string = localStorage.getItem('token')!;

  return authService.checkIfLogged(token).pipe(
    map(res => res),
    catchError(() => {
      router.navigate(['login']);
      return of(false);
    })
  );
};

export const canActivateChild: CanActivateChildFn = (route: ActivatedRouteSnapshot, state: RouterStateSnapshot) => canActivate(route, state);