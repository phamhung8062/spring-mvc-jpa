<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.laptrinhjavaweb.util.SecurityUtils" %>
<c:url var="buildingUrl" value="/user/building/list?page=${model.page}&limit=${model.limit}" />
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Tòa Nhà</title>
	</head>

	<body>
<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
				</li>
				<li class="active">Tòa Nhà</li>
			</ul>
			<!-- /.breadcrumb -->


		</div>

		<div class="page-content">

			<div class="page-header">
				<h1>
					Tòa Nhà <small> <i
						class="ace-icon fa fa-angle-double-right"></i>  Danh Sách Tòa Nhà
					</small>
				</h1>
			</div>
			<!-- /.page-header -->

			<div class="row">
				<div class="widget-box">
					<div class="widget-header">
						<h4 class="widget-title">Tìm Kiếm</h4>

						<div class="widget-toolbar">
							<a href="#" data-action="collapse"> <i
								class="ace-icon fa fa-chevron-up"></i>
							</a>
						</div>
					</div>
					<div class="widget-body">
						<div class="widget-main">
							<div class="row">
								<div class="col-xs-12">
									<!-- PAGE CONTENT BEGINS -->
									<div class="row">
										<form:form action="${buildingUrl}" method="get"
											id="formSearchBuilding" modelAttribute="model">
											<div class="col-sm-4">
												<div>
													<label for="name">Tên Tòa Nhà</label> <input type="text"
														id="name" class="form-control" name="name" value="${model.name}" />
												</div>
											</div>
											<div class="col-xs-12 col-sm-4">
												<div>
													<label for="buildingArea">Diện Tích Sàn</label> <input
														type="number" id="buildingArea" class="form-control"
														name="buildingArea" value="${model.buildingArea}" />
												</div>

											</div>
											<div class="col-xs-12 col-sm-4">
												<div>
													<label for="numberOfBasement">Số Tầng Hầm</label> <input
														type="number" id="numberOfBasement" class="form-control"
														name="numberOfBasement" value="${model.numberOfBasement}" />
												</div>

											</div>
											<div class="col-xs-12 col-sm-4">
												<div>
													<label for="district"> Quận </label> <select id="district"
														name="district" class="form-control">
														<option value="">Chọn Quận</option>
														<!-- option value="QUAN_1">Quận 1</option>
														<option value="QUAN_2">Quận 2</option>
														<option value="QUAN_3">Quận 3</option>
														<option value="QUAN_4">Quận 4</option-->
														<c:forEach var="item" items="${districts}">
															<option value="${item.key}" ${item.key == model.district ? 'selected':'' }>${item.value}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="col-xs-12 col-sm-4">
												<div>
													<label for="ward">Phường</label> <input type="text"
														id="ward" class="form-control" name="ward" value="${model.ward}" />
												</div>
											</div>
											<div class="col-xs-12 col-sm-4">
												<div>
													<label for="street">Đường</label> <input type="text"
														id="street" class="form-control" name="street" value="${model.street}" />
												</div>
											</div>
											<div class="col-xs-12 col-sm-3">
												<div>
													<label for="areaRentFrom">Diện Tích Thuê Từ</label> <input
														type="number" id="areaRentFrom" class="form-control"
														name="areaRentFrom" value="${model.areaRentFrom}" />
												</div>
											</div>
											<div class="col-xs-12 col-sm-3">
												<div>
													<label for="areaRentTo">Diện Tích Thuê Đến</label> <input
														type="number" id="areaRentTo" class="form-control"
														name="areaRentTo"  value="${model.areaRentTo}" />
												</div>
											</div>
											<div class=" col-xs-12 col-sm-3">
												<div>
													<label for="costRentFrom">Gía Thuê Từ</label> <input
														type="number" id="costRentFrom" class="form-control"
														name="costRentFrom"  value="${model.costRentFrom}" />
												</div>
											</div>
											<div class="col-xs-12 col-sm-3">
												<div>
													<label for="costRentTo">Gía Thuê Đến</label> <input
														type="number" id="costRentTo" class="form-control"
														name="costRentTo"  value="${model.costRentTo}"/>
												</div>
											</div>

											<label class="col-sm-3 control-label no-padding-right">Loại Tòa Nhà </label>
											<div class="col-sm-9">
												<c:forEach var="item" items="${buildingTypes}">
													<label class="checkbox-inline"><input type="checkbox" 
													value="${item.key}" id="buildingTypes" name="buildingTypes"
													 	${fn:contains(fn:join(model.buildingTypes,','),item.key) ? 'checked': ''}>${item.value}</label> 
												</c:forEach>
											</div>
											

											<div class=" col-xs-12 col-sm-3">
												<div>
													<button type="button" class="btn btn-success" id="btnSearchBuilding">Tìm Kiếm</button>
												</div>
											</div>
										<input type="hidden" value="${model.page}" id="page" name="page"/>
										<input type="hidden" value="${model.limit}" id="limit" name="limit"/>	
										<input type="hidden" value="<%=SecurityUtils.getPrincipal().getUsername()%>" id="staffName" name="staffName"/>
										</form:form>
									</div>


									<!-- PAGE CONTENT ENDS -->
								</div>
								<!-- /.col -->
							</div>
							<!-- /.row -->
						</div>
					</div>
					<!--body-->
				</div>
				<!--box-->
				<div class="pull-right">
				    <button class="btn btn-white btn-info btn-bold"
						data-toggle="tooltip" title="Refesh" onclick="myResetFunctionb()">
						<i class="fa fa-repeat" aria-hidden="true"></i>
					</button>
					<!-- <a href="#"
						class="btn btn-white btn-info btn-bold" data-toggle="tooltip"
						title="Thêm Tòa Nhà"> <i class="fa fa-plus-circle"
						aria-hidden="true"></i>
					</a> -->
					<!-- <button class="btn btn-white btn-info btn-bold"
						data-toggle="tooltip" title="Xóa Tòa Nhà" id="btnDeleteBuilding">
						<i class="fa fa-trash-o" aria-hidden="true"></i>
					</button> -->
				</div>
				<div class="row">
				
					<div class="col-xs-12">
						<table id="buildingList"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th></th>
									<th>Tên Sản Phẩm</th>
									<th>Địa Chỉ</th>
									<th>Tên Quản lý</th>
									<th>Số Điện Thoại</th>
									<th>Diện Tích Sàn</th>
									<th>Giá Thuê</th>
									<th>Phí Dịch Vụ</th>
									<th>Loại Tòa Nhà</th>
									<th>Thao Tác</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${buildings}">
									<tr>
										<td><input type="checkbox" value="${item.id}"
											id="${item.id}" /></td>
										<td>${item.name}</td>
										<td>${item.address}</td>
										<td>${item.managerName}</td>
										<td>${item.managerPhone}</td>
										<td>${item.buildingArea}</td>
										<td>${item.costRent }</td>
										<td>${item.serviceCost}</td>
										<td>${item.type}</td>
										<td>
											<button class="btn btn-xs btn-info" data-toggle="tooltip"
												title="Giao Tòa Nhà"
												<%-- onclick="assingmentBuilding(${item.id})" --%>>
												<i class="fa fa-bars" aria-hidden="true"></i>
											</button>
											<%-- <c:url  value="/admin/building/edit" var="buildingEdit">
												<c:param name="id" value="${item.id}"/>
											</c:url> --%>
											<%-- <a href="${buildingEdit}" class="btn btn-xs btn-info" data-toggle="tooltip" title="Cập Nhập Tòa Nhà" >
												<i class="fa fa-pencil" aria-hidden="true"></i>
											</a> --%>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					  <div class="paging">
						 <ul class="pagination" id="pagination"></ul>
					  </div>
					</div>
				</div>
				
				<!--Table-->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-content -->
	</div>
