import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateComponent } from './create/create.component';
import { EditComponent } from './edit/edit.component';
import { IndexComponent } from './index/index.component';
import { ViewComponent } from './view/view.component';

const routes: Routes = [
  //{path: '', component: IndexComponent },
  {path: ':paisId/view',  component: ViewComponent },
  {path: 'create',  component: CreateComponent },
  {path: ':paisId/edit',  component: EditComponent },
  {path: '', component: IndexComponent},
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class  PaisRoutingModule { }
