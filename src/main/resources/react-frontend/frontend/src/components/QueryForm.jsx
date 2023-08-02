import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import "./QueryForm.css";

const QueryForm = () => {
  const history = useHistory();
  const [formData, setFormData] = useState({
    field1: "",
    field2: "",
    field3: "",
    field4: "",
  });

  const handleSubmit = (e) => {
    e.preventDefault();
    const { field1, field2, field3, field4 } = formData;
    // Your logic to send the form data to the backend
    history.push("/query-response"); // Redirect to the query response page
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevFormData) => ({
      ...prevFormData,
      [name]: value,
    }));
  };

  return (
    <div className="query-form-container">
      <h1>Enter your query</h1>
      <form id="myForm" onSubmit={handleSubmit}>
        <input
          type="text"
          name="field1"
          value={formData.field1}
          onChange={handleChange}
          required
        /><br />
        <input
          type="text"
          name="field2"
          value={formData.field2}
          onChange={handleChange}
          required
        /><br />
        <input
          type="text"
          name="field3"
          value={formData.field3}
          onChange={handleChange}
          required
        /><br />
        <input
          type="text"
          name="field4"
          value={formData.field4}
          onChange={handleChange}
          required
        /><br />
        <button type="submit" id="submitBtn" disabled={!formData.field1 || !formData.field2 || !formData.field3 || !formData.field4}>Submit</button>
      </form>
    </div>
  );
};

export default QueryForm;
