package java_fundamentals.oop.inheritance;

public class StudentEmployee extends Student{

    private double rateOfThePayPerHour;
    private String employeeId;

    public StudentEmployee(String firstName, String lastName, double rateOfThePayPerHour, String employeeId, String studentId) {
        super(firstName, lastName, studentId);
        this.rateOfThePayPerHour = rateOfThePayPerHour;
        this.employeeId = employeeId;
    }

    public double getRateOfThePayPerHour() {
        return rateOfThePayPerHour;
    }

    public void setRateOfThePayPerHour(double rateOfThePayPerHour) {
        this.rateOfThePayPerHour = rateOfThePayPerHour;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return super.toString() + " StudentEmployee{" +
                "rateOfThePayPerHour=" + rateOfThePayPerHour +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}
