package com.kogentix.rest.controller;

import com.kogentix.client.MySqlClient;
import org.restexpress.Request;
import org.restexpress.Response;
import java.util.Collections;
import java.util.List;


public class Controller {
    public Controller() {

        super();
    }

    public String create(Request request, Response response) {
        //TODO: Your 'POST' logic here...
        return null;

    }

    public List<Object> read(Request request, Response response) {
        //TODO: Your 'GET' logic here...

        String tableName = request.getHeader("tableName");
        MySqlClient obj = new MySqlClient();
        List<Object> result = obj.select(tableName);
        return result;
    }


    public List<Object> readAll(Request request, Response response) {
        //TODO: Your 'GET collection' logic here...
        return Collections.emptyList();
    }

    public String update(Request request, Response response) {
        //TODO: Your 'PUT' logic here...

        String tableName = request.getHeader("tableName");
        String values = request.getHeader("values");

        MySqlClient obj = new MySqlClient();
        String result = obj.insert(tableName, values);
        return result;

        //response.setResponseNoContent();
    }

    public void delete(Request request, Response response) {
        //TODO: Your 'DELETE' logic here...
        response.setResponseNoContent();
    }
}
