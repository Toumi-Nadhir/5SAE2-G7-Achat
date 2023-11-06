import { Component, OnInit } from '@angular/core';
import { FactureService } from '../facture.service';

@Component({
  selector: 'app-list-facture',
  templateUrl: './list-facture.component.html',
  styleUrls: ['./list-facture.component.css']
})
export class ListFactureComponent implements OnInit {

  facturelist : any[] = []


  constructor(private _factureService : FactureService) { }

  ngOnInit(): void {

    this._factureService.getFactures().subscribe(
      (res) => {
          this.facturelist = res
      }
    )

  }

}
