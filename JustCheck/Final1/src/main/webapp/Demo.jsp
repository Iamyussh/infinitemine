<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
    <html>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        
        <style type="text/css">
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                height: 100vh;
            }

            h1 {
                color: #333;
                text-align: center;
                margin-bottom: 20px;
                font-size: 2em;
            }

            .dashboard {
                display: flex;
                flex-wrap: wrap;
                justify-content: space-around;
                padding: 20px;
            }

            .widget {
                background-color: #fff;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                border-radius: 5px;
                padding: 20px;
                margin: 10px;
                width: 300px;
                box-sizing: border-box;
                transition: box-shadow 0.3s ease-in-out;
            }

            .widget:hover {
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            }

            .widget h2 {
                color: #555;
                font-size: 1.5em;
                margin-bottom: 15px;
            }

            .widget form {
                display: flex;
                flex-direction: column;
            }

            .widget label {
                margin-bottom: 8px;
            }

            .widget input,
            .widget select {
                padding: 8px;
                margin-bottom: 15px;
                box-sizing: border-box;
            }

            .widget button {
                background-color: #4CAF50;
                color: white;
                padding: 10px;
                border: none;
                border-radius: 3px;
                cursor: pointer;
            }

            .widget button:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
    
        <h1>
            <h:outputText value="Admin Dashboard" />
        </h1>
        
        <div class="dashboard">
            <!-- Widget 1: Add a Subplan -->
            <div class="widget">
                <h:form id="subplanForm">
                    <h2>Create Insurance Plans</h2>
                    <!-- Include your form components for adding a subplan -->
                </h:form>
            </div>
            
            <!-- Add more widgets as needed -->
        </div>
        
    </body>
    </html>
</f:view>



