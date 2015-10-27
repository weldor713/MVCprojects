/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Document ready function
$(document).ready(function () {
    loadContacts();
    // on click for our add button
    $('#add-button').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
        event.preventDefault();
// Make an Ajax call to the server. HTTP verb = POST, URL = contact 
        $.ajax({
            type: 'POST',
            url: 'contact',
// Build a JSON object from the data in the form 
            data: JSON.stringify({
                firstName: $('#add-first-name').val(),
                lastName: $('#add-last-name').val(),
                company: $('#add-company').val(),
                phone: $('#add-phone').val(),
                email: $('#add-email').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
// If the call succeeds, clear the form and reload the summary
            $('#add-first-name').val('');
            $('#add-last-name').val('');
            $('#add-company').val('');
            $('#add-phone').val('');
            $('#add-email').val('');
            $('#validationErrors').empty();
            loadContacts();
            //return false;
        }).error(function (data, status) {
            $('#validationErrors').empty();
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                //var errorDiv = $('#validationErrors');
                //errorDiv.append(validationError.message).append($('<br>'));
                $('#validationErrors').append(validationError.message).append($('<br>'));
            });
        });
    });
    $('#edit-button').click(function (event) {
// prevent the button press from submitting the whole page event.preventDefault();
// Ajax call -
// Method - PUT
// URL - contact/{id}
// Just reload all of the Contacts upon success
        $.ajax({
            type: 'PUT',
            url: 'contact/' + $('#edit-contact-id').val(),
            data: JSON.stringify({
                contactId: $('#edit-contact-id').val(),
                firstName: $('#edit-first-name').val(),
                lastName: $('#edit-last-name').val(),
                company: $('#edit-company').val(),
                phone: $('#edit-phone').val(),
                email: $('#edit-email').val()
            }),
            headers: {
                'Accept': 'application/json', 'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadContacts();
            $('#editModal').modal('hide');
        }).error(function (data, status) {
            $('#validationErrorsEdit').empty();
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                //var errorDiv = $('#validationErrors');
                //errorDiv.append(validationError.message).append($('<br>'));
                $('#validationErrorsEdit').append(validationError.message).append($('<br>'));
            });
        });
    });
    $('#search-button').click(function (event) {
// we don’t want the button to actually submit 
// we'll handle data submission via ajax 
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'search/contacts',
            data: JSON.stringify({
                firstName: $('#search-first-name').val(),
                lastName: $('#search-last-name').val(),
                company: $('#search-company').val(),
                phone: $('#search-phone').val(),
                email: $('#search-email').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            $('#search-first-name').val('');
            $('#search-last-name').val('');
            $('#search-company').val('');
            $('#search-phone').val('');
            $('#search-email').val('');
            fillContactTable(data, status);
        });
    });
});
//==========
// FUNCTIONS
//==========
// Load contacts into the summary table
function loadContacts() {

    $.ajax({
        url: "contacts"
    }).success(function (data, status) {
        fillContactTable(data, status);
    });
}

function fillContactTable(contactList, status) {
    clearContactTable();
    var cTable = $('#contentRows');
    $.each(contactList, function (index, contact) {
        cTable.append($('<tr>')
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-contact-id': contact.contactId,
                                    'data-toggle': 'modal',
                                    'data-target': '#detailsModal'
                                })
                                .text(contact.firstName + ' ' + contact.lastName)
                                ) // ends the <a> tag
                        ) // ends the <td> tag for the contact name
                .append($('<td>').text(contact.company))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-contact-id': contact.contactId,
                                    'data-toggle': 'modal',
                                    'data-target': '#editModal'
                                })
                                .text('Edit')
                                ) // ends the <a> tag
                        ) // ends the <td> tag for Edit
                .append($('<td>').append($('<a>')
                        .attr({
                            'onClick': 'deleteContact(' +
                                    contact.contactId + ')'
                        })

                        .text('Delete')
                        )
                        )
                );
    });
}



// Clear all content rows from the summary table
function clearContactTable() {
    $('#contentRows').empty();
}

$('#detailsModal').on('show.bs.modal', function (event) {
// Get the element that triggered this event - in our case it is a contact // name link in the summary table. This link has an attribute that contains // the contactId for the given contact. We'll use that to retrieve the
// contact's details.
    var element = $(event.relatedTarget);
// grab the contact id
    var contactId = element.data('contact-id');
    // PLACEHOLDER:  Eventually we'll make an ajax call to the server to get the
    //               details for this contact but for now we'll load the dummy data
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'contact/' + contactId
    }).success(function (contact) {
        modal.find('#contact-id').text(contact.contactId);
        modal.find('#contact-firstName').text(contact.firstName);
        modal.find('#contact-lastName').text(contact.lastName);
        modal.find('#contact-company').text(contact.company);
        modal.find('#contact-phone').text(contact.phone);
        modal.find('#contact-email').text(contact.email);
    });
});
$('#editModal').on('show.bs.modal', function (event) {
// Get the element that triggered this event - in our case it is a contact // name link in the summary table. This link has an attribute that contains // the contactId for the given contact. We'll use that to retrieve the
// contact's details.
    var element = $(event.relatedTarget);
// Grab the contact id
    var contactId = element.data('contact-id');
// PLACEHOLDER: Eventually we'll make an ajax call to the server to get the
    //               details for this contact but for now we'll load the dummy
// data
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'contact/' + contactId
    }).success(function (contact) {
        modal.find('#contact-id').text(contact.contactId);
        modal.find('#edit-contact-id').val(contact.contactId);
        modal.find('#edit-first-name').val(contact.firstName);
        modal.find('#edit-last-name').val(contact.lastName);
        modal.find('#edit-company').val(contact.company);
        modal.find('#edit-phone').val(contact.phone);
        modal.find('#edit-email').val(contact.email);
    });
});
function deleteContact(id) {
    var answer = confirm("Do you really want to delete this contact?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'contact/' + id}).success(function () {
            loadContacts();
        });
    }
}