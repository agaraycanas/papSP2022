import { Component, OnInit } from '@angular/core';
import { Pais } from '../pais';
import { PaisService } from '../pais.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {

  paises: Pais[] = [];

  constructor(public paisService: PaisService) { }

  ngOnInit(): void {
    this.paisService.getAll().subscribe(
      (data) => {
        this.paises = data._embedded.paises;
        console.log(this.paises)
      }
    );
  }

  deletePais(id: number) {
    this.paisService.delete(id).subscribe(
      res => {
        this.paises = this.paises.filter(item => item.id !== id);
        console.log('Pais borrado con éxito');
      }
    )
  }
}
