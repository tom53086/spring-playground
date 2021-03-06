package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static java.util.Calendar.APRIL;

@RestController
public class PagesController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
    @GetMapping("/bestDog")
    public String getBestDog(){
        return "Griffin, of course!";
    }

    @GetMapping("/math/pi")
    public String getPie() {
        return "3.141592653589793";
    }

    @GetMapping("/math/calculate")
    public String calculate(@RequestParam(required = false) String operation, int x, int y){
        if (operation.equals("subtract")) {
            return x + " - " + y + " = " + (x - y);
        } else if (operation.equals("multiply")) {
            return x + " * " + y + " = " + (x * y);
        } else if (operation.equals("divide")) {
            return x + " / " + y + " = " + (x / y);
        }else {
            return x + " + " + y + " = " + (x + y);
        }
    }

    @GetMapping("/math/calculate2")
    public String calculate2(@RequestParam(defaultValue = "add") String operation, @RequestParam int x,@RequestParam int y){
        return MathService.calculate(operation, x, y).toString();
    }

    @PostMapping("/math/sum")
    public String sum(@RequestParam Integer[] n){
        return MathService.sum(n).toString();
    }

    @RequestMapping("/math/volume/{length}/{width}/{height}")
    public String volume(@PathVariable int length, @PathVariable int width, @PathVariable int height){
        int result = length * width * height;
        return String.format("The volume of a %dx%dx%d rectangle is %d", length, width, height, result);
    }

    @PostMapping(value = "/math/area")
    public String area(@RequestParam HashMap<String, String> formData){
        if(formData.get("type").equals("circle")){
            if(!formData.containsKey("radius")) return "Invalid";

            double radius = Double.parseDouble(formData.get("radius"));
            double result = Math.PI * radius * radius;
            return String.format("Area of a circle with a radius of %.0f is %.5f", radius, result);

        } else if(formData.get("type").equals("rectangle")){
           if(!(formData.containsKey("width") && formData.containsKey("height"))) return "Invalid";

            int width = Integer.parseInt(formData.get("width"));
            int height = Integer.parseInt(formData.get("height"));
            int result = width * height;
            return String.format("Area of a %dx%d rectangle is %d", width, height, result);
        }
        return "Invalid. Need to submit a circle or rectangle";
    }

    @GetMapping("/flights/flight")
    public Flight getFlight(){
        Flight.Person person = new Flight.Person();
        person.setFirstName("Some name");
        person.setLastName("Some other name");

        Flight.Ticket ticket = new Flight.Ticket();
        ticket.setPassenger(person);
        ticket.setPrice(200);

        Flight flight = new Flight();
        flight.setDeparts(new Date(2017 - 1900, APRIL, 21, 14, 34));
        flight.setTickets(Arrays.asList(ticket));

        return flight;
    }

    @GetMapping("/flights")
    public List<Flight> getListOfFlights(){
        Flight.Person person1 = new Flight.Person();
        person1.setFirstName("Some name");
        person1.setLastName("Some other name");

        Flight.Ticket ticket1 = new Flight.Ticket();
        ticket1.setPassenger(person1);
        ticket1.setPrice(200);

        Flight flight1 = new Flight();
        flight1.setDeparts(new Date(2017 - 1900, APRIL, 21, 14, 34));
        flight1.setTickets(Arrays.asList(ticket1));

        Flight.Person person2 = new Flight.Person();
        person2.setFirstName("Some name");

        Flight.Ticket ticket2 = new Flight.Ticket();
        ticket2.setPassenger(person2);
        ticket2.setPrice(400);

        Flight flight2 = new Flight();
        flight2.setDeparts(new Date(2017 - 1900, APRIL, 21, 14, 34));
        flight2.setTickets(Arrays.asList(ticket2));

        return Arrays.asList(flight1, flight2);
    }
}
