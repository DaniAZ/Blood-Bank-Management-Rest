package edu.mum.bloodbankrest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@SpringBootApplication
public class BloodbankrestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloodbankrestApplication.class, args);
    }




}
