import { Component, OnInit } from '@angular/core';
import { WorkerService } from 'src/app/services/worker.service';
import { MatTableDataSource } from '@angular/material/table';

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
  selector: 'app-view-workers',
  templateUrl: './view-workers.component.html',
  styleUrls: ['./view-workers.component.css']
})

export class ViewWorkersComponent implements OnInit {

  constructor(private workerService: WorkerService) { }

  ngOnInit(): void {

    this.getAllWorkers();
  }

  ELEMENT_DATA!: Worker[];
  displayedColumns: string[] = ['fname', 'email', 'phone' , 'gender', 'username', 'addLine1' ,'district', 'organisation', 'action'];
  dataSource = new MatTableDataSource<Worker>(this.ELEMENT_DATA);

  public getAllWorkers(){

    let response = this.workerService.getWorkers();

    response.subscribe(worker => this.dataSource.data = worker as Worker[]);
  }

  public delete(workerId: number){
    console.log(workerId)

    this.workerService.delete(workerId).subscribe(
      (data: any) => {
        //success
        console.log(data);
        alert('If no pending work, worker gets deleted');
        window.location.href="/view-workers";
      },
      (error) => {
        //error
        console.log(error);
        alert('something went wrong');
      }
    );
  }

}
