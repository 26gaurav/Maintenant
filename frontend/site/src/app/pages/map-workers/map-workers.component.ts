import { Component, OnInit } from '@angular/core';
import { WorkerService } from 'src/app/services/worker.service';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';
import { ConstantPool } from '@angular/compiler';

export interface Worker {
  fname: string,
  lname: string,
  email: string,
  phone:string,
  age:number,
  gender:string,
  username: string,
  addLine1: string,
  addLine2: string,
  district: string,
  pin:string,
  state:string,
  organisation:string,
}

@Component({
  selector: 'app-map-workers',
  templateUrl: './map-workers.component.html',
  styleUrls: ['./map-workers.component.css']
})
export class MapWorkersComponent implements OnInit {

  constructor(private activatedroute: ActivatedRoute,private workerService: WorkerService) { }

  ngOnInit(): void {
    this.getAllWorkers();
  }

  ELEMENT_DATA!: Worker[];
  displayedColumns: string[] = ['fname', 'email', 'phone' , 'gender', 'username', 'addLine1' ,'district', 'organisation', 'action'];
  dataSource = new MatTableDataSource<Worker>(this.ELEMENT_DATA);
  complaintId=0;

  public getAllWorkers(){

    let response = this.workerService.getWorkers();

    response.subscribe(worker => this.dataSource.data = worker as Worker[]);
  }

  public map(workerid : number){
    this.complaintId = Number(this.activatedroute.snapshot.paramMap.get("id"))
    console.log(this.complaintId)
    console.log(workerid);

    this.workerService.map(this.complaintId, workerid).subscribe(
      (response:any) => {
        console.log(response);
        Swal.fire('Successfully mapping done !!');
      },
      error => {
        console.log(error);
        alert("Worker already mapped to given complaint")
      }
    );
  }

  public done(){
    window.location.href="/admin-complaints";
  }

}
