package ConKUeror.domain.controller;

import java.io.IOException;

import ConKUeror.domain.model.Player.Player;

public interface EndOfTheGameListener
{
    void resolveGame(Player player) throws IOException;
}
