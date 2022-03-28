import { Component, OnInit } from '@angular/core';
import { PaisService } from '../pais.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Pais } from '../pais';
  
@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.scss']
})
export class ViewComponent implements OnInit {
   
  id!: number;
  pais!: Pais;
   
  constructor(
    public paisService: PaisService,
    private route: ActivatedRoute,
    private router: Router
   ) { }
  
  ngOnInit(): void {
    this.id = this.route.snapshot.params['paisId'];
      
    this.paisService.find(this.id).subscribe((data: Pais)=>{
      this.pais = data;
    });
  }
  
}