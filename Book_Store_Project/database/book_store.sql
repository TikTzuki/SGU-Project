-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 17, 2020 lúc 08:20 PM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `book_store`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `author`
--

CREATE TABLE `author` (
  `author_id` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `author`
--

INSERT INTO `author` (`author_id`, `first_name`, `last_name`, `phone_number`, `email`) VALUES
(1, 'Nguyễn Nhật', 'Ánh', '09786452', 'nguyennhatanh@gmail.com'),
(2, 'Paulo', 'Coelho', '08754654', 'paulo@gmail.com'),
(4, 'Marijn', 'Haverbeke', '08456431', 'marijn@gmail.com'),
(5, 'Geogre R.R.', 'Martin', '01234567', 'martin@gmail.com'),
(6, 'Stephen', 'King', '01235468', 'king@gmail.com'),
(7, 'Mario', 'Puzo', '01235465', 'puzo@gmail.com'),
(8, 'Agatha', 'Christie', '01235445', 'christie@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book`
--

CREATE TABLE `book` (
  `book_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `isbn` varchar(13) NOT NULL,
  `publication_date` date DEFAULT NULL,
  `price` decimal(12,0) DEFAULT 0,
  `available_quantity` int(11) DEFAULT 0,
  `ten_anh` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `book`
--

INSERT INTO `book` (`book_id`, `author_id`, `genre_id`, `title`, `isbn`, `publication_date`, `price`, `available_quantity`, `ten_anh`) VALUES
(1, 1, 1, 'Còn chút gì để nhớ', '9786041004832', '2016-06-26', '65000', 40, '1.jpg'),
(2, 2, 2, 'Nhà giảm kim thuật', '3120365442653', '2018-12-02', '55000', 31, '2.jpg'),
(3, 4, 3, 'Eloquent Javascript', '9781593279509', '2018-12-04', '250000', 58, '3.jpg'),
(4, 8, 2, 'The Big Four', '', '2020-05-11', '500000', 60, '4.png'),
(5, 5, 2, 'The Song of Ice and Fire', '', '2020-06-01', '250000', 100, '5.jpg'),
(6, 6, 2, 'IT', '', '2019-12-15', '150000', 200, 'it.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book_order`
--

CREATE TABLE `book_order` (
  `order_id` int(11) NOT NULL,
  `staff_id` int(11) NOT NULL,
  `discount_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `total` decimal(12,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='book_order';

--
-- Đang đổ dữ liệu cho bảng `book_order`
--

INSERT INTO `book_order` (`order_id`, `staff_id`, `discount_id`, `customer_id`, `order_date`, `total`) VALUES
(3, 1, 1, 1, '2020-05-31', '58500'),
(4, 1, 1, 1, '2020-05-31', '110000'),
(7, 2, 0, 1, '2020-06-14', '120000'),
(9, 2, 0, 3, '2020-06-14', '120000'),
(10, 1, 1, 2, '2020-06-17', '258500'),
(11, 1, 1, 3, '2020-06-18', '313500');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`customer_id`, `first_name`, `last_name`, `email`, `phone_number`, `address`) VALUES
(1, 'Nguyễn Văn', 'Nam', 'nguyennam@gmail.com', '0912345678', '34 Nguyen Van Cu'),
(2, 'Đỗ Thanh', 'Mụi', 'muimui@gmail.com', '0914785236', '34 Nguyễn Trãi'),
(3, 'Lê', 'Nhã', 'nha@gmail.com', '0123456789', '56 Lê Duẩn');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `discount`
--

CREATE TABLE `discount` (
  `discount_id` int(11) NOT NULL,
  `discount_name` varchar(255) DEFAULT NULL,
  `discount_type` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `discount`
--

INSERT INTO `discount` (`discount_id`, `discount_name`, `discount_type`, `start_date`, `end_date`, `status`) VALUES
(0, 'Không áp mã', '0', '2015-01-01', '2050-01-01', 1),
(1, 'Black Friday 2020', '100', '2020-11-20', '2020-11-27', 1),
(2, 'Chào tháng 5', '200', '2020-05-20', '2020-05-27', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `discount_detail`
--

CREATE TABLE `discount_detail` (
  `discount_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `percent` int(11) NOT NULL,
  `status` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `discount_detail`
--

INSERT INTO `discount_detail` (`discount_id`, `book_id`, `percent`, `status`) VALUES
(1, 1, 10, 1),
(1, 3, 20, 1),
(2, 2, 5, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `genre`
--

CREATE TABLE `genre` (
  `genre_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `genre`
--

INSERT INTO `genre` (`genre_id`, `name`) VALUES
(1, 'Văn Học Việt Nam'),
(2, 'Văn Học Nước Ngoài'),
(3, 'Tin Học');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_item`
--

CREATE TABLE `order_item` (
  `order_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT 0,
  `price` decimal(12,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `order_item`
--

INSERT INTO `order_item` (`order_id`, `book_id`, `quantity`, `price`) VALUES
(3, 1, 1, '65000'),
(4, 1, 3, '195000'),
(4, 2, 2, '110000'),
(7, 1, 1, '65000'),
(7, 2, 1, '55000'),
(9, 1, 1, '65000'),
(9, 2, 1, '55000'),
(10, 1, 1, '65000'),
(10, 3, 1, '250000'),
(11, 1, 1, '65000'),
(11, 2, 1, '55000'),
(11, 3, 1, '250000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `publisher`
--

CREATE TABLE `publisher` (
  `publisher_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `publisher`
--

INSERT INTO `publisher` (`publisher_id`, `name`, `address`, `email`, `phone_number`) VALUES
(1, 'Phương Đông', '45 Nguyễn Tri Phương', 'ncskh@nxbpd.com.vn', '02838683930'),
(2, 'Trẻ', '37 Nguyễn Đình Chiểu', 'cskh@nxbtre.com.vn', '08461321584'),
(3, 'Văn Học', '65 Le Duan', 'cskh@nxbvh.com.vn', '09455533348');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `received_note`
--

CREATE TABLE `received_note` (
  `received_note_id` int(11) NOT NULL,
  `publisher_id` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `total_price` decimal(10,0) DEFAULT NULL,
  `received_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `received_note`
--

INSERT INTO `received_note` (`received_note_id`, `publisher_id`, `state`, `total_price`, `received_date`) VALUES
(1, 1, 'received', '12000000', '2018-01-01'),
(2, 2, 'received', '2500000', '2016-01-01'),
(3, 3, 'received', '1600000', '2018-01-01');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `received_note_detail`
--

CREATE TABLE `received_note_detail` (
  `received_note_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT 0,
  `cost_price` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `received_note_detail`
--

INSERT INTO `received_note_detail` (`received_note_id`, `book_id`, `quantity`, `cost_price`) VALUES
(1, 3, 60, '200000'),
(2, 1, 50, '50000'),
(3, 2, 40, '40000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`role_id`, `role_name`) VALUES
(1, 'admin'),
(2, 'manager'),
(3, 'staff');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `staff`
--

CREATE TABLE `staff` (
  `staff_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  `state` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `staff`
--

INSERT INTO `staff` (`staff_id`, `name`, `email`, `password`, `phone_number`, `sex`, `role_id`, `state`) VALUES
(1, 'Long', 'tranlong@gmail.com', 'P@ssword1', '0858267296', 'Nam', 1, 1),
(2, 'Ninh', 'tranninh@gmail.com', 'P@ssword1', '09444555666', 'Nam', 1, 1),
(3, 'Vũ', 'levu@gmail.com', 'P@ssword', '09111222333', 'Nam', 1, 1),
(4, 'Tran', 'huynhtran@gmail.com', 'P@ssword', '09555666777', 'Nữ', 1, 1),
(5, 'Nhi', 'trannhi@gmail.com', '12345678', '09222333444', 'Nữ', 3, 1),
(6, 'Thủy', 'thuyta@gmail.com', '12345678', '09333444555', 'Nữ', 2, 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`author_id`);

--
-- Chỉ mục cho bảng `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`),
  ADD KEY `b_author_id_pk` (`author_id`),
  ADD KEY `b_genre_id_pk` (`genre_id`);

--
-- Chỉ mục cho bảng `book_order`
--
ALTER TABLE `book_order`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `od_staff_id_pk` (`staff_id`),
  ADD KEY `od_discount_id_pk` (`discount_id`),
  ADD KEY `od_customer_id_pk` (`customer_id`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Chỉ mục cho bảng `discount`
--
ALTER TABLE `discount`
  ADD PRIMARY KEY (`discount_id`);

--
-- Chỉ mục cho bảng `discount_detail`
--
ALTER TABLE `discount_detail`
  ADD PRIMARY KEY (`discount_id`,`book_id`),
  ADD KEY `discount_id` (`discount_id`),
  ADD KEY `fk_discount_book` (`book_id`);

--
-- Chỉ mục cho bảng `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`genre_id`);

--
-- Chỉ mục cho bảng `order_item`
--
ALTER TABLE `order_item`
  ADD PRIMARY KEY (`order_id`,`book_id`),
  ADD KEY `oi_order_id_pk` (`order_id`),
  ADD KEY `oi_book_id_pk` (`book_id`);

--
-- Chỉ mục cho bảng `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`publisher_id`);

--
-- Chỉ mục cho bảng `received_note`
--
ALTER TABLE `received_note`
  ADD PRIMARY KEY (`received_note_id`),
  ADD KEY `fk_received_note` (`publisher_id`);

--
-- Chỉ mục cho bảng `received_note_detail`
--
ALTER TABLE `received_note_detail`
  ADD PRIMARY KEY (`received_note_id`,`book_id`),
  ADD KEY `fk_book` (`book_id`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Chỉ mục cho bảng `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staff_id`),
  ADD KEY `staff_fk_1` (`role_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `author`
--
ALTER TABLE `author`
  MODIFY `author_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `book`
--
ALTER TABLE `book`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `book_order`
--
ALTER TABLE `book_order`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `discount`
--
ALTER TABLE `discount`
  MODIFY `discount_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `genre`
--
ALTER TABLE `genre`
  MODIFY `genre_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `publisher`
--
ALTER TABLE `publisher`
  MODIFY `publisher_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `received_note`
--
ALTER TABLE `received_note`
  MODIFY `received_note_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `staff`
--
ALTER TABLE `staff`
  MODIFY `staff_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `book_ibfk_3` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`genre_id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `book_order`
--
ALTER TABLE `book_order`
  ADD CONSTRAINT `book_order_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`),
  ADD CONSTRAINT `book_order_ibfk_2` FOREIGN KEY (`discount_id`) REFERENCES `discount` (`discount_id`),
  ADD CONSTRAINT `book_order_ibfk_3` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`);

--
-- Các ràng buộc cho bảng `discount_detail`
--
ALTER TABLE `discount_detail`
  ADD CONSTRAINT `fk_discount_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_discount_detail` FOREIGN KEY (`discount_id`) REFERENCES `discount` (`discount_id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `order_item`
--
ALTER TABLE `order_item`
  ADD CONSTRAINT `order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `book_order` (`order_id`),
  ADD CONSTRAINT `order_item_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`);

--
-- Các ràng buộc cho bảng `received_note`
--
ALTER TABLE `received_note`
  ADD CONSTRAINT `fk_received_note` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`publisher_id`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `received_note_detail`
--
ALTER TABLE `received_note_detail`
  ADD CONSTRAINT `fk_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_received_note_id` FOREIGN KEY (`received_note_id`) REFERENCES `received_note` (`received_note_id`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `staff_fk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
