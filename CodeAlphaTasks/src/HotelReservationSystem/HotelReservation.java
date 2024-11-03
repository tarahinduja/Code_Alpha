package HotelReservationSystem;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {
    private List<Room>rooms;
    private List<Reservation>reservations;
    public HotelReservation(){
        this.rooms=new ArrayList<>();
        this.reservations=new ArrayList<>();
    }
    public void addRoom(int RoomNumber,RoomCategory category){
        Room room=new Room(RoomNumber,category);
        rooms.add(room);
    }
    public List<Room> searchAvailableRooms(RoomCategory category) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable() && room.getCategory() == category) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
    public void makeReservation(int RoomNumber,String GuestName,String ArrivalDate,String DepatureDate,double TotalCoast){
        Room room = getRoomByNumber(RoomNumber);
        if (room != null && room.isAvailable()) {
            Reservation reservation = new Reservation(reservations.size() + 1, room, GuestName, ArrivalDate, DepatureDate, TotalCoast);
            reservations.add(reservation);
            room.setAvailable(false);
            System.out.println("Reservation made successfully!");
        } else {
            System.out.println("Room is not available or does not exist!");
        }
    }
    public Void viewBookingDetails(int ReservationId){
        Reservation reservation= getReservationById(ReservationId);
        if (reservation!=null){
            System.out.println("ReservationId"+reservation.getReservationId());
            System.out.println("Room Number"+reservation.getRoom().getRoomNumber());
            System.out.println("Guest Name"+reservation.getGuestName());
            System.out.println("Arrival Date"+reservation.getArrivalDate());
            System.out.println("Depature Date"+reservation.getDepatureDate());
            System.out.println("Total Coast"+reservation.gettotalcoast());
        }
        else {
            System.out.println("Reservation doesnot Exist");
        }
        return null;
    }
    private Room getRoomByNumber(int roomNumber) {
        for (Room room:rooms){
            if(room.getRoomNumber()==roomNumber){
                return room;
            }
        }
        return null;
    }
    private Reservation getReservationById(int ReservationId){
        for (Reservation reservation:reservations){
            if (reservation.getReservationId()==ReservationId){
                return reservation;
            }
        }
        return null;
    }
}
