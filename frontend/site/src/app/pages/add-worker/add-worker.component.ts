import { Component, OnInit } from '@angular/core';
import { WorkerService } from 'src/app/services/worker.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-worker',
  templateUrl: './add-worker.component.html',
  styleUrls: ['./add-worker.component.css']
})
export class AddWorkerComponent implements OnInit {

  worker = {
    fname: '',
    lname: '',
    email:'',
    phone:'',
    age:0,
    gender:'',
    username:'',
    addLine1: '',
    addLine2: '',
    district: '',
    pin: '',
    state:'',
    organisation:'',
    password:''
  };

  constructor(private workerService : WorkerService,private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    console.log("Worker add form is submitted")

    //addUser: userservice
    this.workerService.addWorker(this.worker).subscribe(
      (data: any) => {
        //success
        console.log(data);
        Swal.fire('Worker successfully added!!!');
        //alert('Worker Successfully added');
        this.router.navigate(['crud-workers']);
      },
      (error) => {
        //error
        console.log(error);
        alert('something went wrong!!!');
      }
    );
  }

}
