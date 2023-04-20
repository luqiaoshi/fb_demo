package com.fse.cw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * {@link FBTeam} 测试用例
 *
 * @author yipeng
 */
public class FBTeamTest {

    public static final String PERSON_GENDER = "man";
    public static final FBPlayer MESSI = new FBPlayer("Messi", 1, PERSON_GENDER);
    public static final FBPlayer RONALDO = new FBPlayer("Ronaldo", 2, PERSON_GENDER);

    private FBTeam fbTeam;

    @Before
    public void setUp() throws Exception {
        fbTeam = new FBTeam();
        Assert.assertEquals(0, fbTeam.getTeamList().size());
        Assert.assertEquals(FBTeam.DEFAULT_TEAM_COLOR, fbTeam.getTeamColor());
    }

    @Test
    public void setTeamList() {
        // 首次设置
        fbTeam.setTeamList(Collections.singletonList(MESSI));
        // 再次设置
        fbTeam.setTeamList(Collections.singletonList(RONALDO));
        List<FBPlayer> teamList = fbTeam.getTeamList();
        // 检查设置是否成功
        Assert.assertEquals(1, teamList.size());
        // 检查第二次设置是否生效
        Assert.assertEquals(MESSI, teamList.get(0));
    }

    @Test
    public void setTeamColor() {
        String teamColor = "Red";
        fbTeam.setTeamColor(teamColor);
        Assert.assertEquals(teamColor, fbTeam.getTeamColor());
    }

    @Test
    public void getTeamColor() {
        Assert.assertEquals(FBTeam.DEFAULT_TEAM_COLOR, fbTeam.getTeamColor());
    }

    @Test
    public void addTeamMemberToList() {
        fbTeam.addTeamMemberToList(RONALDO);
        List<FBPlayer> teamList = fbTeam.getTeamList();
        Assert.assertEquals(1, teamList.size());
        Assert.assertEquals(RONALDO, teamList.get(0));
    }

    @Test
    public void removeTeamMemberFromList() {
        addTeamMemberToList();
        fbTeam.removeTeamMemberFromList(RONALDO);
        Assert.assertEquals(0, fbTeam.getTeamList().size());
    }

    @Test
    public void getTeamList() {
        List<FBPlayer> teamList = fbTeam.getTeamList();
        Assert.assertEquals(0, teamList.size());
        fbTeam.addTeamMemberToList(RONALDO);
        Assert.assertEquals(1, teamList.size());
        Assert.assertEquals(RONALDO, teamList.get(0));
    }

    @Test
    public void testToString() {
        // 当没有队员时的输出
        String nonPlayer = fbTeam.toString();
        Assert.assertEquals("Team Members: None", nonPlayer);
        // 当存在队员时打印队员的信息
        fbTeam.addTeamMemberToList(RONALDO);
        fbTeam.addTeamMemberToList(MESSI);
        String singlePlayer = fbTeam.toString();
        Assert.assertEquals("Team Members: [0]: Ronaldo\n[1]: Messi\n", singlePlayer);
    }
}