</div>
<script type="text/javascript">
 var currentPage = ${model.page};
 var totalPages = ${model.totalPage};
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
            	if (currentPage != page) {
            		$('#limit').val(10);
					$('#page').val(page);
					$('#formSearchBuilding').submit();
				}
            }
        });
    });
</script>
<!-- /.main-content -->
<!-- basic scripts -->
	<div class="modal fade" id="assingmentBuildingModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Danh Sách Nhân Viên</h4>
				</div>
				<div class="modal-body">
					<table class="table table-bordered" id="staffList">
						<thead>
							<th>Chọn Nhân Viên</th>
							<th>Tên Nhân Viên</th>
						</thead>
						<tbody>
						<!--<c:forEach var="item" items="${users}">
									<tr>
										<td><input type="checkbox" value="${item.checked}"
											id="checkbox_${item.checked}" /></td>
										<td>${item.fullName}</td>
									</tr>
						</c:forEach>
							 <tr>
								<td><input type="checkbox" value="2" id="checkbox_2" /></td>
								<td>Nguyễn Văn B</td>

							</tr>
							<tr>
								<td><input type="checkbox" value="3" id="checkbox_3" /></td>
								<td>Nguyễn Văn C</td>
							</tr>
							<tr>
								<td><input type="checkbox" value="4" id="checkbox_4" /></td>
								<td>Nguyễn Văn D</td>
							</tr-->
						</tbody>
					</table>
					<input type="hidden" id="buildingId" name="buildingId" value="" />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default"
						id="btnAssignBuilding">Giao Tòa Nhà</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
				</div>
			</div>

		</div>
	</div>

</body>
</html>
