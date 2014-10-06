package controllers;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.junit.Test;
import org.junit.runner.RunWith;
import service.TodoService;

import java.io.File;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@RunWith(Arquillian.class)
public class TodoControllerTest {

    public static final String WEBAPP_SRC = "src/main/webapp";
    public static final String baseUrl = "http://localhost:8080/api";

    @Deployment(testable = false)
    public static Archive<?> createDeployment() {

        MavenDependencyResolver resolver = DependencyResolvers.use(
                MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");

        WebArchive war = ShrinkWrap.create(WebArchive.class, "restGlassfishExample-1.0-SNAPSHOT.war")
                .addPackage(TodoController.class.getPackage())
                .addPackage(TodoService.class.getPackage())
                .addAsLibraries(
                        resolver.artifact("com.jayway.restassured:rest-assured")
                                .resolveAsFiles())
                .addAsWebInfResource(new File(WEBAPP_SRC, "WEB-INF/glassfish-web.xml"))
                .addAsWebInfResource(EmptyAsset.INSTANCE,"beans.xml");

        return war;
    }

    @Test
    public void testGetTodos() throws Exception {
        expect().body(matchesJsonSchemaInClasspath("todos-schema.json")).when().get(baseUrl + "/todos");
    }

    @Test
    public void testGetTodo() throws Exception {
        expect().statusCode(200).when().get(baseUrl + "/todos/1");
    }

    /*@Test
    public void testGetNotFoundTodo() throws Exception {
        expect().statusCode(404).when().get(baseUrl + "/todos/11");
    } */
}