package com.geleigeit.LinenAndFlowers;

import com.geleigeit.LinenAndFlowers.repository.DeliveryServiceRepository;
import com.geleigeit.LinenAndFlowers.repository.OrderRepository;
import com.geleigeit.LinenAndFlowers.repository.OrderStatusRepository;
import com.geleigeit.LinenAndFlowers.repository.UserRepository;
import com.geleigeit.LinenAndFlowers.service.impl.DeliveryServiceImpl;
import com.geleigeit.LinenAndFlowers.service.impl.OrderService;
import com.geleigeit.LinenAndFlowers.service.impl.OrderStatusService;
import com.geleigeit.LinenAndFlowers.service.impl.UserService;
import com.geleigeit.LinenAndFlowers.tracking.ups.UpsDeliveryConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EntityScan("com.geleigeit.LinenAndFlowers.entity")
@EnableJpaRepositories("com.geleigeit.LinenAndFlowers.repository")
@EnableScheduling
public class EtsyToDoApplication {

	@Autowired
	private static UserRepository userRepository;
	private static OrderRepository orderRepository;
	private static DeliveryServiceRepository deliveryServiceRepository;
	private static OrderStatusRepository orderStatusRepository;


	public static void main(String[] args) {
		SpringApplication.run(EtsyToDoApplication.class, args);

//		UserService userService = new UserService(userRepository);
//		OrderService orderService = new OrderService(orderRepository, userService);
//		DeliveryServiceImpl deliveryServiceImpl = new DeliveryServiceImpl(deliveryServiceRepository);
//		OrderStatusService orderStatusService = new OrderStatusService(orderStatusRepository);
//
//		UpsDeliveryConnector upsDeliveryConnector = new UpsDeliveryConnector(userService, orderService, deliveryServiceImpl, orderStatusService);
//		upsDeliveryConnector.updateTrackingInformation();
	}
}