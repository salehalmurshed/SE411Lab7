package util;

import model.Booking;

public final class BookingService {

    private BookingService() {
    }

    public static double computeTotalPrice(Booking booking)
            throws Exception {

        if (booking == null) {
            throw new IllegalArgumentException(
                "Booking cannot be null.");
        }

        return booking.computeTotalPrice();
    }
}