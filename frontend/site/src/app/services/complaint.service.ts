import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class ComplaintService {

  constructor(private http: HttpClient) { }

  public addComplaint(complaint: any, userId: number) {
    return this.http.post(`${baseUrl}/lodgeComplaint/${userId}`, complaint);
  }

  getComplaints(userId: number){
   
    return this.http.get(`${baseUrl}/getAllComplaint/${userId}`);
  }

  getAllComplaints(){
   
    return this.http.get(`${baseUrl}/admin/getAllComplaints`);
  }

  public delete(complaintId : number){

    return this.http.get(`${baseUrl}/deleteComplaint/${complaintId}`);
  }

  getSearchComplaints(complaintId : number){
    
    return this.http.get(`${baseUrl}/getComplaint/${complaintId}`);
  }

  public updateComplaint(complaint: any, complaintId: number) {
    return this.http.post(`${baseUrl}/updateComplaint/${complaintId}`, complaint);
  }
}
