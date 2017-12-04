package ch.sebooom.microservices;

import java.io.IOException;

public class AllSystemLaunch {

    public static void main(String[] args) throws IOException {

        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec("mvn spring-boot:run");
    }
}
