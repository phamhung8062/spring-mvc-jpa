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
                                            <form class="form-horizontal" role="form" id="formEdit" >
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label no-padding-right" for="customerName"> Tên Khách Hàng </label>
                                                        <div class="col-sm-9">
                                                            <input type="text" id="customerName"  class="form-control" name="customerName" value="${model.customerName}"/>
                                                        </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label no-padding-right" for=""> Email </label>
                                                        <div class="col-sm-9">
                                                                <input type="text" id="email"  class="form-control"  name="email" value="${model.email}"/>
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
                                                    <label class="col-sm-3 control-label no-padding-right"></label>
                                                        <div class="col-sm-3">
																<button type="button" class="btn btn-primary" id="btnAddCustomer" >Thêm Tài Khoản</button>
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