$('#btnAddUser').click(function() {
	var data = {};
	var listroles = [];
	var formData = $('#formEdit').serializeArray();
	$.each(formData, function(index, v) {
		if (v.name == "listroles") {
			listroles.push(v.value);
		} else {
			data["" + v.name + ""] = v.value;
		}

	});
	data['listroles'] = listroles;
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/api/user/insert",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function (response) {
			alert('Thêm Thành Công');
			window.location="http://localhost:8080/admin/user/list?page=1&limit=10";
			//console.log('success');
		},
		error : function(response) {
			alert('Thêm Không Thành Công');
			window.location="http://localhost:8080/admin/user/list?page=1&limit=10";
		}
	});
})
$('#btnEditUser').click(function User(userId) {
	var data = {};
	var listroles = [];
	var formData = $('#formEdit').serializeArray();
	$.each(formData, function(index, v) {
		if (v.name == "listroles") {
			listroles.push(v.value);
		} else {
			data["" + v.name + ""] = v.value;
		}

	});
	data['listroles'] = listroles;
	$.ajax({
		type : "PUT",
		url : "http://localhost:8080/api/user/edit",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function(response) {
			alert('Cập Nhập Thành Công');
			window.location="http://localhost:8080/admin/user/list?page=1&limit=10";
		},
		error : function(response) {
			alert('Cập Nhập Không Thành Công');
			window.location="http://localhost:8080/admin/user/list?page=1&limit=10";
		}
	});
})
$('#btnEditStaff').click(function User(userId) {
	var data = {};
	var listroles = [];
	var formData = $('#formEditStaff').serializeArray();
	$.each(formData, function(index, v) {
		if (v.name == "listroles") {
			listroles.push(v.value);
		} else {
			data["" + v.name + ""] = v.value;
		}

	});
	data['listroles'] = listroles;
	$.ajax({
		type : "PUT",
		url : "http://localhost:8080/api/user/edit",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function(response) {
			alert('Cập Nhập Thành Công');
			location.reload();
		},
		error : function(response) {
			alert('Cập Nhập Không Thành Công');
			window.location="http://localhost:8080/user/home";
		}
	});
})
$('#btnEditAdmin').click(function User(userId) {
		var data = {};
		var listroles = [];
		var formData = $('#formEditAdmin').serializeArray();
		$.each(formData, function(index, v) {
			if (v.name == "listroles") {
				listroles.push(v.value);
			} else {
				data["" + v.name + ""] = v.value;
			}

		});
		data['listroles'] = listroles;
		$.ajax({
			type : "PUT",
			url : "http://localhost:8080/api/user/edit",
			data : JSON.stringify(data),
			dataType : "json",
			contentType : "application/json",
			success : function(response) {
				alert('Cập Nhập Thành Công');
				location.reload();
			},
			error : function(response) {
				alert('Cập Nhập Không Thành Công');
				window.location="http://localhost:8080/admin/home";
			}
		});
})