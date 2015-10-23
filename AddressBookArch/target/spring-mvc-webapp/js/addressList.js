// Document ready function
$(document).ready(function () {
    loadAddresss();
});
//==========
// FUNCTIONS
//==========
// Load addresss into the summary table
function loadAddresss() {
// Make an Ajax GET call to the 'addresss' endpoint. Iterate through
// each of the JSON objects that are returned and render them to the
// summary table
    $.ajax({
        url: "addresss"
    }).success(function (data, status) {
        fillAddressTable(data, status);
    });
}


function fillAddressTable(addressList, status) {
// clear the previous list
    clearAddressTable();
// grab the tbody element that will hold the new list of addresss
    var cTable = $('#contentRows');
// render the new address data to the table
    $.each(addressList, function (index, address) {
        cTable.append($('<tr>')
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-address-id': address.addressId,
                                    'data-toggle': 'modal',
                                    'data-target': '#detailsModal'
                                })
                                .text(address.firstName + ' ' +address.lastName)
                                ) // ends the <a> tag
                        ) // ends the <td> tag for the address name
                .append($('<td>').text(address.address))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-address-id': address.addressId,
                                    'data-toggle': 'modal',
                                    'data-target': '#editModal'
                                })
                                .text('Edit')
                                ) // ends the <a> tag
                        ) // ends the <td> tag for Edit
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'onClick': 'deleteAddress(' +
                                            address.addressId + ')'
                                })
                                .text('Delete')
                                ) // ends the <a> tag
                        ) // ends the <td> tag for Delete
                ); // ends the <tr> for this Address
    }); // ends the 'each' function
}

// Clear all content rows from the summary table
function clearAddressTable() {
    $('#contentRows').empty();
}

    // on click for our search button
$('#search-button-city').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
    event.preventDefault();
    $.ajax({
        type: 'POST',
        url: 'bycity/address',
        data: JSON.stringify({
            firstName: $('#search-first-name').val(),
            lastName: $('#search-last-name').val(),
            address: $('#search-address').val(),
            city: $('#search-city').val(),
            state: $('#search-state').val(),
            zip: $('#search-zip').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {
        $('#search-first-name').val('');
        $('#search-last-name').val('');
        $('#search-address').val('');
        $('#search-city').val('');
        $('#search-state').val('');
        $('#search-zip').val('');
        fillAddressTable(data, status);
    });
});

$('#search-button-last-name').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
    event.preventDefault();
    $.ajax({
        type: 'POST',
        url: 'bylastname/address',
        data: JSON.stringify({
            firstName: $('#search-first-name').val(),
            lastName: $('#search-last-name').val(),
            address: $('#search-address').val(),
            city: $('#search-city').val(),
            state: $('#search-state').val(),
            zip: $('#search-zip').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {
        $('#search-first-name').val('');
        $('#search-last-name').val('');
        $('#search-address').val('');
        $('#search-city').val('');
        $('#search-state').val('');
        $('#search-zip').val('');
        fillAddressTable(data, status);
    });
});

$('#search-button-state').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
    event.preventDefault();
    $.ajax({
        type: 'POST',
        url: 'bystate/address',
        data: JSON.stringify({
            firstName: $('#search-first-name').val(),
            lastName: $('#search-last-name').val(),
            address: $('#search-address').val(),
            city: $('#search-city').val(),
            state: $('#search-state').val(),
            zip: $('#search-zip').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {
        $('#search-first-name').val('');
        $('#search-last-name').val('');
        $('#search-address').val('');
        $('#search-city').val('');
        $('#search-state').val('');
        $('#search-zip').val('');
        fillAddressTable(data, status);
    });
});

$('#search-button-zip').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
    event.preventDefault();
    $.ajax({
        type: 'POST',
        url: 'byzip/address',
        data: JSON.stringify({
            firstName: $('#search-first-name').val(),
            lastName: $('#search-last-name').val(),
            address: $('#search-address').val(),
            city: $('#search-city').val(),
            state: $('#search-state').val(),
            zip: $('#search-zip').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {
        $('#search-first-name').val('');
        $('#search-last-name').val('');
        $('#search-address').val('');
        $('#search-city').val('');
        $('#search-state').val('');
        $('#search-zip').val('');
        fillAddressTable(data, status);
    });
});
// on click for our add button
$('#add-button').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
    event.preventDefault();
// Make an Ajax call to the server. HTTP verb = POST, URL = contact
    $.ajax({
        type: 'POST',
        url: 'address',
// Build a JSON object from the data in the form
        data: JSON.stringify({
            firstName: $('#add-first-name').val(),
            lastName: $('#add-last-name').val(),
            address: $('#add-address').val(),
            city: $('#add-city').val(),
            state: $('#add-state').val(),
            zip: $('#add-zip').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {
// If the call succeeds, clear the form and reload the summary table

        $('#add-first-name').val('');
        $('#add-last-name').val('');
        $('#add-address').val('');
        $('#add-city').val('');
        $('#add-state').val('');
        $('#add-zip').val('');
        loadAddresss();
//return false;
    });
});

// This code runs in response to show.bs.modal event for the details Modal
$('#detailsModal').on('show.bs.modal', function (event) {
// get the element that triggered the event
    var element = $(event.relatedTarget);
    var addressId = element.data('address-id');
    var modal = $(this);
// make an ajax call to get address information for given address id
// this is a GET request to address/{id}
// upon success, put the returned JSON data into the modal dialog
    $.ajax({
        type: 'GET',
        url: 'address/' + addressId
    }).success(function (address) {
        modal.find('#address-id').text(address.addressId);
        modal.find('#address-firstName').text(address.firstName);
        modal.find('#address-lastName').text(address.lastName);
        modal.find('#address-address').text(address.address);
        modal.find('#address-city').text(address.city);
        modal.find('#address-state').text(address.state);
        modal.find('#address-zip').text(address.zip);
    });
});



// This code runs in response to the show.hs.modal event for the edit Modal
$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var addressId = element.data('address-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'address/' + addressId
    }).success(function (address) {
        modal.find('#address-id').text(address.addressId);
        modal.find('#edit-address-id').val(address.addressId);
        modal.find('#edit-first-name').val(address.firstName);
        modal.find('#edit-last-name').val(address.lastName);
        modal.find('#edit-address').val(address.address);
        modal.find('#edit-city').val(address.city);
        modal.find('#edit-state').val(address.state);
        modal.find('#edit-zip').val(address.zip);
    });
});

// onclick handler for edit button
$('#edit-button').click(function (event) {
// prevent the button press from submitting the whole page
    event.preventDefault();
// Ajax call -
// Method - PUT
// URL - address/{id}
// Just reload all of the Addresss upon success
    $.ajax({
        type: 'PUT',
        url: 'address/' + $('#edit-address-id').val(),
        data: JSON.stringify({
            addressId: $('#edit-address-id').val(),
            firstName: $('#edit-first-name').val(),
            lastName: $('#edit-last-name').val(),
            address: $('#edit-address').val(),
            city: $('#edit-city').val(),
            state: $('#edit-state').val(),
            zip: $('#edit-zip').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function () {
        loadAddresss();
    });
});

function deleteAddress(id) {
    var answer = confirm("Do you really want to delete this address?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'address/' + id
        }).success(function () {
            loadAddresss();
        });
    }
}