import { Component, OnInit } from '@angular/core';
import { Role } from 'src/app/model/role';
import { User } from 'src/app/model/user';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  newUser:User=new User();
  constructor(private authService:AuthService,private router:Router) { }

  roles:Role[]=[];
  ngOnInit(): void {
  }

  addUsers(){
    this.authService.SignUp(this.newUser).subscribe();
    this.router.navigate(['/login'])  

  }

}
