import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ComplaintService } from 'src/app/services/complaint.service';

@Component({
  selector: 'app-update-complaint',
  templateUrl: './update-complaint.component.html',
  styleUrls: ['./update-complaint.component.css']
})
export class UpdateComplaintComponent implements OnInit {

  complaintDetails = {
    id: 0,
    heading: '',
    description: '',
    addLine1: '',
    issueDate:'',
    addLine2: '',
    district: '',
    pin: '',
    state:'',
    progressLevel: 0,
    progressDescription: '',
  };

  disable = true;
  isComplaintUpdate = true;
  errorMsg = '';
  complaintId=0;

  constructor(private activatedroute: ActivatedRoute, private complaintService: ComplaintService) { }

  ngOnInit(): void {

    this.complaintId = Number(this.activatedroute.snapshot.paramMap.get("id"))
    console.log(this.complaintId)

    this.complaintService.getSearchComplaints(this.complaintId).subscribe(
      (response:any) => {
        // console.log(response);
        this.complaintDetails.id = response.id;
        this.complaintDetails.heading = response.heading;
        this.complaintDetails.description = response.description;
        this.complaintDetails.issueDate = response.issueDate;
        this.complaintDetails.addLine1 = response.addressDetail.addLine1;
        this.complaintDetails.addLine2 = response.addressDetail.addLine2;
        this.complaintDetails.pin = response.addressDetail.pin;
        this.complaintDetails.state = response.addressDetail.state;
        this.complaintDetails.district = response.addressDetail.district;

        this.complaintDetails.progressLevel = response.progressLevel;
        this.complaintDetails.progressDescription = response.progressDescription;

        console.log(this.complaintDetails);
      },
      (error:any) =>  {
        console.log(error);
      }
    );


  }

  change(){
    this.disable = !this.disable;
  }

  onSubmit(){
    console.log("form is submitted");
    this.complaintService.updateComplaint(this.complaintDetails, this.complaintId).subscribe(
      (response:any) => {
        console.log(response);
        window.location.href="/view-complaints";
      },
      error => {
        console.log(error);
      }
    );
  }
}
