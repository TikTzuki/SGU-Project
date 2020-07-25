$(".show-submenu").on(
    "click",
    function() {

        if ($(this).attr("class", ) == "fa fa-plus show-submenu") {
            $(this).attr("class", "fa fa-minus show-submenu");
        } else {
            $(this).attr("class", "fa fa-plus show-submenu");
        }

        $(".sub_menu_content").slideToggle();
    }
);
$(document).ready(function() {
    var shoppingCart = (function() {
        // =============================
        // Private methods and propeties
        // =============================
        let cart = [];

        // Constructor
        function Item(name, price, count) {
            this.name = name;
            this.price = price;
            this.count = count;
        }

        // Save cart
        function saveCart() {
            localStorage.setItem('shoppingCart', JSON.stringify(cart));
        }

        // Load cart
        function loadCart() {
            cart = JSON.parse(localStorage.getItem('shoppingCart'));
        }
        if (localStorage.getItem("shoppingCart") != null) {
            loadCart();
        }


        // =============================
        // Public methods and propeties
        // =============================
        var obj = {};

        // Add to cart
        obj.addItemToCart = function(name, price, num) {
                console.log(num);
                for (var item in cart) {
                    if (cart[item].name === name) {
                        console.log("item count:" + cart[item].count);
                        cart[item].count += num;
                        saveCart();
                        return;
                    }
                }
                console.log(num);
                var item = new Item(name, price, num);
                cart.push(item);
                saveCart();
            }
            // Set count from item
        obj.setCountForItem = function(name, count) {
            for (var i in cart) {
                if (cart[i].name === name) {
                    cart[i].count = count;
                    break;
                }
            }
        };
        // Remove item from cart
        obj.removeItemFromCart = function(name) {
            for (var item in cart) {
                if (cart[item].name === name) {
                    cart[item].count--;
                    if (cart[item].count === 0) {
                        cart.splice(item, 1);
                    }
                    break;
                }
            }
            saveCart();
        }

        // Remove all items from cart
        obj.removeItemFromCartAll = function(name) {
            for (var item in cart) {
                if (cart[item].name === name) {
                    cart.splice(item, 1);
                    break;
                }
            }
            saveCart();
        }

        // Clear cart
        obj.clearCart = function() {
            cart = [];
            saveCart();
        }

        // Count cart 
        obj.totalCount = function() {
            var totalCount = 0;
            for (var item in cart) {
                totalCount += cart[item].count;
            }
            return Number(totalCount);
        }

        // Total cart
        obj.totalCart = function() {
            var totalCart = 0;
            for (var item in cart) {
                totalCart += cart[item].price * cart[item].count;
            }
            return Number(totalCart);
        }

        // List cart
        obj.listCart = function() {
            var cartCopy = [];
            for (i in cart) {
                item = cart[i];
                itemCopy = {};
                for (p in item) {
                    itemCopy[p] = item[p];

                }
                itemCopy.total = Number(item.price * item.count);
                cartCopy.push(itemCopy)
            }
            return cartCopy;
        }

        // cart : Array
        // Item : Object/Class
        // addItemToCart : Function
        // removeItemFromCart : Function
        // removeItemFromCartAll : Function
        // clearCart : Function
        // countCart : Function
        // totalCart : Function
        // listCart : Function
        // saveCart : Function
        // loadCart : Function
        return obj;
    })();


    // *****************************************
    // Triggers / Events
    // ***************************************** 
    // Add item
    $('.add-to-cart').click(function(event) {
        event.preventDefault();
        var name = $(this).data('name');
        var price = Number($(this).data('price'));
        shoppingCart.addItemToCart(name, price, 1);
        displayCart();
    });
    $('.add-to-cart-more').click(function(event) {
        event.preventDefault();
        var name = $(this).data('name');
        var price = Number($(this).data('price'));
        var num = Number($(this).prev().val());
        shoppingCart.addItemToCart(name, price, num);
        console.log(num);
        displayCart();
    });

    // Clear items
    $('.clear-cart').click(function() {
        shoppingCart.clearCart();
        displayCart();
    });

    function displayCart() {
        var cartArray = shoppingCart.listCart();
        var output = "";
        output += "<form class=\"\" action=\"cart.html\" method=\"post\">" +
            "<table class=\"cart-table\" cellspacing=\"0\">" +
            "<thead><tr>" +
            "<th class=\"product-remove\"> </th>" +
            "<th class=\"product-thumbnail\"> </th>" +
            "<th class=\"product-name\"> Sản Phẩm </th>" +
            "<th class=\"product-price\"> Giá </th>" +
            "<th class=\"product-quantity\"> Số Lượng </th>" +
            "<th class=\"product-subtotal\"> Tổng </th>" +
            "</tr></thead>" +
            "<tbody class=\"show-cart table\">";

        for (var i in cartArray) {
            output +=
                "<tr>" +
                "<td id='product-remove'><a class='delete-item' id='remove' href='' data-name=" + cartArray[i].name + ">×</a></td>" +
                "<td id='product-thumbnail'>" +
                "<a href='#'>" +
                "<img id='cart-img-item' src='IMG/" + cartArray[i].name + ".jpg' alt=''>" +
                "</a>" +
                "</td>" +
                "<td id='product-name'><p><a href='#'>" + cartArray[i].name + "</a></p></td>" +
                "<td>" + cartArray[i].price + "</td>" +
                "<td><div class='input-group'><button class='minus-item ' data-name=" + cartArray[i].name + " data-price=" + cartArray[i].price + ">-</button>" +
                "<input type='text' class='add-to-cart-quantity item-count form-control' data-name='" + cartArray[i].name + "' value='" + cartArray[i].count + "'>" +
                "<button class='plus-item ' data-name=" + cartArray[i].name + " data-price=" + cartArray[i].price + ">+</button></div></td>" +
                "<td>" + cartArray[i].total + "</td>" +
                "</tr>";
        }
        output += "</tbody>" +
            "</table>" +
            "</form>";
        if (cartArray.length == 0)
            output = "<h2 style=\"text-align:center;margin:20px 0;\"> Bạn chưa có sản phẩm nào </h2>";
        $('.show-cart').html(output);
        $('.total-cart').html(shoppingCart.totalCart());
        $('.total-count').html(shoppingCart.totalCount());
    }

    // Delete item button

    $('.show-cart').on("click", ".delete-item", function(event) {
        var name = $(this).data('name')
        shoppingCart.removeItemFromCartAll(name);
        displayCart();
    })


    // -1
    $('.show-cart').on("click", ".minus-item", function(event) {
            var name = $(this).data('name');
            shoppingCart.removeItemFromCart(name);
            displayCart();
        })
        // +1
    $('.show-cart').on("click", ".plus-item", function(event) {
        var name = $(this).data('name');
        var price = $(this).data('price');
        shoppingCart.addItemToCart(name, price, 1);
        displayCart();
    })

    // Item count input
    $('.show-cart').on("change", ".item-count", function(event) {
        var name = $(this).data('name');
        var count = Number($(this).val());
        shoppingCart.setCountForItem(name, count);
        displayCart();
    });

    displayCart();

    $(".add-to-cart-quantity").on("keypress", function(event) {
        return event.charCode > 48 && event.charCode < 57;
    })
})

/*
// SCROLL to TOP
window.onscroll = function() { scrollFunction() };

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("myBtn1").style.display = "block";
    } else {
        document.getElementById("myBtn1").style.display = "none";
    }
}
document.getElementById('myBtn1').addEventListener("click", function() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
})
*/