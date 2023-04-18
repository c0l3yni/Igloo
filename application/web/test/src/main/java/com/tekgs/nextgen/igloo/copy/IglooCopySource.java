package com.tekgs.nextgen.igloo.copy;

public class IglooCopySource {
    public static IglooCopySource getInstance() {
        return new IglooCopySource();
    }

    public String getSuccessMessage() {
        return "Payment Successful :)";
    }
}
