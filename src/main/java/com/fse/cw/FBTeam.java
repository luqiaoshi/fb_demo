package com.fse.cw;

import java.util.ArrayList;

public class FBTeam {
    private ArrayList<FBPlayer> teamList;
    private String teamColor;

    public FBTeam() {
        teamList = new ArrayList<FBPlayer>();
        teamColor = "White";
    }

    public void setTeamList(ArrayList<FBPlayer> teamList) {
        if (this.teamList == null)
            this.teamList = teamList;
    }

    public void setTeamColor(String teamColor){
        this.teamColor = teamColor;
    }

    public String getTeamColor(){return this.teamColor;}
    public void addTeamMemberToList(FBPlayer teamMember) {
        this.teamList.add(teamMember);
    }
    public void removeTeamMemberFromList(FBPlayer teamMember) {
        this.teamList.remove(teamMember);
    }

    public ArrayList<FBPlayer> getTeamList() {
        return teamList;
    }


    @Override
    public String toString() {

        String member = "Team Members: ";
        if (getTeamList().size()==0){
            member+="None";
        }
        for (int i = 0; i < getTeamList().size(); i++) {
            member += "[" + i + "]: " + getTeamList().get(i).getPersonName() + "\n";
        }

        return   member ;
    }
}
