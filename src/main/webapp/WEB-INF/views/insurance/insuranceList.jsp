<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/section/header.jsp" %>


<div class="container-fluid">

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <div class="d-sm-flex align-items-center justify-content-between mb-4">
                <h6 class="m-0 font-weight-bold text-primary"> Insurance Table </h6>

                <a href="/insurance/addInsurance" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" ><i
                        class="icon text-white-50">></i> +Add Insurance</a>
            </div>



            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>

                            <th>Insurance Number </th>
                            <th>Provider </th>
                            <th>Type</th>
                            <th>Valid Date</th>
                            <th>Client Id</th>
                            <th>Vehicle</th>
                            <td>Action</td>

                        </tr>
                        </thead>
                        <tfoot>
                        <tr>

                            <th>Insurance Number </th>
                            <th>Provider </th>
                            <th>Type</th>
                            <th>Valid Date</th>
                            <th>Client Id</th>
                            <th>Vehicle</th>
                            <td>Action</td>
                        </tr>
                        </tfoot>
                        <tbody>
                        <c:forEach items="${insurances}" var="insurance">
                            <tr>

                                <td>${insurance.insuranceNumber}</td>
                                <td>${insurance.provider}</td>
                                <td>${insurance.type}</td>
                                <th>${insurance.insuranceValidDate}</th>
                                <td>${insurance.client.id}</td>
                                <td>${insurance.vehicle.plateNumber}</td>

                                <td>
                                    <a href="<c:url value="/insurance/deleteInsurance?id=${insurance.id}"/>" class="btn btn-danger btn-circle btn-lg" >del</a>
                                    <a href="<c:url value="/insurance/editInsurance?id=${insurance.id}"/>" class="btn btn-warning btn-circle btn-lg">updt</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
        </div>

    </div>
</div>

<%@ include file="/WEB-INF/views/section/footer.jsp" %>