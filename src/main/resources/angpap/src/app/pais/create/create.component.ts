import { Component, OnInit } from '@angular/core';
import { PaisService } from '../pais.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators} from '@angular/forms';
   
@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  
  form!: FormGroup;
   
  constructor(
    public paisService: PaisService,
    private router: Router
  ) { }
  
  ngOnInit(): void {
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
    this.paisService.create(this.form.value).subscribe(res => {
         console.log('Paśi creado con éxito');
         this.router.navigateByUrl('pais/index');
    })
  }
  
}