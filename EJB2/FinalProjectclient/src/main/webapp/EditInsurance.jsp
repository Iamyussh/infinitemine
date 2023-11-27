<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        
  
    .container {
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      padding: 20px;
      border-radius: 8px;
    }

    .input-box {
      width: 100%;
      box-sizing: border-box;
      margin-bottom: 15px;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
      font-size: 16px;
    }

    /* Add additional styling as needed */

    #form {
  margin-top: 70px;
  text-align: center;
  }

    h2{
    text-align: center;
    margin-top: 35px;
    color: #333;
    }
    
    
      body {
                font-family: 'Roboto', sans-serif;
                 background-image: url('add1.jpg'); /* Set the path to your background image */
                background-size: cover; /* Ensures the background image covers the entire viewport */
                background-position: center; /* Centers the background image */
                background-repeat: no-repeat; /* Prevents the background image from repeating */
                text-align: center;
                background-color: #f8f9fa;
                text-align: center;
                margin: 0;
                padding: 0;
            }

            h1 {
                color: #007bff;
                margin-bottom: 30px;
                 font-weight: bold; /* Make the heading bold */
    			
                
                
            }

            center {
                text-align: center;
            }

            #form {
                max-width: 600px;
                margin: 0 auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            label {
                display: inline-block;
                width: 150px; /* Adjust the width as needed */
                margin-bottom: 8px;
                font-weight: bold;
            }

            input,
            select {
                width: 50%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ced4da;
                border-radius: 4px;
                box-sizing: border-box;
            }

            select {
                appearance: none;
                background: url('https://cdn.jsdelivr.net/gh/GoogleWebComponents/google-web-components/google-logo.png') no-repeat right 10px center;
                background-size: 20px;
            }
            
            
            #form #addbutton:hover {
  background-color: #0056b3; /* Darker shade on hover */
  color: #fff;
  cursor: pointer;
}

/* Additional styles for a consistent hover effect across buttons */
#form h:commandButton:hover {
  background-color: #007bff;
  color: #fff;
  cursor: pointer;
}

/* Additional styles for a consistent hover effect across links */
#form a:hover {
  color: #007bff;
  text-decoration: underline;
}
            

          
    
    
  </style>

    </head>
    <body>
        <h2>
            <h:outputText value="Edit Insurance" />
        </h2>
        <h:form id="form">
            <div id="form">
                <h:outputText value="Types " />
                <h:selectOneMenu value="#{insuranceFound.type}">
                    <f:selectItem itemValue="Government" itemLabel="Government" />
                    <f:selectItem itemValue="Private" itemLabel="Private" />
                </h:selectOneMenu>
                <br/><br/>
                <h:outputText value="Premium Start" />
                <h:inputText id="pstart" value="#{insuranceFound.premiumStart}">
                    <f:convertDateTime pattern="yyyy-MM-dd"/>
                </h:inputText>
                <br /><br />
                <h:outputText value="Premium End" />
                <h:inputText id="pend" value="#{insuranceFound.premiumEnd}">
                    <f:convertDateTime pattern="yyyy-MM-dd"/>
                </h:inputText>
                <br /><br />
                <h:outputText value="Status" />
                <h:selectOneMenu value="#{insuranceFound.status}">
                    <f:selectItem itemValue="Active" itemLabel="Active" />
                    <f:selectItem itemValue="Pending" itemLabel="Pending" />
                </h:selectOneMenu>
            </div>
            <br><br>
            <h:commandButton id="addbutton" action="#{insuranceDetailsdao.UpdateInsurance(insuranceFound)}" value="Save Changes"/>
            <h:messages />
        </h:form>
    </body>
    </html>
</f:view>
