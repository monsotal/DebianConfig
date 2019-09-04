package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.*;
import com.debian_config.Main.Main;

@DisplayName("JUnit 5 Example")
class UnitTest {
 
    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all test methods");
    }
 
    @BeforeEach
    void beforeEach() {
        System.out.println("Before each test method");
    }
 
    @AfterEach
    void afterEach() {
        System.out.println("After each test method");
    }
 
    @AfterAll
    static void afterAll() {
        System.out.println("After all test methods");
    }
 
    @Test
    @DisplayName("Hostname validation test")
    void hostnametest() throws IOException {
        System.out.println("Hostname validation test");

// Saves the original content of "/etc/hostname" file before making changes    
        
        String origcontent = new String(Files.readAllBytes(Paths.get("/etc/hostname")));
        
 try {

// verifies that method returned value(assuming being called with "hostname-test" argument) equals "hostname-test" 
	 
	 assertEquals("hostname-test",Main.configureHostname("hostname-test"));
	 System.out.println("hostname unittest passed successfully");

	    }
 
 catch(Exception e) {
	 e.printStackTrace();
	 System.out.println("error in test");


 }
 
 // cleanup the unit test by replacing "/etc/hostname" content with the original content

 finally {
	 FileWriter orighostname = new FileWriter("/etc/hostname");
	 orighostname.write(origcontent);
	 orighostname.close();
 }
 

    }
    
 

    @Test
    @DisplayName("Second test")
    void secondTest() {
	        System.out.println("Second test method");
	 
 }
  

}
