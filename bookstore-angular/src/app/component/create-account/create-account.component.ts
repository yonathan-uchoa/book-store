import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.scss']
})
export class CreateAccountComponent implements OnInit{
  form!: FormGroup;
  constructor(
    private formBuilder: FormBuilder
) { }
  ngOnInit(): void {
    this.form = this.formBuilder.group({
      name:['', Validators.required],
      username:['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(50)]]
    })
  }

  get forms(){
    return this.form.controls;
  }

  onSubmit() {
    console.log(this.form)
    if(this.form.invalid){
      return;
    }
    console.log(this.form.value)
  }
}
