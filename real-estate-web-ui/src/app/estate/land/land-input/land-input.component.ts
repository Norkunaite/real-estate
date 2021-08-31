import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { LandService } from '../land-service.service';


@Component({
  selector: 'app-land-input',
  templateUrl: './land-input.component.html',
  styleUrls: ['./land-input.component.css']
})
export class LandInputComponent implements OnInit {

  estateRegisterForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private landService: LandService) {
    this.estateRegisterForm = this.formBuilder.group({
      id: [''],
      estate: this.formBuilder.group({
        action: [''],
        price: [''],
        decription: ['']
      }),
      address: this.formBuilder.group({
        districtMunicipality: [''],
        town: [''],
        microdistrict: [''],
        street: ['']
      }),
      landArea: ['']
    });
  }

  ngOnInit(): void {
  }




  onSubmit() {
    let land = this.estateRegisterForm.value;
    console.log(land)
    this.landService.createLand(land).subscribe(res=>console.log(res));

  }

}
