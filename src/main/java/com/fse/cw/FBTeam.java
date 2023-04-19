package com.fse.cw;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class FBTeam {

    /**
     * 默认的球队颜色
     */
    public static final String DEFAULT_TEAM_COLOR = "White";

    /**
     * 设置团队的标记
     * {@link FBTeam#setTeamList(List)} 只允许标记一次
     */
    private final AtomicBoolean mark = new AtomicBoolean(false);
    private List<FBPlayer> teamList;
    private String teamColor;

    public FBTeam() {
        teamList = new ArrayList<FBPlayer>();
        teamColor = DEFAULT_TEAM_COLOR;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        final FBTeam fbTeam = new FBTeam();
        final CountDownLatch latch = new CountDownLatch(1);
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    System.out.println("设置前:" + Thread.currentThread().getName());
                    latch.await();
                    fbTeam.setTeamList(new ArrayList<FBPlayer>());
                    System.out.println("设置后:" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        for (int i = 0; i < 5; i++) {
            executorService.submit(runnable);
        }
        Thread.sleep(1000);
        latch.countDown();
        executorService.shutdown();
    }

    public String getTeamColor() {
        return this.teamColor;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    public void addTeamMemberToList(FBPlayer teamMember) {
        this.teamList.add(teamMember);
    }

    public void removeTeamMemberFromList(FBPlayer teamMember) {
        // FBPlayer 需要重写 equal 方法
        this.teamList.remove(teamMember);
    }

    public List<FBPlayer> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<FBPlayer> teamList) {
        if (teamList != null) {
            // 设置团队信息
            if (mark.compareAndSet(false, true)) {
                // System.out.println("执行成功的线程: " + Thread.currentThread().getName());
                this.teamList = teamList;
            }
        }
    }

    @Override
    public String toString() {

        StringBuilder member = new StringBuilder("Team Members: ");
        if (getTeamList().size() == 0) {
            member.append("None");
        }
        for (int i = 0; i < getTeamList().size(); i++) {
            member.append("[").append(i).append("]: ").append(getTeamList().get(i).getPersonName()).append("\n");
        }

        return member.toString();
    }
}
