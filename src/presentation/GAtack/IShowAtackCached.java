package presentation.GAtack;

public interface IShowAtackCached {

	//Pre: the cached Atack should be not null
	//Post: it will update the cachedAtack
	//WARNING: You should use this method each time you use activate Atack Positions
	//     is mandatory to use each time you use activateAtackPositions() method
	void setCacheAtack(IPGraphicDistanceAtack cacheAtack);
	
	
}
