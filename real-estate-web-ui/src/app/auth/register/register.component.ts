import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthService } from '../auth.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private authService: AuthService) {
    this.registerForm = this.formBuilder.group({
      username: [''],
      email: [''],
      password: [''],
      confirmPassword: ['']

    });
  }

  ngOnInit(): void {
  }

  createUser() {
    let user = this.registerForm.value;
    this.authService.signup(user).subscribe(res=>console.log(res));
  }

  onSubmit() {
    this.createUser();
  }

}
