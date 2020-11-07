package vo;

public class EmployeeVO {
    private int EmployeeNO;
    private int DepartNO;
    private String Name;
    private String Position;

    public EmployeeVO(int employeeNO, int departNO, String name, String position) {
        EmployeeNO = employeeNO;
        DepartNO = departNO;
        Name = name;
        Position = position;
    }




    @Override
    public String toString() {
        return "EmployeeVO{" +
                "EmployeeNO=" + EmployeeNO +
                ", DepartNO=" + DepartNO +
                ", Name='" + Name + '\'' +
                ", Position='" + Position + '\'' +
                '}';
    }
}
