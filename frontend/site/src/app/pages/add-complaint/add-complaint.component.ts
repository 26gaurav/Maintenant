import { Component, OnInit } from '@angular/core';
import { ComplaintService } from 'src/app/services/complaint.service';

@Component({
  selector: 'app-add-complaint',
  templateUrl: './add-complaint.component.html',
  styleUrls: ['./add-complaint.component.css']
})
export class AddComplaintComponent implements OnInit {

  complaintDetails = {
    heading: '',
    description: '',
    addLine1: '',
    addLine2: '',
    district: '',
    pin: '',
    state:'',
    progressLevel: 0,
    progressDescription: '',
  };

  constructor(private complaintService: ComplaintService) { }

  ngOnInit(): void {
  }

  onSubmit(){
    console.log("Comlaint add form is submitted")

    //generate the id from the session storage
    var x= JSON.parse(localStorage.getItem('user') || "")
    var userId= x.id;
    console.log(userId)


    //addUser: userservice
    this.complaintService.addComplaint(this.complaintDetails, userId).subscribe(
      (data: any) => {
        //success
        console.log(data);
        alert('success');
      },
      (error) => {
        //error
        console.log(error);
        alert('something went wrong');
      }
    );
  }

}
