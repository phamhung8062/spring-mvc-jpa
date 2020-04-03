$('#btnAddBuilding').click(function() {
	var data = {};
	var buildingTypes = [];
	var formData = $('#formEdit').serializeArray();
	$.each(formData, function(index, v) {
		if (v.name == "buildingTypes") {
			buildingTypes.push(v.value);
		} else {
			data["" + v.name + ""] = v.value;
		}

	});
	data['buildingTypes'] = buildingTypes;
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/api/building",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function(response) {
			alert('Thêm Thành Công');
			window.location="http://localhost:8080/admin/building/list?page=1&limit=10";
			//console.log('success');
		},
		error : function(response) {
			alert('Thêm KhôngThành Công');
			window.location="http://localhost:8080/admin/building/list?page=1&limit=10";
//			console.log('failed');
//			console.log(response);
		}
	});
})
$('#btnEditBuilding').click(function Building(buildingId) {
	var data = {};
	var buildingTypes = [];
	var formData = $('#formEdit').serializeArray();
	$.each(formData, function(index, v) {
		if (v.name == "buildingTypes") {
			buildingTypes.push(v.value);
		} else {
			data["" + v.name + ""] = v.value;
		}

	});
	data['buildingTypes'] = buildingTypes;
	$.ajax({
		type : "PUT",
		url : "http://localhost:8080/api/building",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function(response) {
			alert('Cập Nhập Thành Công');
			window.location="http://localhost:8080/admin/building/list?page=1&limit=10";
			//console.log('success');
		},
		error : function(response) {
			alert('Cập Nhập Không Thành Công');
			window.location="http://localhost:8080/admin/building/list?page=1&limit=10";
		}
	});
})