<div class="page-wrapper">
    <!-- ============================================================== -->
    <!-- Bread crumb and right sidebar toggle -->
    <!-- ============================================================== -->
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-12 d-flex no-block align-items-center">
                <h4 class="page-title">Dashboard</h4>
                <div class="ml-auto text-right">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Library</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- End Bread crumb and right sidebar toggle -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- Container fluid  -->
    <!-- ============================================================== -->
    <div class="container-fluid">
        <!-- ============================================================== -->
        <!-- Sales chart -->
        <!-- ============================================================== -->
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-body">
                        <div class="d-md-flex align-items-center">
                            <div>
                                <h4 class="card-title">Hiệu quả vận hành</h4>
                                <span> Từ ngày: </span>
                                <input type="date" id="start-date-analysis" name="start-date-analysis">
                                <span> đến ngày: </span>
                                <input type="date" id="end-date-analysis" name="end-date-analysis">
                            </div>
                        </div>
                        <div class="row">
                            <!-- column -->
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-6 m-t-15">
                                        <div class="bg-dark p-10 text-white text-center">
                                            <i class="fas fa-dollar-sign m-b-5 font-16"></i>
                                            <h5 class="m-b-0 m-t-5 currency" id="total-revenue">
                                                <!-- JS here-->
                                            </h5>
                                            <small class="font-light">Tổng doanh thu</small>
                                        </div>
                                    </div>
                                    <div class="col-6 m-t-15">
                                        <div class="bg-dark p-10 text-white text-center">
                                            <i class="far fa-list-alt m-b-5 font-16"></i>
                                            <h5 class="m-b-0 m-t-5" id="total-order">
                                                <!-- JS here-->
                                            </h5>
                                            <small class="font-light">Tổng số đơn hàng</small>
                                        </div>
                                    </div>
                                    <div class="col-6 m-t-15">
                                        <div class="bg-dark p-10 text-white text-center">
                                            <i class="fab fa-amazon-pay" aria-hidden="true"></i>
                                            <h5 class="m-b-0 m-t-5 currency" id="avg-order-value">
                                                <!-- JS here-->
                                            </h5>
                                            <small class="font-light ">Giá trị trung bình đơn hàng</small>
                                        </div>
                                    </div>
                                    <div class="col-6 m-t-15">
                                        <div class="bg-dark p-10 text-white text-center">
                                            <i class="far fa-check-circle m-b-5 font-16"></i>
                                            <h5 class="m-b-0 m-t-5" id="total-success-order">
                                                <!-- JS here-->
                                            </h5>
                                            <small class="font-light">Tổng số đơn hàng thành công</small>
                                        </div>
                                    </div>
                                    <div class="col-6 m-t-15">
                                        <div class="bg-dark p-10 text-white text-center">
                                            <i class="fa fa-tag m-b-5 font-16"></i>
                                            <h5 class="m-b-0 m-t-5" id="total-products-selled">
                                                <!-- JS here-->
                                            </h5>
                                            <small class="font-light">Sản phẩm bán được</small>
                                        </div>
                                    </div>
                                    <div class="col-6 m-t-15">
                                        <div class="bg-dark p-10 text-white text-center">
                                            <i class="fas fa-users m-b-5 font-16"></i>
                                            <h5 class="m-b-0 m-t-5" id="total-customer">
                                                <!-- JS here-->
                                            </h5>
                                            <small class="font-light">Số khách hàng</small>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="col-lg-9">
                                <div id="chart1" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                                <!--
                                <div class="flot-chart">
                                    <div class="flot-chart-content" id="flot-line-chart"></div>
                                </div>
                                -->
                            </div>
                            <!-- column -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- Sales chart -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Recent comment and chats -->
        <!-- ============================================================== -->
        <div class="row">
            <!-- column -->
            <div class="col-lg-6">
                <!-- Top sản phẩm bán chạy-->
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Sản phẩm bán chạy nhất</h4>

                    </div>
                    <div class="comment-widgets scrollable">
                        <!-- Product Row -->
                        <div class="d-flex flex-row comment-row m-t-0">
                            <img src="" alt="" class="rounded-circle">
                            <div class="comment-text active w-100">
                                <h6 class="font-medium"> Light name</h6>
                                <span class="m-b-15 d-block">Lorem Ipsum is simply dummy text of the printing and type
                                    setting industry. </span>
                                <div class="comment-footer">
                                    <span class="text-muted float-right"> Doanh thu từ sản phẩm<span
                                            class="subtotal-price"> 150000</span> </span>
                                    <span class="text-muted float-right"> Bán được <span class="quantity-selled">
                                            150000</span></span>
                                    <span class="text-muted float-right"> Giá: <span class="light-price">
                                            150000</span></span>
                                    <button type="button" class="btn btn-success btn-sm"><a
                                            hreft="?page=change_product&light_id=1">Chi tiết</a></button>
                                </div>
                            </div>
                        </div>
                        <!-- Comment Row -->
                        <div class="d-flex flex-row comment-row">
                            <div class="p-2"><img src="library/assets/images/users/4.jpg" alt="user" width="50"
                                    class="rounded-circle"></div>
                            <div class="comment-text active w-100">
                                <h6 class="font-medium">Michael Jorden</h6>
                                <span class="m-b-15 d-block">Lorem Ipsum is simply dummy text of the printing and type
                                    setting industry. </span>
                                <div class="comment-footer">
                                    <span class="text-muted float-right">May 10, 2016</span>
                                    <button type="button" class="btn btn-cyan btn-sm"><a href="">Sửa</a></button>
                                    <button type="button" class="btn btn-success btn-sm"><a hreft="">Chi
                                            tiết</a></button>
                                </div>
                            </div>
                        </div>
                        <!-- Comment Row -->
                        <div class="d-flex flex-row comment-row">
                            <div class="p-2"><img src="library/assets/images/users/5.jpg" alt="user" width="50"
                                    class="rounded-circle"></div>
                            <div class="comment-text w-100">
                                <h6 class="font-medium">Johnathan Doeting</h6>
                                <span class="m-b-15 d-block">Lorem Ipsum is simply dummy text of the printing and type
                                    setting industry. </span>
                                <div class="comment-footer">
                                    <span class="text-muted float-right">August 1, 2016</span>
                                    <button type="button" class="btn btn-cyan btn-sm">Edit</button>
                                    <button type="button" class="btn btn-success btn-sm">Publish</button>
                                    <button type="button" class="btn btn-danger btn-sm">Delete</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- column -->

            <div class="col-lg-6">
                <!-- Loại sản phẩm bán chạy nhất Card -->
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title"> Loại sản phẩm & thương hiệu bán chạy nhất</h4>
                        <div class="chat-box scrollable" style="height:475px;">
                            <div class="row">
                                <div class="col-sm-6">
                                    <!--chat Row -->
                                    <ul class="chat-list" id="top-category-selled-ajax">
                                        <!--chat Row -->
                                        <li class="chat-item">
                                            <div>
                                                <span> 1. </span>
                                                <span> Đèn chùm </span>
                                                <a href=""><button class="btn btn-info btn-sm" type="button"> Xem
                                                    </button></a>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <div class="col-sm-6">
                                    <!--chat Row -->
                                    <ul class="chat-list" id="top-brand-selled-ajax">
                                        <!--chat Row -->
                                        <li class="chat-item">
                                            <div>
                                                <span> 1. </span>
                                                <span> Đèn chùm </span>
                                                <a href=""><button class="btn btn-info btn-sm" type="button"> Xem
                                                    </button></a>
                                            </div>
                                        </li>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Người mua nhiều nhất -->
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title"> Khách hàng thân quen</h4>
                        <div class="chat-box scrollable" style="height:475px;">
                            <div class="row">
                                <div class="col-sm-12">
                                    <!--chat Row -->
                                    <ul class="chat-list" id="top-customer-ajax">
                                        <!--chat Row -->
                                        <li class="chat-item">
                                            <div>
                                                <span> 1. </span>
                                                <span> Đèn chùm </span>
                                                <a href=""><button class="btn btn-info btn-sm" type="button"> Xem
                                                    </button></a>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- Recent comment and chats -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- End Container fluid  -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- footer -->
    <!-- ============================================================== -->
    <footer class="footer text-center">
        All Rights Reserved by Matrix-admin. Designed and Developed by <a href="https://wrappixel.com">WrapPixel</a>.
    </footer>
    <!-- ============================================================== -->
    <!-- End footer -->
    <!-- ============================================================== -->
        <!--TikTzuki's Script-->
        <script src="library/ajax/site-analysis.js"></script>
</div>