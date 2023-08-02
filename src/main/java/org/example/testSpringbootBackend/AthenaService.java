package org.example.testSpringbootBackend;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.athena.AthenaClient;
import software.amazon.awssdk.services.athena.model.*;

@Service
public class AthenaService {

    public String executeAthenaQuery(String query, String accesskey, String secretkey, String Database, String outputS3bucketlocation) {
        // Set up AWS credentials

        String accessKey = accesskey;
        String secretKey = secretkey;
        AwsCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);

        // Set up Athena client
        AthenaClient athenaClient = AthenaClient.builder()
                .region(Region.AP_SOUTHEAST_1) // Change to the appropriate region
                .credentialsProvider(() -> credentials)
                .build();

        // Set up the query execution request
        String database = Database; // Your database name

        StartQueryExecutionRequest queryExecutionRequest = StartQueryExecutionRequest.builder()
                .queryString(query)
                .queryExecutionContext(QueryExecutionContext.builder().database(database).build())
                .resultConfiguration(ResultConfiguration.builder().outputLocation(outputS3bucketlocation).build())
                .build();

        // Start the query execution
        StartQueryExecutionResponse queryExecutionResponse = athenaClient.startQueryExecution(queryExecutionRequest);
        String queryExecutionId = queryExecutionResponse.queryExecutionId();

        // Wait for the query execution to complete
        waitForQueryCompletion(athenaClient, queryExecutionId);

        // Get the query results
        GetQueryResultsRequest queryResultsRequest = GetQueryResultsRequest.builder()
                .queryExecutionId(queryExecutionId)
                .build();

        GetQueryResultsResponse queryResultsResponse = athenaClient.getQueryResults(queryResultsRequest);

        // Build a string representation of the query results
        StringBuilder resultBuilder = new StringBuilder();
        for (Row row : queryResultsResponse.resultSet().rows()) {
            for (Datum datum : row.data()) {
                resultBuilder.append(datum.varCharValue()).append("\t");
            }
            resultBuilder.append("\n");
        }

        // Clean up resources
        athenaClient.close();

        return resultBuilder.toString();
    }

    private static void waitForQueryCompletion(AthenaClient athenaClient, String queryExecutionId) {
        // Check the status of the query execution
        GetQueryExecutionRequest queryExecutionRequest = GetQueryExecutionRequest.builder()
                .queryExecutionId(queryExecutionId)
                .build();

        GetQueryExecutionResponse queryExecutionResponse;
        QueryExecutionState queryExecutionState;

        do {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            queryExecutionResponse = athenaClient.getQueryExecution(queryExecutionRequest);
            queryExecutionState = queryExecutionResponse.queryExecution().status().state();
        } while (queryExecutionState == QueryExecutionState.RUNNING || queryExecutionState == QueryExecutionState.QUEUED);

        if (queryExecutionState != QueryExecutionState.SUCCEEDED) {
            // Query execution failed
            QueryExecutionStatus queryExecutionStatus = queryExecutionResponse.queryExecution().status();
            throw new RuntimeException("Query execution failed: " + queryExecutionStatus.stateChangeReason());
        }
    }
}


// SELECT * FROM "nilupa_athena_db_test"."sample_table_test" limit 10;