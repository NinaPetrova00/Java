package com.citb408;

import com.citb408.bank.*;
import com.citb408.box.Box;
import com.citb408.hotel.Hotel;
import com.citb408.hotel.InsufficientNumberOfRoomsException;
import com.citb408.hotel.RoomIsRentedException;

public class Main {

    public static void main(String[] args) {
        // Task 1 - Box
        {
        Box box = new Box(2, 3, 4);
        box.increaseDimensions(5);
        System.out.println(box);

        try{
            box.increaseDimensions(120);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }
            System.out.println(box);

        box.optionalIncreaseDimensions(10,100);
        }

        // Task 2 - Hotel
        {
            Hotel hotel = new Hotel(5);
            try {
                hotel.rentRoom(1);
                hotel.rentRoom(2);
                hotel.rentRoom(3);
                hotel.rentRoom(4);
                hotel.rentRoom(5);
                hotel.rentRoom(6);
            } catch (InsufficientNumberOfRoomsException e) {
                e.printStackTrace();
            } catch (RoomIsRentedException e) {
                e.printStackTrace();
            }
        }

        // Task 3 - Bank
        {
            Bank unicreditBulbank = new Bank("UnicreditBulbank", 800, 5000);
            Customer maria = new Customer("Maria");
            Account mariasAccount = new Account(maria, "UNCR10BG1234567890");

            unicreditBulbank.addAccount(mariasAccount);
            //unicreditBulbank.deposit(mariasAccount, -1000);

            unicreditBulbank.deposit(mariasAccount, 1000);
            unicreditBulbank.displayAccounts();

            try {
                unicreditBulbank.withdrawATM(mariasAccount, 500);
                unicreditBulbank.withdrawATM(mariasAccount, 600);
                unicreditBulbank.withdrawCashDesk(mariasAccount, 6000);
            } catch (LimitExceededException e) {
                e.printStackTrace();
            } catch (NotEnoughFundsException e) {
                e.printStackTrace();
            }
        }
    }
}
