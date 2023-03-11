package org.mattpayne.learning.sm1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;


@SpringBootApplication
public class Sm1Application implements CommandLineRunner  {

    @Autowired
    private StateMachine<States, Events> stateMachine;
    public static void main(final String[] args) {
        SpringApplication.run(Sm1Application.class, args);
    }

        @Override
        public void run(String... args) throws Exception {
           stateMachine.sendEvent(Events.COIN);
           stateMachine.sendEvent(Events.PUSH);
            State<States, Events> current = stateMachine.getState();
            System.out.println("Current state: " + current.getId());

        }

}

