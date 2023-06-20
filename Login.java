package RoomBooking;

import java.util.Map;
import java.util.Scanner;

public class Login {
    int exit;
    public Login(){this.exit=0;}

    public int newUserLogin(){
        Scanner sc = new Scanner(System.in);
//        System.out.println(this.getClass().getCanonicalName());

        System.out.println("-----Welcome to Registration Portal-----");
        System.out.println("Please provide the following details :- ");
        System.out.println("Enter Organization name (Type \"None\" if none) :");
        String org = sc.nextLine();
        System.out.print("Enter name : ");
        String name= sc.nextLine();
        System.out.print("Enter ID : ");
        String id = sc.nextLine();
        User newUser = new User(name, id , org);
        Thread userObject = new Thread(newUser);
        userObject.start();
        System.out.print("Enter purpose : ");
        String purpose = sc.nextLine();
        System.out.print("Enter no. of students : ");
        int no_students = sc.nextInt();
        System.out.println("Select the RoomBooking.Room type: ");
        System.out.println("Press 1 for NAB Audi with capacity of 150 students \nPress 2 for LTC Hall with capacity of 100 students \nPress 3 for RoomBooking.Library Brainstorming room with capacity of 25 students");
        int roomtype = sc.nextInt();
        if(User.checkCapacity(no_students , roomtype)==1)
        { return 0;}
        System.out.println("-------Displaying available slots-------");
        switch(roomtype){
            case 1: newUser.checkAvailabiity(Main.nab); break;
            case 2: newUser.checkAvailabiity(Main.ltc); break;
            case 3: newUser.checkAvailabiity(Main.lib); break;
        }
        System.out.print("Enter your preferred slot no. : ");
        int slotNo = sc.nextInt();
        BookingRequest request = new BookingRequest(newUser,purpose, slotNo,roomtype,"" , 0,no_students);
        Main.userList.put(newUser.getName(), newUser.getId());
        newUser.makeRequest(Main.requestList,request);
        System.out.println("User "+newUser.getName()+" has been registered successfully and request made successfully !");
        System.out.println("---------------------------------");
        System.out.println("Press 0 to continue and 1 to exit");
        exit = sc.nextInt();
        userObject.interrupt();
        return exit;
    }

    public int registeredUserLogin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Login to existing account-----");
        System.out.print("Enter name : ");
        String name = sc.nextLine();
        System.out.print("Enter BITS ID : ");
        String id = sc.nextLine();
        int valid = 0;
        for (Map.Entry<String,String> userElement : Main.userList.entrySet()){
            if(userElement.getKey().equals(name) && userElement.getValue().equals(id)){ valid = 1; break; }
        }
        if(valid==0) { System.out.println("Invalid user !");}
        else {
            System.out.println("Login successful !");
            System.out.println("-----Displaying Application Status-----");
            User newUser = new User(name, id);
            Thread userObject = new Thread(newUser);
            userObject.start();
            int approved = newUser.track(Main.requestList);
            System.out.println("---------------------------------");
            if(approved == 0){
            System.out.println("Press 1 for editing the purpose of application \nPress 2 for deleting the application");
            int choice3 = sc.nextInt();
            switch (choice3){
                case 1: System.out.print("Enter new purpose: ");
                    String purpose = sc.next();
                    newUser.updatePurpose(Main.requestList,purpose);
                    System.out.println("Purpose edited successfully");
                    System.out.println("Press 0 to continue and 1 to exit");
                    exit = sc.nextInt();
                    userObject.interrupt();
                    break;
                case 2 : System.out.println("Deleting request.....");
                    newUser.deleteRequest(Main.requestList);
                    System.out.println("Request deleted successfully");
                    System.out.println("Press 0 to continue and 1 to exit");
                    exit = sc.nextInt();
                    userObject.interrupt();
                    break;
            } }  else {
                System.out.println("Press 0 to continue and 1 to exit");
                exit = sc.nextInt();
            }
        }
        return exit;
    }

    public int adminLogin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("----Welcome to Admin Mode----");
        System.out.println("Enter Admin Id : ");
        String name = sc.next();
        System.out.println("Enter Admin password : ");
        String password = sc.next();
        if(Main.admin.name .equals(name) && Main.admin.password.equals(password)){
            System.out.println("Admin login successful !");
            System.out.println("------------------------");
            int logout = 0 ;
            while(logout ==0) {
                System.out.println("Press 1 to view all pending requests \nPress 2 to view all rooms \nPress 3 to logout");
                int choice4 = sc.nextInt();
                switch (choice4) {
                    case 1: if(BookingRequest.totalRequests !=0){
                        System.out.println("Displaying all pending requests");
                        Main.admin.getAllRequests(Main.requestList);
                        System.out.println("------------------------");
                        System.out.println("Select a request (Enter request no.) OR press 0 to logout");
                        int choice5 = sc.nextInt();
                        if(choice5==0) {
                            System.out.println("Logging out..........");
                         logout=1 ; break;}
                        int approved = Main.admin.showARequest(Main.requestList, choice5);
                        if(approved == 0 ){
                        System.out.println("Press 1 to approve the request \nPress 2 to disapprove the request \nPress 3 to ask the applicant for a more elaborated purpose");
                        int choice6 = sc.nextInt();
                        Main.admin.bookRoom(choice5, choice6); }  }
                        else System.out.println("No pending requests");
                        System.out.println("------------------------");
                        break;
                    case 2:
                        System.out.println("Displaying all rooms");
                        System.out.println("------------------------");
                        System.out.println("Nab Audi:");
                        Main.nab.showAllRooms();
                        System.out.println("------------------------");
                        System.out.println("Ltc Halls:");
                        Main.ltc.showAllRooms();
                        System.out.println("------------------------");
                        System.out.println("Library Brainstorming Room:");
                        Main.lib.showAllRooms();
                        break;
                    case 3 : logout = 1;
                    break;
                }
            }
        }
        else { System.out.println("Invalid admin credentials!!! Try again.    ") ;}
        System.out.println("Press 0 to continue and 1 to exit");
        exit = sc.nextInt();
        return exit;
    }
}
