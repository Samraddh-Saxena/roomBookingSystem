package RoomBooking;

import java.util.*;

public class Main {
    static HashMap<String, String> userList = new HashMap<>();
    static List <BookingRequest> requestList = new ArrayList<>();
    static Room nab = new Nab();
    static Room ltc = new Ltc();
    static Room lib = new Library();
    static Admin admin = new Admin();
    {
        Thread adminObject = new Thread(admin);
        adminObject.start();
    }

    public static void main(String[] args) {
        Login login = new Login();
        Scanner sc = new Scanner(System.in);
        int exit = 0;
        while(exit !=1){

            System.out.println("-----Welcome to Room Booking Management System-----");
            System.out.println("Press 1 for User mode \nPress 2 for Admin mode \nPress 3 to exit");
            int choice1 = sc.nextInt() ;
            System.out.println("---------------------------------------------------");
            switch(choice1){
                case 1: System.out.println("Press 1 for New User \nPress 2 for Registered User");
                    int choice2 = sc.nextInt();
                    switch (choice2){
                        case 1:  exit = login.newUserLogin() ;
                            break;
                        case 2 : exit = login.registeredUserLogin();
                            break;
                    }
                    break;
                case 2 : exit = login.adminLogin();
                    break;
                case 3: System.out.println("Terminating the program.....");
                exit = 1;
                break;
            }
        }

    }
}