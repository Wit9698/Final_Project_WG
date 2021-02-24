<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ include file="/WEB-INF/views/section/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <div class="d-sm-flex align-items-center justify-content-between mb-4">
                <h6 class="m-0 font-weight-bold text-primary"> Vehicle Table </h6>

                <a href="/vehicle/addBrand" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" ><i
                        class="icon text-white-50">></i> +Add Vehicle</a>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>Category </th>
                            <th>Brand </th>
                            <th>Model </th>
                            <th>Plate Number</th>
                            <th>Type</th>
                            <th>Color</th>
                            <th>First Registration</th>
                            <th>Client Id</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>id</th>
                            <th>Category </th>
                            <th>Brand </th>
                            <th>Model </th>
                            <th>Plate Number</th>
                            <th>Type</th>
                            <th>Color</th>
                            <th>First Registration</th>
                            <th>Client Id</th>
                            <th>Action</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <c:forEach items="${vehicles}" var="vehicle">
                            <tr>
                                <th>${vehicle.id}</th>
                                <td>${vehicle.category}</td>
                                <td>${vehicle.vehicleModel.brand.brandName}</td>
                                <td>${vehicle.vehicleModel.modelName}</td>
                                <th>${vehicle.plateNumber}</th>
                                <td>${vehicle.type}</td>
                                <td>${vehicle.color}</td>
                                <td>${vehicle.firstRegistrationDate}</td>
                                <td>${vehicle.client.id}</td>
                                <td>
                                    <a href="<c:url value="/vehicle/deleteV?id=${vehicle.id}"/>" class="btn btn-danger btn-circle btn-lg" >del</a>
                                    <a href="<c:url value="/vehicle/editV?id=${vehicle.id}"/>" class="btn btn-warning btn-circle btn-lg">updt</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
        </div>

    </div>
    <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<!-- Footer -->
<%@ include file="/WEB-INF/views/section/footer.jsp" %>