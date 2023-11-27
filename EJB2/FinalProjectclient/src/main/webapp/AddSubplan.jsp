<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f4f4f4;
                 background-image: url('subplan.jpg');
                margin: 0;
                padding: 0;
                text-align: center;
                align-items: center;
                justify-content: center;
                min-height: 100vh;
            }

            h2 {
                color: #333;
            }

            #myForm {
                max-width: 400px;
                width: 80%;
                padding: 30px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                margin: 20px auto;
                text-align: left; /* Align text in the form to the left */
            }

            h:outputText {
                display: block;
                margin-bottom: 8px;
                font-weight: bold;
                color: #555;
                text-align: left;
            }

             td h:inputText {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ddd;
                border-radius: 4px;
                box-sizing: border-box;
                color: #333;
                text-align: left; /* Align text within the input text */
            }
            .insbutton {
                background-color: #3498db;
                color: #fff;
                padding: 8px 12px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 18px;
                transition: background-color 1.3s;
                margin-top: 5px;
                width: 42%;
            }

            .insbutton:hover {
                background-color: #2980b9;
            }

            h:messages {
                margin-top: 10px;
                color: #d9534f;
            }
        </style>
    </head>
    <body>

        <h2>
            <h:outputText value="Add a Subplan" />
        </h2>

        <h:form id="myForm">
        
          <img src="leaf.jpg" alt="Image Alt Text" style="max-width: 100%; height: auto;"/>
            <table>
                <tr>
                    <th><h:outputText value="Insurance Id" /></th>
                    <td><h:inputText id="insid" value="#{insuranceid}" /></td>
                </tr>
                <tr>
                    <th><h:outputText value="Premium Amount" /></th>
                    <td><h:inputText id="pamt" value="#{insurancePlan.premiumamt}" /></td>
                </tr>
                <tr>
                    <th><h:outputText value="Coverage Amount" /></th>
                    <td><h:inputText id="cvgamt" value="#{insurancePlan.coverageamt}" /></td>
                </tr>
                <tr>
                    <th><h:outputText value="Diseases Covered" /></th>
                    <td><h:inputText id="dis" value="#{insurancePlan.discov}" /></td>
                </tr>
            </table>

            <h:commandButton styleClass="insbutton" action="#{insuranceController.addInsurancePlans(insurancePlan)}" value="Add"/>
            &nbsp;

            <h:commandButton styleClass="insbutton" action="InsuranceShow.jsp" value="Insurance Details"/>
            <h:messages/>
        </h:form>

    </body>
    </html>
</f:view>


