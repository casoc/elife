<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${user.id != null}">
  <div class="field">
    <input type="hidden" name="id" value="<c:out value='${user.id}'/>"/>
  </div>
</c:if>

<div class="form-group">
  <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> User Name </label>

  <div class="col-sm-9">
    <input type="text" id="form-field-1" placeholder="Username" class="col-xs-10 col-sm-5" name="username" value="<c:out value='${user.username}'/>">
  </div>
</div>

<div class="form-group">
  <label class="col-sm-3 control-label no-padding-right" for="enabled">Enabled</label>
  <label class="col-sm-9">
    <c:choose>
      <c:when test="${!user.enabled}">
        <input id="enabled" name="enabled" class="ace ace-switch ace-switch-6" type="checkbox">
      </c:when>
      <c:otherwise>
        <input id="enabled" name="enabled" class="ace ace-switch ace-switch-6" type="checkbox" checked>
      </c:otherwise>
    </c:choose>
    <span class="lbl"></span>
  </label>
</div>

<div>
  <a href="/admin/users">back index</a>
</div>

<div class="clearfix form-actions">
  <div class="col-md-offset-3 col-md-9">
    <button class="btn btn-info" type="submit">
      <i class="icon-ok bigger-110"></i>
      Submit
    </button>

    &nbsp; &nbsp; &nbsp;
    <button class="btn" type="reset">
      <i class="icon-undo bigger-110"></i>
      Reset
    </button>
  </div>
</div>
