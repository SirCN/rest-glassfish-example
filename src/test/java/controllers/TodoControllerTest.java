package controllers;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TodoControllerTest {
    // To be added again
   /* public static final String WEBAPP_SRC = "src/main/webapp";
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
    } */

}