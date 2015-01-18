package com.poolingpeople.utils.neo4jApi;

//import com.poolingpeople.testUtils.EmbeddedTestServer;
//import com.poolingpeople.testUtils.LocalNeo4jRestServer;
import org.apache.commons.io.IOUtils;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.ws.rs.core.Response;
import java.io.BufferedInputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//import org.neo4j.shell;

//@RunWith(JUnit4.class)
public class ResponseParserTest {

//    static LocalNeo4jRestServer neo4jServer;
//
//    @BeforeClass
//    public static void startNeo4j() {
//        neo4jServer = new EmbeddedTestServer().withPropertiesFile("neo4j-server.properties");
//        neo4jServer.startup();
//    }
//
//    @After
//    public void tearDown() {
//        neo4jServer.clean();
//    }
//
//    @AfterClass
//    public static void stopNeo4j() throws Exception {
//        neo4jServer.shutdown();
//    }
//
//    @Test
//    @Ignore
//    public void testRunParametrizedCypherQuery(){
//        String q = "MATCH (n:uuid { uuid: \"61a26134-062d-401d-93b9-5cce763f1835\" }) " +
//                "RETURN n.dateIssued AS dateIssued, n.occupation AS occupation, n.givenName AS givenName, " +
//                "n.postalCode AS postalCode, n.privacy AS privacy, n.description AS description, " +
//                "n.dateModified AS dateModified, n.type AS type, n.uuid AS uuid, n.password AS password, " +
//                "n.familyName AS familyName, n.registrationCode AS registrationCode, n.location AS location, " +
//                "n.state AS state, n.addressLocality AS addressLocality, n.email AS email\n";
//
//        ResponseParser responseParser = new ResponseParser();
//        Neo4jRestApiAdapter adapter = new Neo4jRestApiAdapterImpl();
//
//        List<Map<String, Object>> r = adapter.runParametrizedCypherQuery(q);
//    }
//
//    @Test
//    public void testShortCypherResponse(){
//        ResponseParser responseParser = new ResponseParser();
//
//        Collection<Map<String,Map<String,Object>>> result =
//                responseParser.parse(getClass().getClassLoader().getResourceAsStream("shortCypherResponse.json"));
//
//        assertEquals(1, result.size());
//        Map<String,Map<String,Object>> row = result.iterator().next();
//        Map<String,Object> component = row.get("component");
//        assertNotNull(component);
//
//        assertEquals(component.size(), 15);
//        assertEquals(component.get("occupation"), "Developer");
//        assertEquals(component.get("location"), "Darmstadt");
//        assertEquals(component.get("type"), "person");
//        assertEquals(component.get("description"), "Das ist Sebastian");
//
////        String query = "MATCH (component)-[r:owner|observer]->(main:uuid {uuid:{main}}) return component";
////
////        Neo4jRestApiAdapter adapter = new Neo4jRestApiAdapterImpl();
////
////        Map<String, Object> params = new HashMap<>();
////        params.put("main", "1e5e4dbe-32ff-4cf9-a7fa-243fed09e8fa");
////
////
////        result = adapter.runCypherQuery(query, params);
////
////        assertEquals(1, result.size());
////        row = result.iterator().next();
////        component = row.get("component");
////        assertNotNull(component);
////
////        assertEquals(component.size(), 15);
////        assertEquals(component.get("occupation"), "Developer");
////        assertEquals(component.get("location"), "Darmstadt");
////        assertEquals(component.get("type"), "person");
////        assertEquals(component.get("description"), "Das ist Sebastian");
//    }
//
//    @Test
//    public void testShortCypherResponseOnServer(){
//
//    }
//
//    @Test
//    public void testListResponse() throws Exception {
//        ResponseParser responseParser = new ResponseParser();
//        List<Map<String, Object>> result = responseParser.parseList(
//                getClass().getClassLoader().getResourceAsStream("attributesJson.json"));
//
//        assertEquals(25, result.size());
//        result.get(0).get("n.uuid").equals("df7ca1d1-3baf-48c8-9b73-4e0552ad41e8");
//        result.get(0).get("n.username").equals("U-349518368");
//    }
//
//    @Test
//    public void test200Response() throws Exception {
//        ResponseParser responseParser = new ResponseParser();
//
//        Collection<Map<String,Map<String,Object>>> result =
//                responseParser.parse(getClass().getClassLoader().getResourceAsStream("cypherResponse.json"));
//
//        Map<String,Map<String,Object>> row = result.iterator().next();
//
//        assertEquals(9, result.size());
//        assertNotNull(row.get("c"));
//        assertNotNull(row.get("n"));
//        assertNotNull(row.get("c.uuid"));
//
//    }
//
//    @Test
//    public void test400Response() throws Exception {
//        ResponseParser responseParser = new ResponseParser();
//
//        Response response = javax.ws.rs.core.Response
//                .status(Response.Status.BAD_REQUEST)
//                .entity(getClass().getClassLoader().getResourceAsStream("neo4jErrorResponse.json"))
//                .build();
//
//        Neo4jResponse neo4jResponse = mock(Neo4jResponse.class);
//        when(neo4jResponse.getReceivedResponse()).thenReturn(response);
//
//        when(neo4jResponse.getRawResponseBody()).
//                thenReturn(IOUtils.toString((BufferedInputStream) response.getEntity()));
//
//        try {
//            Collection<Map<String, Map<String, Object>>> result = responseParser.parseOrException(neo4jResponse);
//        }catch (Neo4jClientErrorException e){
//            assertEquals(e.getMessage(), "Expected a parameter named collaborator");
//            assertEquals(e.getExceptionFullName(), "org.neo4j.cypher.ParameterNotFoundException");
//            assertEquals(e.getExceptionName(), "ParameterNotFoundException");
//            return;
//        }
//
//        fail("exception not catched");
//    }
//
//    @Test
//    public void testErrorResponseOnServer() throws Exception {
//        ResponseParser responseParser = new ResponseParser();
//        Neo4jRestApiAdapter adapter = new Neo4jRestApiAdapterImpl();
//
//        try{
//            adapter.runParametrizedCypherQuery("match n retun n.uuid");
//            fail();
//        }catch (Neo4jClientErrorException e){
//            assertEquals(e.getMessage(), "Invalid input 'n': expected 'r/R' (line 1, column 13)\n\"match n retun n.uuid\"\n             ^");
//            assertEquals(e.getExceptionFullName(), "org.neo4j.cypher.SyntaxException");
//            assertEquals(e.getExceptionName(), "SyntaxException");
//            return;
//        }
//
//        try{
//            adapter.runParametrizedCypherQuery("match n retun n.uuid", null);
//            fail();
//        }catch (Neo4jClientErrorException e){
//            assertEquals(e.getMessage(), "Invalid input 'n': expected 'r/R' (line 1, column 13)\n\"match n retun n.uuid\"\n             ^");
//            assertEquals(e.getExceptionFullName(), "org.neo4j.cypher.SyntaxException");
//            assertEquals(e.getExceptionName(), "SyntaxException");
//            return;
//        }
//
//        try{
//            adapter.runCypherQuery("match n retun n.uuid", null);
//            fail();
//        }catch (Neo4jClientErrorException e){
//            assertEquals(e.getMessage(), "Invalid in2put 'n': expected 'r/R' (line 1, column 13)\n\"match n retun n.uuid\"\n             ^");
//            assertEquals(e.getExceptionFullName(), "org.neo4j.cypher.SyntaxException");
//            assertEquals(e.getExceptionName(), "SyntaxException");
//            return;
//        }
//    }
//
//    @Test
//    public void test500Response() throws Exception {
//        ResponseParser responseParser = new ResponseParser();
//
//        Response response = javax.ws.rs.core.Response
//                .serverError()
//                .build();
//
//        Neo4jResponse neo4jResponse = mock(Neo4jResponse.class);
//        when(neo4jResponse.getReceivedResponse()).thenReturn(response);
//
//        try {
//            Collection<Map<String, Map<String, Object>>> result = responseParser.parseOrException(neo4jResponse);
//        }catch (Neo4jException e){
//            assertEquals(e.getMessage(), "Neo4j reported 5xx error");
//            return;
//        }
//
//        fail("exception not catched");
//    }
}