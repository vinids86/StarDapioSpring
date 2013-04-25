package br.com.stardapio.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.stardapio.domain.Restaurant;

@Service
public class RestaurantService {
	private static final Logger logger_c = Logger.getLogger(Restaurant.class);

	public Restaurant getRestaurantById(String restaurantId_p) {
		Restaurant restaurant = new Restaurant();
		
		// recupera restaurante do banco pelo id
		restaurant.setNome("nome do restaurante");
		restaurant.setEnd("end do restaurante");
		restaurant.setPicRes(0);
		
		return restaurant;
	}
}
