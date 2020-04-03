function myResetFunction() {
  document.getElementById("formSearchUser").reset();
  window.location="http://localhost:8080/admin/user/list?page=1&limit=10";
}

$('#btnDeleteUser').click(
		function(e) {
			e.preventDefault();
			var data = {};
			var listIds = $('#userList').find(
					'tbody input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			data['ids'] = listIds;
			if (confirm('Bạn có muốn xóa không?')) {
				deleteUser(data);
				alert('Xóa Thành Công');
			} else {
				location.reload();
			}
			location.reload();
			
		});
function deleteUser(data) {
	$.ajax({
		type : "DELETE",
		url : "http://localhost:8080/api/user/delete",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function reload() {
			//console.log("success");
			location.reload()
		},
		error : function(response) {
			console.log("failed");
			console.log(response);
		}
	});
}
$('#btnSearchUser').click(function (e) { 
	e.preventDefault();
	$('#formSearchUser').submit();
});