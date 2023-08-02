import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import QueryForm from "./components/QueryForm";
import QueryResponse from "./components/QueryResponse";

function App() {
  return (
    <Router>
      <div className="App">
        <Switch>
          <Route path="/" exact component={QueryForm} />
          <Route path="/query-response" component={QueryResponse} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;