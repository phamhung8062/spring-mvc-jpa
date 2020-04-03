<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="userUrl" value="/admin/user/list?page=${model.page}&limit=${model.limit}" />
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Người Dùng</title>
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
				<li class="active">Người Dùng</li>
			</ul>
			<!-- /.breadcrumb -->


		</div>

		<div class="page-content">

			<div class="page-header">
				<h1>
					Người Dùng <small> <i
						class="ace-icon fa fa-angle-double-right"></i> Danh Sách Người Dùng
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
										<form:form action="${userUrl}" method="get" id="formSearchUser" modelAttribute="model">
												<div class="col-sm-4">
													<div>
															<label for="userName">Tên Tài Khoản</label>
															<input type="text" id="userName" class="form-control" name="userName" value="${model.userName}" />
													</div>
												</div>
												<div class="col-sm-4">
													<div>
															<label for="fullName">Tên Đầy Đủ</label>
															<input type="text" id="fullName" class="form-control" name="fullName" value="${model.fullName}" />
													</div>
				
												</div>
												<div class="col-sm-4">
													<div>
															<label for="phone">Số Điện Thoại</label>
															<input type="number" id="name" class="form-control" name="phone" value="${model.phone}" />
													</div>
				
												</div>
											</div>
									    </div><!-- /.col -->
										<div class="col-xs-12">
											<div class="row">
												<div class="col-sm-4">
													<div>
															<label for="email">EMail</label>
															<input type="text" id="email" class="form-control" name="email" value="${model.email}" />
													</div>
												</div>
											</div>
									    </div><!-- /.col -->
											<div class=" col-xs-12 col-sm-3">
												<div>
													<button type="button" class="btn btn-success" id="btnSearchUser">Tìm Kiếm</button>
												</div>
												
											</div>
										<input type="hidden" value="${model.page}" id="page" name="page"/>
										<input type="hidden" value="${model.limit}" id="limit" name="limit"/>	
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
						data-toggle="tooltip" title="Refesh" onclick="myResetFunction()">
						<i class="fa fa-repeat" aria-hidden="true"></i>
					</button>
					<a href="<c:url  value='/admin/user/insert'/>"
						class="btn btn-white btn-info btn-bold" data-toggle="tooltip"
						title="Thêm Tài Khoản"> <i class="fa fa-plus-circle"
						aria-hidden="true"></i>
					</a>
					<button class="btn btn-white btn-info btn-bold"
						data-toggle="tooltip" title="Xóa Tài Khoản" id="btnDeleteUser">
						<i class="fa fa-trash-o" aria-hidden="true"></i>
					</button>
					
				</div>
				<div class="row">
				
					<div class="col-xs-12">
						<table id="userList"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th></th>
									<th>Tên Tài Khoản</th>
									<th>Tên Đầy Đủ</th>
									<th>Địa Chỉ</th>
									<th>Số Điện Thoại</th>
									<th>Email</th>
									<th>Chức Vụ</th>
									<th>Thao Tác</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${users}">
									<tr>
										<td><input type="checkbox" value="${item.id}"
											id="${item.id}" /></td>
										<td>${item.userName}</td>
										<td>${item.fullName}</td>
										<td>${item.address}</td>
										<td>${item.phone}</td>
										<td>${item.email}</td>
										<td></td>
										<td>
											<c:url  value="/admin/user/edit" var="userEdit">
												<c:param name="id" value="${item.id}"/>
											</c:url>
											<a href="${userEdit}" class="btn btn-xs btn-info" data-toggle="tooltip" title="Cập Nhập Tài Khoản" >
												<i class="fa fa-pencil" aria-hidden="true"></i>
											</a>
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
					$('#formSearchUser').submit();
				}
            }
        });
    });
</script>
<!-- /.main-content -->
<!-- basic scripts -->

</body>
</html>
