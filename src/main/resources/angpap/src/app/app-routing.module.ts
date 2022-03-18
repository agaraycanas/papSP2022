import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './pais/index/index.component';
import { PaisRoutingModule } from './pais/pais-routing.module';
import { PaisModule } from './pais/pais.module';

const routes: Routes = [
  { path:'pais', 
    loadChildren: () => import('./pais/pais.module').then(m=>m.PaisModule)
  },
  { path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
