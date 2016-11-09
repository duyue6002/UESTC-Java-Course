package castle;

/**
 * Created by duyue on 2016/11/9.
 */
public class HandlerBye extends Handler {
    public HandlerBye(Game game) {
        super(game);
    }

    @Override
    public boolean isBye() {
        return true;
    }
}
