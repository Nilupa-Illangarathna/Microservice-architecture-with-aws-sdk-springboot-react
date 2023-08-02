import React from "react";
import { Link } from "react-router-dom";

const QueryResponse = () => {
  // Replace the following variable with the actual query results you receive from the backend
  const queryResults = "Sample query results";

  return (
    <div className="query-response-container">
      <h1>Query Response</h1>
      <h4>Query Results:</h4>
      <pre>{queryResults}</pre>
      <Link to="/">Back</Link>
    </div>
  );
};

export default QueryResponse;
