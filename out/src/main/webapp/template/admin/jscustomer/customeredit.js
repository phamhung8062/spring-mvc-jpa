$('#btnAddCustomer').click(function() {
	var data = {};
	var formData = $('#formEdit').serializeArray();
	$.each(formData, function(index, v) {
			data["" + v.name + ""] = v.value;
	});
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/api/customer/insert",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function (response) {
			alert('Thêm Thành Công');
			window.location="http://localhost:8080/admin/customer/list?page=1&limit=10";
			//console.log('success');
		},
		error : function(response) {
			alert('Thêm Không Thành Công');
			window.location="http://localhost:8080/admin/customer/list?page=1&limit=10";
		}
	});
})
$('#btnEditCustomer').click(function User(userId) {
	var data = {};
	var formData = $('#formEdit').serializeArray();
	$.each(formData, function(index, v) {
			data["" + v.name + ""] = v.value;
	});
	$.ajax({
		type : "PUT",
		url : "http://localhost:8080/api/customer/edit",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function(response) {
			alert('Cập Nhập Thành Công');
			window.location="http://localhost:8080/admin/customer/list?page=1&limit=10";
		},
		error : function(response) {
			alert('Cập Nhập Không Thành Công');
			window.location="http://localhost:8080/admin/customer/list?page=1&limit=10";
		}
	});
})
