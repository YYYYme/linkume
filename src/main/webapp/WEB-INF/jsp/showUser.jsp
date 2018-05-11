<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>spring</title>
    <style type="text/css">
    .tableCss {
    	border:1px solid;
    	color:black;
    	width:200px;
    	height:100px;
    	border-collapse:collapse;
    }
    </style>  
  </head>  
    
  <body>  
    <table border="1" cellspacing="0" cellpadding="0">
    	<thead>
	    	<tr>
		    	<th>ID</th>
		    	<th>姓名</th>
		    	<th>密码</th>
		    	<th>年龄</th>
		    </tr>
	    </thead>
	    <tbody>
		    <tr>
		    	<td>${user.id}</td>
		    	<td>${user.userName}</td>
		    	<td>${user.password}</td>
		    	<td>${user.age}</td>
		    </tr>
	    </tbody>
    </table>
      
  </body>  
</html> 