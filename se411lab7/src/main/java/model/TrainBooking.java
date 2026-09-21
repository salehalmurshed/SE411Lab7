package model;

import exception.InvalidArgumentException;
import exception.MissingInformationException;
import util.GlobalConfig;

public class TrainBooking extends Booking {

    public enum SeatClass {
        STANDARD, FIRST_CLASS
    }

    private final SeatClass seatClass;
    private Integer distanceKm;

    public TrainBooking(String bookingId, String customerFullName,
                        String travelDate, String destinationCity,
                        SeatClass seatClass) {
        super(bookingId, customerFullName, travelDate, destinationCity);
        this.seatClass = seatClass;
    }

    public void setDistanceKm(Integer distanceKm) {
        this.distanceKm = distanceKm;
    }

    public Integer getDistanceKm() {
        return distanceKm;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    @Override
    public double computeTotalPrice()
            throws MissingInformationException, InvalidArgumentException {

        if (distanceKm == null) {
            throw new MissingInformationException(
                "Distance was not provided for train booking "
                + getBookingId());
        }

        if (distanceKm < 1 ||
            distanceKm > GlobalConfig.MAX_TRAIN_DISTANCE) {

            throw new InvalidArgumentException(
                "Train distance must be between 1 and "
                + GlobalConfig.MAX_TRAIN_DISTANCE + " km.");
        }

        if (seatClass == SeatClass.FIRST_CLASS) {
            return distanceKm * GlobalConfig.TRAIN_FIRST_CLASS_RATE;
        }

        return distanceKm * GlobalConfig.TRAIN_STANDARD_RATE;
    }
}