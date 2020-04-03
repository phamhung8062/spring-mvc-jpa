<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.laptrinhjavaweb.util.SecurityUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>
    <div class="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>
        <div class="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
    <ul class="nav nav-list">
      <li class="">
       					<c:url  value="/admin/user/user/edit" var="userEdit">
												<c:param name="id" value="${SecurityUtils.getPrincipal().getId()}"/>
						</c:url>
						 <a href="${userEdit}">
						<i class="menu-icon fa fa-user" aria-hidden="true"></i>
							<span class="menu-text"> Thông Tin Cá Nhân </span>
						</a>
						
						<b class="arrow"></b>
		</li>
    	
		<li >
            <a href="#" class="dropdown-toggle">
				<i class="menu-icon fa fa-list-alt" aria-hidden="true"></i>
                <span class="menu-text"></span>
                Quản lý người dùng
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/admin/user/list?page=1&limit=10'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        DS người dùng
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
        <li >
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"></span>
                Quản lý tòa nhà
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/admin/building/list?page=1&limit=10'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        DS Tòa Nhà
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
        <li class="">
						<a href="<c:url value='/admin/customer/list?page=1&limit=10'/>">
							<i class="menu-icon fa fa-fighter-jet"></i>
							<span class="menu-text"> Quản Lý Khách Hàng </span>
						</a>

						<b class="arrow"></b>
		</li>
        
    </ul>
    <div class="sidebar-toggle sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>