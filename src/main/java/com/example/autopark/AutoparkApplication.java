package com.example.autopark;

import com.example.autopark.entity.Auto;
import com.example.autopark.entity.Auto_personnel;
import com.example.autopark.entity.Journal;
import com.example.autopark.entity.Routes;
import com.example.autopark.repository.AutoRepository;
import com.example.autopark.repository.Auto_personnelRepository;
import com.example.autopark.repository.JournalRepository;
import com.example.autopark.repository.RoutesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;

@SpringBootApplication
public class AutoparkApplication {

    private static final Logger log = LoggerFactory.getLogger(AutoparkApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AutoparkApplication.class, args);
    }

/*    @Bean
    public CommandLineRunner test(Auto_personnelRepository auto_personnelRepository,
                                  AutoRepository autoRepository,
                                  JournalRepository journalRepository,
                                  RoutesRepository routesRepository){
        return args -> {
            //journalRepository.save(new Journal(new Timestamp(5410),new Timestamp(5511)));
            Auto_personnel auto_personnel = new Auto_personnel("qwerty","asdfgh","zxcvb");
            auto_personnelRepository.save(auto_personnel);
            Routes routes = new Routes("Piter-Kaliningrad");
            routesRepository.save(routes);
            Auto auto = new Auto("rus","zaz","red", auto_personnel);
            Auto auto1 = new Auto("rus","zaz","red", auto_personnel);
            Auto auto2 = new Auto();
            autoRepository.save(auto);
            autoRepository.save(auto1);
            auto2.setAuto_pk_id(999L);
            auto2.setColor("hp");
            auto2.setMark("vaz");
            auto2.setNum("4321ababoy");
            auto2.setAuto_personnel(auto_personnel);
            autoRepository.save(auto2);
            journalRepository.save(new Journal(new Timestamp(12L),new Timestamp(11L),auto,routes));
            //autoRepository.save(new Auto("rus","zaz","red", auto_personnel.getAuto_personnel_pk_id()));
            //auto_personnelRepository.save(new Auto_personnel("SecondApp","My second app"));

            for(Auto_personnel app: auto_personnelRepository.findAll()){
                log.info("The application is: " + app.toString());
            }
            for(Auto app: autoRepository.findAll()){
                log.info("The application is: " + app.toString());
            }
            for(Journal app: journalRepository.findAll()){
                log.info("The application is: " + app.toString());
            }
            for(Routes app: routesRepository.findAll()){
                log.info("The application is: " + app.toString());
            }
        };
    }*/
}
