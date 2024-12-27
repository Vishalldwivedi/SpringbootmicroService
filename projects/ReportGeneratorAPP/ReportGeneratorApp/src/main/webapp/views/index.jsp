<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<div class="container">
 <h3 class="pb-6 pt-3">Report Application</h3>

<form:form action="search" modelAttribute="search" method="POST">


			<tr>
				<td>Plan Name:</td>
				<td>
				    <form:select path="planName">
				        <form:option value="">-Select-</form:option>
				        <form:options items="${names}"/>
				    </form:select>
                </td>
                <td>Plan Status:</td>
                	<td>
                	    <form:select path="planStatus">
                			 <form:option value="">-Select-</form:option>
                			 <form:options items="${status}"/>
                	     </form:select>
                    </td>
                <td>Gender:</td>
                	<td><form:radiobutton path="gender" value="male"/> Male
                <form:radiobutton path="gender" value="female"/> Fe-Male</td>

                </tr>


                <tr>
                <td>StartDate:</td>
                <td>
                <form:input path="startDate" type="date"
                 date-date-format="mm/dd/yyyy"/>
                </td>


                  <td>EndDate:</td>
                         <td>
                            <form:input path="endDate" type="date"
                                    date-date-format="mm/dd/yyyy"/>
                           </td>
                </tr>
<tr>
<td>
<input type ="submit" value="Search"/>

</td>
</tr>


</form:form>

<hr/>
<table class="table table-striped table-hover">
    <thead>
        <tr>
            <th>ID</th>
            <th>holder name</th>
            <th>plan name</th>
            <th>Gender </th>
            <th>plan status</th>
            <th>startDate</th>
            <th>endDate</th>
            <th>benefitAmt</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${plans}" var ="plan">
            <tr>
                <td>${plan.citizenId}</td>
                <td>${plan.citizenName}</td>

                <td>${plan.planName}</td>
                <td>${plan.gender}</td>
                <td>${plan.planStartDate}</td>
                <td>${plan.planEndDate}</td>
                <td>${plan.benefitAmt}</td>


            </tr>
        </c:forEach>
        <c:if test="${empty plans} ">
        NO RECORDS FOUND
           </c:if>
    </tbody>
</table>
<hr/>

Export : <a href="excel">Excel</a> <a href="pdf">Pdf</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>
