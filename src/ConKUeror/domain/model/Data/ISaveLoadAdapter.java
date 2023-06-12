package ConKUeror.domain.model.Data;

import java.io.Serializable;

public interface ISaveLoadAdapter {
	void save(GameState gameState);
	GameState load();

}
