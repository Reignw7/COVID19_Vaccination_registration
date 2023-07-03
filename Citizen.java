/*
Walker
Reign
4144021
CSC211 Practical 2
Citizen class
 */

public class Citizen {

    private String citizenID;
    private String citizenName;
    private String citizenSurname;
    private String citizenCellNumber;
    private int registrationDay;
    private int registrationMonth;
    private int registrationYear;

    public Citizen(String citizenID, String citizenName, String citizenSurname, String citizenCellNumber, int registrationDay,int registrationMonth, int registrationYear){
            citizenID = null;
            citizenName = null;
            citizenSurname = null;
            registrationDay = 0;
            registrationMonth = 0;
            registrationYear = 0;

    }

    public Citizen() {

    }


    public String getCitizenID(){
      return citizenID;
    };
    public String getCitizenName(){
        return citizenName;
    };
    public String getCitizenSurname(){
        return citizenSurname;
    };
    public String getCitizenCellNumber(){
        return citizenCellNumber;
    };

    public int getRegistrationDay(){
      return registrationDay;
    };
    public int getRegistrationMonth(){
        return registrationMonth;
    };
    public int getRegistrationYear(){
        return registrationYear;
    };

    public void setCitizenID(String citizenID){
        this.citizenID = citizenID;
    };
    public void setCitizenName(String citizenName){
        this.citizenName = citizenName;
    };
    public void setCitizenSurname(String citizenSurname){
        this.citizenSurname = citizenSurname;
    };
    public void setCitizenCellNumber(String citizenCellNumber){
        this.citizenCellNumber = citizenCellNumber;
    };
    public void setRegistrationDay(int registrationDay1){
        this.registrationDay = registrationDay1;
    };
    public void setRegistrationMonth(int registrationMonth1){
        this.registrationMonth = registrationMonth1;
    };
    public void setRegistrationYear(int registrationYear1){
        this.registrationYear = registrationYear1;
    };








}
