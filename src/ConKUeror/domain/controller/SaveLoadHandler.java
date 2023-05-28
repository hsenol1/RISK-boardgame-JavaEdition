package ConKUeror.domain.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ConKUeror.domain.model.Data.GameState;

public class SaveLoadHandler {

   public SaveLoadHandler() {

}

public void saveGame(String fileName, GameState gameState) throws IOException {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
        oos.writeObject(gameState);
    }
}

public GameState loadGame(String fileName) throws IOException, ClassNotFoundException {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
        return (GameState) ois.readObject();
    }
}

}
