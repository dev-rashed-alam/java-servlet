<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Crud using servlet</title>
</head>
<body>

<section>
    <c:out value="Message from Taglib Tag"/>
    <div class="container">
        <h2 class="text-center pt-2 pb-2">Student List</h2>
        <h2 class="text-center pt-2 pb-2"><c:out value="${requestScope.get(\"test\")}"/></h2>
        <table class="table">
            <thead>
            <tr>
                <th scope="col"><c:out value="#"/></th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Email</th>
                <th scope="col">Phone Number</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${studentList}" var="student">
                <tr>
                    <td><c:out value="${student.id}"/></td>
                    <td><c:out value="${student.firstName}"/></td>
                    <td><c:out value="${student.lastName}"/></td>
                    <td><c:out value="${student.email}"/></td>
                    <td><c:out value="${student.phoneNumber}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>