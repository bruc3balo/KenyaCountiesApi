package com.counties.kenya;

import com.counties.kenya.models.County;
import com.counties.kenya.models.SubCounty;
import com.counties.kenya.models.Ward;
import com.counties.kenya.utils.JsonResponse;
import com.counties.kenya.utils.JsonResponse2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static com.counties.kenya.repository.Repos.dataService;

@SpringBootApplication
@EnableScheduling
@CrossOrigin("*")
@Slf4j
public class KenyaCountiesApplication {
    public static void main(String[] args) {
        SpringApplication.run(KenyaCountiesApplication.class, args);
    }

    private final String bearer = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsic21lLWFwaSJdLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNjM4MTk3NjUyLCJqdGkiOiI2MWE0ZDg2MS02MjFiLTQ4ZGYtODhmMC1hNGI4MzU1NjUxMDYiLCJjbGllbnRfaWQiOiI4YXNqQ0ZudmhaUWF3aFE2M2Rib1BJVjF0dXdYOGt5cCJ9.XGUCxa-Gv8z7FsFkp6qRCTAbD-Tj0V82CdtpRl3JHoc";

    @Bean
    CommandLineRunner runner() {
        return args -> {

            try {
                 addCounties();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    addSubCounty();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        addWard();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        };

    }

    private void addCounties() {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://192.168.20.18:5043/api/v1/config/county")
                .header("Authorization", bearer)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                ObjectMapper mapper = new ObjectMapper();
                mapper.findAndRegisterModules();

                String data = Objects.requireNonNull(response.body()).string();
                JsonResponse res = mapper.readValue(data, JsonResponse.class);
                List countyList = mapper.readValue(mapper.writeValueAsString(res.getData()), List.class);
                countyList.forEach(c -> {

                    try {
                        County county = mapper.readValue(mapper.writeValueAsString(c), County.class);
                        log.info(mapper.writeValueAsString(county));
                        county.setCreatedAt(LocalDateTime.now().toString());
                        dataService.saveCounty(county);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    //
                });
            }

        });

    }

    private void addWard() {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://192.168.20.18:5043/api/v1/config/ward")
                .header("Authorization", bearer)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                ObjectMapper mapper = new ObjectMapper();
                mapper.findAndRegisterModules();

                String data = Objects.requireNonNull(response.body()).string();
                JsonResponse2 res = mapper.readValue(data, JsonResponse2.class);

                List wardList = mapper.readValue(mapper.writeValueAsString(res.getData().getContent()), List.class);
                log.info(String.valueOf(wardList.size()));
                wardList.forEach(c -> {

                    try {
                        Ward ward = mapper.readValue(mapper.writeValueAsString(c), Ward.class);
                        log.info(mapper.writeValueAsString(ward));
                        ward.setCreatedAt(LocalDateTime.now().toString());
                        dataService.saveWard(ward);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    //
                });
            }

        });
    }

    private void addSubCounty() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://192.168.20.18:5043/api/v1/config/sub_county")
                .header("Authorization", bearer)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                ObjectMapper mapper = new ObjectMapper();
                mapper.findAndRegisterModules();

                String data = Objects.requireNonNull(response.body()).string();
                JsonResponse2 res = mapper.readValue(data, JsonResponse2.class);

                List subCountyList = mapper.readValue(mapper.writeValueAsString(res.getData().getContent()), List.class);
                log.info(String.valueOf(subCountyList.size()));
                subCountyList.forEach(c -> {

                    try {
                        SubCounty subCounty = mapper.readValue(mapper.writeValueAsString(c), SubCounty.class);
                        log.info(mapper.writeValueAsString(subCounty));
                        subCounty.setCreatedAt(LocalDateTime.now().toString());
                        dataService.saveSubCounty(subCounty);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }

                });
            }

        });
    }
}
