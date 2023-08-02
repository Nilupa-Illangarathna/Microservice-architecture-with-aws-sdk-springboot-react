package org.example.testSpringbootBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


// Custom created classes
import org.example.ConfigFileRelated.ConfigReader;
import org.example.ConfigFileRelated.Config;

@Controller
public class FormController {

    @Autowired
    private AthenaService athenaService;

    @GetMapping("/")
    public String showFormPage() {
        return "index"; // Returns the index.html page
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam String field1, @RequestParam String field2,
                             @RequestParam String field3, @RequestParam String field4, Model model) {


        // // Set up AWS credentials and configs requried are placed in this located in (Test02 - The same approch with credintials in a config.txt to gitignore\configFile\config.txt)
        Config config = ConfigReader.readConfig();


        String accessKey = config.getAccessKey(); // Access key
        String secretKey = config.getSecretKey(); // Secret key
        String database = config.getDatabase(); // database name
        // String tableName = config.getTableName(); // table tableName
        String outputS3bucketlocation = config.getOutputLocation(); // Output S3 location


        // Concatenate the query string with fields 1, 2, and 4
        String query = field3;

        // Execute the Athena query and get the results
        String queryResults = athenaService.executeAthenaQuery(query , accessKey, secretKey, database, outputS3bucketlocation);

        // Pass the query results to the "hello" page
        model.addAttribute("queryResults", queryResults);

        return "hello";
    }

    @PostMapping("/back")
    public String submitForm(Model model) {
        return "index";
    }
}


