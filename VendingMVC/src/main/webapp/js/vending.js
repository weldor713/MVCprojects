/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    var money = 0;
    loadItems();

    $('#add-one').click(function () {
        var adder = 1;
        money = parseFloat(money) + parseFloat(adder);
        var moneyTwoDec = parseFloat(money).toFixed(2);
        var total = "Total Money: $ " + moneyTwoDec;
        document.getElementById("show-bank").innerHTML = total;
    });
    $('#add-five').click(function () {
        var adder = 5;
        money = parseFloat(money) + parseFloat(adder);
        var moneyTwoDec = parseFloat(money).toFixed(2);
        var total = "Total Money: $ " + moneyTwoDec;
        document.getElementById("show-bank").innerHTML = total;
    });
    $('#add-ten').click(function () {
        var adder = 10;
        money = parseFloat(money) + parseFloat(adder);
        var moneyTwoDec = parseFloat(money).toFixed(2);
        var total = "Total Money: $ " + moneyTwoDec;
        document.getElementById("show-bank").innerHTML = total;
    });
    $('#foodchoice').click(function (e) {
        e.preventDefault();
        e.stopPropagation();
        var moneyTwoDec = parseFloat(money).toFixed(2);
        var total = "Total Change: $ " + moneyTwoDec;
        document.getElementById("change").innerHTML = total;
        money = 0;
        moneyTwoDec = parseFloat(money).toFixed(2);
        total = "Total Money: $ " + moneyTwoDec;
        document.getElementById("show-bank").innerHTML = total;
        return false;
    })

    function loadItems() {
        $ajax({
            url: "vending"
        }).success(function (data, status) {
            fillItemTable(data, status);
        });

    }

    function fillItemTable(itemList, status) {
// clear the previous list
        clearItemTable();
// grab the tbody element that will hold the new list of dvds
        var cTable = $('#itemdisplay');
// render the new dvd data to the table
        $.each(itemList, function (index, item) {
            cTable.append($('<tr>')
                    .append($('<td>')
                            .append(function(n){
            return "<button id = '" + item.item_id + "'>";
                            }
                                    .text(item.name))
                            .append($('<p>')
                                    .text(item.cost)
                                    )
                            .append($('<p>')
                                    .text('Qty: ')
                                    .text(item.qty)
                                    )
                            .append($('<br>'))
                            )
                    );
        });
    }




    function clearItemTable() {
        $('#itemdisplay').empty();
    }

})