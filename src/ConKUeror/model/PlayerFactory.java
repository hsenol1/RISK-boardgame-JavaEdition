package src.ConKUeror.model;

public class PlayerFactory {

    public static Player createPlayer(String name) {
        // Validate input
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        
        // Create a new Player object with the given name
        Player player = new Player(name);
           
        return player;
    }
    
}
