package RoomBooking;//package RoomBoooking;
import java.util.*;

public class RoomStructure {
    String name;
    int noOfSeats ;
    TreeMap<String , User> slots = new TreeMap<>();
    public RoomStructure(){

    }
    public RoomStructure(String name, int noOfSeats, TreeMap<String, User> slotList){
        this.name = name;
        this.noOfSeats = noOfSeats ;
         slots = slotList;
    }

    public void showAllRooms(List<RoomStructure> roomsList){

        for(RoomStructure room: roomsList){
            System.out.println(room.name+" "+room.noOfSeats);

            for(Map.Entry<String, User> slot: room.slots.entrySet()){
                if(slot.getValue()==null)
                {System.out.println(slot.getKey() + " " + slot.getValue());}
                else
                {System.out.println(slot.getKey() + " " + slot.getValue().getName());}
            }
        }
    }


}
