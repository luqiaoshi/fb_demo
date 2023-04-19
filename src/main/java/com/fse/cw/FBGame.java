package com.fse.cw;
import java.util.ArrayList;
import java.util.Date;
public class FBGame {
    private Date gameTime;
    private String gameVenue;
    private int maxPlayerNumber;
    private FBTeam gameTeam1;
    private FBTeam gameTeam2;
    private FBTeam waitList;

    public FBGame() {
        gameTime = new Date();
        gameVenue = "TBD";
        maxPlayerNumber = 0;
        gameTeam1 = new FBTeam();
        gameTeam2 = new FBTeam();
        waitList = new FBTeam();
    }

    public FBGame(Date gameTime,String gameVenue,int maxPlayerNumber) {
        if (isTimeValid())
            setGameTime(gameTime);
        if (isVenueValid())
            setGameVenue(gameVenue);
        setMaxPlayerNumber(maxPlayerNumber);
        gameTeam1 = new FBTeam();
        gameTeam2 = new FBTeam();
        waitList = new FBTeam();
    }

    public Date getGameTime() {
        return gameTime;
    }
    public String getGameVenue() { return gameVenue; }
    public int getMaxPlayerNumber() { return maxPlayerNumber; }
    public FBTeam getGameTeam1(){return gameTeam1;}
    public FBTeam getGameTeam2(){return gameTeam2;}
    public FBTeam getWaitList(){return waitList;}
    public void setGameTime(Date gameTime) {
        if (isTimeValid())
            this.gameTime = gameTime;
    }
    public void setGameVenue(String gameVenue) {
        if (isVenueValid())
            this.gameVenue = gameVenue;
    }
    public void setMaxPlayerNumber(int maxPlayerNumber) {
        if (isPlayerNumValid())
            this.maxPlayerNumber = maxPlayerNumber;
    }

    public void setGameTeam1(FBTeam gameTeam1){
        this.gameTeam1 = gameTeam1;
    }
    public void setGameTeam2(FBTeam gameTeam2){
        this.gameTeam2 = gameTeam2;
    }
    public void addPlayer(FBPlayer fbPlayer){
        this.waitList.addTeamMemberToList(fbPlayer);
    }
    public boolean isTimeValid() {
        return this.gameTime == null;
    }
    public boolean isVenueValid() {
        return this.gameVenue == null;
    }
    public boolean isPlayerNumValid() {
        return this.maxPlayerNumber == 0;
    }

    public void getGameInfo(){
        System.out.println("Time is "+this.getGameTime() + ", venue is " + this.getGameVenue());
        System.out.println("Team 1 color is "+this.getGameTeam1().getTeamColor());
        String memberInfo1 = this.getGameTeam1().toString();
        System.out.println(memberInfo1);
        System.out.println("Team 2 color is "+this.getGameTeam2().getTeamColor());
        String memberInfo2 = this.getGameTeam2().toString();
        System.out.println(memberInfo2);
    }
}
