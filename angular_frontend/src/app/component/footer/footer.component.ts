import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  isLoggedIn = false;      

  constructor(private authService:AuthService) { }

  ngOnInit(): void {
    this.isLoggedIn = this.authService.IsLoggedIn();

  }

}
