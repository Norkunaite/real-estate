import { Component, OnInit } from '@angular/core';
import { LandPayload } from '../land-payload';
import { LandService } from '../land-service.service';

@Component({
  selector: 'app-land-card',
  templateUrl: './land-card.component.html',
  styleUrls: ['./land-card.component.css']
})
export class LandCardComponent implements OnInit {

  lands:LandPayload[]=[];

  constructor(private landService: LandService) { }

  ngOnInit(): void {
    this.getAllLands();
  }

  getAllLands(){
    this.landService.getAllLands().subscribe(lands=>{this.lands=lands; console.log(lands)});
  }

  

}
