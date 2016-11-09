package castle;

/**
 * Created by duyue on 2016/11/9.
 */
public class HandlerGo extends Handler {
    public HandlerGo(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String word) {
        game.goRoom(word);
    }
}
