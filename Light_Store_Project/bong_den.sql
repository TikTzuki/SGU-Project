-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 14, 2020 lúc 08:55 AM
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
-- Cơ sở dữ liệu: `bong_den`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bongden`
--

CREATE TABLE `bongden` (
  `mabd` int(11) NOT NULL,
  `maloai` int(11) DEFAULT NULL,
  `tenbd` varchar(255) DEFAULT NULL,
  `gia` int(255) DEFAULT NULL,
  `soluongtonkho` int(255) DEFAULT NULL,
  `kichthuoc` varchar(255) DEFAULT NULL,
  `mausac` varchar(255) DEFAULT NULL,
  `khoiluong` float(255,0) DEFAULT NULL,
  `mota` varchar(500) DEFAULT NULL,
  `hinhanh` varchar(255) DEFAULT NULL,
  `mathuonghieu` int(11) DEFAULT NULL,
  `chatlieu` varchar(255) DEFAULT NULL,
  `trangthai` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Đang đổ dữ liệu cho bảng `bongden`
--

INSERT INTO `bongden` (`mabd`, `maloai`, `tenbd`, `gia`, `soluongtonkho`, `kichthuoc`, `mausac`, `khoiluong`, `mota`, `hinhanh`, `mathuonghieu`, `chatlieu`, `trangthai`) VALUES
(1, 1, 'Nemo Crown Minor', 20000000, 20, '250 100', 'Vàng', 5, 'Đèn chùm tinh khiết được thiết kế bởi Jehs + Laub\r\nÁnh sáng xung quanh miễn phí và toàn diện\r\nThân máy bằng nhôm mịn với bề mặt chất lượng cao.Nemo Crown Minor không phải là một đèn chùm thông thường. Ánh sáng mặt dây này không có bất kỳ sự rượt đuổi và rườm rà nào và thay vào đó tập trung vào một thiết kế hợp lý và mô-đun. Đối với điều này, các đèn chiếu sáng được bố trí hài hòa và thân đèn được làm bằng nhôm đúc là tâm điểm chú ý của Vương miện nhỏ. Các đèn được đặt trên một cột trung tâm và đ', 'chum1.jpg', 1, 'Thủy tinh', 1),
(2, 1, '2097-30', 4000000, 25, '280 120', 'Đen', 5, 'Ánh sáng xung quanh toàn diện theo mọi hướng Ánh sáng 2097-30 từ nhà sản xuất cao cấp của Ý Flos kết hợp vẻ ngoài quý phái của một chiếc đèn chùm với chủ nghĩa thực dụng hiện đại. Phần trung tâm của thân đèn mặt dây thanh lịch vượt thời gian này được làm bằng một ống thép liên tục. Nó chứa các đường dây điện. 30 bóng đèn được phân bổ hài hòa của Flos 2097-30 được cung cấp với các ổ cắm là một', 'chum2.jpg', 2, 'Thủy tinh', 1),
(3, 1, 'Dear Ingo', 6000000, 20, '250 100', 'Đen', 18, 'Original \"spider\" design\r\nIndividually adjustable diffusers\r\nSuitable for LED lamps.Những người tìm kiếm sự kết hợp thành công giữa thiết kế độc quyền và ánh sáng linh hoạt chắc chắn là lựa chọn đúng đắn khi mua Moooi Dear Ingo. Đèn treo Dear Ingo của nhà sản xuất nội thất và ánh sáng Hà Lan Moooi nổi bật với thiết kế giật gân gợi nhớ đến một con nhện khổng lồ. Moooi Dear Ingo được đặc trưng bởi 16 cánh tay xoay với đầu đèn có thể điều chỉnh trông giống như đèn bàn thông thường được sắp xếp theo', 'chum3.jpg', 3, 'Thủy tinh', 1),
(4, 1, 'Luceplan Mesh ø80 cm', 20000000, 60, '100 130', 'Đen', 4, 'Lưới cá\r\nVới cấu trúc phức tạp của nó, ánh sáng mặt dây chuyền giống như lưới cá.Phân phối ánh sáng mềm\r\nCác đèn LED được bao phủ bởi các bộ khuếch tán polycarbonate phân phối ánh sáng nhẹ nhàng.', 'chum4.jpg', 4, 'Thủy tinh', 1),
(5, 1, 'Hanami Pendant', 15000000, 30, '200 90', 'Trang', 3, 'Nhìn cây anh đào mê hoặc\r\nÁnh sáng nhẹ nhàng, hài hòa\r\nĐược làm từ Lentiflex® được cấp bằng sáng chế', 'chum5.jpg', 5, 'Thủy tinh', 1),
(6, 1, 'Harrisont', 10000000, 17, '300 120', 'Đen', 5, 'Lấy cảm hứng từ phong cách gác xép của Tribeca ở New York\r\nỔ cắm tiếp xúc với đèn LED cho ánh sáng đa hướng\r\nSản xuất chất lượng cao từ thép và sứ.Đèn chùm Harrison là một sáng tạo của nhà thiết kế người Đan Mạch Søren Rose. Đèn treo là một phần của loạt Tribeca, có tên của khu phố nổi tiếng cùng tên ở New York. Khi thiết kế đèn chùm Harrison, Dane lấy cảm hứng từ sự quyến rũ của những năm 1930 quyến rũ của Tribeca. Anh ấy có một chuyến đi đến New York để tìm đồ đạc ánh sáng từ thời đó, mang the', 'chum6.jpg', 6, 'Thủy tinh', 1),
(7, 1, 'Zoom pendant', 14000000, 50, '400 140', 'Trắng', 6, 'Thiết kế sáng tạo với cấu trúc mắt cáo\r\nÁnh sáng rực rỡ nhờ đèn halogen điện áp thấp\r\nTùy chọn có sẵn với giá treo kính pha lê để tạo ra một cái nhìn đèn chùm.Serien Lighting Zoom.Đèn treo mặt dây Serien Lighting Zoom gây ấn tượng bởi khả năng biến đổi. Đèn treo này là một cấu trúc mạng được đóng lại để tạo thành một vòng tròn. Ở đây, đường kính của vòng tròn có thể được điều chỉnh liên tục trong khoảng từ 20 cm đến 1,30 m. Zoom được làm bằng thép không gỉ chải được phủ một vật liệu nhựa trong s', 'chum7.jpg', 8, 'Thủy tinh', 1),
(8, 1, 'Heracleum II Pendant', 15000000, 20, '200 120', 'Trắng', 7, 'Không có kết nối cáp làm xáo trộn ấn tượng thẩm mỹ\r\nCông nghệ LED tiết kiệm năng lượng\r\nThiết kế hữu cơ với hiệu ứng ánh sáng quyến rũ.Bằng cách giới thiệu đèn treo Heracleum II nhỏ, nhãn hiệu thiết kế Hà Lan Moooi cung cấp một nguồn sáng phi thường. Giống như cây cùng tên Heracleum, tên tiếng Latin của hogweed, mặt dây chuyền nhỏ Moooi Heracleum II nổi bật với vô số \"nhánh\" của nó. Ở cuối mỗi thương hiệu, một đèn LED được đặt trong một ống kính làm bằng polycarbonate. Nhờ cấu trúc giống như thự', 'chum8.jpg', 9, 'Thủy tinh', 1),
(9, 1, 'Crown Major', 2000000, 15, '150 110', 'Trắng', 7, 'Không có kết nối cáp làm xáo trộn ấn tượng thẩm mỹ\r\nCông nghệ LED tiết kiệm năng lượng\r\nThiết kế hữu cơ với hiệu ứng ánh sáng quyến rũ.Bằng cách giới thiệu đèn treo Heracleum II nhỏ, nhãn hiệu thiết kế Hà Lan Moooi cung cấp một nguồn sáng phi thường. Giống như cây cùng tên Heracleum, tên tiếng Latin của hogweed, mặt dây chuyền nhỏ Moooi Heracleum II nổi bật với vô số \"nhánh\" của nó. Ở cuối mỗi thương hiệu, một đèn LED được đặt trong một ống kính làm bằng polycarbonate. Nhờ cấu trúc giống như thự', 'chum9.jpg', 10, 'Thủy tinh', 1),
(10, 1, 'Mesh ø55 cm ', 15000000, 50, '200 127', 'Trắng', 8, 'Thiết kế sáng tạo\r\nĐèn phòng hài hòa\r\nĐèn LED làm mờ thông qua bộ điều chỉnh độ sáng hàng đầu.Lưới Luceplan ø55 cm tượng trưng cho thiết kế sáng tạo theo nghĩa chân thực nhất của từ này. Đèn chiếu sáng mặt dây chuyền, đã giành được giải thưởng Red Dot, gây bất ngờ với \"chao đèn\" gợi nhớ đến lưới đánh cá hơn là đèn điện. Điều này phù hợp với các mô-đun LED phân bố đồng đều nằm trong các nút của mạng - điều này không chỉ cung cấp một cảnh tượng hấp dẫn khi đèn bật, mà còn có hiệu ứng ánh sáng hài ', 'chum10.jpg', 11, 'Thủy tinh', 1),
(11, 1, 'Zoom Pendant', 13000000, 15, '150 120', 'Đen', 8, 'Bóng đèn mở rộng\r\nĐèn LED mạnh mẽ\r\nÁnh sáng xung quanh hài hòa.Đèn LED mặt dây Serien Lighting Zoom gợi nhớ đến một vương miện quý giá. Ánh sáng mặt dây có sức hấp dẫn lớn đối với một thủ thuật cơ học đơn giản: một cấu trúc mắt cáo làm bằng thép không gỉ chải với các dải nhựa mờ. Điều này cho phép bạn liên tục mở rộng bóng đèn. Qua đó, đèn LED Zoom có thể đạt đường kính lên tới 130 cm. Để duy trì chất lượng ánh sáng đặc trưng của phiên bản halogen của đèn treo Zoom, phiên bản LED đi kèm với các ', 'chum11.jpg', 1, 'Thủy tinh', 1),
(12, 1, 'La Lollo Pendant ', 16000000, 20, '250 124', 'Vàng', 9, 'Làm bằng vật liệu sáng chế sáng tạo\r\nĐèn phòng đồng phục\r\nHoạt động hiệu quả năng lượng LED.Với đèn LED mặt dây Slamp La Lollo L, Lorenza Bozzoli cung cấp cho kỷ nguyên quyến rũ của những năm 1950. Đèn treo bao gồm một số xi lanh được làm từ nhựa được cấp bằng sáng chế. Chúng được bố trí xung quanh một vòng đèn LED. Khi đèn mặt dây chuyền La Lollo L, tên của nó để tỏ lòng tôn kính với ngôi sao điện ảnh người Ý Gina Lollobrigida, được bật lên, ánh sáng được phản chiếu theo một cách không thể tưởn', 'chum12.jpg', 2, 'Thủy tinh', 1),
(13, 1, 'Franklin', 12000000, 45, '140 126', 'Đen', 6, 'Thiết kế công nghiệp thuần túy\r\nHiệu ứng ánh sáng hài hòa\r\nSản xuất chất lượng cao từ thép và sứ.', 'chum13.jpg', 3, 'Thủy tinh', 1),
(14, 1, 'Leonard', 11000000, 20, '160 123', 'Đen', 5, 'Lấy cảm hứng từ khu phố nổi tiếng Tribeca ở Manhattan\r\nỔ cắm không được che chắn cho phát xạ ánh sáng không bị cản trở\r\nSản xuất từ thép và sứ chất lượng cao.Đèn chùm Menu Leonard thu hút người xem với sự pha trộn tinh tế của chủ nghĩa thuần túy Scandinavia và thiết kế công nghiệp thô. Nhà thiết kế người Đan Mạch Søren Rose đã tìm thấy nguồn cảm hứng của mình khi đến Mỹ để tìm kiếm những ý tưởng mới. Ông đã tìm thấy ở Tribeca, một khu phố ở Manhattan nổi tiếng với kiến trúc bắt nguồn từ nơi là m', 'chum14.jpg', 4, 'Thủy tinh', 1),
(15, 1, 'Athene A-3DL', 14000000, 100, '300 120', 'Đen', 7, 'Trục flex điều chỉnh riêng\r\nGóc chùm có thể điều chỉnh\r\nHoạt động kinh tế LED.Các giải thưởng như Giải thưởng Thiết kế của Cộng hòa Liên bang Đức hoặc Giải thưởng Red Dot đã nói lên điều đó: đèn LED trần / đèn tường Athene A-3DL không chỉ trông thú vị, mà còn cung cấp chức năng tinh vi. Giống như các đường gân của cây leo, ba cánh tay uốn cong làm bằng nhôm chải (có sẵn với vỏ dệt màu khác nhau) rủ xuống. Ngoài ra, đèn trần / đèn tường Athene A-3DL tự hào có đầu đèn với bề mặt có gân đặc biệt.', 'chum15.jpg', 5, 'Thủy tinh', 1),
(16, 1, 'Chambers 76', 12000000, 130, '250 150', 'Đen', 3, 'Hiển thị màu sắc rực rỡ Ra = 100\r\nVới 240 lumens, nó đạt được 34% độ sáng của đèn sợi đốt 60W\r\nÁnh sáng ấm áp, trắng ấm', 'chum16.jpg', 6, 'Thủy tinh', 1),
(17, 2, 'Tube Light', 5000000, 200, '100 100', 'Trắng', 2, 'Thiết kế sang trọng\r\nVật liệu chất lượng cao.Thiết kế\r\nNhãn hiệu ClassiCon của Đức chuyên phục hồi các tác phẩm kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Gray và một phiên bản tái bản được ủy quyền bởi người giữ bản quyền London Aram Design Ltd., ClassiCon Tube Light là một chiếc xấp xỉ. Đèn sàn cao 1 m bao gồm một ống thép mạ crôm có ổ cắm bằng nhựa màu đe', 'ong1.jpg', 7, 'Thủy tinh', 1),
(18, 2, 'Tube Pendant light', 3000000, 101, '100 90', 'Đen', 2, 'Thiết kế\r\nNhãn hiệu ClassiCon của Đức chuyên phục hồi các tác phẩm kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Gray và một phiên bản tái bản được ủy quyền bởi người giữ bản quyền London Aram Design Ltd., ClassiCon Tube Light là một chiếc xấp xỉ. Đèn sàn cao 1 m bao gồm một ống thép mạ crôm có ổ cắm bằng nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở ', 'ong2.jpg', 8, 'Thủy tinh', 1),
(19, 2, 'Top Light Tube mini ', 3000000, 89, '110 95', 'Trắng', 3, 'Nhãn hiệu hàng đầu của Đức chuyên phục hồi kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Gray và một phiên bản tái bản được ủy quyền bởi người giữ bản quyền London Aram Design Ltd., Top Tube Light mini là một chiếc. Đèn sàn cao 1 m bao gồm một ống thép mạ crôm có ổ cắm bằng nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim loại cũng', 'ong3.jpg', 9, 'Thủy tinh', 1),
(20, 2, 'Gubi Turbo Pendant', 3000000, 102, '140 100', 'Trắng', 5, 'The German label Gugi specialised in reviving timeless design classics. Among those rediscovered gems is the elegant Tube Light floor lamp, designed in 1927 by the Irish designer Eileen Gray and an authorised re-edition by the London licence holder Aram Designs Ltd. The Gugi  Turbo Pendant light   is an approx. 1 m tall floor lamp that consists of a chromed steel pipe with a black plastic socket on each end to hold the illuminant. The flat floor base made of metal is chromed, as well. Under the ', 'ong4.jpg', 10, 'Thủy tinh', 1),
(21, 2, '3 Pendant ', 10000000, 29, '300 120', 'Trắng', 3, 'Nhãn hiệu NeMo của Đức chuyên phục hồi các tác phẩm kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Grey và một phiên bản tái bản được ủy quyền bởi người giữ bản quyền London Aram Design Ltd. Đèn 3 ống là một. Đèn sàn cao 1 m bao gồm một ống thép mạ crôm có ổ cắm bằng nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim loại cũng được mạ', 'ong5.jpg', 11, 'Thủy tinh', 1),
(22, 2, 'Tube 360° - 700 Wall Light Flap', 10000000, 49, '270 130', 'Đen', 4, 'Nhãn hiệu DCW của Đức chuyên phục hồi các tác phẩm kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Gray và một phiên bản tái bản được ủy quyền bởi người giữ bản quyền London Aram Design Ltd. Tube 360 ° - 700 Wall Light Flap. Đèn sàn cao 1 m bao gồm một ống thép mạ crôm có ổ cắm bằng nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim lo', 'ong6.jpg', 1, 'Thủy tinh', 1),
(23, 2, 'Tube Pendant', 13000000, 50, '400 50', 'Trắng', 5, 'Nhãn hiệu Mooi của Đức chuyên phục hồi kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Gray và một phiên bản tái bản được ủy quyền bởi chủ sở hữu giấy phép London Aram Design Ltd. Đèn sàn cao 1 m bao gồm một ống thép mạ crôm có ổ cắm bằng nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim loại cũng được mạ crôm. Dưới chân đế, Tube Ligh', 'ong7.jpg', 2, 'Thủy tinh', 1),
(24, 2, '1 Wall Light', 1340000, 301, '430 90', 'Trắng', 4, 'Nhãn hiệu NeMo của Đức chuyên phục hồi các tác phẩm kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Grey và được tái bản ủy quyền bởi người giữ bản quyền London Aram Design Ltd. 1 Đèn sàn cao 1 m bao gồm một loại thép mạ crôm ống có một ổ cắm nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim loại cũng được mạ crôm. Dưới chân đế, Tube ', 'ong8.jpg', 3, 'Thủy tinh', 1),
(25, 2, 'Dokka Pendant', 1510000, 201, '210 110', 'Trắng', 5, 'The German label Northern specialised in reviving timeless design classics. Among those rediscovered gems is the elegant Tube Light floor lamp, designed in 1927 by the Irish designer Eileen Gray and an authorised re-edition by the London licence holder Aram Designs Ltd. Dokka Pendant 1 m tall floor lamp that consists of a chromed steel pipe with a black plastic socket on each end to hold the illuminant. The flat floor base made of metal is chromed, as well. Under the base, the Tube Light is fitt', 'ong9.jpg', 4, 'Thủy tinh', 1),
(26, 2, 'Puk Turn Up- & Downlight', 15100000, 231, '340 90', 'Đen', 6, 'Nhãn hiệu Top Light của Đức chuyên phục hồi các tác phẩm kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Gray và một phiên bản tái bản được ủy quyền bởi chủ sở hữu giấy phép London Aram Design Ltd. Puk Turn Up- & Downlight Đèn sàn cao 1 m bao gồm một ống thép mạ crôm với một ổ cắm nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim loại', 'ong10.jpg', 5, 'Thủy tinh', 1),
(27, 2, 'PH 5 Pendant Light', 1501000, 59, '270 98', 'Trắng', 4, 'Nhãn hiệu Louis Poulsen của Đức chuyên phục hồi các tác phẩm kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Grey và được tái bản ủy quyền bởi người giữ giấy phép ở Luân Đôn Aram Design Ltd. ống thép với một ổ cắm nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim loại cũng được mạ crôm. Dưới chân đế, Tube Light được trang bị một tàu l', 'ong11.jpg', 6, 'Thủy tinh', 1),
(28, 2, 'Light-Air Wall Light', 1611000, 68, '370 100', 'Trắng', 5, 'Nhãn hiệu Kartell của Đức chuyên phục hồi các tác phẩm kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Gray và một phiên bản tái ủy quyền của chủ sở hữu giấy phép London Aram Design Ltd. Đèn sàn cao 1 m ống thép mạ crôm với một ổ cắm nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim loại cũng được mạ crôm. Dưới chân đế, Tube Light đượ', 'ong12.jpg', 7, 'Thủy tinh', 1),
(29, 2, 'Octo 4241 Pendant Light', 2310000, 240, '430 99', 'Vàng', 6, 'Nhãn hiệu Secto Design của Đức chuyên phục hồi các tác phẩm kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Grey và được tái bản ủy quyền bởi chủ sở hữu giấy phép Luân Đôn Aram Design Ltd. Đèn chiếu sáng Octo 4241 Đèn sàn cao 1 m bao gồm một lớp mạ crôm ống thép với một ổ cắm nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim loại cũng', 'ong13.jpg', 8, 'Thủy tinh', 1),
(30, 2, 'Cone Light Wall Light', 1510000, 259, '370 109', 'Trắng', 3, 'Nhãn hiệu B.lux của Đức chuyên phục hồi các tác phẩm kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Grey và được tái bản ủy quyền bởi người giữ bản quyền ở Luân Đôn Aram Design Ltd. ống thép với một ổ cắm nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim loại cũng được mạ crôm. Dưới chân đế, Tube Light được trang bị một tàu lượn nỉ. ', 'ong14.jpg', 9, 'Thủy tinh', 1),
(31, 2, 'LED Top Light Puk Maxx Turn Up- & Downlight', 1450000, 240, '400 120', 'Trắng', 5, 'Thiết kế riêng\r\nPhát xạ ánh sáng kép linh hoạt\r\nĐèn LED tiết kiệm, thân thiện với môi trường.Với đèn LED Top Light Puk Maxx Turn Up- & Downlight, nhà thiết kế người Đức Rolf Ziel rất chú trọng đến cá tính. Điều này đã thể hiện trong nhiều loại vỏ khác nhau cho bạn lựa chọn. Đèn trần bán phẳng có sẵn trong các bề mặt khác nhau, chẳng hạn như chrome hoặc đánh bóng chrome. Tuy nhiên, khả năng cấu hình của đèn LED Puk Maxx Turn Up- & Downlight không dừng lại ở đó. Có nhiều phụ kiện bổ sung, chẳng hạ', 'ong15.jpg', 10, 'Thủy tinh', 1),
(32, 2, 'Tuar Bollard Light 77cm Hue White', 1400000, 300, '410 110', 'Đen', 6, 'Với Philips Hue Tuar Bollard Light 77cm Hue White, nhà thiết kế người Đức Rolf Ziel rất chú trọng đến cá tính. Điều này đã thể hiện trong nhiều loại vỏ khác nhau cho bạn lựa chọn. Đèn trần bán phẳng có sẵn trong các bề mặt khác nhau, chẳng hạn như chrome hoặc đánh bóng chrome. Tuy nhiên, cấu hình của Philips Hue Tuar Bollard Light 77cm Hue White không dừng lại ở đó. Có nhiều phụ kiện bổ sung, chẳng hạn như bộ khuếch tán, gương phản xạ, thấu kính và bộ lọc màu, ảnh hưởng trực tiếp đến hiệu ứng án', 'ong16.jpg', 11, 'Thủy tinh', 1),
(33, 3, 'Bulb Fiction', 13200000, 150, '320 105', 'Trắng', 1, 'Nhãn hiệu Fritz Hansen của Đức chuyên phục hồi các tác phẩm kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Grey và được tái bản ủy quyền bởi người giữ bản quyền London Aram Design Ltd. Bóng đèn sàn cao 1 m bao gồm một ống thép mạ crôm với một ổ cắm nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim loại cũng được mạ crôm. Dưới chân đế', 'tron1.jpg', 1, 'Thủy tinh', 1),
(34, 3, 'Bulb', 20000000, 321, '340 105', 'Đen ', 1, 'Nhãn hiệu Bóng đèn Đức chuyên phục hồi kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Grey và được tái bản ủy quyền bởi người giữ bản quyền London Aram Design Ltd. Đèn sàn cao 1 m Ingo Maurer bao gồm một ống thép mạ crôm với một ổ cắm nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim loại cũng được mạ crôm. Dưới chân đế, Tube Light đ', 'tron2.jpg', 1, 'Thủy tinh', 1),
(35, 3, '2097-18 incl', 24000000, 149, '259 80', 'Đen', 3, 'Nhãn hiệu Flos của Đức chuyên phục hồi kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Gray và một phiên bản tái bản được ủy quyền bởi người giữ bản quyền London Aram Design Ltd. 2097-18 bao gồm đèn sàn cao 1 m bao gồm một lớp mạ crôm ống thép với một ổ cắm nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim loại cũng được mạ crôm. Dưới', 'tron3.jpg', 2, 'Thủy tinh', 1),
(36, 3, 'Bulb SR1 Pendant Light', 12000000, 79, '340 80', 'Trắng trong', 1, 'Nhãn hiệu & truyền thống của Đức chuyên phục hồi kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Grey và được tái bản ủy quyền bởi người giữ bản quyền ở Luân Đôn Aram Design Ltd. ống thép với một ổ cắm nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim loại cũng được mạ crôm. Dưới chân đế, Tube Light được trang bị một tàu lượn nỉ. Nhờ ', 'tron4.jpg', 3, 'Thủy tinh', 1),
(37, 3, 'TR Bulb Table Lamp', 13200000, 45, '100 90', 'Trắng', 1, 'Nhãn hiệu & truyền thống của Đức chuyên phục hồi kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Grey và được tái bản ủy quyền bởi người giữ bản quyền London Aram Design Ltd. TR Bóng đèn sàn cao l1 mamp bao gồm thép mạ crôm ống có một ổ cắm nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim loại cũng được mạ crôm. Dưới chân đế, Tube Li', 'tron5.jpg', 4, 'Thủy tinh', 1),
(38, 3, 'Lichtstange Wall Bracket', 11000000, 35, '100 90', 'Trắng', 2, 'Giá treo tường nhỏ gọn để lắp đặt tiết kiệm không gian\r\nThay đổi đèn dễ dàng\r\nPhát xạ ánh sáng không bị cản trở theo mọi hướng.Chính thức giảm đến mức tối đa, Top Light Lichtstange với giá treo tường chỉ bao gồm một chân đế dài 9 cm được làm bằng nhôm chất lượng cao giữ đèn chiếu sáng. Cơ sở có sẵn với nhiều lớp hoàn thiện bề mặt khác nhau, chẳng hạn như niken mờ, nhôm mờ và chrome sáng bóng.', 'tron6.jpg', 5, 'Thủy tinh', 1),
(39, 3, 'TR Bulb Pendant', 13200000, 56, '140 100', 'Trắng', 1, 'Chính thức giảm đến mức tối đa, Top Light Lichtstange với giá treo tường chỉ bao gồm một chân đế dài 9 cm được làm bằng nhôm chất lượng cao giữ đèn chiếu sáng. Cơ sở có sẵn với nhiều lớp hoàn thiện bề mặt khác nhau, chẳng hạn như niken mờ, nhôm mờ và chrome sáng bóng.', 'tron7.jpg', 6, 'Thủy tinh', 1),
(40, 3, 'Mega Bulb SR2 Pendant Light', 12210000, 36, '200 120', 'Trong suốt', 1, 'Mega Bulb SR2 Pendant Light', 'tron8.jpg', 7, 'Thủy tinh', 1),
(41, 3, 'Bulo Table', 10000000, 76, '200 100', 'Đen sọc', 2, 'Thiết kế tinh xảo, không phô trương và trang nhã pha trộn với môi trường của nó\r\nĐiều chỉnh ánh sáng vùng nhờ vào chân đế\r\nĐèn LED hiệu quả với ánh sáng trắng ấm\r\nĐèn bàn Tecnolumen Bulo là một màu sắc bắt mắt với hình học vượt thời gian. Đầu đèn hình cầu của nó được làm bằng nhôm và thủy tinh. Hình dạng thông thường của đèn bàn bị phá vỡ bởi năm đĩa đồng tâm được bố trí xung quanh bộ khuếch tán hoàn thiện satin trung tâm. Để nhấn mạnh hiệu ứng ba chiều, bên trong các đoạn nhôm được cung cấp một', 'tron9.jpg', 8, 'Thủy tinh', 1),
(42, 3, 'Bulo Pendant', 7000000, 100, '180 107', 'Đen sọc', 1, 'Thiết kế tinh xảo, không phô trương và trang nhã pha trộn với môi trường của nó\r\nĐiều chỉnh ánh sáng vùng nhờ vào chân đế\r\nĐèn LED hiệu quả với ánh sáng trắng ấm\r\nĐèn bàn Tecnolumen Bulo là một màu sắc bắt mắt với hình học vượt thời gian. Đầu đèn hình cầu của nó được làm bằng nhôm và thủy tinh. Hình dạng thông thường của đèn bàn bị phá vỡ bởi năm đĩa đồng tâm được bố trí xung quanh bộ khuếch tán hoàn thiện satin trung tâm. Để nhấn mạnh hiệu ứng ba chiều, bên trong các đoạn nhôm được cung cấp một', 'tron10.jpg', 9, 'Thủy tinh', 1),
(43, 3, 'TR Bulb', 1000000, 53, '200 129', 'Trắng', 2, 'Kết xuất màu tốt Ra = 80\r\nVới 525 lumens, nó đạt được 74% độ sáng của đèn sợi đốt 60W\r\nÁnh sáng ấm áp, trắng ấm\r\nTuổi thọ rất dài lên tới 30.000 giờ', 'tron11.jpg', 10, 'Thủy tinh', 1),
(44, 3, 'Nelson Cigar Bubble Pendant Light', 14000000, 67, '210 123', 'Trắng', 3, 'Kết xuất màu tốt Ra = 80\r\nVới 525 lumens, nó đạt được 74% độ sáng của đèn sợi đốt 80W\r\nÁnh sáng ấm áp, trắng ấm\r\nTuổi thọ rất dài lên tới 30.000 giờ', 'tron12.jpg', 11, 'Thủy tinh', 1),
(45, 3, 'Nelson Saucer Crisscross Bubble Pendant Light', 9000000, 50, '350 141', 'Trắng', 3, 'Kết xuất màu tốt Ra = 80\r\nVới 525 lumens, nó đạt được 74% độ sáng của đèn sợi đốt 80W\r\nÁnh sáng ấm áp, trắng ấm\r\nTuổi thọ rất dài lên tới 30.000 giờ', 'tron13.jpg', 1, 'Thủy tinh', 1),
(46, 3, 'TR Bulb Wall', 1200000, 201, '210 123', 'Trắng', 1, 'Nhãn hiệu & truyền thống của Đức chuyên phục hồi kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Grey và được tái bản ủy quyền bởi người giữ bản quyền London Aram Design Ltd. TR Bóng đèn sàn cao l1 mamp bao gồm thép mạ crôm ống có một ổ cắm nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim loại cũng được mạ crôm. Dưới chân đế, Tube Li', 'tron14.jpg', 2, 'Thủy tinh', 1),
(47, 3, 'I Ricchi Poveri - Monument', 10000000, 180, '310 120', 'Đen', 2, 'Nhãn hiệu & truyền thống của Đức chuyên phục hồi kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Grey và được tái bản ủy quyền bởi người giữ bản quyền London Aram Design Ltd. TR Bóng đèn sàn cao l1 mamp bao gồm thép mạ crôm ống có một ổ cắm nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim loại cũng được mạ crôm. Dưới chân đế, Tube Li', 'tron15.jpg', 3, 'Thủy tinh', 1),
(48, 3, 'TR Bulb Pendant Light với 4 đèn', 14000000, 75, '260 102', 'Trắng', 2, 'Nhãn hiệu & truyền thống của Đức chuyên phục hồi kinh điển thiết kế vượt thời gian. Trong số những viên đá quý được tái phát hiện đó là đèn sàn Tube Light thanh lịch, được thiết kế vào năm 1927 bởi nhà thiết kế người Ireland Eileen Grey và được tái bản ủy quyền bởi người giữ bản quyền London Aram Design Ltd. một ống thép mạ crôm với một ổ cắm nhựa màu đen ở mỗi đầu để giữ đèn chiếu sáng. Các cơ sở sàn phẳng làm bằng kim loại cũng được mạ crôm. Dưới chân đế, Tube Light được trang bị một tàu lượn ', 'tron16.jpg', 4, 'Thủy tinh', 1),
(49, 4, 'Wittenberg 4.0', 7000000, 98, '300 122', 'Trắng', 3, 'Direct downward light\r\nModern LED operation\r\nSleek, unobtrusive design.Đèn LED downlight trần Mawa Wittenberg 4.0 thể hiện chính nó trong một thiết kế nhỏ gọn và đồ sộ. Đèn trần thanh mảnh với đường kính chỉ 7,6 cm chỉ tập trung vào thứ thiết yếu: thân hình trụ và mô-đun LED nhúng - không có đường nối đáng lo ngại, không có ốc vít có thể nhìn thấy. Do đó, đèn LED downlight đèn trần Wittenberg 4.0 pha trộn không phô trương với nội thất. Đèn trần được sản xuất từ nhôm sơn tĩnh điện cao cấp. Thiết ', 'tran1.jpg', 5, 'Thủy tinh', 1),
(50, 4, 'Discocó 68', 2000000, 35, '310 111', 'Vàng', 2, 'Hình dạng nổi bật\r\nHiệu ứng ánh sáng mê hoặc\r\nÁnh sáng xung quanh không chói.\r\nBarshe Mathieu, người tạo ra đèn trần Marset Discocó 68 dựa trên thiết kế của ông dựa trên các nghiên cứu được công bố bởi nhà thiết kế nổi tiếng người Đan Mạch Poul Henningsen. Giống như các sáng tạo của Dane, đèn trần này được đặc trưng bởi một cấu trúc tinh vi: bóng của Discocó 68 bao gồm 21 đĩa đóng vai trò là gương phản xạ. Chúng có thể được gắn dễ dàng - không cần dụng cụ - vào tán cây mạ crôm. Họ tự sắp xếp xun', 'tran2.jpg', 6, 'Thủy tinh', 1),
(51, 4, 'Ceiling track - 2', 1400000, 70, '270 90', 'Đen', 1, 'Hình dạng nổi bật\r\nHiệu ứng ánh sáng mê hoặc\r\nÁnh sáng xung quanh không chói.\r\nBarshe Mathieu, người tạo ra đèn trần Marset Discocó 68 dựa trên thiết kế của ông dựa trên các nghiên cứu được công bố bởi nhà thiết kế nổi tiếng người Đan Mạch Poul Henningsen. Giống như các sáng tạo của Dane, đèn trần này được đặc trưng bởi một cấu trúc tinh vi: bóng của Discocó 68 bao gồm 21 đĩa đóng vai trò là gương phản xạ. Chúng có thể được gắn dễ dàng - không cần dụng cụ - vào tán cây mạ crôm. Họ tự sắp xếp xun', 'tran3.jpg', 7, 'Thủy tinh', 1),
(52, 4, 'Lampe Gras No 302', 1400000, 221, '170 100', 'Đen', 3, 'Kiểu dáng công nghiệp Pháp từ những năm 1920\r\nÁnh sáng vùng định hướng nhu cầu nhờ cánh tay nối linh hoạt\r\nBóng có sẵn trong nhiều màu sắc khác nhau.\r\nVới vẻ ngoài công nghiệp, đèn trần DCW Lampe Gras No 302 lan tỏa một nét quyến rũ retro đặc biệt. Đèn trần được Bernard-Albin Gras nghĩ ra vào năm 1921 và được đặc trưng bởi tính linh hoạt phi thường và tay nghề chất lượng cao. Vào thời điểm đó, Le Corbusier đã rất ấn tượng bởi ánh sáng trần mà anh ta đã lắp đặt tại cửa hàng của mình. Ngày nay, La', 'tran4.jpg', 8, 'Thủy tinh', 1),
(53, 4, 'Or 2', 13000000, 87, '300 90', 'Vàng', 3, 'Nguyên tắc cơ bản của chủ nghĩa tối giản là „ít hơn nhiều hơn và đèn trần Mawa Or 2 là trường hợp và quan điểm của nguyên tắc nói trên. Đèn trần Mawa Or 2 đã được giảm một cách thanh lịch đến mức cần thiết của cuộc sống sáng chói. Tuy nhiên, các nhà thiết kế\r\nNguyên tắc cơ bản của chủ nghĩa tối giản là „ít hơn nhiều hơn và đèn trần Mawa Or 2 là trường hợp và quan điểm của nguyên tắc nói trên. Đèn trần Mawa Or 2 đã được giảm một cách thanh lịch đến mức cần thiết của cuộc sống sáng chói. Tuy nhiên', 'tran5.jpg', 9, 'Thủy tinh', 1),
(54, 4, 'Euclid', 12000000, 270, '310 102', 'Trắng', 2, 'Thiết kế phẳng với độ dày chỉ 2 cm\r\nHệ thống thấu kính hiện đại\r\nMô-đun LED thân thiện với môi trường.\r\nĐèn LED trần Euclid Min của Bruck là đèn trần đặc biệt phẳng. Với độ dày chỉ 2 cm, nó thực tế hợp nhất với trần nhà. Cũng liên quan đến hình dạng của nó, đèn LED trần Euclid Min cho thấy sự hạn chế, là một đĩa tròn đơn giản với bề mặt kín đáo trong chrome hoặc đánh bóng chrome hoặc trắng. Đèn LED trần Bruck Euclid Min được sản xuất từ nhôm và kim loại chất lượng cao, với lỗ mở được phủ bằng hệ', 'tran6.jpg', 10, 'Thủy tinh', 1),
(55, 4, 'Stem', 17000000, 155, '260 105', 'Trắng', 2, 'Thiết kế phẳng với độ dày chỉ 2 cm\r\nHệ thống thấu kính hiện đại\r\nMô-đun LED thân thiện với môi trường.\r\nĐèn LED trần Euclid Min của Bruck là đèn trần đặc biệt phẳng. Với độ dày chỉ 2 cm, nó thực tế hợp nhất với trần nhà. Cũng liên quan đến hình dạng của nó, đèn LED trần Euclid Min cho thấy sự hạn chế, là một đĩa tròn đơn giản với bề mặt kín đáo trong chrome hoặc đánh bóng chrome hoặc trắng. Đèn LED trần Bruck Euclid Min được sản xuất từ nhôm và kim loại chất lượng cao, với lỗ mở được phủ bằng hệ', 'tran7.jpg', 1, 'Thủy tinh', 1),
(56, 4, 'Mercer', 2300000, 77, '280 105', 'Vàng', 3, 'Bóng thủy tinh thổi bằng tay với một dải ruy băng bông mịn dùng làm bộ khuếch tán\r\nNgôn ngữ thiết kế duyên dáng đầy sang trọng kín đáo\r\nÁnh sáng xung quanh sáng phát ra theo mọi hướng.\r\nThiết kế\r\nĐèn trần Marset Mercer gây ấn tượng bởi thiết kế đặc biệt của nó: không giống như những gì chúng ta biết từ các đèn khác, bóng râm không đại diện cho giới hạn bên ngoài mà nó nằm bên trong bộ khuếch tán thủy tinh. Với đường kính 44 cm, đèn trần này lớn hơn đèn trung bình và thể hiện như một vật bắt mắt ', 'tran8.jpg', 2, 'Thủy tinh', 1),
(57, 4, '89576.1/89576.2', 12000000, 59, '320 100', 'Vàng', 5, 'Hình dạng nổi bật\r\nHiệu ứng ánh sáng mê hoặc\r\nÁnh sáng xung quanh không chói.\r\nBarshe Mathieu, người tạo ra 89576.1 / 89576.2 - Đèn trần dựa trên thiết kế của ông dựa trên các nghiên cứu được công bố bởi nhà thiết kế nổi tiếng người Đan Mạch Poul Henningsen. Giống như các sáng tạo của Dane, đèn trần này được đặc trưng bởi một cấu trúc tinh vi: bóng của Discocó 68 bao gồm 21 đĩa đóng vai trò là gương phản xạ. Chúng có thể được gắn dễ dàng - không cần dụng cụ - vào tán cây mạ crôm. Họ tự sắp xếp x', 'tran9.jpg', 11, 'Thủy tinh', 1),
(58, 4, 'Annex S', 23000000, 895, '350 90', 'Trắng', 3, 'Thiết kế vượt thời gian sản xuất tại Đức\r\nCác phiên bản có phát xạ ánh sáng riêng biệt cho ánh sáng xung quanh quyến rũ\r\nThay thế đèn chiếu sáng mà không sử dụng công cụ.\r\nThiết kế cổ điển của đèn trần Serien Lighting Phụ lục S làm cho nó trở nên bắt mắt thực sự, làm phong phú mọi môi trường xung quanh với sự hiện diện đơn thuần của nó. Hơn nữa, nó được cung cấp một bóng râm hình nón, bằng tay, có thể là opal hoặc trong suốt, như mong muốn. Ngoài ra, phiên bản trong suốt cung cấp ba tùy chọn tuy', 'tran10.jpg', 3, 'Thủy tinh', 1),
(59, 4, 'Kushi 33', 2000000, 152, '200 100', 'Đen', 4, 'Thiết kế vượt thời gian sản xuất tại Đức\r\nCác phiên bản có phát xạ ánh sáng riêng biệt cho ánh sáng xung quanh quyến rũ\r\nThay thế đèn chiếu sáng mà không sử dụng công cụ.\r\nThiết kế cổ điển của đèn trần Serien Lighting Phụ lục S làm cho nó trở nên bắt mắt thực sự, làm phong phú mọi môi trường xung quanh với sự hiện diện đơn thuần của nó. Hơn nữa, nó được cung cấp một bóng râm hình nón, bằng tay, có thể là opal hoặc trong suốt, như mong muốn. Ngoài ra, phiên bản trong suốt cung cấp ba tùy chọn tuy', 'tran11.jpg', 4, 'Thủy tinh', 1),
(60, 4, 'Étoile', 12012000, 157, '170 100', 'Trắng trong', 3, 'Thiết kế biểu cảm\r\nBộ khuếch tán làm bằng vật liệu sáng tạo\r\nPhản xạ ánh sáng hấp dẫn.\r\nNhờ vẻ ngoài phi thường của nó, đèn LED trần Slamp Etoile gợi lên sự liên tưởng với những ngôi sao lấp lánh trên bầu trời đêm. Do đó, sự sáng tạo của Adriano Rachele có một sức mạnh biểu cảm gần như thơ mộng. Bộ khuếch tán xa hoa được làm bằng vật liệu nhựa chất lượng cao, được cấp bằng sáng chế Lentiflex®, một sự kết hợp của các polyme và tinh thể thủy tinh. Hiệu ứng lung linh của nó khiến chúng ta nhớ đến t', 'tran12.jpg', 5, 'Thủy tinh', 1),
(61, 4, 'Canio', 1000000, 352, '270 90', 'Trắng', 3, 'Thiết kế biểu cảm\r\nBộ khuếch tán làm bằng vật liệu sáng tạo\r\nPhản xạ ánh sáng hấp dẫn.\r\nNhờ vẻ ngoài phi thường của nó, Ánh sáng trần Canio khơi dậy sự liên kết với những ngôi sao lấp lánh trên bầu trời đêm. Do đó, sự sáng tạo của Adriano Rachele có một sức mạnh biểu cảm gần như thơ mộng. Bộ khuếch tán xa hoa được làm bằng vật liệu nhựa chất lượng cao, được cấp bằng sáng chế Lentiflex®, một sự kết hợp của các polyme và tinh thể thủy tinh. Hiệu ứng lung linh của nó khiến chúng ta nhớ đến trò chơi', 'tran13.jpg', 6, 'Thủy tinh', 1),
(62, 4, 'Cubetto', 1500000, 166, '260 90', 'Trắng', 4, 'Máy khuếch tán làm từ thủy tinh pha lê chính hãng\r\nĐiểm nhấn với thiết kế trang nhã\r\nThích hợp cho đèn GU10.\r\nXưởng thiết kế người Ý, Pamio Design đã phát triển gia đình Cubetto cho Fabbian, một công ty có trụ sở ở phía đông bắc nước Ý. Đèn trần Fab10 Cubetto GU10 được đặc trưng bởi thân hình vuông được làm bằng thủy tinh pha lê chính hãng, được phun cát ở bên trong. Bằng cách này, hình dạng của đèn chiếu sáng được phản ánh kín đáo trong hình bóng của đèn trần. Vẻ ngoài thanh lịch này làm cho đè', 'tran14.jpg', 7, 'Thủy tinh', 1),
(63, 4, 'Funnel', 1777700, 77, '270 102', 'Trắng', 3, 'The Vibia Funnel Ceiling Light LED has no corners and edges. Instead, the body of the ceiling light reminds us of a water drop that solidified before hitting the ground. The Funnel Ceiling Light LED is offered with two different surface decors: in white lacquered aluminium and gold hammered aluminium. The latter not only adds a touch of extravagance to any interior design context but also supplies a particularly pleasant light. The white version of this ceiling light from Vibia, however, adapts ', 'tran15.jpg', 8, 'Thủy tinh', 1),
(64, 4, 'Drusa Wall', 14000000, 89, '310 100', 'Trắng', 5, 'Thiết kế tự nhiên\r\nÁnh sáng xung quanh hài hòa\r\nSản xuất từ ​​glas thổi tay\r\nNhờ thiết kế bề mặt được lấy cảm hứng từ bánh tráng Nhật Bản, Foscarini Rituals Soffitto là một thiết bị bắt mắt thực sự tràn ngập phòng khách với ánh sáng trắng ấm áp, dễ chịu. Bóng của Rituals Soffitto của Foscarini được sản xuất theo quy trình phức tạp trong các xưởng sản xuất máy thổi thủy tinh trên đảo Murano. Ở đây, bề mặt hữu cơ của ánh sáng trần được tạo ra trong một quy trình bao gồm các bước đúc khác nhau và t', 'tran16.jpg', 9, 'Thủy tinh', 1),
(65, 5, 'Lantern LED', 1200000, 34, '50 90', 'Trong suốt', 1, 'Đèn lồng LED toát lên vẻ hoài cổ quyến rũ. Chiếc đèn bàn của Lyndon Neri và Rossana Hu gợi nhớ một cách đáng kinh ngạc về một chiếc đèn lồng cổ điển. Để duy trì hiệu ứng retro, Lantern Light sử dụng một đèn LED đặc biệt có hình dạng gợi nhớ đến một ngọn nến - trước đây thường là nguồn sáng ưa thích trong đèn lồng. Bộ khuếch tán làm bằng thủy tinh pha lê và khung làm bằng đồng chất lượng cao hoàn thiện vẻ ngoài của đèn lồng LED\r\n\r\nĐiều này làm ấm trái tim của người quan sát không chỉ với vẻ ngoài', 'long1.jpg', 10, 'Thủy tinh', 1),
(66, 5, 'Endura Wall', 1300000, 67, '54 100', 'Trăng', 1, 'Đèn lồng tường Endura toát lên vẻ hoài cổ quyến rũ. Chiếc đèn bàn của Lyndon Neri và Rossana Hu gợi nhớ một cách đáng kinh ngạc về một chiếc đèn lồng cổ điển. Để duy trì hiệu ứng retro, Lantern Light sử dụng một đèn LED đặc biệt có hình dạng gợi nhớ đến một ngọn nến - trước đây thường là nguồn sáng ưa thích trong đèn lồng. Bộ khuếch tán làm bằng thủy tinh pha lê và khung làm bằng đồng chất lượng cao hoàn thiện vẻ ngoài của đèn lồng LED\r\n\r\nĐiều này làm ấm trái tim của người quan sát không chỉ với', 'long2.jpg', 11, 'Thủy tinh', 1),
(67, 5, 'LED Uma Sound', 1020000, 22, '67 90', 'Trắng', 1, 'Đèn LED Uma Sound toát lên vẻ hoài cổ quyến rũ. Chiếc đèn bàn của Lyndon Neri và Rossana Hu gợi nhớ một cách đáng kinh ngạc về một chiếc đèn lồng cổ điển. Để duy trì hiệu ứng retro, Lantern Light sử dụng một đèn LED đặc biệt có hình dạng gợi nhớ đến một ngọn nến - trước đây thường là nguồn sáng ưa thích trong đèn lồng. Bộ khuếch tán làm bằng thủy tinh pha lê và khung làm bằng đồng chất lượng cao hoàn thiện vẻ ngoài của đèn lồng LED\r\n\r\nĐiều này làm ấm trái tim của người quan sát không chỉ với vẻ ', 'long3.jpg', 1, 'Thủy tinh', 1),
(68, 5, 'Endura Classic', 1400000, 44, '78 90', 'Đen', 1, 'kết xuất màu tốt Ra = 80\r\nVới 810 lumens, nó đạt được 114% độ sáng của đèn sợi đốt 60W\r\nÁnh sáng ấm áp, trắng ấm.', 'long4.jpg', 2, 'Thủy tinh', 1),
(69, 5, 'Orbis', 1200000, 33, '59 100', 'Đen', 1, 'Khớp nối cánh tay và đầu\r\nThiết kế đồ sộ\r\nCông nghệ điện áp thấp cho ánh sáng tuyệt vời.\r\nĐèn bàn ClassiCon Orbis kết hợp thiết kế đồ nư với chức năng và chất lượng vật liệu vượt trội. Cổ điển hiện đại từ năm 1994, được thiết kế bởi Herbert H. Schultes, là một tuyệt phẩm của sự linh hoạt. Một số khớp cho phép đèn bàn của Orbis di chuyển theo các hướng khác nhau. Điều đáng chú ý là không có dây cáp làm xáo trộn tính thẩm mỹ tinh tế của đèn bàn này. Ngoài ra, đầu đèn có thể xoay hoặc nghiêng.\r\n\r\nV', 'long5.jpg', 3, 'Thủy tinh', 1),
(70, 5, 'LED ClassiCon Lantern Light', 1340000, 45, '70 90', 'Trắng', 1, 'Nhìn đèn lồng hấp dẫn\r\nVật liệu chất lượng cao, chẳng hạn như đồng thau và thủy tinh pha lê\r\nBao gồm cả điều chỉnh độ sáng\r\nĐèn bàn LED ClassiCon Lantern Light toát lên sự hoài cổ quyến rũ. Chiếc đèn bàn của Lyndon Neri và Rossana Hu gợi nhớ một cách đáng kinh ngạc về một chiếc đèn lồng cổ điển. Để duy trì hiệu ứng retro, Lantern Light sử dụng một đèn LED đặc biệt có hình dạng gợi nhớ đến một ngọn nến - trước đây thường là nguồn sáng ưa thích trong đèn lồng. Bộ khuếch tán làm bằng thủy tinh pha ', 'long6.jpg', 4, 'Thủy tinh', 1),
(71, 5, 'Lana', 1300000, 56, '68 102', 'Trắng', 1, 'Nhìn đèn lồng hấp dẫn\r\nVật liệu chất lượng cao, chẳng hạn như đồng thau và thủy tinh pha lê\r\nBao gồm cả điều chỉnh độ sáng\r\nPablo Design Uma Mini Sound Lantern LED toát lên sự hoài cổ quyến rũ. Chiếc đèn bàn của Lyndon Neri và Rossana Hu gợi nhớ một cách đáng kinh ngạc về một chiếc đèn lồng cổ điển. Để duy trì hiệu ứng retro, Lantern Light sử dụng một đèn LED đặc biệt có hình dạng gợi nhớ đến một ngọn nến - trước đây thường là nguồn sáng ưa thích trong đèn lồng. Bộ khuếch tán làm bằng thủy tinh ', 'long7.jpg', 5, 'Thủy tinh', 1),
(72, 5, 'Brazo', 1400000, 57, '71 100', 'Trong suốt', 1, 'Nhìn đèn lồng hấp dẫn\r\nVật liệu chất lượng cao, chẳng hạn như đồng thau và thủy tinh pha lê\r\nBao gồm cả điều chỉnh độ sáng\r\nThiết kế Pablo Đèn bàn Brazo toát lên sự hoài cổ quyến rũ. Chiếc đèn bàn của Lyndon Neri và Rossana Hu gợi nhớ một cách đáng kinh ngạc về một chiếc đèn lồng cổ điển. Để duy trì hiệu ứng retro, Lantern Light sử dụng một đèn LED đặc biệt có hình dạng gợi nhớ đến một ngọn nến - trước đây thường là nguồn sáng ưa thích trong đèn lồng. Bộ khuếch tán làm bằng thủy tinh pha lê và k', 'long8.jpg', 6, 'Thủy tinh', 1),
(73, 5, 'Lamella 3', 1650000, 86, '80 102', 'Trắng', 2, 'Nhìn đèn lồng hấp dẫn\r\nVật liệu chất lượng cao, chẳng hạn như đồng thau và thủy tinh pha lê\r\nBao gồm cả điều chỉnh độ sáng\r\nLamella 3 toát lên vẻ hoài cổ quyến rũ. Chiếc đèn bàn của Lyndon Neri và Rossana Hu gợi nhớ một cách đáng kinh ngạc về một chiếc đèn lồng cổ điển. Để duy trì hiệu ứng retro, Lantern Light sử dụng một đèn LED đặc biệt có hình dạng gợi nhớ đến một ngọn nến - trước đây thường là nguồn sáng ưa thích trong đèn lồng. Bộ khuếch tán làm bằng thủy tinh pha lê và khung làm bằng đồng ', 'long9.jpg', 7, 'Thủy tinh', 1),
(74, 5, 'Stern', 2400000, 80, '74 106', 'Trắng', 2, 'Vật liệu chất lượng cao, chẳng hạn như đồng thau và thủy tinh pha lê\r\nBao gồm cả điều chỉnh độ sáng\r\nLamella 3 toát lên vẻ hoài cổ quyến rũ. Chiếc đèn bàn của Lyndon Neri và Rossana Hu gợi nhớ một cách đáng kinh ngạc về một chiếc đèn lồng cổ điển. Để duy trì hiệu ứng retro, Lantern Light sử dụng một đèn LED đặc biệt có hình dạng gợi nhớ đến một ngọn nến - trước đây thường là nguồn sáng ưa thích trong đèn lồng. Bộ khuếch tán làm bằng thủy tinh pha lê và khung làm bằng đồng chất lượng cao hoàn thi', 'long10.jpg', 8, 'Thủy tinh', 1),
(75, 5, '172 Pendant ', 2410000, 22, '99 70', 'Trắng', 2, 'Nhìn đèn lồng hấp dẫn\r\nVật liệu chất lượng cao, chẳng hạn như đồng thau và thủy tinh pha lê\r\nBao gồm cả điều chỉnh độ sáng\r\nLamella 3 toát lên vẻ hoài cổ quyến rũ. Chiếc đèn bàn của Lyndon Neri và Rossana Hu gợi nhớ một cách đáng kinh ngạc về một chiếc đèn lồng cổ điển. Để duy trì hiệu ứng retro, Lantern Light sử dụng một đèn LED đặc biệt có hình dạng gợi nhớ đến một ngọn nến - trước đây thường là nguồn sáng ưa thích trong đèn lồng. Bộ khuếch tán làm bằng thủy tinh pha lê và khung làm bằng đồng ', 'long11.jpg', 9, 'Thủy tinh', 1),
(76, 5, 'Snowdrop Pendant', 2310000, 42, '75 40', 'Trắng', 3, 'Nhìn đèn lồng hấp dẫn\r\nVật liệu chất lượng cao, chẳng hạn như đồng thau và thủy tinh pha lê\r\nBao gồm cả điều chỉnh độ sáng\r\nMặt dây chuyền tuyết 3 ánh sáng toát lên vẻ hoài cổ quyến rũ. Chiếc đèn bàn của Lyndon Neri và Rossana Hu gợi nhớ một cách đáng kinh ngạc về một chiếc đèn lồng cổ điển. Để duy trì hiệu ứng retro, Lantern Light sử dụng một đèn LED đặc biệt có hình dạng gợi nhớ đến một ngọn nến - trước đây thường là nguồn sáng ưa thích trong đèn lồng. Bộ khuếch tán làm bằng thủy tinh pha lê v', 'long12.jpg', 10, 'Thủy tinh', 1),
(77, 5, 'Swirl 3 Pendant', 2150000, 72, '95 70', 'Đỏ', 2, 'Mặt dây chuyền tuyết 3 ánh sáng toát lên vẻ hoài cổ quyến rũ. Chiếc đèn bàn của Lyndon Neri và Rossana Hu gợi nhớ một cách đáng kinh ngạc về một chiếc đèn lồng cổ điển. Để duy trì hiệu ứng retro, Lantern Light sử dụng một đèn LED đặc biệt có hình dạng gợi nhớ đến một ngọn nến - trước đây thường là nguồn sáng ưa thích trong đèn lồng. Bộ khuếch tán làm bằng thủy tinh pha lê và khung làm bằng đồng chất lượng cao hoàn thiện vẻ ngoài của đèn lồng của đèn bàn LED Classicon Lantern Light.\r\n\r\nĐiều này l', 'long13.jpg', 11, 'Thủy tinh', 1),
(78, 5, 'ELEK', 3200000, 68, '100 90', 'Trắng', 2, 'Vật liệu chất lượng cao, chẳng hạn như đồng thau và thủy tinh pha lê\r\nBao gồm cả điều chỉnh độ sáng\r\nMặt dây chuyền tuyết 3 ánh sáng toát lên vẻ hoài cổ quyến rũ. Chiếc đèn bàn của Lyndon Neri và Rossana Hu gợi nhớ một cách đáng kinh ngạc về một chiếc đèn lồng cổ điển. Để duy trì hiệu ứng retro, Lantern Light sử dụng một đèn LED đặc biệt có hình dạng gợi nhớ đến một ngọn nến - trước đây thường là nguồn sáng ưa thích trong đèn lồng. Bộ khuếch tán làm bằng thủy tinh pha lê và khung làm bằng đồng c', 'long14.jpg', 1, 'Thủy tinh', 1),
(79, 5, 'Sax 224-1/17', 2410000, 44, '105 90', 'Trắng', 1, 'Mặt dây chuyền tuyết 3 ánh sáng toát lên vẻ hoài cổ quyến rũ. Chiếc đèn bàn của Lyndon Neri và Rossana Hu gợi nhớ một cách đáng kinh ngạc về một chiếc đèn lồng cổ điển. Để duy trì hiệu ứng retro, Lantern Light sử dụng một đèn LED đặc biệt có hình dạng gợi nhớ đến một ngọn nến - trước đây thường là nguồn sáng ưa thích trong đèn lồng. Bộ khuếch tán làm bằng thủy tinh pha lê và khung làm bằng đồng chất lượng cao hoàn thiện vẻ ngoài của đèn lồng của Sax 224-1 / 17\r\n\r\nĐiều này làm ấm trái tim của ngư', 'long15.jpg', 2, 'Thủy tinh', 1),
(80, 5, 'Caché Pendant', 5400000, 67, '130 80', 'Đen', 2, 'Sự kết hợp hấp dẫn của bề mặt kim loại mịn và vải xếp li\r\nÁnh sáng vùng hướng xuống\r\nKiểm soát ánh sáng chói tuyệt vời\r\nĐèn treo mặt dây chuyền Le Klint Caché XL lan tỏa một nét quyến rũ kín đáo và không phô trương. Thoạt nhìn, đèn mặt dây thanh lịch này bao gồm một bóng hình bát được làm bằng thép không gỉ và một dây cáp có khung bằng đồng. Tuy nhiên, ngay khi bạn nhìn vào khe hở ánh sáng, Caché XL làm bạn ngạc nhiên với một yếu tố thiết kế khác thường: khe hở ánh sáng được phủ bằng vải xếp li ', 'long16.jpg', 3, 'Thủy tinh', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ct_dh`
--

