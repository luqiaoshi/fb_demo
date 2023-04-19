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

    public FBPlayer(String personName, int personID, String personGender) {
        if (isNameValid())
            setPersonName(personName);
        setPersonID(personID);
        setPersonGender(personGender);
    }


    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        if (isNameValid())
            this.personName = personName;
    }

    public String getPersonGender() {
        return personGender;
    }

    public void setPersonGender(String personGender) {
        if (isGenderValid())
            this.personGender = personGender;
    }

    public int getPersonID() {
        return personID;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FBPlayer)) return false;

        FBPlayer fbPlayer = (FBPlayer) o;

        if (personID != fbPlayer.personID) return false;
        if (!personName.equals(fbPlayer.personName)) return false;
        return personGender.equals(fbPlayer.personGender);
    }

    @Override
    public int hashCode() {
        int result = personName.hashCode();
        result = 31 * result + personGender.hashCode();
        result = 31 * result + personID;
        return result;
    }

    @Override
    public String toString() {
        String info = "Player Information:\n";
        info = info + "Name: " + this.getPersonName() + "\n";
        info = info + "Gender: " + this.getPersonGender() + "\n";
        info = info + "ID: " + this.getPersonID() + "\n";
        return info;
    }
}
