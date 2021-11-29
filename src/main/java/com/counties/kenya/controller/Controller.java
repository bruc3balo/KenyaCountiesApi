package com.counties.kenya.controller;

import com.counties.kenya.models.County;
import com.counties.kenya.models.SubCounty;
import com.counties.kenya.models.Ward;
import com.counties.kenya.utils.MyApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping(value = "/kenya", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
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

            List<County> countyTypeList = dataService.getCounties(countyName, id != null ? String.valueOf(id) : null, deleted);

            MyApiResponse response = new MyApiResponse(countyTypeList.isEmpty() ? "No counties found" : "List of counties found (" + countyTypeList.size() + ")", countyTypeList);
            return new ResponseEntity<>(response, countyTypeList.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            MyApiResponse response = new MyApiResponse(e.getLocalizedMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //SubCountyType
    @GetMapping(value = {"sub_county"}, produces = {"application/json"})
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiOperation(value = "Get sub county config list", httpMethod = "GET", notes = "Get list of sub county config")
    public ResponseEntity<?> getConfigSubCountyTypeList(HttpServletRequest request,
                                                        @RequestParam(value = "id", required = false) Integer id,
                                                        @RequestParam(value = "county_id", required = false) Integer countyId,
                                                        @RequestParam(value = "deleted", required = false) Boolean deleted,
                                                        @RequestParam(value = "name", required = false) String name,
                                                        @RequestParam(value = "page", required = false) String page,
                                                        @RequestParam(value = "page_size", required = false) String pageSize) {

        try {

            List<String> unknownParams = filterRequestParams(request, Arrays.asList("id", "name", "ward", "deleted", "county_id", "page", "page_size"));
            if (!unknownParams.isEmpty()) {
                // get all errors
                String apiDesc = unknownParams.stream().map(x -> "'" + x.toUpperCase() + "'").collect(Collectors.joining(", ")) + " : Not valid Parameters";
                MyApiResponse response = new MyApiResponse(apiDesc);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            int pageNo = (page != null && Integer.parseInt(page) > 0) ? Integer.parseInt(page) - 1 : 0;
            int pageRequestSize = (pageSize != null && Integer.parseInt(pageSize) > 0) ? Integer.parseInt(pageSize) : Integer.MAX_VALUE;

            List<SubCounty> subCountyList = dataService.getSubCounties(name, id != null ? String.valueOf(id) : null, countyId != null ?String.valueOf(countyId) : null, deleted);


            MyApiResponse response = new MyApiResponse(subCountyList.isEmpty() ? "No sub country page found" : "Page size " + pageRequestSize + " at page number " + pageNo + " of sub country found (" + subCountyList.size() + ")", subCountyList);
            return new ResponseEntity<>(response, subCountyList.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            MyApiResponse response = new MyApiResponse(e.getLocalizedMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //SubCountyType
    @GetMapping(value = {"ward"}, produces = {"application/json"})
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiOperation(value = "Get ward list", httpMethod = "GET", notes = "Get list of wards")
    public ResponseEntity<?> getWardList(HttpServletRequest request,
                                         @RequestParam(value = "id", required = false) Integer id,
                                         @RequestParam(value = "sub_county_id", required = false) Integer subCountyId,
                                         @RequestParam(value = "deleted", required = false) Boolean deleted,
                                         @RequestParam(value = "name", required = false) String name,
                                         @RequestParam(value = "page", required = false) String page,
                                         @RequestParam(value = "page_size", required = false) String pageSize) {

        try {

            List<String> unknownParams = filterRequestParams(request, Arrays.asList("id", "name", "sub_county_id", "deleted", "page", "page_size"));
            if (!unknownParams.isEmpty()) {
                // get all errors
                String apiDesc = unknownParams.stream().map(x -> "'" + x.toUpperCase() + "'").collect(Collectors.joining(", ")) + " : Not valid Parameters";
                MyApiResponse response = new MyApiResponse(apiDesc);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            int pageNo = (page != null && Integer.parseInt(page) > 0) ? Integer.parseInt(page) - 1 : 0;
            int pageRequestSize = (pageSize != null && Integer.parseInt(pageSize) > 0) ? Integer.parseInt(pageSize) : Integer.MAX_VALUE;
            List<Ward> wardList = dataService.getWard(name, id != null ? String.valueOf(id) : null, subCountyId != null ? String.valueOf(subCountyId) : null, deleted);

            MyApiResponse response = new MyApiResponse(wardList.isEmpty() ? "No ward page found" : "Page size " + pageRequestSize + " at page number " + pageNo + " of wards found (" + wardList.size() + ")", wardList);
            return new ResponseEntity<>(response, wardList.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
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
