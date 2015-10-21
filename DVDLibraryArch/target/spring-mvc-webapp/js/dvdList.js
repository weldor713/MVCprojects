// Document ready function
$(document).ready(function () {
    loadContacts();
});
//==========
// FUNCTIONS
//==========
// Load contacts into the summary table
function loadContacts() {
// clear the previous list
    clearContactTable();
// grab the tbody element that will hold the new list of contacts
    var cTable = $('#contentRows');
// Iterate through each of the JSON objects in the test contact data
// and render to the summary table
    $.each(testContactData, function (index, contact) {
        cTable.append($('<tr>')
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-contact-id': contact.contactId,
                                    'data-toggle': 'modal',
                                    'data-target': '#detailsModal'
                                })
                                .text(contact.title)
                                ) // ends the <a> tag
                        ) // ends the <td> tag for the contact name
                .append($('<td>').text(contact.studio))
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
                .append($('<td>').text('Delete'))
                );
    });
}
// Clear all content rows from the summary table
function clearContactTable() {
    $('#contentRows').empty();
}

// This code runs in response to the show.bs.modal event - it gets the correct
// contact data and renders it to the dialog
$('#detailsModal').on('show.bs.modal', function (event) {
// Get the element that triggered this event - in our case it is a contact
// name link in the summary table. This link has an attribute that contains
// the contactId for the given contact. We'll use that to retrieve the
// contact's details.
    var element = $(event.relatedTarget);
// grab the contact id
    var contactId = element.data('contact-id');
// PLACEHOLDER: Eventually we'll make an ajax call to the server to get the
//details for this contact but for now we'll load the dummy
//data

    var modal = $(this);
    modal.find('#contact-id').text(dummyDetailsContact.contactId);
    modal.find('#contact-title').text(dummyDetailsContact.title);
    modal.find('#contact-director').text(dummyDetailsContact.director);
    modal.find('#contact-releasedate').text(dummyDetailsContact.releasedate);
    modal.find('#contact-studio').text(dummyDetailsContact.studio);
    modal.find('#contact-mpaarating').text(dummyDetailsContact.mpaarating);
});

// This code runs in response to the show.bs.modal event - it gets the correct
// contact data and renders it to the dialog
$('#editModal').on('show.bs.modal', function (event) {
// Get the element that triggered this event - in our case it is a contact
// name link in the summary table. This link has an attribute that contains
// the contactId for the given contact. We'll use that to retrieve the
// contact's details.
var element = $(event.relatedTarget);
// Grab the contact id
var contactId = element.data('contact-id');
// PLACEHOLDER: Eventually we'll make an ajax call to the server to get the
//details for this contact but for now we'll load the dummy
//data

var modal = $(this);
modal.find('#contact-id').text(dummyEditContact.contactId);
modal.find('#edit-title').val(dummyEditContact.title);
modal.find('#edit-director').val(dummyEditContact.director);
modal.find('#edit-releasedate').val(dummyEditContact.releasedate);
modal.find('#edit-studio').val(dummyEditContact.studio);
modal.find('#edit-mpaarating').val(dummyEditContact.mpaarating);
});

// TEST DATA
var testContactData = [
    {
        contactId: 1,
        title: "Star Wars",
        director: "George Lucas",
        releasedate: "25-05-1977",
        mpaarating: "PG",
        studio: "Twentieth Century Fox"},
    {
        contactId: 2,
        title: "Dawn of the Dead",
        director: "George Romero",
        releasedate: "25-05-1979",
        mpaarating: "NR",
        studio: "United Films"},
    {
        contactId: 3,
        title: "Shaun of the Dead",
        director: "Edgar Wright",
        releasedate: "24-09-2004",
        mpaarating: "R",
        studio: "Universal Pictures"}
];

var dummyDetailsContact =
        {
            contactId: 12,
            title: "The Muppet Movie",
            director: "James Frawley",
            releasedate: "22-07-1979",
            mpaarating: "G",
            studio: "Associated Film Distribution"
        };

var dummyEditContact =
        {
            contactId: 13,
            title: "Mad Max",
            director: "George Miller",
            releasedate: "12-04-1979",
            mpaarating: "R",
            studio: "Columbia"
        };