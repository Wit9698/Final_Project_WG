<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/section/header.jsp" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<form:form method="post"
           modelAttribute="vehicle">
    <body>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Add Vehicle</h6>
        </div>
        <div class="card-body">
            <div class="form-group">
                <form:hidden path="id"/>
                <label >Category</label>
                <form:select path="category" items="${categories}" class="form-control"/>
            </div>


            <div class="form-group">
                <label >Brand</label>
                <form:select path="vehicleModel.brand.id" items="${brands}" itemLabel="brandName" itemValue="id" />
                If you want to change brand you should go step back
            </div>
            <div class="form-group">
                <label >Model </label>
                <form:select path="vehicleModel.id" items="${models}" itemLabel="modelName" itemValue="id" />
                Do not forget to choose a model
            </div>
            <div class="form-group">
                <label >Plane Number</label>
                <form:input path="plateNumber" class="form-control" />
                <form:errors path="plateNumber" element="div"/>
            </div>
            <div class="form-group">
                <label >Type </label> <br>
                <form:select path="type" items="${types}" class="form-control"/>
            </div>
            <div class="form-group">
                <label >Color</label>
                <form:input path="color" class="form-control" /></div>
                <form:errors path="color" element="div"/>
            <div class="form-group">
                <label >First Registration </label>
                <form:input path="firstRegistrationDate" class="form-control" />
                <form:errors path="firstRegistrationDate" element="div"/>
            </div>
            <div class="form-group">
                <label >Client Id </label>
                <form:select path="client.id" items="${clients}" itemLabel="id" itemValue="id" />
            </div>
            <button type="submit" class="btn btn-primary">Zapisz</button>
            </form>
        </div>
    </body>
</form:form>
<%@ include file="/WEB-INF/views/section/footer.jsp" %>