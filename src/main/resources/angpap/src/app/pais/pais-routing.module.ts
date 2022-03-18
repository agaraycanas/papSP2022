import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateComponent } from './create/create.component';
import { EditComponent } from './edit/edit.component';
import { IndexComponent } from './index/index.component';
import { ViewComponent } from './view/view.component';

const routes: Routes = [
  {path: 'pais', redirectTo: 'pais/index', pathMatch: 'full'},
  {path: 'pais/index', component: IndexComponent },
  {path: 'pais/:paisId/view',  component: ViewComponent },
  {path: 'pais/create',  component: CreateComponent },
  {path: 'pais/:paisId/edit',  component: EditComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PaisRoutingModule { }
