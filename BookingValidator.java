import java.util.*;

public class BookingValidator {

    Set<String> valid;

    public BookingValidator(Set<String> v) {
        valid = v;
    }

    public void validate(Reservation r) throws InvalidBookingException {

        if (r.getGuestName() == null)
            throw new InvalidBookingException("Invalid name");

        if (!valid.contains(r.getRoomType()))
            throw new InvalidBookingException("Invalid room type");
    }
}