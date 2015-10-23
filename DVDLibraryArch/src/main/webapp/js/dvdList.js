// Document ready function
$(document).ready(function () {
    loadDvds();
});
//==========
// FUNCTIONS
//==========
// Load dvds into the summary table
function loadDvds() {
// Make an Ajax GET call to the 'dvds' endpoint. Iterate through
// each of the JSON objects that are returned and render them to the
// summary table
    $.ajax({
        url: "dvds"
    }).success(function (data, status) {
        fillDvdTable(data, status);
    });
}

// Clear all content rows from the summary table
function clearDvdTable() {
    $('#contentRows').empty();
    }
    
    
function fillDvdTable(dvdList, status) {
// clear the previous list
    clearDvdTable();
// grab the tbody element that will hold the new list of dvds
    var cTable = $('#contentRows');
// render the new dvd data to the table
    $.each(dvdList, function (index, dvd) {
        cTable.append($('<tr>')
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-dvd-id': dvd.dvdId,
                                    'data-toggle': 'modal',
                                    'data-target': '#detailsModal'
                                })
                                .text(dvd.title)
                                ) // ends the <a> tag
                        ) // ends the <td> tag for the dvd name
                .append($('<td>').text(dvd.director))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-dvd-id': dvd.dvdId,
                                    'data-toggle': 'modal',
                                    'data-target': '#editModal'
                                })
                                .text('Edit')
                                ) // ends the <a> tag
                        ) // ends the <td> tag for Edit
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'onClick': 'deleteDvd(' +
                                            dvd.dvdId + ')'
                                })
                                .text('Delete')
                                ) // ends the <a> tag
                        ) // ends the <td> tag for Delete
                ); // ends the <tr> for this Dvd
    }); // ends the 'each' function
}


// on click for our add button
    $('#add-button').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
        event.preventDefault();
// Make an Ajax call to the server. HTTP verb = POST, URL = dvd 
        $.ajax({
            type: 'POST',
            url: 'dvd',
// Build a JSON object from the data in the form 
            data: JSON.stringify({
                title: $('#add-title').val(),
                director: $('#add-director').val(),
                releasedate: $('#add-releasedate').val(),
                mpaarating: $('#add-mpaarating').val(),
                studio: $('#add-studio').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
// If the call succeeds, clear the form and reload the summary
            $('#add-title').val('');
            $('#add-director').val('');
            $('#add-releasedate').val('');
            $('#add-mpaarating').val('');
            $('#add-studio').val('');
            loadDvds();
            //return false;
        });
    });
    
    // on click for our search button
$('#search-button').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
    event.preventDefault();
    $.ajax({
        type: 'POST',
        url: 'search/dvds',
        data: JSON.stringify({
            title: $('#search-title').val(),
            director: $('#search-director').val(),
            releasedate: $('#search-releasedate').val(),
            mpaarating: $('#search-mpaarating').val(),
            studio: $('#search-studio').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {
        $('#search-title').val('');
        $('#search-director').val('');
        $('#search-releasedate').val('');
        $('#search-mpaarating').val('');
        $('#search-studio').val('');
        fillDvdTable(data, status);
    });
});

// This code runs in response to show.bs.modal event for the details Modal
$('#detailsModal').on('show.bs.modal', function (event) {
// get the element that triggered the event
    var element = $(event.relatedTarget);
    var dvdId = element.data('dvd-id');
    var modal = $(this);
// make an ajax call to get dvd information for given dvd id
// this is a GET request to dvd/{id}
// upon success, put the returned JSON data into the modal dialog
    $.ajax({
        type: 'GET',
        url: 'dvd/' + dvdId
    }).success(function (dvd) {
        modal.find('#dvd-id').text(dvd.dvdId);
        modal.find('#dvd-title').text(dvd.title);
        modal.find('#dvd-director').text(dvd.director);
        modal.find('#dvd-releasedate').text(dvd.releasedate);
        modal.find('#dvd-mpaarating').text(dvd.mpaarating);
        modal.find('#dvd-studio').text(dvd.studio);
    });
});

// This code runs in response to the show.hs.modal event for the edit Modal
$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var dvdId = element.data('dvd-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'dvd/' + dvdId
    }).success(function (dvd) {
        modal.find('#dvd-id').text(dvd.dvdId);
        modal.find('#edit-dvd-id').val(dvd.dvdId);
        modal.find('#edit-title').val(dvd.title);
        modal.find('#edit-director').val(dvd.director);
        modal.find('#edit-releasedate').val(dvd.releasedate);
        modal.find('#edit-mpaarating').val(dvd.mpaarating);
        modal.find('#edit-studio').val(dvd.studio);
    });
});

// onclick handler for edit button
$('#edit-button').click(function (event) {
// prevent the button press from submitting the whole page
    event.preventDefault();
// Ajax call -
// Method - PUT
// URL - dvd/{id}
// Just reload all of the Dvds upon success
    $.ajax({
        type: 'PUT',
        url: 'dvd/' + $('#edit-dvd-id').val(),
        data: JSON.stringify({
            dvdId: $('#edit-dvd-id').val(),
            title: $('#edit-title').val(),
            director: $('#edit-director').val(),
            releasedate: $('#edit-releasedate').val(),
            mpaarating: $('#edit-mpaarating').val(),
            studio: $('#edit-studio').val()

        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function () {
        loadDvds();
    });
});

function deleteDvd(id) {
    var answer = confirm("Do you really want to delete this dvd?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'dvd/' + id
        }).success(function () {
            loadDvds();
        });
    }
}