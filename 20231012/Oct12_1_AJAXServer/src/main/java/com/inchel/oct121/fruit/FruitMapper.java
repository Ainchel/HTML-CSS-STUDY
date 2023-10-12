package com.inchel.oct121.fruit;

import java.util.List;

public interface FruitMapper {

	public abstract List<Fruit> getAllFruit();
	
	public abstract List<Fruit> getSearchFruit(Fruit f);
	
}
