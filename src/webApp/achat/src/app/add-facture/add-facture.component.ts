import { Component, OnInit } from '@angular/core';
import { FactureService } from '../facture.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-add-facture',
  templateUrl: './add-facture.component.html',
  styleUrls: ['./add-facture.component.css']
})
export class AddFactureComponent implements OnInit {

  newfacture: {
    montantRemise: number;
    montantFacture: number;
    dateCreationFacture: Date;
  } =
  {
    montantRemise : 0,
    montantFacture : 0,
    dateCreationFacture : new Date()

  }
  ;

  constructor(private _factureService : FactureService ,private _location: Location ) { }

  ngOnInit(): void {

    this.newfacture.montantFacture = 0
    this.newfacture.montantFacture = 0
  }

  OnSubmit(){
    this.newfacture.dateCreationFacture = new Date()

    console.log(this.newfacture);

    this._factureService.addFacture(this.newfacture).subscribe(
    (res) => {
      this._location.back()
    }

    )
  }

}
