package hr.fer.oop.zad3;

public class Team {
    private Player[] players;
    private String nickname;
    public Team(String nickname, Player[] team) {
        this.nickname = nickname;
        players = new Player[team.length];
        for (int i = 0; i < players.length; i++) {
            this.players[i] = team[i];
        }
    }
    public String getNickname() {return nickname;}
    public Player[] getPlayers() {return players;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nickname);
        sb.append(" :");
        for (Player player : players) {
            sb.append(" ");
            sb.append(player.getNickname());
        }
        return sb.toString();
    }
}
