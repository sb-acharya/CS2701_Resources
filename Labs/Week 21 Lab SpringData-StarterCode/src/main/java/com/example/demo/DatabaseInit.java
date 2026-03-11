package com.example.demo;

import com.example.demo.Models.*;
import com.example.demo.Repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProduceRepository produceRepository;

	@Autowired
	private SellerProduceRepository sellerProduceRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		orderItemRepository.deleteAll();
		orderRepository.deleteAll();
		sellerProduceRepository.deleteAll();
		produceRepository.deleteAll();
		userRepository.deleteAll();

		User user1 = new User("Bob", "bob@sample.com", "bob_pass", UserType.BUYER);
		User user2 = new User("Prapanch", "prapanch@sample.com", "prapanch_pass", UserType.SELLER);
		User user3 = new User("Ademola", "ademola@sample.com", "ademola_pass", UserType.BOTH);
		User user4 = new User("Zhixian", "zhixian@sample.com", "zhixian_pass", UserType.BUYER);

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);

		Produce produce1 = new Produce("Apple");
		Produce produce2 = new Produce("Lettuce");
		Produce produce3 = new Produce("Potatoes");

		produceRepository.save(produce1);
		produceRepository.save(produce2);
		produceRepository.save(produce3);

		SellerProduce sellerProduce1 = new SellerProduce(user2, produce1, 0.15, 100);
		SellerProduce sellerProduce2 = new SellerProduce(user2, produce2, 0.25, 20);
		SellerProduce sellerProduce3 = new SellerProduce(user3, produce1, 0.30, 50);
		SellerProduce sellerProduce4 = new SellerProduce(user3, produce3, 0.05, 30);

		sellerProduceRepository.save(sellerProduce1);
		sellerProduceRepository.save(sellerProduce2);
		sellerProduceRepository.save(sellerProduce3);
		sellerProduceRepository.save(sellerProduce4);

		Order order1 = new Order(user1);
		Order order2 = new Order(user4);

		orderRepository.save(order1);
		orderRepository.save(order2);

		OrderItem item1 = new OrderItem(order1, sellerProduce3, 2);
		OrderItem item2 = new OrderItem(order1, sellerProduce2, 1);
		OrderItem item3 = new OrderItem(order2, sellerProduce1, 10);
		OrderItem item4 = new OrderItem(order2, sellerProduce4, 15);

		orderItemRepository.save(item1);
		orderItemRepository.save(item2);
		orderItemRepository.save(item3);
		orderItemRepository.save(item4);
	}
}