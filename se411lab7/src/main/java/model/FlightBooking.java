package model;

import exception.InvalidArgumentException;
import exception.MissingInformationException;
import util.GlobalConfig;

public class FlightBooking extends Booking {

    private final double baseTicketPrice;
    private Double luggageWeight;

    public FlightBooking(String bookingId, String customerFullName,
                         String travelDate, String destinationCity,
                         double baseTicketPrice) {
        super(bookingId, customerFullName, travelDate, destinationCity);
        this.baseTicketPrice = baseTicketPrice;
    }

    public void setLuggageWeight(Double luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    public Double getLuggageWeight() {
        return luggageWeight;
    }

    public double getBaseTicketPrice() {
        return baseTicketPrice;
    }

    @Override
    public double computeTotalPrice()
            throws MissingInformationException, InvalidArgumentException {

        if (luggageWeight == null) {
            throw new MissingInformationException(
                "Luggage weight was not provided for flight "
                + getBookingId());
        }

        if (luggageWeight < 0 ||
            luggageWeight > GlobalConfig.MAX_LUGGAGE_WEIGHT) {

            throw new InvalidArgumentException(
                "Luggage weight must be between 0 and "
                + GlobalConfig.MAX_LUGGAGE_WEIGHT + " kg.");
        }

        return baseTicketPrice +
               (luggageWeight * GlobalConfig.EXTRA_LUGGAGE_RATE);
    }
}