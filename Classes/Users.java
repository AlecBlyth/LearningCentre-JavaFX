package BunnyCorp.Classes;

public class Users<T> implements java.io.Serializable {

    private int userID;
    private String user;
    private String pass;
    private String firstName;
    private String secondName;
    private String fullName;
    private String Address;
    private String Town;
    private String PostCode;
    private String PhoneNum;
    private String DOB;
    private T Type;

    public Users(int ID, String userName, String passWord, String firName, String secName, String userAddress, String userTown, String userPost, String userNum, String userDOB, T userType) {
        user = userName;
        pass = passWord;
        userID = ID;
        firstName = firName;
        secondName = secName;
        fullName = firName + " " + secName;
        Address = userAddress;
        Town = userTown;
        PostCode = userPost;
        PhoneNum = userNum;
        DOB = userDOB;
        Type = userType;
    } //Adds Attributes

    public String getUser() {
        return user;
    } //Gets Username

    public String getPass() {
        return pass;
    } //Gets Password

    public int getUserID() {
        return userID;
    } //Gets User ID

    public String getFirstName() {
        return firstName;
    } //Gets first name

    public String getSecondName() {
        return secondName;
    } //Gets second name

    public String getFullName() {
        return fullName;
    } //Gets first and second name to create full name

    public String getAddress() {
        return Address;
    } //Gets address

    public String getTown() {
        return Town;
    } //Gets town or city

    public String getPostCode() {
        return PostCode;
    } //Gets postcode

    public String getPhoneNum() {
        return PhoneNum;
    } //Gets phone number

    public String getDOB() {
        return DOB;
    } //Gets date of birth

    public void set(T Type) {
        this.Type = Type;
    } //Sets usertype to Type

    public T getType() {
        return Type;
    } //Gets usertype

    public void setUser(String user) {
        this.user = user;
    }  //Sets username - used for editing profile

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    } //Sets firstname  - used for editing profile

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    } //Sets second name  - used for editing profile

    public void setAddress(String address) {
        Address = address;
    } //Sets address  - used for editing profile

    public void setTown(String town) {
        Town = town;
    } //Sets town or city  - used for editing profile

    public void setPostCode(String postCode) {
        PostCode = postCode;
    } //Sets postcode  - used for editing profile

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    } //sets phone number  - used for editing profile

    public void setPass(String pass) {
        this.pass = pass;
    } //Sets password  - used for editing profile

    public void setDOB(String DOB) {
        this.DOB = DOB;
    } // Sets DOB  - used for editing profile

    public void setType(T type) {
        Type = type;
    } //Sets usertype  - used for editing profile
}