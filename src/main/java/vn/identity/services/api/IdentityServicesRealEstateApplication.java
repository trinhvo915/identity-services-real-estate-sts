package vn.identity.services.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import vn.identity.services.api.entity.Diem;
import vn.identity.services.api.repository.DiemRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@SpringBootApplication
@EnableJpaAuditing
@Slf4j
public class IdentityServicesRealEstateApplication {

    public static void main(String[] args)  {
        SpringApplication.run(IdentityServicesRealEstateApplication.class, args);
    }

}
