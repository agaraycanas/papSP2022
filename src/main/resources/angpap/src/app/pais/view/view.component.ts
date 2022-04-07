import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PaisService } from '../pais.service';
import { Pais } from '../pais';
  
@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
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
      
    this.paisService.find(this.id).subscribe((data)=>{
      this.pais= data._embedded;
    });
  }
  
}