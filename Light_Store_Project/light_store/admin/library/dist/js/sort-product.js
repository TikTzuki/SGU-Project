$(document).ready(function() {
    console.log("delete-product");
    $("#sort-id").click(function(e) {
        e.preventDefault();
        sortListDirNum(".id-product");
    });
    $("#sort-cate").click(function(e) {
        e.preventDefault();
        sortListDir(".cate-product");
    });
    $("#sort-name").click(function(e) {
        e.preventDefault();
        sortListDir(".name-product");
    });
    $("#sort-price").click(function(e) {
        e.preventDefault();
        sortListDirNum(".price-product");
    });
    $("#sort-quantity").click(function(e) {
        e.preventDefault();
        sortListDirNum(".quantity-product");
    });
    $("#sort-brand").click(function(e) {
        e.preventDefault();
        sortListDir(".brand-product");
    });

    function sortListDir(sortBy) {
        var i, switching, itemSort, shoudSwitch, dir, switchcount = 0;
        switching = true;
        dir = "asc";
        while (switching) {
            switching = false;
            itemSort = $("#body-table tr td " + sortBy);
            for (i = 0; i < (itemSort.length - 1); i++) {
                shoudSwitch = false;
                if (dir == "asc") {
                    if (itemSort[i].innerHTML.toLowerCase() > itemSort[i + 1].innerHTML.toLowerCase()) {
                        shoudSwitch = true;
                        break;
                    }
                } else if (dir == "desc") {
                    if (itemSort[i].innerHTML.toLowerCase() < itemSort[i + 1].innerHTML.toLowerCase()) {
                        shoudSwitch = true;
                        break;
                    }
                }
            }
            if (shoudSwitch) {
                itemSort[i].parentNode.parentNode.parentNode.insertBefore(itemSort[i + 1].parentNode.parentNode, itemSort[i].parentNode.parentNode);
                switching = true;
                switchcount++;
            } else {
                if (switchcount == 0 && dir == "asc") {
                    dir = "desc";
                    switching = true;
                }
            }

        }
    }

    function sortListDirNum(sortBy) {
        var table, i, switching, itemSort, shoudSwitch, dir, switchcount = 0;
        switching = true;
        dir = "asc";
        while (switching) {
            switching = false;
            itemSort = $("#body-table tr td " + sortBy);
            for (i = 0; i < (itemSort.length - 1); i++) {
                shoudSwitch = false;
                if (dir == "asc") {
                    if (Number(itemSort[i].innerHTML) > Number(itemSort[i + 1].innerHTML)) {
                        shoudSwitch = true;
                        break;
                    }
                } else if (dir == "desc") {
                    if (Number(itemSort[i].innerHTML) < Number(itemSort[i + 1].innerHTML)) {
                        shoudSwitch = true;
                        break;
                    }
                }
            }
            if (shoudSwitch) {
                itemSort[i].parentNode.parentNode.parentNode.insertBefore(itemSort[i + 1].parentNode.parentNode, itemSort[i].parentNode.parentNode);
                switching = true;
                switchcount++;
            } else {
                if (switchcount == 0 && dir == "asc") {
                    dir = "desc";
                    switching = true;
                }
            }

        }
    }
})