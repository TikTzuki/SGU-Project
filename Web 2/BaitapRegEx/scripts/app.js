setInterval(clock, 1000);
function clock() {
    var d = new Date();
    document.getElementById("time").innerHTML = d.toLocaleTimeString();
}

$(document).ready(() => {
    var flag = false;
    $("#Field7").prop("disabled", true);

    $("#form69").submit(function (event) {
        var mail = $("#Field9").val();
        var country = $("#Field7").val();

        if (!ValidateEmail(mail)) {
            event.preventDefault();
            $("#errEmail").text("Email sai cu phap.");
        }

        if (country == "") {
            event.preventDefault();
            $("#errCountry").text("Chon Country.");
        }

        if (flag == false) {
            event.preventDefault();
        }
    });

    $("#Field7").click(function () {
        var country = $("#Field7").val();
        var countryCode;

        switch (country) {
            case "Afghanistan":
                countryCode = "93";
                break;
            case "Saudi Arabia":
                countryCode = "966";
                break;
            case "Spain":
                countryCode = "34";
                break;
            case "United Kingdom":
                countryCode = "44";
                break;
            case "United States":
                countryCode = "1";
                break;
            case "Vietnam":
                countryCode = "84";
                break;
            default:
                countryCode = "";
                break;
        }

        $("#Field8").val(countryCode);
    });

    $("#form69").keyup(function isEmptyName() {
        var username0 = $("#Field0").val();
        var username1 = $("#Field1").val();
        var email = $("#Field9").val();
        var province = $("#Field5").val();

        username0 = username0.trim();
        username1 = username1.trim();
        email = email.trim();

        if (province === "") {
            $("#Field7").prop("disabled", true);
        } else {
            $("#Field7").prop("disabled", false);
        }

        if (username0 === "" || username1 === "") {
            $("#errName").text("Khong duoc de trong ten dang nhap");
            flag = false;
        } else {
            $("#errName").text("");
            flag = true;
        }

        if (email === "") {
            $("#errEmail").text("Khong duoc de trong email");
            flag = false;
            $(this)
                .find(":input[type=submit]")
                .prop("disabled", false);
        } else {
            $("#errEmail").text("");
            flag = true;
        }
    });

    $("#Field10").change(function () {
        var accomStatus = $("#Field10").val();

        if (accomStatus == "") {
            $("#errAccomStatus").text("Khong duoc de trong Accommodation Status");
            flag = false;
        } else {
            $("#errAccomStatus").text("");
            flag = true;
        }
    });

    function ValidateEmail(mail) {
        if (mail.indexOf("@") < mail.indexOf(".")) {
            return true;
        } else {
            return false;
        }
    }

    //Triangle
    $("#loadTriangle").click(function () {
        var heightTriangle = Number($("#inputTriangle").val());
        var n = Math.pow(heightTriangle, 2);
        var arrNum = [];
        console.log(n);
        for (var i = 0; i < n; i++) {
            arrNum[i] = i + 1;
        }
        console.log(arrNum);

        var triangle = $("#triangle");
        triangle.html("");
        var g = 0;
        for (var i = 1; i <= heightTriangle; i++) {
            var row = "";
            for (var j = 1; j <= 2 * heightTriangle - 1; j++) {
                if (
                    (j > heightTriangle - i && j < heightTriangle + i) ||
                    j == heightTriangle
                ) {
                    row += "<td>" + arrNum[g++] + "</td>";
                } else {
                    row += '<td style="width:20px"> &nbsp; </td>';
                }
            }
            triangle.html(triangle.html() + "<tr>" + row + "</tr>");
        }
    });

    //Select yyyy/mm/dd
    function OptionYear(begin, end) {
        var options;
        for (var i = begin; i <= end; i++) {
            options += '<option value="' + i + '">' + i + '</option>';
        }
        return options;
    };

    function OptionMonth() {
        var options;
        for (var i = 1; i <= 12; i++) {
            options += '<option value="' + i + '">' + i + '</option>';
        }
        return options;
    }

    function OptionDate(endDate) {
        var options;
        for (var i = 1; i <= endDate; i++) {
            options += '<option value="' + i + '">' + i + '</option>';
        }
        return options;
    }

    $("#Select1").html(OptionYear(2000, 2030));

    $("#Select2").html(OptionMonth());

    $("#Select3").html(OptionDate(getDate($('#Select2').val(), $('#Select1').val())));

    $("#Select2").change(function () {
        $("#Select3").html(OptionDate(getDate($('#Select2').val(), $('#Select1').val())));
    });

    $("#Select1").change(function () {
        $("#Select3").html(OptionDate(getDate($('#Select2').val(), $('#Select1').val())));
    });

    $("#Select4").html(OptionYear(2000, 2030));

    $("#Select5").html(OptionMonth());

    $("#Select6").html(OptionDate(getDate($('#Select5').val(), $('#Select4').val())));

    $("#Select5").change(function () {
        $("#Select6").html(OptionDate(getDate($('#Select5').val(), $('#Select4').val())));
    });

    $("#Select4").change(function () {
        $("#Select6").html(OptionDate(getDate($('#Select5').val(), $('#Select4').val())));
    });
    //get date
    function getDate(month, year) {
        var date;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return date = 31;
        if (month == 2) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                return date = 29;
            }
            else return date = 28;
        }
        return date = 30;
    }

});
