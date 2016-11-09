package castle;

/**
 * Created by duyue on 2016/11/9.
 */
public class HandlerHelp extends Handler {
    public HandlerHelp(Game game) {
        super(game);
    }

    @Override
    public boolean isHelp() {
        return true;
    }
}
