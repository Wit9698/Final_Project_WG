<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/section/header.jsp" %>

            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h6 class="m-0 font-weight-bold text-primary"> Client Table </h6>

                        <a href="/client/addClient" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" ><i
                             class="icon text-white-50">></i> +Add Client</a>
                    </div>



                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>id</th>
                                    <th>First Name</th>
                                    <th>Last Nnme</th>
                                    <th>PESEL</th>
                                    <th>IDNumber</th>
                                    <th>Gender</th>
                                    <th>Email</th>
                                    <th>Nationality</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>id</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>PESEL</th>
                                    <th>ID Number</th>
                                    <th>Gender</th>
                                    <th>Email</th>
                                    <th>Nationality</th>
                                    <th>Action</th>
                                </tr>
                                </tfoot>
                                <tbody>
                                 <c:forEach items="${clients}" var="client">
                                <tr>
                                    <th>${client.id}</th>
                                    <td>${client.firstName}</td>
                                    <td> ${client.lastName}</td>
                                    <td> ${client.pesel}</td>
                                    <th>${client.IDNumber}</th>
                                    <td>${client.gender}</td>
                                    <td>${client.email}</td>
                                    <td>${client.nationality}</td>

                                   <td>
                                       <a href="<c:url value="/client/delete?id=${client.id}"/>" class="btn btn-danger btn-circle btn-lg" >del</a>
                                       <a href="<c:url value="/client/edit?id=${client.id}"/>" class="btn btn-warning btn-circle btn-lg">updt</a>
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