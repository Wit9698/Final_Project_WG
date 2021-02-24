<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/section/header.jsp" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<form:form method="post"
           modelAttribute="insurance">
    <body>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Add new </h6>
        </div>
        <div class="card-body">
            <div class="form-group">
                <form:hidden path="id"/>
                <label >Insurance Number</label>
                <form:input path="insuranceNumber" class="form-control" />
                <form:errors path="insuranceNumber" element="div"  />
            </div>
            <div class="form-group">
                <label >Provider </label>
                <form:input path="provider" class="form-control" />
                <form:errors path="provider" element="div"  />
            </div>
            <div class="form-group">
                <label >Type </label> <br>
                <form:select path="type" items="${types}" class="form-control"/>
            </div>
            <div class="form-group">
                <label >Valid Date</label>
                <form:input path="insuranceValidDate" class="form-control" /></div>
            <form:errors path="insuranceValidDate" element="div"  />

            <div class="form-group">
                <label >Client</label>
                <form:select path="client.id" items="${clients}" itemLabel="IDNumber"  itemValue="id" />
            </div>
            <div class="form-group">
                <label >Vehicle </label>
                <form:select path="vehicle.id" items="${vehicles}" itemLabel="plateNumber" itemValue="id" />
            </div>
            <button type="submit" class="btn btn-primary">Zapisz</button>
            </form>
        </div>
    </body>
</form:form>
<%@ include file="/WEB-INF/views/section/footer.jsp" %>