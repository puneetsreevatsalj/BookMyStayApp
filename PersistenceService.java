import java.io.*;

public class PersistenceService {

    private static final String FILE_NAME = "system_state.dat";

    // Save system state
    public void saveState(BookingHistory history, RoomInventory inventory) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(history);
            oos.writeObject(inventory);

            System.out.println("\nSystem state saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving system state: " + e.getMessage());
        }
    }

    // Load system state
    public Object[] loadState() {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            BookingHistory history = (BookingHistory) ois.readObject();
            RoomInventory inventory = (RoomInventory) ois.readObject();

            System.out.println("System state restored successfully.");

            return new Object[]{history, inventory};

        } catch (Exception e) {
            System.out.println("No previous data found. Starting fresh.");
            return null;
        }
    }
}