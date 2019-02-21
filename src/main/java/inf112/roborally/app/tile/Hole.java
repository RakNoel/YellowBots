package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

public class Hole extends AbstractCollidableTile {

    @Override
    public int getRenderPriority() {
        return 1;
    }

    @Override
    public char getSymbol() {
        return 'X';
    }

    @Override
    public void execute(Player[] player) {
        player[0].takenDamage(10);
    }
}