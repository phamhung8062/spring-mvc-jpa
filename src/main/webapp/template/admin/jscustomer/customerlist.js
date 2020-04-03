function myResetFunctionC() {
  document.getElementById("formSearchCustomer").reset();
  window.location="http://localhost:8080/admin/user/list?page=1&limit=10";
}

$('#btnDeleteCustomer').click(
		function(e) {
			e.preventDefault();
			var data = {};
			var listIds = $('#customerList').find(
					'tbody input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			data['ids'] = listIds;
			if (confirm('Bạn có muốn xóa không?')) {
				deleteCustomer(data);
				alert('Xóa Thành Công');
			} else {
				location.reload();
			}
			location.reload();
			
		});
function deleteCustomer(data) {
	$.ajax({
		type : "DELETE",
		url : "http://localhost:8080/api/customer/delete",
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
$('#btnSearchCustomer').click(function (e) { 
	e.preventDefault();
	$('#formSearchCustomer').submit();
});