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
  selector: 'app-admin-complaints',
  templateUrl: './admin-complaints.component.html',
  styleUrls: ['./admin-complaints.component.css']
})
export class AdminComplaintsComponent implements OnInit {

  constructor(private complaintService: ComplaintService) { }

  ngOnInit(): void {

    this.getAllComplaints();
  }

  ELEMENT_DATA!: Complaint[];
  displayedColumns: string[] = ['heading', 'description', 'addLine1' , 'district', 'state', 'pin' ,'progressLevel', 'action'];
  dataSource = new MatTableDataSource<Complaint>(this.ELEMENT_DATA);

  public getAllComplaints(){

    let response = this.complaintService.getAllComplaints();

    response.subscribe(complaint => this.dataSource.data = complaint as Complaint[]);
  }

  public updateProgress(complaint_id: number){
    console.log(complaint_id)

    this.complaintService.updateProgressAdmin(complaint_id).subscribe(
      (data: any) => {
        //success
        console.log(data);
        Swal.fire('Congratulations!!! The complaint is solved!!');
        window.location.href="/admin-complaints"
      },
      (error) => {
        //error
        console.log(error);
        alert('something went wrong!');
      }
    );
  }

}
