package com.counties.kenya.controller;

import com.counties.kenya.models.County;
import com.counties.kenya.utils.MyApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

import static com.counties.kenya.repository.Repos.dataService;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Api(tags = "Counties", value = "Counties", produces = "application/json")
public class Controller {

    @GetMapping(value = {"county"}, produces = {"application/json"})
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiOperation(value = "Get county config list", httpMethod = "GET", notes = "Get list of county config")
    public ResponseEntity<?> getConfigCountyTypeList(HttpServletRequest request,
                                                     @RequestParam(value = "deleted", required = false) Boolean deleted,
                                                     @RequestParam(value = "id", required = false) Integer id,
                                                     @RequestParam(value = "name", required = false) String countyName) {

        try {

            List<String> unknownParams = filterRequestParams(request, Arrays.asList("id", "name", "deleted"));
            if (!unknownParams.isEmpty()) {
                // get all errors
                String apiDesc = unknownParams.stream().map(x -> "'" + x.toUpperCase() + "'").collect(Collectors.joining(", ")) + " : Not valid Parameters";
                MyApiResponse response = new MyApiResponse(apiDesc);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            List<County> countyTypeList = dataService.getCounties(PageRequest.of(0,Integer.MAX_VALUE)).getContent();

            MyApiResponse response = new MyApiResponse(countyTypeList.isEmpty() ? "No counties found" : "List of counties found (" + countyTypeList.size() + ")", countyTypeList);
            return new ResponseEntity<>(response, countyTypeList.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            MyApiResponse response = new MyApiResponse(e.getLocalizedMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public static List<String> filterRequestParams(HttpServletRequest request, List<String> knownParams) {
        Enumeration<String> query = request.getParameterNames();
        List<String> list = Collections.list(query);
        list.removeAll(knownParams);
        return list;
    }

}
