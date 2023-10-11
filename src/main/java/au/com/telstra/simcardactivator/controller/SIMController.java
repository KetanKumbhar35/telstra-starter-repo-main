package au.com.telstra.simcardactivator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import au.com.telstra.simcardactivator.Entity.ActuatorResponse;
import au.com.telstra.simcardactivator.Entity.SIMRequest;
import au.com.telstra.simcardactivator.Entity.actuatorRequest;

@RestController
public class SIMController {
	// Define the URL of the actuator microservice
    private static final String ACTUATOR_URL = "http://localhost:8444/actuate"; // Change this URL as needed

    // Autowire RestTemplate to make HTTP requests
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/activate")
    public ResponseEntity<String> activateSIM(@RequestBody SIMRequest simRequest) {
        // Create a request object for the actuator
        actuatorRequest actuatorRequest = new actuatorRequest(simRequest.getIccid());

        // Send a POST request to the actuator
        ResponseEntity<ActuatorResponse> responseEntity = restTemplate.postForEntity(
                ACTUATOR_URL,
                actuatorRequest,
                ActuatorResponse.class
        );

        // Get the response from the actuator
        ActuatorResponse actuatorResponse = responseEntity.getBody();

        // Check if the activation was successful
        boolean activationSuccess = actuatorResponse != null && actuatorResponse.isSuccess();

        // Print the result
        if (activationSuccess) {
            System.out.println("SIM card activation was successful.");
        } else {
            System.out.println("SIM card activation failed.");
        }

        // You can return a response based on your requirements
        return ResponseEntity.ok("Activation request received");
    }

}
