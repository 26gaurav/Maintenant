import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ComplaintService } from 'src/app/services/complaint.service';

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
  selector: 'app-view-complaints',
  templateUrl: './view-complaints.component.html',
  styleUrls: ['./view-complaints.component.css']
})
export class ViewComplaintsComponent implements OnInit {

  constructor(private complaintService: ComplaintService) { }

  ngOnInit(): void {

    this.getAllComplaints();
  }

  ELEMENT_DATA!: Complaint[];
  displayedColumns: string[] = ['heading', 'description', 'addLine1' , 'district', 'state', 'pin' ,'progressLevel', 'action'];
  dataSource = new MatTableDataSource<Complaint>(this.ELEMENT_DATA);

  public getAllComplaints(){

    //generate the id from the session storage
    var x= JSON.parse(localStorage.getItem('user') || "")
    var userId= x.id;
    console.log(userId)


    let response = this.complaintService.getComplaints(userId);

    response.subscribe(complaint => this.dataSource.data = complaint as Complaint[]);
  }

  public delete(complaintId: number){
    console.log(complaintId)

    this.complaintService.delete(complaintId).subscribe(
      (data: any) => {
        //success
        console.log(data);
        alert('Successfully deleted');
        window.location.href="/view-complaints";
      },
      (error) => {
        //error
        console.log(error);
        alert('something went wrong');
      }
    );
  }

}
