<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${user.id != null}">
  <div class="field">
    <input type="hidden" name="id" value="<c:out value='${user.id}'/>"/>
  </div>
</c:if>
<div class="field">
  <label for="username">User Name:</label>
  <input type="text" name="username" id="username" value="<c:out value='${user.username}'/>"/>
</div>
<div class="field">
  <label for="enabled">Enabled:</label>
  <input type="text" name="enabled" id="enabled" value="<c:out value='${user.enabled}'/>"/>
</div>
<div class="actions">
  <input type="submit" value="submit"/>
</div>
