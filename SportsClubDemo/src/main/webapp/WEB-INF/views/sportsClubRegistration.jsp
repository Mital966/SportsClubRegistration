<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Club Reg Form</title>
<script src="https://code.jquery.com/jquery-3.6.4.js"
	integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
	crossorigin="anonymous"></script>
<!-- Bootstrap -->
<link
	href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css'
	rel='stylesheet' type='text/css'>
<script
	src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js'
	type='text/javascript'></script>
<!-- Datepicker -->
<link
	href='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css'
	rel='stylesheet' type='text/css'>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js'
	type='text/javascript'></script>

<script src="https://cdn.lordicon.com/ritcuqlt.js"></script>
<script src="https://kit.fontawesome.com/c1c53dbe72.js"
	crossorigin="anonymous"></script>

</head>
<style>
label {
	color: #28C7C2;
}

.symbol {
	
}
</style>
<body>
	<div class="container mt-5">
		<form method="post" action="./registerApplication"
			enctype="multipart/form-data">
			<div class="card">
			<div hidden>
				<input name = "regId" value="${currAppl ne null?currAppl.regId:'-1'}" >
				</div>
				<div class="card-header bg-dark text-light text-center">
					<div class="h2">Sports Application Form</div>
				</div>
				<div class="card-body">
					<div class="form">
						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-3">
								<label>club Name</label><span class="text-danger">*</span> <select
									class="form-control" name="clubId" id="clubId"
									onchange="getAllSports()">

									<option value='-1'>-select-</option>
									<c:forEach items="${clubList}" var="club">
										<option value="${club.clubId}" <c:if test="${club.clubId eq currAppl.club.clubId}">selected="selected"</c:if>>${club.clubName}</option>
									</c:forEach>	
								</select>
							</div>

							<div class="col-md-3 float-right">
								<label>Sports Name</label><span class="text-danger">*</span> <select
									id="sportsId" name="sportsId" class="form-control">

									<option value='-1'><c:choose>
											<c:when test="${currAppl ne null}">${currAppl.sports.sportsName}</c:when>
											<c:otherwise>-select-</c:otherwise>
										</c:choose>
									</option>
								</select>
							</div>
						</div>

						<div class="mt-5">
							<hr>
							<div class="h2">Applicant Details</div>
							<hr>
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<label>Applicant Name</label><span class="text-danger">*</span>

									<input class="form-control" type="text" name="name"
										<c:if test="${currAppl ne null}">value="${currAppl.name}"</c:if>>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label>Applicant Email</label><span class="text-danger">*</span>
									<input class="form-control" type="text" name="email"
										<c:if test="${currAppl ne null}">value="${currAppl.email}"</c:if>>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label>Mobile Number</label><span class="text-danger">*</span>
									<input class="form-control" type="text" name="phoneNo"
										<c:if test="${currAppl ne null}">value="${currAppl.mobileNo}"</c:if>>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<label>Date of Birth</label><span class="text-danger">*</span> <input
									type="text" name="dob" id="doa" class="form-control"
									placeholder="yyyy-mm-dd"
									value='<fmt:formatDate value="${currAppl.dob}" pattern="yyyy-MM-dd"/>'>
							</div>
							<div class="col-md-4 form-group">
								<label> Gender </label><span class="text-danger">*</span>
								<div>
									<input type="radio" name="gender" value="Male"
										<c:if test="${currAppl.gender eq 'Male'}">checked="checked"</c:if>>Male
									<input type="radio" name="gender" value="Female"
										<c:if test="${currAppl.gender eq 'Female'}">checked="checked"</c:if>>Female
								</div>
							</div>
							<div class="col-md-3">
								<label>Upload File</label><span class="text-danger">*</span> <input
									class="form-control " type="file" name="file">
							</div>

						</div>

					</div>
				</div>
			</div>

			<div class="text-center mt-3">
				<input
					class="${status ne null?'btn btn-warning':'btn btn-success'}"
					type="submit" value="${status ne null?'Update' : 'Submit' }">
				<input class="btn btn-danger" type="reset" value="Reset">
			</div>
		</form>

		<div class="card mt-3">
		<div class = "card-header text-center bg-danger text-dark">
		<div class = "h2">Application Details</div>
		</div>
			<div class = "card-body">
				<table class="table">
					<thead>
						<tr>
							<th>sl.No</th>
							<th>Name</th>
							<th>Email</th>
							<th>Mobile No</th>
							<th>Gender</th>
							<th>Date Of Birth</th>
							<th>Image</th>
							<th>Club</th>
							<th>Sports</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${applicationList}" var="appl"
							varStatus="counter">
							<tr>
								<td>${counter.count}</td>
								<td>${appl.name}</td>
								<td>${appl.email}</td>
								<td>${appl.mobileNo}</td>
								<td>${appl.gender}</td>
								<td>${appl.dob}</td>
								<td>${appl.imagePath}</td>
								<td>${appl.club.clubId}</td>
								<td>${appl.sports.sportsId}</td>
								<td><a
									href="http://localhost:8080/SportsClubReg/sportsRegForm/deleteApplication?appId=${appl.regId}"><i
										class="fa-solid fa-trash text-danger"></i></a> &nbsp;
										 <a
									href="http://localhost:8080/SportsClubReg/sportsRegForm/updateApplication?appId=${appl.regId}"><i
										class="fa-solid fa-pen-to-square text-info"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>



	</div>
	<script>
		function getAllSports() {
			var cId = document.getElementById("clubId").value;
			$.ajax({
				type : "get",
				url : "getClub",
				data : "clubId=" + cId,
				success : function(res) {

					$("#sportsId").html(res);
				}
			});
		}
		
		
	</script>
	<script type="text/javascript">
		document.addEventListener("DOMContentLoaded", () => {
		setTimeout(function(){
        	document.getElementById('alertId').style.display='none';
        },3000);
		});
		$(document).ready(function(){
		$('#doa').datepicker({
	           "format": "yyyy-mm-dd"	           
	     }); 
	});

</script>
</body>
</html>