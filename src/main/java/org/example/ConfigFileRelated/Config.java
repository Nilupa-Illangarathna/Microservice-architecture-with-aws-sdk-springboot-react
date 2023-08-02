package org.example.ConfigFileRelated;

public class Config {
    private String accessKey;
    private String secretKey;
    private String database;
    // private String tableName;
    private String outputLocation;

    // Add getter and setter methods for the properties

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    // public String getTableName() {
    //     return tableName;
    // }

    // public void setTableName(String tableName) {
    //     this.tableName = tableName;
    // }

    public String getOutputLocation() {
        return outputLocation;
    }

    public void setOutputLocation(String outputLocation) {
        this.outputLocation = outputLocation;
    }
}





// outputLocation="s3://nilupa-test-s3/Athena/"
// database="nilupa_athena_db"
// secretKey=lAH6w4OfnROVXmdEna4uqG3QaiN9DId+5qCtJW+k
// accessKey="AKIAZUNGUZNGPGY2VPHU"