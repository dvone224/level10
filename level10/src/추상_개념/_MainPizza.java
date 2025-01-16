package 추상_개념;

import java.util.ArrayList;

public class _MainPizza {
	public static void main(String[] args) {
		
		PizzaService service = new PizzaService();
		
		ArrayList<Pizza> orderList = new ArrayList<Pizza>();
		
		// 업케스팅
		orderList.add(new SweetPotatoPizza(12000, "피자스쿨"));
		orderList.add(new BulgogiPizza(13000, "피자스쿨"));
		orderList.add(new PineApplePizza(12000, "피자스쿨"));
		orderList.add(new SweetPotatoPizza(12000, "피자스쿨"));
		orderList.add(new BulgogiPizza(13000, "피자스쿨"));
		orderList.add(new PineApplePizza(12000, "피자스쿨"));
		
		service.orderPizzas(orderList);
		
	}
}
