package castle;

/**
 * Created by duyue on 2016/11/9.
 */

public class Handler {
    protected Game game;

    public Handler(Game game){
        this.game = game;
    }

    public void doCmd(String word) {

    }

    public boolean isBye() {
        return false;
    }

    public boolean isHelp() {
        return false;
    }

}
