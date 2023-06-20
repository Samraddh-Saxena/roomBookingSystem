package RoomBooking;

import java.util.Calendar;

public class BookingRequest {
    private User user;
    private String bookingStatus;
    private String purpose;
    private int roomtype;
    private int slotNo;
   static public int totalRequests ;
   public int requestNo;
   private String adminRemark ;
   public int roomAlloted ;
   public String roomName;
public int noOfStudents;
public int  visibility ;
    public BookingRequest(User user , String purpose, int slotNo, int roomtype, String bookingStatus , int roomAlloted , int noOfStudents){
        this.user = user;
        this.bookingStatus = bookingStatus;
        this.purpose = purpose;
        this.slotNo = slotNo ;
        this.adminRemark = "";
        this.roomtype = roomtype;
        totalRequests++ ;
        this.requestNo = totalRequests ;
        this.roomAlloted = roomAlloted;
        this.noOfStudents = noOfStudents;
        this.visibility = 1;
        if(roomtype==1) setRoomName("RoomBooking.Nab");
        else if(roomtype==2) setRoomName("RoomBooking.Ltc");
        else setRoomName("Lib");

    }

    public  int getRequestNo() {
        return requestNo;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public  void setRequestNo(int requestNo) {
        this.requestNo = requestNo;
    }

    public String getAdminRemark() {
        return adminRemark;
    }

    public void setAdminRemark(String adminRemark) {
        this.adminRemark = adminRemark;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public int getRoomType() {
        return roomtype;
    }

    public void setRoomType(int roomType) {
        this.roomtype = roomtype;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String isBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public int getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(int roomtype) {
        this.roomtype = roomtype;
    }

    public int getRoomAlloted() {
        return roomAlloted;
    }

    public void setRoomAlloted(int roomAlloted) {
        this.roomAlloted = roomAlloted;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void printBookingDetails(){
        System.out.println("Request number      : " + this.getRequestNo());
        System.out.println("Applicant name      : " + this.getUser().getName());
        System.out.println("Applicant's BITS Id : " + this.getUser().getId());
        System.out.println("Oragnization name   : "+ this.getUser().getOrg());
        System.out.println("No. of students     : " + this.noOfStudents);
        System.out.println("Room requested      : " + this.getRoomName());
        System.out.println("Slot requested      : " + BookingRequest.slotName(this.getSlotNo()));
        System.out.println("Purpose             : " + this.getPurpose());
        System.out.println("Booking Status      : " + this.isBookingStatus());
        System.out.println("Admin Remark        : " + this.getAdminRemark());
        System.out.println("Room Alloted        : " + this.getRoomAlloted());
    }

  public static String slotName(int slotNo){
   String slotName = "";
      Calendar now = Calendar.getInstance();
      switch (slotNo) {
          case (1):
              slotName = String.valueOf(now.get(Calendar.DATE) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR)) + " " + "4:00pm - 5:00pm";
              break;
          case (2):
              slotName = String.valueOf(now.get(Calendar.DATE) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR)) + " " + "5:00pm - 6:00pm";
              break;
          case (3):
              slotName = String.valueOf(now.get(Calendar.DATE) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR)) + " " + "6:00pm - 7:00pm";
              break;
          case (4):
              slotName = String.valueOf(now.get(Calendar.DATE) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR)) + " " + "7:00pm - 8:00pm";
              break;
          case (5):
              now.add(Calendar.DATE, 1);
              slotName = String.valueOf(now.get(Calendar.DATE) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR)) + " " + "4:00pm - 5:00pm";
              break;
          case (6):
              now.add(Calendar.DATE, 1);
              slotName = String.valueOf(now.get(Calendar.DATE) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR)) + " " + "5:00pm - 6:00pm";
              break;
          case (7):
              now.add(Calendar.DATE, 1);
              slotName = String.valueOf(now.get(Calendar.DATE) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR)) + " " + "6:00pm - 7:00pm";
              break;
          case (8):
              now.add(Calendar.DATE, 1);
              slotName = String.valueOf(now.get(Calendar.DATE) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR)) + " " + "7:00pm - 8:00pm";
              break;
          case (9):
              now.add(Calendar.DATE, 2);
              slotName = String.valueOf(now.get(Calendar.DATE) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR)) + " " + "4:00pm - 5:00pm";
              break;
          case (10):
              now.add(Calendar.DATE, 2);
              slotName = String.valueOf(now.get(Calendar.DATE) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR)) + " " + "5:00pm - 6:00pm";
              break;
          case (11):
              now.add(Calendar.DATE, 2);
              slotName = String.valueOf(now.get(Calendar.DATE) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR)) + " " + "6:00pm - 7:00pm";
              break;
          case (12):
              now.add(Calendar.DATE, 2);
              slotName = String.valueOf(now.get(Calendar.DATE) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR)) + " " + "7:00pm - 8:00pm";
              break;
               }
      return slotName ;
  }

}
