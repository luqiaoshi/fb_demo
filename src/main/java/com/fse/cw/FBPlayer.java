package com.fse.cw;

public class FBPlayer {
    private String personName;
    private String personGender;  
    private int personID;

    public FBPlayer() {
        personName = null; 
        personGender = null;
        personID = 0;
    }

    public FBPlayer(String personName, int personID, String personGender ) {
        if (isNameValid())
            setPersonName(personName);
        setPersonID(personID);
        setPersonGender(personGender);
    }


    public String getPersonName() { return personName; }
    public String getPersonGender() { return personGender; } 

    public int getPersonID() { return personID; }

    public void setPersonName(String personName) {
        if (isNameValid())
            this.personName = personName;
    }
    public void setPersonGender(String personGender) {
        if (isGenderValid())
            this.personGender = personGender;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public boolean isNameValid() {
        return this.personName == null;
    }
    public boolean isGenderValid() {
        return this.personGender == null;
    }
 
    public boolean isIDValid() {
        return this.personID == 10000000;
    }

    @Override
    public String toString() {
        String info = "Player Information:\n";
        info = info + "Name: "+this.getPersonName() + "\n";
        info = info + "Gender: "+this.getPersonGender() + "\n";
        info = info + "ID: "+this.getPersonID() + "\n"; 
        return   info ;
    }
}
