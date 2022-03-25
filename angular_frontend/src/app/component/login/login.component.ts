import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  currentuser:User=new User();

  responseData:any;
  constructor(private authService:AuthService,private router:Router) { }

  ngOnInit(): void {
  }

  login(){
    this.authService.login(this.currentuser).subscribe((result)=>{
      if(result!=null){
       this.responseData=result;
       localStorage.setItem('token',this.responseData.jwtToken);
       localStorage.setItem("roles",JSON.stringify(this.responseData.user.roles));
       if(this.responseData.user.roles[0].roleName=="Admin"){
         this.router.navigate(['/admin'])  
       }else{
         
         this.router.navigate(['/user'])
       }
      
      }
    }
    );
  }
  
  
  
}
