<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/section/header.jsp" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<form:form method="post"
           modelAttribute="vehicle">
    <body>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Select a brand: </h6>
        </div>
        <div class="card-body">
            <div class="form-group">
                <form:hidden path="id"/>

            <div class="form-group">
                <label >Select a brand </label>
                <form:select path="vehicleModel.brand.id" items="${brands}" itemLabel="brandName" itemValue="id" />
            </div>
            <button type="submit" class="btn btn-primary">NEXT</button>
            </form>
        </div>
    </body>
</form:form>
<%@ include file="/WEB-INF/views/section/footer.jsp" %>