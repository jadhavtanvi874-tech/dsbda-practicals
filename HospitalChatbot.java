import java.util.Scanner;

public class HospitalChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Hospital Chatbot =====");

        System.out.println("1. Doctor Timing");
        System.out.println("2. Emergency Number");
        System.out.println("3. Book Appointment");
        System.out.println("4. Hospital Address");
        System.out.println("5. Ambulance Service");
        System.out.println("6. Available Doctors");
        System.out.println("7. Exit");

        System.out.print("Enter Choice: ");
        int choice = sc.nextInt();

        switch(choice) {

            case 1:
                System.out.println("Doctors available from 10 AM to 5 PM");
                break;

            case 2:
                System.out.println("Emergency Number: 108");
                break;

            case 3:
                System.out.println("Appointment Booked Successfully");
                break;

            case 4:
                System.out.println("Address: City Hospital, Nashik");
                break;

            case 5:
                System.out.println("Ambulance Service Available 24 Hours");
                break;

            case 6:
                System.out.println("Doctors: Dr. Sharma, Dr. Patil");
                break;

            case 7:
                System.out.println("Thank You!");
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}