function assingmentBuilding(buildingId) {
	openModalAssingmentBuilding();
	$('#buildingId').val(buildingId);
	console.log($('#buildingId').val());
}
function openModalAssingmentBuilding() {
	$('#assingmentBuildingModal').modal();
	//call api assginment
	showStaffAsignment();
}
$('#btnAssignBuilding').click(
		function(e) {
			e.preventDefault();
			//call api
			var data = {};

			data['buildingId'] = $('#buildingId').val();

			//$('#staffList').find('tbody input[type=checkbox]');
			//tra ve mot mang staff
			var staffs = $('#staffList').find(
					'tbody input[type=checkbox]:checked').map(function() {
				return $(this).val();

			}).get();
			data['satffs'] = staffs;
			//call api giao toa nha
			assignStaff(data);

		});
function assignStaff(data) {
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/api-user-assignment",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function(response) {
			console.log("success");

		},
		error : function(response) {
			console.log("failed");
			console.log(response);
		}
	});
}
function showStaffAsignment() {
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/api-user?type=SHOW_STAFF_ASSIGNMENT",
		//url : "http://localhost:8080/api-user",
		dataType : "json",
		success : function(response) {
			var html='';
			$.each(response, function (index,StaffOutput) { 
			html+='<tr>';
			html+='<td><input type="checkbox" value="'+StaffOutput.StaffId+'" id="checkbox_'+StaffOutput.StaffId+'" '+StaffOutput.checked+' /></td>';
			html+='<td>'+StaffOutput.name+'</td>';
			html+='</tr>'; 
			});
			
			$('#staffList tbody').html(html);

		},
		error : function(response) {
			console.log("failed");
			console.log(response);
		}
	});
}
$('#btnDeleteBuilding').click(
		function(e) {
			e.preventDefault();
			var data = {};
			var buildingIds = $('#buildingList').find(
					'tbody input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			data['buildingIds'] = buildingIds;
			deleteBuilding(data);
		});
function deleteBuilding(data) {
	$.ajax({
		type : "DELETE",
		url : "http://localhost:8080/api-building",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function(response) {
			console.log("success");
		},
		error : function(response) {
			console.log("failed");
			console.log(response);
		}
	});
}
$('#btnSearchBuilding').click(function (e) { 
	e.preventDefault();
	$('#formSearchBuilding').submit();
});