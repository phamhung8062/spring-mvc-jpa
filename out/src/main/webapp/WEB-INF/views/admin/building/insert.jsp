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
                                                    <label class="col-sm-3 control-label no-padding-right" for="name"> Tên Tòa Nhà </label>
                                                        <div class="col-sm-9">
                                                            <input type="text" id="name"  class="form-control" name="name" value="${model.name}"/>
                                                        </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label no-padding-right" for="numberOfBasement"> Số Tầng Hầm </label>
                                                        <div class="col-sm-9">
                                                                <input type="number" id="numberOfBasement"  class="form-control"  name="numberOfBasement" value="${model.numberOfBasement}" />
                                                        </div>
                                                </div>
                                               
												<div class="form-group">
                                                    <label class="col-sm-3 control-label no-padding-right" for="areaRent"> Diện Tích Thuê </label>
                                                        <div class="col-sm-9">
                                                                <input type="text" id="areaRent"  class="form-control" name="areaRent" value="${model.areaRent}" />
                                                        </div>
												</div>
												<div class="form-group">
                                                    <label class="col-sm-3 control-label no-padding-right"></label>
                                                        <div class="col-sm-9">
																<button type="button" class="btn btn-primary" id="btnAddBuilding" >Thêm Tòa Nhà</button>
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