package com.fse.cw;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
public class FBApp {
    public static ArrayList<FBGame> footBallGames;
    public static ArrayList<FBPlayer> footBallPlayers;

    public static void main(String[] args) {
        footBallGames = new ArrayList<FBGame>();
        footBallPlayers = new ArrayList<FBPlayer>();
        footBallPlayers.add(new FBPlayer("Hawkeye", 20220101,"Male"));
        footBallPlayers.add(new FBPlayer("Black Widow", 20220801,"Male"));
        footBallPlayers.add(new FBPlayer("Iron Man", 20229756,"Male"));
        footBallPlayers.add(new FBPlayer("Thor", 20228842,"Male"));
        footBallPlayers.add(new FBPlayer("Captain America", 20220808,"Male"));
        footBallPlayers.add(new FBPlayer("Batman", 20234477,"Male"));
        footBallPlayers.add(new FBPlayer("Superman", 20239988,"Male"));
        footBallPlayers.add(new FBPlayer("Wonder Woman", 20233378,"Male"));
        footBallPlayers.add(new FBPlayer("Flash", 20231335,"Male"));
        Date curDate = new Date();
        FBGame fbGame = new FBGame(curDate,"outside football field",20);
        footBallGames.add(fbGame);
        DisplayMainMenu();
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String choice = in.next();
            try {
                if (choice.equals("D")) {
                    DisplayAllGames();
                } else if (choice.equals("P")) {
                    DisplayAllPlayers();
                } else if (choice.equals("S")) {
                    SearchFootBallGame();
                } else if (choice.equals("R")) {
                    SearchFootBallPlayers();
                } else if (choice.equals("A")) {
                    AddGame();
                } else if (choice.equals("F")) {
                    AddFootballPlayer();
                } else if (choice.equals("K")) {
                    AddPlayersToGame();
                } else if (choice.equals("Q")) {
                    SetTeamColor();
                } else if (choice.equals("M")) {
                    SetTeamMember();
                } else if (choice.equals("X")) {
                    System.out.println("\nGoodbye!");
                    break;
                }
            } catch(Exception e) {
                System.out.println("Something went wrong: " + e.toString() + "\n");
            }

            DisplayMainMenu();
        }
        in.close();
    }

    public static void DisplayMainMenu() {
        System.out.println("\nWhat do you want to do?");
        System.out.println("[D]: Display games");
        System.out.println("[P]: Display players");
        System.out.println("[S]: Search for a game.");
        System.out.println("[R]: Search for a player.");
        System.out.println("[A]: Create a new game with settings.");
        System.out.println("[F]: Enter a new player.");
        System.out.println("[K]: Add players to game.");
        System.out.println("[Q]: Change team color.");
        System.out.println("[M]: Set team member.");
        System.out.println("[X]: Exit.");
        System.out.print("Enter choice: ");
    }

    public static void DisplayAllGames() {
        for (int j = 0; j < footBallGames.size(); j++) {
            FBGame footballGame = footBallGames.get(j);
            System.out.println("\nGame " + (j + 1));
            System.out.println("------");
            footballGame.getGameInfo();
        }
    }
    public static void DisplayAllPlayers() {
        for (int j = 0; j < footBallPlayers.size(); j++) {
            FBPlayer footBallPlayer = footBallPlayers.get(j);
            System.out.println("\nPlayer " + (j + 1));
            System.out.println(footBallPlayer.toString());
        }
    }
    public static void SearchFootBallGame() {
        System.out.print("Enter Game Time: ");
        Scanner in = new Scanner(System.in);
        String time = in.nextLine();
        int games = 0;
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            Date gTime = new SimpleDateFormat("dd/MM/yyyy").parse(time);
            for (FBGame footballGame : footBallGames) {
                Date gameTime = footballGame.getGameTime();
                if (fmt.format(gTime).equals(fmt.format(gameTime))) {
                    footballGame.getGameInfo();
                    games +=1;
                }
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if (games > 0){
            System.out.println("There is not any game at " + time);
        }

    }
    public static void SearchFootBallPlayers() {
        System.out.print("Enter Player Name: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        int names = 0;

        for (FBPlayer footballPlayer : footBallPlayers) {
            String personName = footballPlayer.getPersonName();
            if (personName.equals(name)) {
                System.out.println(footballPlayer.toString());
            }
        }
        if (names > 0){
            System.out.println("There is nobody call " + name);
        }

    }

    public static void AddGame(){
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter game time: (dd/MM/yyyy)");
        String time = in.nextLine();
        Date gameTime = new Date();
        try {
            gameTime = new SimpleDateFormat("dd/MM/yyyy").parse(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Enter game venue: ");
        String venue = in.nextLine();
        System.out.print("Enter game max number of players: ");
        int maxPlayerNumber = in.nextInt();
        FBGame footballGame = new FBGame(gameTime,venue,maxPlayerNumber);
        footBallGames.add(footballGame);
        System.out.println("Team created successfully.");
        footballGame.getGameInfo();
    }

    public static void AddFootballPlayer() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter footballPlayer name: ");
        String name = in.nextLine();
        System.out.print("\nEnter footballPlayer Gender: ");
        String gender = in.nextLine();
        System.out.print("\nEnter footballPlayer ID: ");
        int id = in.nextInt();

        System.out.println("----------");
        FBPlayer fbPlayer = new FBPlayer(name,id,gender);
        footBallPlayers.add(fbPlayer);

        System.out.println("Football player created successfully: " + name +" id " + id + ".");
        System.out.println(" How many games to join?: ");
        int num = in.nextInt();
        int gameId ;
        for (int j = 0; j<= num -1; j++){
            gameId= in.nextInt();
            footBallGames.get(gameId-1).addPlayer(fbPlayer);
        }
        System.out.println("Player create successfully.");

    }


    public static void SetTeamColor() {
        System.out.println("\n----------");
        System.out.println("All games: ");
        for (int j = 0; j < footBallGames.size(); j++) {
            FBGame footBallGame = footBallGames.get(j);
            System.out.println("Game " + (j + 1) + " [" + footBallGame.getGameTime() +" " + footBallGame.getGameVenue() + "]");
        }
        System.out.println("----------");

        Scanner in = new Scanner(System.in);

        System.out.print("Which game to set team color?: ");
        int index = in.nextInt() - 1;
        in.nextLine();
        System.out.println("\n----------");
        FBGame footBallGame = footBallGames.get(index);
        System.out.println("Team1 current color:" + footBallGame.getGameTeam1().getTeamColor());
        System.out.println("Which color to use for Team1?");
        String color = in.nextLine();
        footBallGame.getGameTeam1().setTeamColor(color);

        System.out.println("\n Team2 current color:" + footBallGame.getGameTeam2().getTeamColor());
        System.out.println("Which color to use?");
        color = in.nextLine();
        footBallGame.getGameTeam2().setTeamColor(color);
        System.out.println("Team color has changed successfully.");
    }
    public static void SetTeamMember() {

        System.out.println("All games: ");
        for (int j = 0; j < footBallGames.size(); j++) {
            FBGame footBallGame = footBallGames.get(j);
            System.out.println("Game " + (j + 1) + " [" + footBallGame.getGameTime() + footBallGame.getGameVenue() + "]");
        }
        System.out.println("----------");

        Scanner in = new Scanner(System.in);

        System.out.print("Which game to set members?: ");
        int index = in.nextInt() - 1;

        System.out.println("\n----------");
        FBGame footBallGame = footBallGames.get(index);
        System.out.println(footBallGame.getGameTeam1().toString());
        System.out.println(footBallGame.getGameTeam2().toString());
        System.out.println("Waiting----------");
        System.out.println(footBallGame.getWaitList().toString());
        System.out.println("----------");

        System.out.print("How many players in team1?: ");
        int memberNumber = in.nextInt() - 1;
        System.out.print("Which member to team1?: ");
        for (int j = 0; j < memberNumber; j++){
            int memberIndex = in.nextInt() - 1;
            footBallGame.getGameTeam1().addTeamMemberToList(footBallGame.getWaitList().getTeamList().get(memberIndex));
        }
        for (int j = 0; j < footBallGame.getGameTeam1().getTeamList().size(); j++){
            footBallGame.getWaitList().removeTeamMemberFromList(footBallGame.getGameTeam1().getTeamList().get(j));
        }

        System.out.print("Remaining Waiting ");
        System.out.println(footBallGame.getWaitList().toString());
        System.out.print("How many members to team2?: ");
        memberNumber = in.nextInt() - 1;
        System.out.print("Which member to team2?: ");
        for (int j = 0; j < memberNumber; j++){
            int memberIndex = in.nextInt() - 1;
            footBallGame.getGameTeam2().addTeamMemberToList(footBallGame.getWaitList().getTeamList().get(memberIndex));
        }
        for (int j = 0; j < footBallGame.getGameTeam1().getTeamList().size(); j++){
            footBallGame.getWaitList().removeTeamMemberFromList(footBallGame.getGameTeam1().getTeamList().get(j));
        }

        System.out.println("Team member has changed successfully.");
    }
    public static void AddPlayersToGame() {

        System.out.println("All games: ");
        for (int j = 0; j < footBallGames.size(); j++) {
            FBGame footBallGame = footBallGames.get(j);
            System.out.println("Game " + (j + 1) + " [" + footBallGame.getGameTime() + footBallGame.getGameVenue() + "]");
        }
        System.out.println("All players");
        DisplayAllPlayers();
        System.out.println("----------");

        Scanner in = new Scanner(System.in);

        System.out.print("Which game to add players?: ");
        int index = in.nextInt() - 1;
        FBGame footBallGame = footBallGames.get(index);

        System.out.println("\n----------");
        System.out.print("How many players to add?: ");
        int num = in.nextInt();
        for (int j = 0; j<= num -1;j++){
            index = in.nextInt() - 1;
            footBallGame.addPlayer(footBallPlayers.get(index));
        }

        System.out.println("Game players has added successfully.");
    }
}
