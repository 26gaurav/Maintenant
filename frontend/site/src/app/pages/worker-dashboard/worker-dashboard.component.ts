import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ComplaintService } from 'src/app/services/complaint.service';
import Swal from 'sweetalert2';

export interface Complaint {
  heading: string;
  description: string;
  addLine1: string;
  addLine2: string;
  district: string;
  state: string;
  pin: string;
  progressLevel: number;
  progressDescription: string;
}

@Component({
  selector: 'app-worker-dashboard',
  templateUrl: './worker-dashboard.component.html',
  styleUrls: ['./worker-dashboard.component.css']
})
export class WorkerDashboardComponent implements OnInit {

  constructor(private complaintService: ComplaintService) { }

  ngOnInit(): void {
    this.getWorkerComplaints();
  }

  ELEMENT_DATA!: Complaint[];
  displayedColumns: string[] = ['heading', 'description', 'addLine1' , 'district', 'state', 'pin' ,'progressLevel', 'action'];
  dataSource = new MatTableDataSource<Complaint>(this.ELEMENT_DATA);
  firstname = ""
  workerId=0

  public getWorkerComplaints(){

    //generate the id from the session storage
    var x= JSON.parse(localStorage.getItem('user') || "")
    this.workerId= x.id;
    this.firstname= x.firstName;
    console.log(this.workerId)

    let response = this.complaintService.getWorkerComplaints(this.workerId);

    response.subscribe(complaint => this.dataSource.data = complaint as Complaint[]);

  }

  public updateProgress(complaintId: number){

    console.log(complaintId);
    console.log(this.workerId);

    this.complaintService.updateProgress(this.workerId,complaintId).subscribe(
      (data: any) => {
        //success
        console.log(data);
        Swal.fire('Congratulations!!! Your work is marked done for Admin approval!');
        window.location.href="/worker-dashboard"
      },
      (error) => {
        //error
        console.log(error);
        alert('something went wrong');
      }
    );

  }

}
