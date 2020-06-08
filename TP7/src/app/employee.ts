export class Employee 
{
    id : number;
    name : string;
    department : string;
    constructor();
    
    constructor( id?: number, name?: string, department?: string){
        this.id = id;
        this.name = name;
        this.department = department;
    }
}
