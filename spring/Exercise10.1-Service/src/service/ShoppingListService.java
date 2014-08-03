package service;

import generated.shoppingList.Item;
import generated.shoppingList.ShoppingList;

import java.util.HashMap;
import java.util.Map;

public class ShoppingListService implements IShoppingListService {

	private Map<String, Item> items = new HashMap<String, Item>();

	public ShoppingList getList() {
		return new ShoppingList(items.values());
	}

	public Item getItem(String product) {
		return items.get(product);
	}

	public void addToList(Item item) {
		if (items.containsKey(item.getProduct())) {
			Item current = items.get(item.getProduct());
			current.setQty(current.getQty() + item.getQty());
			if (!current.getNotes().equals(item.getNotes())) {
				current.setNotes(current.getNotes() + "\n" + item.getNotes());
			}
		} else {
			items.put(item.getProduct(), item);
		}
	}

	public void removeFromList(String product) {
		if (items.containsKey(product)) {
			items.remove(product);
		}
	}

	public void updateItem(Item item) {
		items.put(item.getProduct(), item);
	}

}
