import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
import { ActivatedRoute, Router } from '@angular/router';
=======
import { PaisService } from '../pais.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Pais } from '../pais';
>>>>>>> 7a9bb6cea82952c26d1f9da30db7ff45fc322d11
import { FormGroup, FormControl, Validators} from '@angular/forms';
import { Pais } from '../pais';
import { PaisService } from '../pais.service';
   
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
<<<<<<< HEAD
    this.id = this.route.snapshot.params['postId'];
=======
    this.id = this.route.snapshot.params['paisId'];
>>>>>>> 7a9bb6cea82952c26d1f9da30db7ff45fc322d11
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
<<<<<<< HEAD
         console.log('Post updated successfully!');
         this.router.navigateByUrl('post/index');
=======
         console.log('País actualizado con éxito');
         this.router.navigateByUrl('pais/index');
>>>>>>> 7a9bb6cea82952c26d1f9da30db7ff45fc322d11
    })
  }
   
}