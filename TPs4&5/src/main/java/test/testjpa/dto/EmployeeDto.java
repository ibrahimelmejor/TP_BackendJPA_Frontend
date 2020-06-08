package test.testjpa.dto;

public class EmployeeDto {
    private String name;
    private String department;

    public EmployeeDto() {
    }

    public EmployeeDto(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}
