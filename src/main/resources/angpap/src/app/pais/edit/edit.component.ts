import { Component, OnInit } from '@angular/core';
import { PaisService } from '../pais.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Pais } from '../pais';
import { FormGroup, FormControl, Validators} from '@angular/forms';
   
@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {
    
  id!: number;
  pais!: Pais;
  form!: FormGroup;
  
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
    
    this.form = new FormGroup({
      title: new FormControl('', [Validators.required]),
      body: new FormControl('', Validators.required)
    });
  }
   
  get f(){
    return this.form.controls;
  }
     
  submit(){
    console.log(this.form.value);
    this.paisService.update(this.id, this.form.value).subscribe(res => {
         console.log('País actualizado con éxito');
         this.router.navigateByUrl('pais/index');
    })
  }
   
}