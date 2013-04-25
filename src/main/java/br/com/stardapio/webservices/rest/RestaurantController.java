package br.com.stardapio.webservices.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import br.com.stardapio.domain.Restaurant;
import br.com.stardapio.service.RestaurantService;

@Controller
public class RestaurantController {
	@Autowired
	private View jsonView_i;
	@Autowired
	private RestaurantService restaurantService_i;

	private static final String DATA_FIELD = "data";
	private static final Logger logger_c = Logger.getLogger(Restaurant.class);

	@RequestMapping(value = "/rest/restaurants/{restaurantId}", method = RequestMethod.GET)
	public ModelAndView getRestaurant(
			@PathVariable("restaurantId") String restaurantId_p) {
		Restaurant restaurant = null;

		if (isEmpty(restaurantId_p) || restaurantId_p.length() < 5) {
			String sMessage = "Error invoking getRestaurant - Invalid restaurant Id parameter";
			return createErrorResponse(sMessage);
		}

		try {
			restaurant = restaurantService_i.getRestaurantById(restaurantId_p);
		} catch (Exception e) {
			String sMessage = "Error invoking getRestaurant. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		logger_c.debug("Returing Restaurant: " + restaurant.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, restaurant);// alterar a
																	// view e a
																	// String!!!
	}

	public static boolean isEmpty(String s_p) {
		return (null == s_p) || s_p.trim().length() == 0;

	}

	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, DATA_FIELD, sMessage);// alterar a
																	// view e a
																	// String!!!
	}
}
