package files;

class GameContext {
    GameState gameState;
    public GameContext(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setWinningState(Symbol symbol){
        if(symbol.equals(Symbol.X)){
            gameState=new XWinState();
            System.out.println("Player 1 wons the game");
        }
        else if(symbol.equals(Symbol.O)) {
            gameState=new OWinState();
            System.out.println("Player 2 wons the game");
        }
        else{
            gameState=new DrawState();
            System.out.println("Game Ends in Draw");
        }
    }
}
interface GameState{
    void nextState(GameContext gameContext);
    boolean isWinningState();
    boolean isGameEnded();
}
class XState implements GameState{
    @Override
    public void nextState(GameContext gameContext) {
        gameContext.gameState=new OState();
    }

    @Override
    public boolean isWinningState() {
        return false;
    }
    @Override
    public boolean isGameEnded(){
        return false;
    }
}
class OState implements GameState{
    @Override
    public void nextState(GameContext gameContext) {
        gameContext.gameState=new XState();
    }

    @Override
    public boolean isWinningState() {
        return false;
    }
    @Override
    public boolean isGameEnded(){
        return false;
    }
}
class XWinState implements GameState{
    @Override
    public void nextState(GameContext gameContext) {
        throw new IllegalArgumentException("XWinState: There is no next State");
    }

    @Override
    public boolean isWinningState() {
        return true;
    }
    @Override
    public boolean isGameEnded(){
        return true;
    }
}
class OWinState implements GameState{
    @Override
    public void nextState(GameContext gameContext) {
        throw new IllegalArgumentException("OWinState: There is no next State");
    }

    @Override
    public boolean isWinningState() {
        return true;
    }
    @Override
    public boolean isGameEnded(){
        return true;
    }
}
class DrawState implements GameState{
    @Override
    public void nextState(GameContext gameContext) {
        throw new IllegalArgumentException("drawState: There is no next State");
    }

    @Override
    public boolean isWinningState() {
        return false;
    }
    @Override
    public boolean isGameEnded(){
        return true;
    }
}
