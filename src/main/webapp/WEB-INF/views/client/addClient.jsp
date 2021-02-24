<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/section/header.jsp" %>

<form:form method="post"
           modelAttribute="client">
<body>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Add Client</h6>
        </div>
        <div class="card-body">
                <div class="form-group">
                    <form:hidden path="id"/>
                    <label >First Name</label>
                    <form:input path="firstName" class="form-control" />
                    <form:errors path="firstName" element="div"  />
                </div>
                <div class="form-group">
                    <label >Last Name</label>
                    <form:input path="lastName" class="form-control"/>
                    <form:errors path="lastName" element="div"  />
                </div>
            <div class="form-group">
                <label >PESEL </label>
                <form:input path="pesel" class="form-control" />
                <form:errors path="pesel" element="div"  />
            </div>
            <div class="form-group">
                <label >ID Number</label>
                <form:input path="IDNumber" class="form-control" />
                <form:errors path="IDNumber" element="div"  />
            </div>
            <div class="form-group">
                <label >Gender </label> <br>
                <form:radiobutton path="gender" value="M" /> Male <br>
                <form:radiobutton path="gender" value="F" /> Female
            </div>
                <div class="form-group">
                    <label >Email</label>
                    <form:input path="email" class="form-control" /></div>
                    <form:errors path="email" element="div"  />
            <div class="form-group">
                <label >Nationality </label>
                <form:select path="nationality" items="${natio}" class="form-control"/>

            </div>
                <button type="submit" class="btn btn-primary">Zapisz</button>
            </form>
        </div>
</body>
</form:form>
<%@ include file="/WEB-INF/views/section/footer.jsp" %>