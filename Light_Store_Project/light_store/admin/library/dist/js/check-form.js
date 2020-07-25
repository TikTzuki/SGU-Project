$(document).ready(function() {

    // Giá trị mặc định của input date
    $('.instance-date').attr({
        'max': instanceDateString(),
        'value': instanceDateString()
    });
    // Đơn vị tiền
    $('.currency').each(function(index, value) {
        let temp = displayCurrency($(this).html());
        $(this).html(temp);
    });
    //Ràng buộc input chỉ nhập số
    $('.onlyNumber').on('keypress', function(event) {
        return event.charCode > 48 && event.charCode < 57;
    });
    //MODAL
    $('button[data-dismiss="modal"]').click(function() {
        $('#myModal').attr({
            style: "display:none;"
        })
        $('.modal-backdrop').attr({
            class: "modal-backdrop hide"
        })
    });
    //Form add user
    $('form[name="formAddUser"]').submit(
        function(e) {
            let flage = true,
                errorMess;
            let username = $('input[name="user_name"]', this).val();
            let email = $('input[name="email"]', this).val();
            let password = $('input[name="password"]', this).val();
            let passwordRe = $('input[name="password-re"]', this).val();
            if (username.length < 1) {
                errorMess = "Nhập tên đăng nhập";
                flage = false;
            }
            if (!checkEmail(email)) {
                errorMess = "Email không hợp lệ";
                flage = false;
            }
            if (!checkPassword(password, passwordRe)) {
                errorMess = "Password k hợp lệ";
                flage = false;
            }
            if (flage == false) {
                e.preventDefault();
                $('#myModal').attr({
                    style: "display: block"
                })
                $('.modal-backdrop').attr({
                    class: "modal-backdrop show"
                })
                $('.modal-body').html(errorMess);
            }
        }
    );
    //Form manager user
    $('form[name="formManagerUser"]').each(function(index, value) {
        $(this).submit(
            function(e) {
                let flag = true,
                    errorMess;
                let username = $('span[name="username"]')[index].textContent.trim();
                let email = jQuery('input[name="email"]')[index].value;
                let oldPassword = $('input[name="old-password"]')[index].value;
                let password = $('input[name="password"]')[index].value;
                let passwordRe = $('input[name="password-re"]')[index].value;
                console.log(username + email + oldPassword + password + passwordRe);
                if (!checkEmail(email)) {
                    errorMess = "Email không hợp lệ";
                    flag = false;
                }
                if (oldPassword === "" && password === "" && passwordRe === "") {
                    flag = true;
                } else {
                    if (!checkPassword(password, passwordRe)) {
                        errorMess = "Password không hợp lệ"
                        flag = false;
                    }
                }
                if (!flag) {
                    e.preventDefault();
                    alert(errorMess);
                }
            }
        );
    });
    //Confirm delete user
    $('.need-confirm').each(function(index, value) {
        $(this).click(function(e) {
            if (!confirm("Bạn chắc chắn không?")) {
                e.preventDefault();
            };
        })
    });

});

function instanceDateString() {
    let instanceDate = new Date(),
        instanceD = instanceDate.getDate() > 9 ? instanceDate.getDate() : 0 + "" + instanceDate.getDate(),
        instanceM = ((instanceDate.getMonth() + 1) > 9) ? (instanceDate.getMonth() + 1) : 0 + "" + (instanceDate.getMonth() + 1),
        instanceY = instanceDate.getFullYear();
    return instanceY + "-" + instanceM + "-" + instanceD;
}

function displayCurrency(money) {
    let currency = Number(money);
    currency += '';
    let resultString = "";
    switch (currency.length % 3) {
        case 0:
            resultString += currency.slice(0, 3);
            currency = currency.slice(3, currency.length);
            console.log("case 0:" + currency + "|" + resultString);
            while (currency.length > 0) {
                resultString += "." + currency.slice(0, 3);
                currency = currency.slice(3, currency.length);
            }
            console.log("case 0:" + currency + "|" + resultString);
            break;
        case 1:
            resultString += currency.slice(0, 1);
            currency = currency.slice(1, currency.length);
            console.log("case 1:" + currency + " " + resultString);
            while (currency.length > 0) {
                resultString += "." + currency.slice(0, 3);
                currency = currency.slice(3, currency.length);
            }
            console.log("case 1:" + currency + " " + resultString);
            break;
        case 2:
            resultString += currency.slice(0, 2);
            currency = currency.slice(2, currency.length);
            console.log("case 2:" + currency + "|" + resultString);
            while (currency.length > 0) {
                resultString += "." + currency.slice(0, 3);
                currency = currency.slice(3, currency.length);
            }
            console.log("case 2:" + currency + "|" + resultString);
            break;
        default:
            break;
    }
    return resultString;
}

function onlyInputNumber(event) {
    return event.charCode > 48 && event.charCode < 57;
}

function checkEmail(email) {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function checkPassword(password, passwordRe) {
    if (password.length == 0 || passwordRe == 0)
        return false;
    if (password.length <= 6)
        return false;
    if (password === passwordRe)
        return true;
    return false;
}