package model;

import exception.InvalidArgumentException;
import exception.MissingInformationException;
import util.GlobalConfig;

public class CarRentalBooking extends Booking {

    private final double dailyRentalRate;
    private Integer numberOfDays;

    public CarRentalBooking(String bookingId, String customerFullName,
                            String travelDate, String destinationCity,
                            double dailyRentalRate) {
        super(bookingId, customerFullName, travelDate, destinationCity);
        this.dailyRentalRate = dailyRentalRate;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public double getDailyRentalRate() {
        return dailyRentalRate;
    }

    @Override
    public double computeTotalPrice()
            throws MissingInformationException, InvalidArgumentException {

        if (numberOfDays == null) {
            throw new MissingInformationException(
                "Number of rental days was not provided for car booking "
                + getBookingId());
        }

        if (numberOfDays < 1 ||
            numberOfDays > GlobalConfig.MAX_RENTAL_DAYS) {

            throw new InvalidArgumentException(
                "Rental days must be between 1 and "
                + GlobalConfig.MAX_RENTAL_DAYS + ".");
        }

        return dailyRentalRate * numberOfDays;
    }
}