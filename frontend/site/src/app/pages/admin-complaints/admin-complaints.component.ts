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

}
