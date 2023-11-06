import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListFactureComponent } from './list-facture/list-facture.component';
import { AddFactureComponent } from './add-facture/add-facture.component';

const routes: Routes = [
  {path : "" , component : ListFactureComponent},
  {path : "addfacture" , component : AddFactureComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
