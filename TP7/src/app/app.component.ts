import { Component } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Employee } from './employee';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angularProject';
  
  name : string = '';
  listEmployees : Employee[];
  employee : Employee = new Employee();
  filedsEmpty: boolean = false;


  constructor( private httpClient:HttpClient ){}
  onNameKeyUp(event:any)
  {
    this.name = event.target.value;
  
  }
  getData()
  {

    this.httpClient.get('/rest/employees/list').subscribe((res: Employee[]) => {
    
    this.listEmployees = res;
  
      });
    
  }

  onSubmit() {
    if(!this.employee.name || !this.employee.department){
        this.filedsEmpty = true;
        return;
    }
    
    this.filedsEmpty = false;
    this.httpClient.post<Employee>('/rest/employees/add', {name : this.employee.name, department: this.employee.department}).subscribe((res) => {
     alert("Information ajouté");
      });
      
  }


  
}
