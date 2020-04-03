function myResetFunctiona() {
  document.getElementById("formSearchBuilding").reset();
  window.location="http://localhost:8080/admin/building/list?page=1&limit=10";
}
function myResetFunctionb() {
	  document.getElementById("formSearchBuilding").reset();
	}
function assingmentBuilding(buildingId) {
	$('#buildingId').val(buildingId);
	console.log($('#buildingId').val());
	$('#assingmentBuildingModal').modal();
//}
//function showStaffAsignment(){
	var  staffs =buildingId;
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/api/user?id="+staffs+" ",
		dataType : "json",
		success : function(response) {
			var html='';
			$.each(response, function (index,users) { 
			html+='<tr>';
			html+='<td><input type="checkbox" value="'+users.id+'" id="checkbox_'+users.id+'" '+users.checked+' /></td>';
			html+='<td>'+users.fullName+'</td>';
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
//function openModalAssingmentBuilding() {
//	$('#assingmentBuildingModal').modal();
//	//call api assginment
//	showStaffAsignment();
//}
$('#btnAssignBuilding').click(
		function(e) {
			e.preventDefault();
			//call api
			var data = {};
			data['id'] = $('#buildingId').val();
			//$('#staffList').find('tbody input[type=checkbox]');
			//tra ve mot mang staff
			var staffs = $('#staffList').find(
					'tbody input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			data['staffss'] = staffs;
			//call api giao toa nha
			//assignStaff(data);
			$.ajax({
				type : "POST",
				url : "http://localhost:8080/api/user/assignment",
				data : JSON.stringify(data),
				dataType : "json",
				contentType : "application/json",
				success : function(response) {
					alert('Giao Tòa Nhà Thành Công');
					window.location="http://localhost:8080/admin/building/list?page=1&limit=10";
					//console.log("success");

				},
				error : function(response) {
					alert('Giao Tòa Nhà Thành Công');
					window.location="http://localhost:8080/admin/building/list?page=1&limit=10";
//					console.log("failed");
//					console.log(response);
				}
			});

		});
//function assignStaff(data) {
//	$.ajax({
//		type : "POST",
//		url : "http://localhost:8080/api/user/assignment",
//		data : JSON.stringify(data),
//		dataType : "json",
//		contentType : "application/json",
//		success : function(response) {
//			console.log("success");
//
//		},
//		error : function(response) {
//			console.log("failed");
//			console.log(response);
//		}
//	});
//}
$('#btnDeleteBuilding').click(
		function(e) {
			e.preventDefault();
			var data = {};
			var buildingIds = $('#buildingList').find(
					'tbody input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			data['ids'] = buildingIds;
			if (confirm('Bạn có muốn xóa không?')) {
				deleteBuilding(data);
				alert('Xóa Thành Công');
			} else {
				location.reload();
			}
			location.reload();
		});
function deleteBuilding(data) {
	$.ajax({
		type : "DELETE",
		url : "http://localhost:8080/api/building",
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