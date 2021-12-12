package me.lagggpixel.bridge.Manger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Scoreboards {

    private ScoreboardManager _manager;
    private Scoreboard _scoreboard;
    private String _time;
    private HashMap<Player, Integer> _kills = new HashMap<Player, Integer>();
    private HashMap<Player, Integer> _goals = new HashMap<Player, Integer>();
    private HashMap<String, Integer> _goals_per_team = new HashMap<String, Integer>();


    public Scoreboards() {
        _manager = Bukkit.getScoreboardManager();
        _scoreboard = _manager.getNewScoreboard();
        _goals_per_team.put("Blue", 0);
        _goals_per_team.put("Red", 0);
        _time = "15:00";
    }

    public void createNewScoreboard(Player pPlayer) {
        _kills.put(pPlayer, 0);
        _goals.put(pPlayer, 0);
        createScoreboard(pPlayer);
    }

    private void createScoreboard(Player pPlayer) {
        Objective objective = _scoreboard.registerNewObjective("Test", "dummy");
        objective.setDisplayName(ChatColor.YELLOW + "Scoreboard Title");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        Score scr_date = objective.getScore( calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR));
        scr_date.setScore(11);

        Score scr_empty_10 = objective.getScore("");
        scr_empty_10.setScore(10);

        Team time = _scoreboard.registerNewTeam("Time");
        time.addEntry(ChatColor.GREEN.toString());
        time.setPrefix("Time: ");
        time.setSuffix(ChatColor.GREEN + _time);
        objective.getScore(ChatColor.BLUE.toString()).setScore(9);

        Score scr_empty_8 = objective.getScore("  ");
        scr_empty_8.setScore(8);

        char bullet = '\u2B24';
        String red_goals = "";
        for (int i = 0; i < 5; i++) {
            if (i < _goals_per_team.get("Red")){
                red_goals = red_goals + "&c" + bullet;
            } else {
                red_goals = red_goals + "&7" + bullet;
            }
        }
        Team red = _scoreboard.registerNewTeam("Red");
        red.addEntry(ChatColor.RED.toString());
        red.setPrefix(ChatColor.RED + "[R] ");
        red.setSuffix(ChatColor.translateAlternateColorCodes('&', red_goals));
        objective.getScore(ChatColor.RED.toString()).setScore(7);

        String blue_goals = "";
        for (int i = 0; i < 5; i++) {
            if (i < _goals_per_team.get("Blue")){
                blue_goals = blue_goals + "&1" + bullet;
            } else {
                blue_goals = blue_goals + "&7" + bullet;
            }
        }
        Team blue = _scoreboard.registerNewTeam("Blue");
        blue.addEntry(ChatColor.BLUE.toString());
        blue.setPrefix(ChatColor.BLUE + "[B] ");
        blue.setSuffix(ChatColor.translateAlternateColorCodes('&', blue_goals));
        objective.getScore(ChatColor.BLUE.toString()).setScore(6);

        Score scr_empty_5 = objective.getScore("   ");
        scr_empty_5.setScore(5);

        Team kills = _scoreboard.registerNewTeam("Kills");
        kills.addEntry(ChatColor.AQUA.toString());
        kills.setPrefix("Kills: ");
        kills.setSuffix(ChatColor.GREEN + _kills.get(pPlayer).toString());
        objective.getScore(ChatColor.AQUA.toString()).setScore(4);

        Team goals = _scoreboard.registerNewTeam("Goals");
        goals.addEntry(ChatColor.DARK_RED.toString());
        goals.setPrefix("Goals: ");
        goals.setSuffix(ChatColor.GREEN + _goals.get(pPlayer).toString());
        objective.getScore(ChatColor.DARK_RED.toString()).setScore(3);

        Score scr_empty_2 = objective.getScore("    ");
        scr_empty_2.setScore(2);

        Score scr_ip = objective.getScore(ChatColor.YELLOW + "www.test.de");
        scr_ip.setScore(1);

        pPlayer.setScoreboard(_scoreboard);
    }

    public void setKill(Player pPlayer) {
        if (_kills.containsKey(pPlayer)){
            _kills.put(pPlayer, _kills.get(pPlayer) + 1);
            _scoreboard.getTeam("Kills").setSuffix(ChatColor.GREEN + _kills.get(pPlayer).toString());
        }
    }

    public void setGoals(Player pPlayer) {
        if (_goals.containsKey(pPlayer)){
            _goals.put(pPlayer, _goals.get(pPlayer) + 1);
            _scoreboard.getTeam("Goals").setSuffix(ChatColor.GREEN + _goals.get(pPlayer).toString());
        }
    }

    public void setGoalsforTeam(String pTeam) {
        char bullet = '\u2B24';
        String color;
        if (_goals_per_team.containsKey(pTeam)){
            _goals_per_team.put(pTeam, _goals_per_team.get(pTeam) + 1);
            if (pTeam.equalsIgnoreCase("Blue")) {
                color = "&1";
            } else {
                color = "&c";
            }
            String goals = "";
            for (int i = 0; i < 5; i++) {
                if (i < _goals_per_team.get(pTeam)){
                    goals = goals + color + bullet;
                } else {
                    goals = goals + "&7" + bullet;
                }
            }
            _scoreboard.getTeam(pTeam).setSuffix(ChatColor.translateAlternateColorCodes('&', goals));
        }
    }

    public void setTime(String pTime){
        _time = pTime;
        _scoreboard.getTeam("Time").setSuffix(ChatColor.GREEN + _time);
    }
}