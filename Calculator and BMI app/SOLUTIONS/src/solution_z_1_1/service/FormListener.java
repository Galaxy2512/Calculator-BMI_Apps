package solution_z_1_1.service;

import java.util.EventListener;

//event listener interface is used to create a custom event listener. It is used to create a custom event
// listener that will be used to listen for the event that will be created when the button is clicked.

public interface FormListener extends EventListener { // import the EventListener interface
    void calculateSubmitted(FormEvent event); // create a method that will be called when the event occurs

    //events in java are objects that are created when something happens. Meaning that when a button is clicked, an event is created.
}