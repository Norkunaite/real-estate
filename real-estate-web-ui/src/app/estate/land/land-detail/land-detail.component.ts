import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LandPayload } from '../land-payload';
import { LandService } from '../land-service.service';

@Component({
  selector: 'app-land-detail',
  templateUrl: './land-detail.component.html',
  styleUrls: ['./land-detail.component.css']
})
export class LandDetailComponent implements OnInit {

  land={
    "id": 0,
  "estate": {
      "action": '',
      "price": 0,
      "decription": ''
  },
  "address": {
      "districtMunicipality": '',
      "town": '',
      "microdistrict": '',
      "street": ''
  },
  "landArea": 0
  }


  constructor(private route: ActivatedRoute, private landService: LandService) {

   }

  ngOnInit(): void {
    this.getLand();
    console.log('this is land')
    console.log(this.land)

  }

  getLand() {
    const id=this.route.snapshot.params['id'];
    this.landService.getLandById(id).subscribe(land=>{this.land=land; console.log(land)});
  }

}
