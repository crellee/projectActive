package Controller;

/**
 * Created by christianhasselstrom on 04/12/2015.
 */
public class Task {

    private String jobDescription;
    private String location;
    private String city;
    private String requiredQualification;
    private String salary;
    private String fromDate;
    private String toDate;
    private int numOfDays;
    private int numberOfHours;
    private int cellNumber;
    private String businessEmail;

    public Task()
    {

    }
    public Task(String jobDescription, String location, String city, String requiredQualification, String salary,
                String fromDate, String toDate, int numOfDays, int numberOfHours, int cellNumber, String businessEmail)
    {
        this.jobDescription = jobDescription;
        this.location = location;
        this.city = city;
        this.requiredQualification = requiredQualification;
        this.salary = salary;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.numOfDays = numOfDays;
        this.numberOfHours = numberOfHours;
        this.cellNumber = cellNumber;
        this.businessEmail = businessEmail;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRequiredQualification() {
        return requiredQualification;
    }

    public void setRequiredQualification(String requiredQualification) {
        this.requiredQualification = requiredQualification;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }
}
