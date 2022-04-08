package com.graphl.graphqlspringboot.controller;

import com.graphl.graphqlspringboot.service.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GraphQLController {

    @Autowired
    GraphQLService graphQLService;

    @RequestMapping(value="/stockData")
    public String getPreAuthDecisionData(@RequestBody String query) {
        ExecutionResult execute = graphQLService.initiateGraphQL().execute(query);
        Map<String, String> obj = execute.getData();
        JSONObject jsonObject = new JSONObject(obj);
        return jsonObject.toString();
    }
}
