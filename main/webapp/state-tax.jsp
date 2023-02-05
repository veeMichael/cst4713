<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 50%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>

	<h2>State & Local Sales Tax Rates, as of January 1, 2022</h2>
	<table>
		<thead>
			<tr>
				<th>State</th>
				<th>State Tax Rate</th>
				<th>Rank</th>
				<th>Avg. Local Tax Rate (a)</th>
				<th>Combined Rate</th>
				<th>Rank</th>
				<th>Max Local Tax Rate</th>
			</tr>
		</thead>
        <tbody>
			<c:forEach items="${states}" var="n">
                <tr>

                    <td class="center">${n.state}</td>
                    <td class="center">${n.formattedSTR}%</td>
                    <td class="center">${n.rank}</td>
                    <td class="center">${n.formattedALTR}%</td>
                    <td class="center">${n.formattedCR}%</td>
                    <td class="center">${n.rank2}</td>
                    <td class="center">${n.formattedMLTR}%</td>

                </tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>

