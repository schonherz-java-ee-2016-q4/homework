<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<tr>
    <td>username</td>
    <td>email</td>
    <td>
        <button type="button" class="btn btn-default" data-dismiss="modal" id="btn_id"
                onclick="switchUserStatus('username_param')">
            enabled
        </button>
    </td>
</tr>