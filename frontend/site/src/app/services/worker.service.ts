import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class WorkerService {

  constructor(private http: HttpClient) { }

  public addWorker(worker: any) {
    return this.http.post(`${baseUrl}/admin/addWorker/`, worker);
  }

  public getWorkers(){
   
    return this.http.get(`${baseUrl}/admin/getAllWorkers`);
  }

  public delete(workerId : number){

    return this.http.get(`${baseUrl}/admin/${workerId}/deleteWorker`);
  }

  public map(complaint_id: number, worker_id: number){
    return this.http.get(`${baseUrl}/admin/${worker_id}/${complaint_id}/complaintMapping`);
  }
}
