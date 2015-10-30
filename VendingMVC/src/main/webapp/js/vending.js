/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var money = 0;
var buttonid = "";
var bttnname = "";
var clickid = 0;

$(document).ready(function () {
    loadItems();
});

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
});

function loadItems() {
    $.ajax({
        url: "vending"
    }).success(function (data, status) {
        fillItemTable(data, status);
    }).error(function () {
        alert("Handler for .error() called.");
    });


}

function fillItemTable(itemList, status) {
// clear the previous list
    clearItemTable();
// grab the tbody element that will hold the new list of items
    var cTable = $('#itemdisplay');
    cTable.empty();
    cTable.append($('<tr>'));
// render the new item data to the table
    $.each(itemList, function (index, item) {
        if (item.qty > 0) {
            buttonid = (item.itemId);
            bttnname = (item.name);
            var btn = document.createElement("BUTTON");
            var par = document.createElement("P");
            par.setAttribute("id", bttnname);
            var thewords = ("Cost: " + item.cost);
            var thewords2 = ("Qty Left: " + item.qty);
            btn.setAttribute("class", "clickme");
            btn.setAttribute("id", bttnname);
            btn.setAttribute("value", buttonid)
            btn.textContent = bttnname;
            cTable.append($('<td class = "inline-block">')
                    .append($(btn)
                            .append(($('<p>')
                                    .text(thewords))
                                    .append($(par)
                                            .text(thewords2))
                                    )
                            )
                    )
                    .append($('<p id="padded">'));
        }
    });
    $('.clickme').click(function () {
        clickid = this.value;
                checkPrice();
    });

}

function clearItemTable() {
    $('#itemdisplay').empty();
}

function vendItem() {
    $.ajax({
        type: 'GET',
        url: 'vend/' + clickid
    }).success(function (item) {
        loadItems();
    })
}

function checkPrice() {
    $.ajax({
        type: 'GET',
        url: 'check/' + clickid
    }).success(function (item) {
        subtract = item.cost;
        if (subtract < money) {
            money = parseFloat(money) - parseFloat(subtract);
            var moneyTwoDec = parseFloat(money).toFixed(2);
            var total = "Total Money: $ " + moneyTwoDec;
            document.getElementById("show-bank").innerHTML = total;
            vendItem();
        }
        else {
//            Show message saying no money!
        }
    });
}
