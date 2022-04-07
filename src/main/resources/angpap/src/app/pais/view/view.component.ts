import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
import { ActivatedRoute, Router } from '@angular/router';
import { PaisService } from '../pais.service';
=======
import { PaisService } from '../pais.service';
import { ActivatedRoute, Router } from '@angular/router';
>>>>>>> 7a9bb6cea82952c26d1f9da30db7ff45fc322d11
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
      
<<<<<<< HEAD
    this.paisService.find(this.id).subscribe((data)=>{
      this.pais= data._embedded;
=======
    this.paisService.find(this.id).subscribe((data: Pais)=>{
      this.pais = data;
>>>>>>> 7a9bb6cea82952c26d1f9da30db7ff45fc322d11
    });
  }
  
}