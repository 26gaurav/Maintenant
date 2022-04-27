import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  loginData = {
    role: '',
    username: '',
    password: '',
  };

  constructor( private snack: MatSnackBar, private LoginService: LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  formSubmit(){

    console.log("Login button clicked");

    if (
      this.loginData.username.trim() == '' || this.loginData.username == null
    ) {
      this.snack.open('Username is required !! ', '', {
        duration: 3000,
      });
      return;
    }

    if (
      this.loginData.password.trim() == '' || this.loginData.password == null
    ) {
      this.snack.open('Password is required !! ', '', {
        duration: 3000,
      });
      return;
    }

    //authenticate: loginService
    this.LoginService.authenticate(this.loginData).subscribe(
      (data: any) => {
        //success
        this.LoginService.setUser(data);
        console.log("Login successful");
        alert('success');

        if(this.loginData.role=== "admin"){

          window.location.href="/admin";
          //this.router.navigate(['admin']);
        }else if(this.loginData.role=== "user"){

          window.location.href="/user-dashboard";
          //this.router.navigate(['user-dashboard']);
        }else{

        }
      },
      (error) => {
        alert("Wrong Credentials!!!!")
        console.log(error);
        this.snack.open(error.error.text, '', {
          duration: 3000,
        });
      }
    );

  }

}
