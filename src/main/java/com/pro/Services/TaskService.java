package com.pro.Services;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pro.Config.Resttemplate;
import com.pro.Model.Location;
import com.pro.Model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.client.RestTemplate;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by muhamd gomaa on 12/14/2017.
 */

@Service
public class TaskService {

    @Autowired
    RestTemplate restTemplate;

    final String uri = "https://maps.googleapis.com/maps/api/geocode/json?address={address}&key=AIzaSyAYHV8FwZJYOMLZXXQW7oDwy0hclrKihmw";

    public Result getAddress(String address)
    {

        Map<String, String> params = new HashMap<>();
        params.put("address", address);

        restTemplate = new RestTemplate();
        Result result = restTemplate.getForObject(uri,Result.class, params);



        System.out.println(result);
        System.out.println(result.getFormattedAddress());

        return result;
    }


}









