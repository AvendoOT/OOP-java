package hr.fer.oop.zad3;

public class HumanPlayer extends Person implements Player {

    private String nickname;

    public HumanPlayer(String name, String id, String nickname) {
        super(name, id);
        this.nickname = nickname;
    }
    public void setNickname(String nickname) {this.nickname = nickname;}

    @Override
    public String getNickname() {
        return null;
    }
}
