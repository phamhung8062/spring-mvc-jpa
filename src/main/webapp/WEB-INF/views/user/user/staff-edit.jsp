<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/taglib.jsp" %>
 
 <div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>
							<li class="active">Dashboard</li>
						</ul><!-- /.breadcrumb -->

						
					</div>

					<div class="page-content">
						<div class="row">
                                <div class="row">
                                        <div class="col-xs-12">
                                            <form class="form-horizontal" role="form" id="formEditStaff" >
                                               <div class="form-group">
                                                    <label class="col-sm-3 control-label no-padding-right" for="userName"> Tên Tài Khoản </label>
                                                        <div class="col-sm-9">
                                                            <input type="text" id="userName"  class="form-control" name="userName" value="${model.userName}" disabled/>
                                                        </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label no-padding-right" for=""> Tên Đầy Đủ </label>
                                                        <div class="col-sm-9">
                                                                <input type="text" id="fullName"  class="form-control"  name="fullName" value="${model.fullName}"/>
                                                        </div>
                                                </div>
												 <div class="form-group">
                                                    <label class="col-sm-3 control-label no-padding-right" for="address"> Địa Chỉ </label>
                                                        <div class="col-sm-9">
                                                                <input type="text" id="address"  class="form-control"  name="address" value="${model.address}" />
                                                        </div>
                                                </div>
												<div class="form-group">
                                                    <label class="col-sm-3 control-label no-padding-right" for="phone"> Số Điện Thoại </label>
                                                        <div class="col-sm-9">
                                                                <input type="number" id="phone"  class="form-control"  name="phone" value="${model.phone}" />
                                                        </div>
                                                </div>
												<div class="form-group">
                                                    <label class="col-sm-3 control-label no-padding-right" for="email"> Email </label>
                                                        <div class="col-sm-9">
                                                                <input type="text" id="email"  class="form-control"  name="email" value="${model.email}" />
                                                        </div>
                                                </div>
                                                <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right" > Chọn Quyền </label>
                                                            <div class="col-sm-9">
                                                                    <label class="checkbox-inline"><input type="radio" value="1" id="listroles"  name="listroles" disabled >Quản Trị Viên</label>
                                                                    <label class="checkbox-inline"><input type="radio" value="2" id="listroles"  name="listroles"  disabled checked>Nhân Viên</label>
                                                            </div>
												</div>
												<div class="form-group">
												<input type="hidden" id="id" name="id" value="${model.id}" />
												<input type="hidden" id="userName" name="userName" value="${model.userName}" />
												<input type="hidden" id="listroles" name="listroles" value="2" />
												</div>
												<div class="form-group">
                                                    <label class="col-sm-3 control-label no-padding-right"></label>
                                                        <div class="col-sm-9">
																<button type="button" class="btn btn-primary" id="btnEditStaff" >Cập Nhập Tài Khoản</button>
																<button type="button" class="btn btn-primary">Hủy</button>
                                                        </div>
                                                </div>
                                            </form>
                                        </div>
                                </div>
							
							
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->