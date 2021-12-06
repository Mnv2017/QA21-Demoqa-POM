package com.telran.demoqa.data;

public class StData {
    public static final String FIRST_NAME = "Maria";
    public static final String LAST_NAME = "Marinina";
    public static final String EMAIL = "maria@gmail.com";
    public static final String PHONE = "987654321";
    public static final String GENDER = "Female";
    public static final String B_DAY = "23 May 1985";
    public static final String[] SUBJECTS = {"Maths", "Chemistry", "English"};
    public static final String[] HOBBIES = {"Reading", "Music"};
    public static final String FILE = "/Users/nataliamorgel/Tools/Sneginka.jpeg";
    public static final String ADDRESS = "Tortuga";
    public static final String STATE = "NCR";
    public static final String CITY = "Noida";

    public static final String FIRST_NAME_TWO = "Svetlana";
    public static final String LAST_NAME_TWO = "Svetlanina";

    private String firstName; //0
    private String lastName; //1
    private String email; // 2
    private String phone; // 3
    private String gender; // 4
    private String bDay; // 5
    private String[] subjects; // 6
    private String[] hobbies; // 7
    private String file; // 8
    private String address; // 9
    private String state;  // 10
    private String city; // 11

    public StData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public StData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public StData setEmail(String email) {
        this.email = email;
        return this;
    }

    public StData setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public StData setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public StData setBDay(String bDay) {
        this.bDay = bDay;
        return this;
    }

    public StData setSubjects(String[] subjects) {
        this.subjects = subjects;
        return this;
    }

    public StData setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    public StData setFile(String file) {
        this.file = file;
        return this;
    }

    public StData setAddress(String address) {
        this.address = address;
        return this;
    }

    public StData setState(String state) {
        this.state = state;
        return this;
    }

    public StData setCity(String city) {
        this.city = city;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getbDay() {
        return bDay;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public String getFile() {
        return file;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}
