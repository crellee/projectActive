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
    private double rating;
    private String businessName;
    private String getSellerRequest;
    private String sellerEmailReq;
    private String sellerJobDescription;
    private String buyerAccept;
    private String buyerAcceptStr;
    private int sellerRated;
    private int buyerRated;

    public Task()
    {

    }
    public Task(String jobDescription, String location, String city, String requiredQualification, String salary,
                String fromDate, String toDate, int numOfDays, int numberOfHours, int cellNumber, String businessEmail,
                double rating, String businessName, String getSellerRequest, String sellerEmailReq, String sellerJobDescription,
                String buyerAccept, String buyerAcceptStr, int sellerRated, int buyerRated)
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
        this.rating = rating;
        this.businessName = businessName;
        this.getSellerRequest = getSellerRequest;
        this.sellerEmailReq = sellerEmailReq;
        this.sellerJobDescription = sellerJobDescription;
        this.buyerAccept = buyerAccept;
        this.buyerAcceptStr = buyerAcceptStr;
        this.sellerRated = sellerRated;
        this.buyerRated = buyerRated;

    }

    public int getSellerRated() {
        return sellerRated;
    }

    public void setSellerRated(int sellerRated) {
        this.sellerRated = sellerRated;
    }

    public int getBuyerRated() {
        return buyerRated;
    }

    public void setBuyerRated(int buyerRated) {
        this.buyerRated = buyerRated;
    }

    public String getBuyerAcceptStr() {
        return buyerAcceptStr;
    }

    public void setBuyerAcceptStr(String buyerAcceptStr) {
        this.buyerAcceptStr = buyerAcceptStr;
    }

    public String getBuyerAccept() {
        return buyerAccept;
    }

    public void setBuyerAccept(String buyerAccept) {
        this.buyerAccept = buyerAccept;
    }

    public String getSellerJobDescription() {
        return sellerJobDescription;
    }

    public void setSellerJobDescription(String sellerJobDescription) {
        this.sellerJobDescription = sellerJobDescription;
    }

    public String getSellerEmailReq() {
        return sellerEmailReq;
    }

    public void setSellerEmailReq(String sellerEmailReq) {
        this.sellerEmailReq = sellerEmailReq;
    }

    public String getGetSellerRequest() {
        return getSellerRequest;
    }

    public void setGetSellerRequest(String getSellerRequest) {
        this.getSellerRequest = getSellerRequest;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
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