CREATE TABLE `ct_dh` (
  `mahd` int(11) NOT NULL,
  `mabd` int(11) NOT NULL,
  `soluong` int(11) DEFAULT NULL,
  `dongia` float(11,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Đang đổ dữ liệu cho bảng `ct_dh`
--

INSERT INTO `ct_dh` (`mahd`, `mabd`, `soluong`, `dongia`) VALUES
(1, 80, 2, 10800000),
(2, 17, 1, 5000000),
(3, 64, 1, 1400000),
(4, 68, 1, 1400000),
(5, 72, 1, 1400000),
(6, 52, 1, 1400000),
(7, 51, 1, 1400000),
(8, 64, 1, 1400000),
(9, 72, 1, 1400000),
(10, 52, 1, 1400000),
(11, 64, 1, 1400000),
(12, 64, 1, 1400000),
(13, 51, 2, 2800000),
(14, 52, 1, 1400000),
(15, 64, 1, 1400000),
(16, 72, 1, 1400000),
(17, 68, 1, 1400000),
(18, 51, 1, 1400000),
(19, 64, 1, 1400000),
(20, 72, 1, 1400000),
(21, 52, 1, 1400000),
(22, 51, 1, 1400000),
(23, 72, 1, 1400000),
(24, 52, 1, 1400000),
(25, 64, 1, 1400000),
(26, 68, 1, 1400000),
(27, 51, 2, 2800000),
(28, 51, 2, 2800000),
(29, 51, 2, 2800000),
(30, 51, 2, 2800000),
(31, 72, 2, 2800000),
(32, 68, 2, 2800000),
(33, 51, 2, 2800000),
(34, 51, 2, 2800000),
(35, 51, 2, 2800000),
(36, 51, 2, 2800000),
(47, 51, 2, 2800000),
(48, 51, 2, 2800000),
(48, 52, 2, 2800000),
(49, 51, 2, 2800000),
(49, 72, 2, 2800000),
(50, 51, 1, 1400000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giaohang`
--

CREATE TABLE `giaohang` (
  `magh` int(11) NOT NULL,
  `ngaygh` date DEFAULT NULL,
  `diachi` varchar(255) DEFAULT NULL,
  `tinhtrang` varchar(255) DEFAULT NULL,
  `sdt` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Đang đổ dữ liệu cho bảng `giaohang`
--

INSERT INTO `giaohang` (`magh`, `ngaygh`, `diachi`, `tinhtrang`, `sdt`) VALUES
(1, '2020-06-02', '12/3 Trần Khánh Dư, P5,Đà Nẵng', '1', '0906123456'),
(2, '2020-06-03', '132 Sư Vạn Hạnh,P7,Q.10,TP.HCM', '2', '0908111021'),
(3, '2020-06-04', '272 An Dương Vương,P5, Q5, TPHCM', '0', '0846377331'),
(4, '2020-06-05', '124 Quang Trung,P6,Q2,Đà Nẵng', '2', '0908123132'),
(5, '2020-06-06', '525 Cầu Giấy,Thanh Trì,  Hà Nội', '0', '0916272772'),
(6, '2020-06-07', '76 Hoàng Hoa Thám, P7,Q1,TPHCM', '0', '0901020200'),
(7, '2020-06-08', '145 Ngô Gia Tự,P5,Q10, TPHCM', '2', '0895995109'),
(8, '2020-06-09', '11 Lạc Long Quân,P6,Q11', '0', '0990029929'),
(9, '2020-06-10', '110 Hòa Bình, P10,Q11', '0', '0807484884'),
(10, '2020-06-11', '125 Phạm Văn Đồng, Linh Trung,Thủ Đức, TP.HCM', '2', '0996969698'),
(11, '2020-06-12', '152 Chu Văn An, P5,Q7, Đà Nẵng', '2', '0879796669'),
(12, '2020-06-01', '145 Phan Chu Trinh, P3, Q4, Đà Nẵng', '2', '0906969699'),
(13, '2020-06-13', '42 Lương Ngọc Quyến, Phường Thuận Phước', '0', '0897797968'),
(14, '2020-06-14', '212 Hoàng Diệu , Phường Hòa Thuận Đông, Đà Nẵng', '1', '0984848949'),
(15, '2020-06-15', '116 Phường Nam Dương,Đà Nẵng', '2', '0897799686'),
(16, '2020-06-16', '82 Âu Cơ, Phường Hòa Khánh Bắc, Đà Nẵng', '1', '0960605050'),
(17, '2020-06-17', '32 Khối Lộc Phước, Phường Thọ Quang, Đà Nẵng', '0', '0899595585'),
(18, '2020-06-18', '383 Hải Phòng, P.Tân Phú, Đà Nẵng', '0', '0996668861'),
(19, '2020-06-19', '125 Cù Chính Lan, P. Hòa Khê, Đà Nẵng', '0', '0899668585'),
(20, '2020-06-20', '12 Nguyễn Thanh Trung, P.Tân Khuê Đông, Đà Nẵng', '0', '0986864847'),
(21, '2020-06-21', '26 Nguyễn Chánh, P.Trung Hòa, Cầu Giấy,Hà Nội', '0', '0988686857'),
(22, '2020-06-22', '88 Trung Kinh, Yên Hòa, Cầu Giấy, Hà Nội', '0', '0897866857'),
(23, '2020-06-23', '166 Khuất Duy Tiến , Thanh Xuân, Hà Nội', '0', '0987878585'),
(24, '2020-06-24', '50 Liễu Giai, Ba Đình Hà Nội', '2', '0898997979'),
(25, '2020-06-25', '73 Vạn Mã, Kim Bảo, Ba Đình, Hà Nội', '1', '0997976688'),
(26, '2020-03-09', '30 Phan Đình Phùng, Quán Thánh, Ba ĐÌnh, Hà Nội', '0', '0987887857'),
(27, '2020-04-21', 'A1 Lê Văn Nghị, Bách Khoa,Hai Bà Trưng Hà Nội', '0', '0986868476'),
(28, '2020-04-20', '20 Tạ Quang Bửu, Bách Khoa, Hai Bà Trưng, Hà Nội', '0', '0896866858'),
(29, '2020-04-26', '104 Nguyễn An Ninh, Hoàng Mai, Hà Nội', '1', '0988685736'),
(30, '2020-04-27', '99 Linh Đường, Hoàng Mai, Hà Nội', '0', '0879685589');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `mahd` int(11) NOT NULL,
  `makh` int(11) DEFAULT NULL,
  `magh` int(11) DEFAULT NULL,
  `ngaydat` datetime(6) DEFAULT NULL,
  `ghichu` varchar(500) DEFAULT NULL,
  `hinhthuc_chitra` varchar(10) NOT NULL DEFAULT 'cod'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`mahd`, `makh`, `magh`, `ngaydat`, `ghichu`, `hinhthuc_chitra`) VALUES
(1, 1, 1, '2020-05-01 15:45:30.000000', '', 'cod'),
(2, 1, 2, '2020-05-18 15:46:18.000000', '', 'cod'),
(3, 1, 1, '2020-05-10 15:47:50.000000', NULL, 'cod'),
(4, 2, 1, '2020-05-11 15:48:03.000000', NULL, 'cod'),
(5, 2, 3, '2020-05-18 15:48:15.000000', NULL, 'cod'),
(6, 3, 4, '2020-05-20 15:48:26.000000', NULL, 'cod'),
(7, 4, 4, '2020-04-26 15:48:39.000000', NULL, 'cod'),
(8, 5, 6, '2020-05-25 15:48:56.000000', NULL, 'cod'),
(9, 5, 6, '2020-05-19 15:49:07.000000', NULL, 'cod'),
(10, 6, 5, '2020-05-11 15:49:19.000000', NULL, 'cod'),
(11, 6, 5, '2020-05-10 15:49:31.000000', NULL, 'cod'),
(12, 6, 1, '2020-05-17 15:49:42.000000', NULL, 'cod'),
(13, 5, 28, '2020-05-25 00:00:00.000000', NULL, 'cod'),
(14, 1, 4, '2020-04-27 15:50:24.000000', NULL, 'cod'),
(15, 5, 3, '2020-05-10 15:50:37.000000', NULL, 'cod'),
(16, 6, 2, '2020-05-03 15:50:48.000000', NULL, 'cod'),
(17, 7, 2, '2020-05-10 15:51:00.000000', NULL, 'cod'),
(18, 8, 9, '2020-05-24 15:51:11.000000', NULL, 'cod'),
(19, 6, 1, '2020-05-24 15:51:21.000000', NULL, 'cod'),
(20, 7, 5, '2020-04-19 15:51:33.000000', NULL, 'cod'),
(21, 8, 5, '2020-04-20 15:51:50.000000', NULL, 'cod'),
(22, 6, 4, '2020-05-24 15:52:01.000000', NULL, 'cod'),
(23, 2, 8, '2020-04-27 15:52:13.000000', NULL, 'cod'),
(24, 4, 9, '2020-05-24 15:52:27.000000', NULL, 'cod'),
(25, 4, 4, '2020-05-25 15:52:45.000000', NULL, 'cod'),
(26, 6, 3, '2020-05-24 15:52:57.000000', NULL, 'cod'),
(27, 7, 6, '2020-05-24 15:53:10.000000', NULL, 'cod'),
(28, 4, 7, '2020-05-31 15:53:32.000000', NULL, 'cod'),
(29, 16, 26, '2020-05-25 00:00:00.000000', NULL, 'cod'),
(30, 16, 26, '2020-05-25 00:00:00.000000', NULL, 'online'),
(31, 16, 18, '2020-05-25 00:00:00.000000', NULL, 'online'),
(32, 16, 17, '2020-05-25 00:00:00.000000', NULL, 'online'),
(33, 16, 15, '2020-05-25 00:00:00.000000', NULL, 'cod'),
(34, 16, 14, '2020-05-25 00:00:00.000000', NULL, 'cod'),
(35, 8, 9, '2020-05-24 15:55:19.000000', NULL, 'cod'),
(36, 7, 23, '2020-04-20 15:55:42.000000', NULL, 'cod'),
(37, 7, 25, '2020-03-15 16:00:43.000000', NULL, 'cod'),
(38, 2, 17, '2020-04-26 16:00:27.000000', NULL, 'cod'),
(39, 3, 15, '2020-03-08 16:00:14.000000', NULL, 'cod'),
(40, 7, 19, '2020-05-31 15:56:39.000000', NULL, 'cod'),
(41, 8, 18, '2020-04-27 15:57:12.000000', NULL, 'cod'),
(42, 8, 24, '2020-04-13 15:57:29.000000', NULL, 'cod'),
(45, 7, 20, '2020-04-13 15:58:19.000000', NULL, 'cod'),
(47, 7, 27, '2020-05-01 15:58:47.000000', NULL, 'cod'),
(48, 6, 28, '2020-05-24 15:58:58.000000', NULL, 'cod'),
(49, 5, 18, '2020-04-27 15:59:10.000000', NULL, 'cod'),
(50, 4, 24, '2020-05-31 15:59:25.000000', NULL, 'cod');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `makh` int(11) NOT NULL,
  `tenkh` varchar(255) DEFAULT NULL,
  `sdt` varchar(12) DEFAULT NULL,
  `thudientu` varchar(50) NOT NULL,
  `matkhau` varchar(255) DEFAULT 'NULL',
  `diachi` varchar(255) DEFAULT NULL,
  `tinhtrang` varchar(255) DEFAULT NULL,
  `tendn` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`makh`, `tenkh`, `sdt`, `thudientu`, `matkhau`, `diachi`, `tinhtrang`, `tendn`) VALUES
(1, 'Hoàng Gia Hân', '0905012345', 'user1@gmail.com', '123', '252 Phạm Ngũ Lão, Q1,TPHCM', '1', 'username1'),
(2, 'Ngô Gia Khánh', '0913778291', 'user2@gmail.com', 'P@ssword1', '123 Phố Xa,Cá Nâu,Đỏ,Tiền Giang', '1', 'username2'),
(3, 'Đoàn Thị Minh Hằng', '0905234567', 'user3@gmail.com', 'P@ssword1', '16 Liên Khu 2-5, Bình Trị Đông, Bình Tân', '0', 'username3'),
(4, 'Lê Thanh Hà', '0898102030', 'user4@gmail.com', 'P@ssword1', '16 Nguyễn Thị Minh Khai, P3, Q1', '1', 'username4'),
(5, 'Huỳnh Thị Lan Anh', '0868101040', 'user5@gmail.com', 'P@ssword1', '254 Hoàng Hoa Thám, P5, Q2', '0', 'username5'),
(6, 'Nguyễn Thị Thu Hà', '0989091201', 'user6@gmail.com', 'P@ssword1', '132 Trần Bình Trọng,P7,Q5', '1', 'username6'),
(7, 'Tôn Đại Gia', '0987444449', 'user7@gmail.com', 'P@ssword1', '12/13 Ngô Gia Tự, P6,Hà Nội', '0', 'username7'),
(8, 'Trịnh Gia', '0858494929', 'user8@gmail.com', 'P@ssword1', '132/67 Cầu Giấy ,Hà Nôi', '1', 'username8'),
(16, 'Thien An', '0903016545', '123@gmail.com', 'd6b0ab7f1c8ab8f514db9a6d85de160a', '1234 nguyễn Thị Minh khai', '1', 'Abc123'),
(17, 'Trương Đạt Nhân', '0913779999', 'NHAN@GMAIL.COM', '5c79b8413fe81742a4147c9373771394', '123 nHÀ MA', '1', 'nhan123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaibd`
--

CREATE TABLE `loaibd` (
  `maloai` int(25) NOT NULL,
  `tenloai` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Đang đổ dữ liệu cho bảng `loaibd`
--

INSERT INTO `loaibd` (`maloai`, `tenloai`) VALUES
(1, 'Đèn chùm'),
(2, 'Đèn ống'),
(3, 'Đèn tròn'),
(4, 'Đèn trần'),
(5, 'Đèn lồng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoidung`
--

CREATE TABLE `nguoidung` (
  `tennd` varchar(255) NOT NULL,
  `matruycap` int(11) DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `thudientu` varchar(50) DEFAULT NULL,
  `matkhau` varchar(50) DEFAULT NULL,
  `makh` int(11) DEFAULT NULL,
  `trangthai` int(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Đang đổ dữ liệu cho bảng `nguoidung`
--

INSERT INTO `nguoidung` (`tennd`, `matruycap`, `ngaysinh`, `thudientu`, `matkhau`, `makh`, `trangthai`) VALUES
('admin', 1, '2000-01-02', 'long278@gmail.com', '25d55ad283aa400af464c76d713c07ad', NULL, 1),
('manager', 3, '2000-01-01', 'manager1@gmail.com', '25d55ad283aa400af464c76d713c07ad', NULL, 1),
('user', 4, '2000-01-01', 'user0@gmail.com', '25d55ad283aa400af464c76d713c07ad', NULL, 1),
('user1', 2, '2020-05-01', 'user1@gmai.com', '25d55ad283aa400af464c76d713c07ad', 1, 1),
('user2', 2, '2020-04-01', 'user2@gmail.com', '25d55ad283aa400af464c76d713c07ad', 2, 1),
('user3', 2, '2019-11-26', 'user3@gmail.com', '25d55ad283aa400af464c76d713c07ad', 3, 1),
('user4', 2, '2010-10-26', 'user4@gmail.com', '25d55ad283aa400af464c76d713c07ad', 4, 1),
('user5', 2, '1999-01-02', 'user5@gmail.com', '25d55ad283aa400af464c76d713c07ad', 5, 1),
('user6', 2, '2000-04-09', 'user6@gmail.com', '25d55ad283aa400af464c76d713c07ad', 6, 1),
('user7', 2, '1998-05-06', 'user7@gmail.com', '25d55ad283aa400af464c76d713c07ad', 7, 1),
('user8', 2, '1997-06-03', 'user8@gmail.com', '25d55ad283aa400af464c76d713c07ad', 8, 1),
('user9', 2, '1993-03-03', 'user9@gmail.com', '25d55ad283aa400af464c76d713c07ad', 9, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thuonghieu`
--

CREATE TABLE `thuonghieu` (
  `mathuonghieu` int(11) NOT NULL,
  `tenthuonghieu` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Đang đổ dữ liệu cho bảng `thuonghieu`
--

INSERT INTO `thuonghieu` (`mathuonghieu`, `tenthuonghieu`) VALUES
(1, 'Nemo'),
(2, 'Flos'),
(3, 'Moooi'),
(4, 'Luci Plan'),
(5, 'Slamp'),
(6, 'Menu'),
(7, 'Gugi'),
(8, 'Moooi'),
(9, 'Luceplan'),
(10, 'NeMo'),
(11, 'DCW');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `vaitro_nguoidung`
--

CREATE TABLE `vaitro_nguoidung` (
  `matruycap` int(11) NOT NULL,
  `quyen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Đang đổ dữ liệu cho bảng `vaitro_nguoidung`
--

INSERT INTO `vaitro_nguoidung` (`matruycap`, `quyen`) VALUES
(1, 'admin'),
(2, 'Khách hàng'),
(3, 'manager'),
(4, 'user');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bongden`
--
ALTER TABLE `bongden`
  ADD PRIMARY KEY (`mabd`) USING BTREE,
  ADD KEY `maloai` (`maloai`) USING BTREE,
  ADD KEY `mathuonghieu` (`mathuonghieu`) USING BTREE;

--
-- Chỉ mục cho bảng `ct_dh`
--
ALTER TABLE `ct_dh`
  ADD PRIMARY KEY (`mahd`,`mabd`) USING BTREE,
  ADD KEY `madh` (`mahd`) USING BTREE,
  ADD KEY `mabd` (`mabd`) USING BTREE;

--
-- Chỉ mục cho bảng `giaohang`
--
ALTER TABLE `giaohang`
  ADD PRIMARY KEY (`magh`) USING BTREE;

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`mahd`) USING BTREE,
  ADD KEY `magh` (`magh`) USING BTREE,
  ADD KEY `makh` (`makh`) USING BTREE;

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`makh`) USING BTREE;

--
-- Chỉ mục cho bảng `loaibd`
--
ALTER TABLE `loaibd`
  ADD PRIMARY KEY (`maloai`) USING BTREE;

--
-- Chỉ mục cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`tennd`) USING BTREE,
  ADD KEY `matruycap` (`matruycap`) USING BTREE,
  ADD KEY `makh` (`makh`) USING BTREE;

--
-- Chỉ mục cho bảng `thuonghieu`
--
ALTER TABLE `thuonghieu`
  ADD PRIMARY KEY (`mathuonghieu`) USING BTREE;

--
-- Chỉ mục cho bảng `vaitro_nguoidung`
--
ALTER TABLE `vaitro_nguoidung`
  ADD PRIMARY KEY (`matruycap`) USING BTREE;

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `bongden`
--
ALTER TABLE `bongden`
  MODIFY `mabd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `mahd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `makh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT cho bảng `loaibd`
--
ALTER TABLE `loaibd`
  MODIFY `maloai` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `thuonghieu`
--
ALTER TABLE `thuonghieu`
  MODIFY `mathuonghieu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `vaitro_nguoidung`
--
ALTER TABLE `vaitro_nguoidung`
  MODIFY `matruycap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bongden`
--
ALTER TABLE `bongden`
  ADD CONSTRAINT `bongden_ibfk_1` FOREIGN KEY (`maloai`) REFERENCES `loaibd` (`maloai`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bongden_ibfk_2` FOREIGN KEY (`mathuonghieu`) REFERENCES `thuonghieu` (`mathuonghieu`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ct_dh`
--
ALTER TABLE `ct_dh`
  ADD CONSTRAINT `ct_dh_ibfk_1` FOREIGN KEY (`mabd`) REFERENCES `bongden` (`mabd`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ct_dh_ibfk_2` FOREIGN KEY (`mahd`) REFERENCES `hoadon` (`mahd`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`magh`) REFERENCES `giaohang` (`magh`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD CONSTRAINT `nguoidung_ibfk_1` FOREIGN KEY (`matruycap`) REFERENCES `vaitro_nguoidung` (`matruycap`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
