package com.ajirasoft.challenge;

import com.ajirasoft.challenge.services.AppService;

public class MainApplication {

    public static void main(String[] args) {
        if(args.length == 3) {
            AppService appService = new AppService();
            boolean result = appService.execute(args[0], args[1], args[2]);
            if(!result) {
                System.out.println("Unable to process the data!!!");
            } else {
                System.out.println("Data has been successfully processed at location : " + args[2]);
            }
        } else {
            System.out.println("Argument length does not match");
        }
    }
}
