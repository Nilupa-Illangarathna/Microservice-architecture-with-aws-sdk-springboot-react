directly run using 
        ./mvnw spring-boot:run

to build the jar use 
        mvn wrapper:wrapper
        ./mvnw clean package
to run the jar created
        java -jar target/testSpringbootBackend-0.0.1-SNAPSHOT.jar


SELECT * FROM "nilupa_athena_db_test"."sample_table_test" limit 10;
SELECT * FROM "nilupa_athena_db_test"."sample_table_test" first_row;




WITH first_row AS (
  SELECT *
  FROM "nilupa_athena_db_test"."sample_table_test"
  LIMIT 1
)
SELECT * FROM first_row
UNION ALL
SELECT * FROM first_row
UNION ALL
SELECT * FROM first_row;