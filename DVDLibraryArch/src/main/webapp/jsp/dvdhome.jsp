<%-- 
    Document   : Home
    Created on : Oct 16, 2015, 10:19:42 AM
    Author     : apprentice
--%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix = "s" uri="http://www.springframework.org/tags"  %>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD Library</title>
        <!--Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
              rel="stylesheet">

        <!-- SWC Icon -->
        <link rel ="shortcut icon"
              href="${pageContext.request.contextPath}img/icon.png">
    </head>
    <body>
        <div class="container">
            <h1>DVD Library</h1>
            <hr>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <h2>My DVDs</h2>
                    <table id="contactTable" class="table table-hover">
                        <tr>
                            <th width="40%">Title</th>
                            <th width="30%">Studio</th>
                            <th width="15%"></th>
                            <th width="15%"></th>
                        </tr>
                        <tbody id="contentRows">
                        </tbody>
                    </table>
                </div>
                <div class="col-md-6">
                    <h2>Add New DVD</h2>
                    <form class="form-horizontal" role="form">
                        <div class ="form-group">
                            <label for ="add-title" class="col-md-4 control-label">
                                Title:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id ="add-title"
                                       placeholder ="Title"/>
                            </div>
                        </div>
                        <div class ="form-group">
                            <label for ="add-director" class="col-md-4 control-label">
                                Last Name:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id ="add-director"
                                       placeholder ="Director"/>
                            </div>
                        </div>
                        <div class ="form-group">
                            <label for ="add-release-date" class="col-md-4 control-label">
                                Release Date:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id ="add-release-date"
                                       placeholder ="Release date"/>
                            </div>
                        </div>
                        <div class ="form-group">
                            <label for ="add-MPAA rating" class="col-md-4 control-label">
                                MPAA rating:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id ="add-MPAA rating"
                                       placeholder ="MPAA rating"/>
                            </div>
                        </div>
                        <div class ="form-group">
                            <label for ="add-studio" class="col-md-4 control-label">
                                Studio:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id ="add-studio"
                                       placeholder ="Studio"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit"
                                        id ="add-button"
                                        class="btn btn-default">
                                    Create DVD entry
                                </button>
                            </div>

                        </div>
                    </form>
                </div> <!--end right column-->
            </div><!-- end Row div -->
        </div>
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
                        <h4 class="modal-title" id="detailsModalLabel">DVD
                            Details</h4>
                    </div>
                    <div class="modal-body">
                        <h3 id="contact-id"></h3>
                        <table class="table table-bordered">
                            <tr>
                                <th>Title:</th>
                                <td id="contact-title"></td>
                            </tr>
                            <tr>
                                <th>Director:</th>
                                <td id="contact-director"></td>
                            </tr>
                            <tr>
                                <th>Release date:</th>
                                <td id="contact-releasedate"></td>
                            </tr>
                            <tr>
                                <th>Studio:</th>
                                <td id="contact-studio"></td>
                            </tr>
                            <tr>
                                <th>MPAA rating:</th>
                                <td id="contact-mpaarating"></td>
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
                            DVD</h4>
                    </div>
                    <div class="modal-body">
                        <h3 id="contact-id"></h3>
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="edit-title" class="col-md-4 control-label">
                                    Title:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-title"
                                           placeholder="Title">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-director" class="col-md-4 control-label">
                                    Director:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-director"
                                           placeholder="Director">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-release-date" class="col-md-4 control-label">
                                    Release date:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-releasedate"
                                           placeholder="Release date">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-mpaa-rating" class="col-md-4 control-label">
                                    MPAA rating:
                                </label>
                                <div class="col-md-8">
                                    <input type="mpaa-rating" class="form-control" id="edit-mpaarating"
                                           placeholder="MPAA rating">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-Studio" class="col-md-4 control-label">
                                    Studio:
                                </label>
                                <div class="col-md-8">
                                    <input type="tel" class="form-control" id="edit-studio"
                                           placeholder="Studio">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <button type="submit" id="edit-button" class="btn btn-default"
                                            data-dismiss="modal">
                                        Edit DVD
                                    </button>
                                    <button type="button" class="btn btn-default"
                                            data-dismiss="modal">
                                        Cancel
                                    </button>
                                    <input type="hidden" id="edit-contact-id">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>   


        <!-- placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dvdList.js"></script>
    </body>
</html>


