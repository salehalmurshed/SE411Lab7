package se411lab7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Booking;
import model.CarRentalBooking;
import model.FlightBooking;
import model.TrainBooking;
import model.TrainBooking.SeatClass;
import util.BookingService;

public class MainApp {

    private static final Logger logger =
            LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {

        logger.info("Application is starting...");

        try {

            Booking flight = new FlightBooking(
                    "F001",
                    "Ahmed Ali",
                    "2026-10-01",
                    "Dubai",
                    500.0);

            ((FlightBooking) flight).setLuggageWeight(20.0);


            Booking train = new TrainBooking(
                    "T001",
                    "Sara Mohammed",
                    "2026-10-05",
                    "Dammam",
                    SeatClass.FIRST_CLASS);

            ((TrainBooking) train).setDistanceKm(500);


            Booking car = new CarRentalBooking(
                    "C001",
                    "Omar Hassan",
                    "2026-10-10",
                    "Riyadh",
                    150.0);

            ((CarRentalBooking) car).setNumberOfDays(4);


            Booking[] bookings = {
                flight,
                train,
                car
            };


            for (Booking booking : bookings) {

                double total =
                        BookingService.computeTotalPrice(booking);

                System.out.println(
                        booking.getBookingId()
                        + " - "
                        + booking.getClass().getSimpleName()
                        + " - Total: "
                        + total);
            }


        } catch (Exception e) {

            logger.error(
                    "Unexpected exception in main.",
                    e);

        } finally {

            logger.info(
                    "Application is stopping...");
        }
    }
}