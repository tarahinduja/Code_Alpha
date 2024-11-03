package HotelReservationSystem;

import java.util.List;
import java.util.Scanner;

enum RoomCategory{
    SINGLE,
    DOUBLE,
    SUITE
}
class Room{
    private int RoomNumber;
    private RoomCategory Category;
    private boolean isAvailable;
    public Room(int roomNumber,RoomCategory category){
        this.RoomNumber=roomNumber;
        this.Category=category;
        this.isAvailable=true;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public RoomCategory getCategory() {
        return Category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
class Main {
    public static void main(String[] args) {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addRoom(1, RoomCategory.SINGLE);
        hotelReservation.addRoom(2, RoomCategory.DOUBLE);
        hotelReservation.addRoom(3, RoomCategory.SUITE);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome To The Hotel Reservation System!");
            System.out.println("Select an Option");
            System.out.println("1:Book a Room");
            System.out.println("2:View Booking Detail");
            System.out.println("3:Exist");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the room which you want to select");
                    System.out.println("1:Single");
                    System.out.println("2:Double");
                    System.out.println("3:Suite");
                    int choice = scanner.nextInt();
                    RoomCategory category = null;
                    double totalCoast = 0.0;
                    switch (choice) {
                        case 1:
                            category = RoomCategory.SINGLE;
                            totalCoast = 15000;
                            break;
                        case 2:
                            category = RoomCategory.DOUBLE;
                            totalCoast = 20000;
                            break;
                        case 3:
                            category = RoomCategory.SUITE;
                            totalCoast = 30000;
                            break;
                        default:
                            System.out.println("Invalid Choice!");
                            continue;
                    }
                    List<Room> availableRoom = hotelReservation.searchAvailableRooms(category);
                    if (availableRoom.isEmpty()) {
                        System.out.println("NO Room Available.");
                        continue;
                    }
                    System.out.println("Available Room.");
                    for (Room room : availableRoom) {
                        System.out.println("Room Number:" + room.getRoomNumber());
                    }
                    System.out.println("Enter the room number you want to book...");
                    int roomnumber = scanner.nextInt();
                    System.out.println("Enter Your Name...");
                    String name = scanner.next();
                    System.out.println("Enter Arrival Date...");
                    String arrivaldate = scanner.next();
                    System.out.println("Enter Depature Date...");
                    String depaturedate = scanner.next();
                    hotelReservation.makeReservation(roomnumber, name, arrivaldate, depaturedate, totalCoast);
                    System.out.println("Select Payment Method...");
                    System.out.println("1:Cash");
                    System.out.println("2:Card");
                    int payment = scanner.nextInt();
                    if (payment == 1) {
                        System.out.println("Payment SucessFull!");
                    } else if (payment == 2) {
                        System.out.println("Enter Credit Card Number");
                        String card = scanner.next();
                        System.out.println("Enter Depature Date");
                        String date = scanner.next();
                        System.out.println("Payment SucessFull...");
                    }
                case 2:
                    System.out.println("Enter Reservation Id");
                    int reservationid=scanner.nextInt();
                    hotelReservation.viewBookingDetails(reservationid);
                    break;
                case 3:
                    System.out.println("Thanks for using our Hotel Reservation System");
                    return;
                default:
                    System.out.println("Invalid Choice.....");
            }
        }
    }
}
