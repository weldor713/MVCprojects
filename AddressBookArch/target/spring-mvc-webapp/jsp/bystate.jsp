<%-- 
    Document   : bystate
    Created on : Oct 16, 2015, 2:15:38 PM
    Author     : apprentice
--%>



<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix = "s" uri="http://www.springframework.org/tags"  %>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
        <style type="text/css">
            h1{
                background-color:lightcoral;
                text-align: center;
                border-radius: 25px;
                padding-top: 10px;
                padding-bottom: 10px;
            }
            #topbar {
                margin-top: 20px;
                padding-top: 10px;
            }
        </style>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Address Book</title>

        <!--Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
              rel="stylesheet">

        <!-- SWC Icon -->
        <link rel ="shortcut icon"
              href="${pageContext.request.contextPath}img/icon.png">


    </head>
    <body>
        <div class="container">
            <h1 class = "col-md-offset-3 col-md-6">Address Book</h1>
            <br><br>
            
            <div id="topbar">
                <%@include file="addressheader.jsp" %>
            </div>
        </div>
                         <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h2>Search By State</h2>
                    <form class="form-horizontal" role="form">
                        <div class ="form-group">
                            <label for ="search-state" class="col-md-4 control-label">
                                State:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id ="search-state"
                                       placeholder ="State"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit"
                                        id ="search-button-state"
                                        class="btn btn-default">
                                    Search
                                </button>
                            </div>
                        </div>
                    </form>
                </div> <!--end left column-->
                <div class="col-md-6">
                    <h2>Search Results</h2>
                    <table id="contactTable" class="table table-hover">
                        <tr>
                            <th width="40%">Name</th>
                            <th width="30%">Address</th>
                            <th width="15%"></th>
                            <th width="15%"></th>
                        </tr>
                        <tbody id="contentRows">
                        </tbody>
                    </table>
                </div>
            </div><!-- end Row div -->

            <!-- Details Modal -->
            <!--
            The aria- attributes are for Accessible Rich Internet Applications
            standards -
            their purpose is to make web applications more accessible to people with
            disabilities.
            -->

            <div class="modal fade" id="detailsModal" tabindex="-1" role="dialog"
                 aria-labelledby="detailsModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Close</span>
                            </button>
                            <h4 class="modal-title" id="detailsModalLabel">Contact
                                Details</h4>
                        </div>
                        <div class="modal-body">
                            <h3 id="contact-id"></h3>
                            <table class="table table-bordered">
                                <tr>
                                    <th>First Name:</th>
                                    <td id="address-firstName"></td>
                                </tr>
                                <tr>
                                    <th>Last Name:</th>
                                    <td id="address-lastName"></td>
                                </tr>
                                <tr>
                                    <th>Address:</th>
                                    <td id="address-address"></td>
                                </tr>
                                <tr>
                                    <th>City:</th>
                                    <td id="address-city"></td>
                                </tr>
                                 <tr>
                                    <th>State:</th>
                                    <td id="address-state"></td>
                                </tr>
                                <tr>
                                    <th>Zip:</th>
                                    <td id="address-zip"></td>
                                </tr>  
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">
                                Close
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Edit Modal -->
            <div class="modal fade" id="editModal" tabindex="-1" role="dialog"
                 aria-labelledby="detailsModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Close</span></button>
                            <h4 class="modal-title" id="detailsModalLabel">Edit
                                Contact</h4>
                        </div>
                        <div class="modal-body">
                            <h3 id="contact-id"></h3>
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="edit-first-name" class="col-md-4 control-label">
                                        First Name:
                                    </label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-first-name"
                                               placeholder="First Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-last-name" class="col-md-4 control-label">
                                        Last Name:
                                    </label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-last-name"
                                               placeholder="Last Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-address" class="col-md-4 control-label">
                                        Address:
                                    </label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-address"
                                               placeholder="Address">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-city" class="col-md-4 control-label">
                                        City:
                                    </label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-city"
                                               placeholder="City">
                                    </div>
                                </div>
                                  <div class="form-group">
                                    <label for="edit-state" class="col-md-4 control-label">
                                        State:
                                    </label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-state"
                                               placeholder="State">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-zip" class="col-md-4 control-label">
                                        Zip:
                                    </label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-zip"
                                               placeholder="Zip">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <button type="submit" id="edit-button" class="btn btn-default"
                                                data-dismiss="modal">
                                            Edit Address
                                        </button>
                                        <button type="button" class="btn btn-default"
                                                data-dismiss="modal">
                                            Cancel
                                        </button>
                                        <input type="hidden" id="edit-contact-id">
                                    </div>
                                </div>
                            </form>
                            <div id="validationErrors" style="color: red"></div>
                        </div>
                    </div>
                </div>
            </div>   
        </div>

        <!-- placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/addressList.js"></script>
    </body>
</html>