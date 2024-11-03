package HotelReservationSystem;
class Reservation {
    private int ReservationId;
    private Room room;
    private String GuestName;
    private String ArrivalDate;
    private String DepatureDate;
    private Double TotalCoast;
    public Reservation(int reservationId,Room room,String guestName,String arrivalDate,String depatureDate,double totalCoast){
        this.ReservationId=reservationId;
        this.room=room;
        this.GuestName=guestName;
        this.ArrivalDate=arrivalDate;
        this.DepatureDate=depatureDate;
        this.TotalCoast=totalCoast;
    }
    public int getReservationId(){
        return ReservationId;
    }
    public Room getRoom(){
        return room;
    }
    public String getGuestName(){
        return GuestName;
    }
    public String getArrivalDate(){
        return ArrivalDate;
    }
    public String getDepatureDate(){
        return DepatureDate;
    }
    public double gettotalcoast(){
        return TotalCoast;
    }
}

