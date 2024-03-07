package com.mycompany.booking;

import io.muserver.*;
import io.muserver.rest.RestHandlerBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.booking.Exception.DuplicateBookingException;
import com.mycompany.booking.model.BookingInfo;
import com.mycompany.booking.service.BookingService;
import com.mycompany.booking.service.impl.BookingPersistInMemoryService;
import com.mycompany.booking.service.impl.BookingServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

public class Booking {
	/**
	 * Reference to logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(Booking.class);

	/**
	 * Inject booking service.
	 */
	private static BookingService bookingService = new BookingServiceImpl(new BookingPersistInMemoryService());

	public static void main(String[] args) {
		LOGGER.info("Starting booking application ...");

		MuServer server = MuServerBuilder.httpServer().withHttpPort(8080)
				.addHandler(RestHandlerBuilder.restHandler(new BookingResource())).start();

		LOGGER.info("Server started at " + server.httpUri());
	}

	@Path("/booking")
	private static class BookingResource {
		@GET
		@Path("/list")
		@Produces("application/json")
		public String getBookingList(@HeaderParam("token") String token) throws JsonProcessingException {
			if (!"owner".equals(token)) {
				return "no acess to it!";
			}
			
			if (bookingService.getBookingInfoList() == null) {
				return null;
			}

			return new ObjectMapper().writer().withDefaultPrettyPrinter()
					.writeValueAsString(bookingService.getBookingInfoList());
		}

		@GET
		@Path("/{customerName}/{tableSize}/{startDate}/{hour}/{minute}")
		@Produces("application/json")
		public String addBookingInfo(@PathParam("customerName") String customerName,
				@PathParam("tableSize") int tableSize, @PathParam("startDate") String startDate,
				@PathParam("hour") int hour, @PathParam("minute") int minute) {
			try {
				bookingService.addBookingInfo(new BookingInfo(customerName, tableSize, startDate, hour, minute));
			} catch (DuplicateBookingException e) {
				return e.getMessage();
			}

			return "ok";
		}
	}
}
