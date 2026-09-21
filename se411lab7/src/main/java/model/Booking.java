package model;

public abstract class Booking {

    private final String bookingId;
    private final String customerFullName;
    private final String travelDate;
    private final String destinationCity;

    public Booking(String bookingId, String customerFullName,
                   String travelDate, String destinationCity) {
        this.bookingId = bookingId;
        this.customerFullName = customerFullName;
        this.travelDate = travelDate;
        this.destinationCity = destinationCity;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public abstract double computeTotalPrice()
            throws Exception;
}