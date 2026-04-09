public class ConcurrentBookingProcessor extends Thread {

    private ReservationService service;

    public ConcurrentBookingProcessor(ReservationService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.processReservations();
    }
}