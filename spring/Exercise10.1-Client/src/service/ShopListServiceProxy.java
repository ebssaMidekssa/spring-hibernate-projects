package service;

import org.springframework.web.client.RestTemplate;

import generated.shoppingList.Item;
import generated.shoppingList.ShoppingList;

public class ShopListServiceProxy implements IShoppingListService {
	private static final String listURL = "http://localhost:8080/Exercise10.1-Service/rest/list";
	private static final String itemURL = "http://localhost:8080/Exercise10.1-Service/rest/item/{product}";

	private RestTemplate restTemplate;
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public void addToList(Item item) {
		restTemplate.postForLocation(listURL, item);
	}
	
	public Item getItem(String product) {
		return restTemplate.getForObject(itemURL, Item.class, product);
	}

	public ShoppingList getList() {
		return restTemplate.getForObject(listURL, ShoppingList.class);
	}

	public void removeFromList(String product) {
		restTemplate.delete(itemURL, product);
	}

	public void updateItem(Item item) {
		restTemplate.put(itemURL, item, item.getProduct());
	}

}
