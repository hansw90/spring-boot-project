package vo;

import java.util.Objects;

public class EmployeePK {

    private int EmployeeNO;
    private int DepartNO;

    public EmployeePK(int employeeNO, int departNO) {
        EmployeeNO = employeeNO;
        DepartNO = departNO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeePK)) return false;
        EmployeePK that = (EmployeePK) o;
        return EmployeeNO == that.EmployeeNO &&
                DepartNO == that.DepartNO;
    }

    @Override
    public int hashCode() {
        return Objects.hash(EmployeeNO, DepartNO);
    }

    @Override
    public String toString() {
        return "EmployeePK{" +
                "EmployeeNO=" + EmployeeNO +
                ", DepartNO=" + DepartNO +
                '}';
    }
}
