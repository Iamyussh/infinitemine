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
                margin: 10px;
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
    font-size: 16px;
    transition: background-color 1.3s;
    margin-top: 5px;
    margin-left: 16px;
    width: 42%;
            }

            .insbutton:hover {
               background-color: green;
    color: #fff; /* Text color in hover state */
    border: 1px solid #2980b9; /* Adding a border in hover state */
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.3); /* Adding a subtle box shadow */
    transition: background-color 0.3s ease, color 0.3s ease, border 0.3s ease, box-shadow 0.3s ease; /* Adding a smooth transition effect */	
            }

            h:messages {
                margin-top: 10px;
                color: #d9534f;
            }
            
          
    
    
.loader-container{
	background-color:#f2f2f2;
}
.lds-facebook {
  display: inline-block;
  position: relative;
  width: 80px;
  height: 80px;
}

.lds-facebook div {
  margin-top: 269px;
    margin-left: 3px;
  display: inline-block;
  position: absolute;
  left: 8px;
  width: 16px;
  height: 80px; /* Adjusted height to match the container */
  background: #000; /* Set the background color to black */
  animation: lds-facebook 3s cubic-bezier(0, 0.5, 0.5, 1) infinite;
}

.lds-facebook div:nth-child(1) {
  left: 8px;
  animation-delay: -0.24s;
}

.lds-facebook div:nth-child(2) {
  left: 32px;
  animation-delay: -0.12s;
}

.lds-facebook div:nth-child(3) {
  left: 56px;
  animation-delay: 0;
}

@keyframes lds-facebook {
  0%{
    top: 8px;
    height: 64px;
  }
  50%, 100% {
    top: 24px;
    height: 32px;
  }
}
	
	.succ{
   color:white;
   
}
.blurred {
    filter: blur(5px); /* Adjust the blur strength as needed */
    pointer-events: none; /* Prevent interaction with blurred elements */
}


/* Add the following CSS to match the input styles */
#myForm table {
    width: 100%;
}

#myForm th {
    text-align: left;
}

#myForm td input {
 display: block;
 	align-content:center;
    width: 100%;
    padding-top: 22px;
    border: none;
    border-radius: 10px;
    color: #201b1b;
    background: #dddddd;
    font-size: 14px;
    transition: 0.3s ease;
     vertical-align: middle; 

    &:focus{
        outline: none;
        ~ label {
            top: 0;
            font: 700 18px Roboto;
            color: #2196f3; /* Adjust based on your design preferences */
        }
    }

    &:-webkit-autofill {
        -webkit-box-shadow: 0 0 0px 1000px #8d96d7 inset;
        -webkit-text-fill-color: #000000 !important;
    }
}

#myForm td label {
    position: absolute;
    top: 15px; /* Adjust based on your design preferences */
    color: rgba(white, .5);
    font: 400 18px Roboto;
    cursor: text;
    transition: 0.25s ease;

    & + .bar:before {
        transform: translateX(0);
    }
}

#myForm td .bar {
    background: #2196f3; /* Adjust based on your design preferences */
    content: '';
    width: 100%;
    height: 1px;
    transition: 0.3s ease;
    position: relative;

    &:before{
        content:'';
        position: absolute;
        width: 100%;
        height: 150%;
        background: #2196f3; /* Adjust based on your design preferences */
        transform: translateX(-100%);
    }
}



     
        </style>
    </head>
    <body>
    
    					
		
			
			<div class="lds-facebook"><div></div><div></div><div></div></div>
			<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
			 <script>
    // Add this script to toggle the loader on form submission
    $(document).ready(function() {
			$(".lds-facebook").fadeOut("slow");
		});
     $(window).on('load', function() {
        $(".lds-facebook").fadeOut("very slow");
    });
 
</script>


        <h2>
            <h:outputText value="Add a Subplan" />
        </h2>
        
        

        <h:form id="myForm">
         <h:outputText value="#{success}" styleClass="succ" />
          <img src="lic.jpg" alt="Image Alt Text" style="max-width:60%; height:150; margin:40px;margin-left: 110px;"/>
            <table>
                <tr>
                    <th><h:outputText value="Insurance Id" /></th>
                    <td><h:inputText id="insid" value="#{insuranceid}" readonly="true"  />
                    </td>
                    
                </tr>
               
                <tr>
                    <th><h:outputText value="Premium Amount" /></th>
                    <td><h:inputText id="pamt" value="#{insuranceplan.premiumamt}" />
                    <h:message for="pamt" style="color:red;" /></td>
                </tr>
                
                
                <tr>
                    <th><h:outputText value="Coverage Amount" /></th>
                    <td><h:inputText id="cvgamt" value="#{insuranceplan.coverageamt}" />
                    <h:message for="cvgamt" style="color: red;" /></td>
                </tr>
                <tr>
                    <th><h:outputText value="Diseases Covered" /></th>
                    <td><h:inputText id="dis" value="#{insuranceplan.discov}"/>
                     <h:message for="dis" style="color: red;" />
                    </td>
                </tr>
            </table>
			<br/>
            <h:commandButton styleClass="insbutton" action="#{insuranceController.addInsurancePlans(insuranceplan)}" value="Add"/>
            &nbsp;

            <h:commandButton  styleClass="insbutton" action="InsuranceDetailsPagination.jsp" value="Insurance Details"/>
            <h:messages />
           
            
        </h:form>
        
        
      

					<script>
    // Add this script to toggle the loader on form submission
    $(document).ready(function() {
			$(".lds-facebook").fadeOut("slow");
		});
     $(window).on('load', function() {
        $(".lds-facebook").fadeOut("very slow");
    });
     $(document).ready(function() {
    	    $(".lds-facebook").fadeOut("slow");
    	    $("#myForm").removeClass("blurred"); // Initially remove the blur
    	});

    	$(window).on('load', function() {
    	    $(".lds-facebook").fadeOut("very slow");
    	    $("#myForm").removeClass("blurred"); // Remove the blur when the loader is hidden
    	});
    	     
		</script>
    


    </body>
    </html>
</f:view>

