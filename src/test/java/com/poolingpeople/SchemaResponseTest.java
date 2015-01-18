package com.poolingpeople;

import com.poolingpeople.utils.neo4jApi.SchemaResponse;
import org.junit.Test;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;

public class SchemaResponseTest {


//    @Test
//    public void testGetConstraints() throws Exception {
//
//        String json = "[ {" +
//                " \"property_keys\" : [ \"bar\" ]," +
//                " \"label\" : \"Foo\"," +
//                " \"type\" : \"UNIQUE\"" +
//                "}, {" +
//                " \"property_keys\" : [ \"uuid\" ]," +
//                " \"label\" : \"UUID\"," +
//                " \"type\" : \"UNIQUE\"" +
//                "} ]";
//
//        Response mockResponse = getMockResponse(json);
//        SchemaResponse r = new SchemaResponse().load(mockResponse);
//
//        List<Map<String, Object>> receivedItems = r.getReceivedDataAsMap();
//
//        assertTrue(r.hasResponseItem());
//        assertEquals(receivedItems.get(0).get("label"), "Foo");
//        assertEquals(receivedItems.get(1).get("type"), "UNIQUE");
//        assertEquals(((List)receivedItems.get(0).get("properties")).get(0), "bar");
//        assertEquals(receivedItems.get(1).get("label"), "UUID");
//        assertEquals(receivedItems.get(1).get("type"), "UNIQUE");
//        assertEquals(((List) (receivedItems.get(1)).get("properties")).get(0), "uuid");
//
//    }
//
//    @Test
//    public void testGetIndexes() throws Exception {
//
//        String json = "[ {" +
//                " \"property_keys\" : [ \"bar\" ]," +
//                " \"label\" : \"Foo\"" +
//                "}, {" +
//                " \"property_keys\" : [ \"uuid\" ]," +
//                " \"label\" : \"UUID\"" +
//                "} ]";
//
//        Response mockResponse = getMockResponse(json);
//        SchemaResponse r = new SchemaResponse().load(mockResponse);
//
//        List<Map<String, Object>> receivedItems = r.getReceivedDataAsMap();
//
//        assertTrue(r.hasResponseItem());
//        assertEquals(receivedItems.get(0).get("label"), "Foo");
//        assertEquals(receivedItems.get(0).get("type"), "INDEX");
//        assertEquals(((List)receivedItems.get(0).get("properties")).get(0), "bar");
//        assertEquals(receivedItems.get(1).get("label"), "UUID");
//        assertEquals(receivedItems.get(1).get("type"), "INDEX");
//        assertEquals(((List) (receivedItems.get(1)).get("properties")).get(0), "uuid");
//
//    }
//
//    private Response getMockResponse(String json){
//        Response mockResponse = mock(Response.class);
//        when(mockResponse.readEntity(String.class)).thenReturn(json);
//
//        when(mockResponse.getStatus()).thenReturn(200);
//        when(mockResponse.getMediaType()).thenReturn(MediaType.APPLICATION_JSON_TYPE);
//        return mockResponse;
//    }

}
