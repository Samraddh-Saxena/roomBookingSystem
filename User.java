package RoomBooking;

import java.util.List;

public class User implements Runnable{

   private String name;
   private String id;
   public String org ;
    public User(String name , String id, String org) {
        this.name= name;
        this.id= id;
        this.org = org ;
    }
    public User(String name , String id) {
        this.name= name;
        this.id= id;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void run()
    {
        try {
//             Displaying the thread that is running
//             System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        }
        catch (Exception e) {
            
            System.out.println("Exception is caught");
        }
    }


    public  static int checkCapacity(int noOfStudents , int roomType){
        switch(roomType){
            case 1: if (noOfStudents > 150) { System.out.println("Out of capacity for Nab Audi. Please select a different room!");
               return 1; } break;
            case 2 : if(noOfStudents>100) { System.out.println("Out of capacity for Ltc hall. Please select a different room!");
                return 1;} break;
            case 3 : if(noOfStudents>25) { System.out.println("Out of capacity for library brainstorming room. Please select a different room!");
                return 1;} break;
        }
        return 0;
    }

    public synchronized void checkAvailabiity(Room room){
    room.showAllAvailableRooms();
    }

    public synchronized void makeRequest(List<BookingRequest> requestList, BookingRequest request){
        requestList.add(request);
    }

    public synchronized void updatePurpose(List<BookingRequest> requestList , String purpose) {
        for (BookingRequest request : requestList) {
            if (request.getUser().getName().equals(this.getName())) {
                request.setPurpose(purpose);
            }
        }
    }
    public void deleteRequest(List<BookingRequest> requestList){
        for (BookingRequest request : requestList) {
            if (request.getUser().getName().equals(this.getName())) {
//                requestList.remove(request);
                request.setVisibility(0);
                BookingRequest.totalRequests-- ;
            }
    }}

    public synchronized int track(List<BookingRequest> requestList){
        int approved =0;
        for(BookingRequest request:requestList){
            if(request.getUser().getName().equals(this.getName()) && request.getVisibility()==1){
                request.printBookingDetails();
                approved =1 ;
                System.out.println("----------------------------");
            }
        }
        return approved ;
    }
}
