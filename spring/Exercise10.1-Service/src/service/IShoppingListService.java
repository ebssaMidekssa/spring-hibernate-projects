package service;

import generated.shoppingList.Item;
import generated.shoppingList.ShoppingList;

public interface IShoppingListService {

	public ShoppingList getList();

	public Item getItem(String product);

	public void addToList(Item item);

	public void removeFromList(String product);

	public void updateItem(Item item);

}