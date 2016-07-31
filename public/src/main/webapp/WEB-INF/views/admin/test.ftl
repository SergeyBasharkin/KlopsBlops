<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Админка" styles=["css/foundation.css","css/test.css","css/cart.css","/css/reset.css","/css/style.css"] scripts=["js/catalog/catalog.js"]/>
<#macro m_body>
<form method="POST" enctype="multipart/form-data"
      action="upload">
    File to upload: <input type="file" name="file"><br />  <br /> <input type="submit"
                                                     value="Upload"> Press here to upload the file!
</form>
</#macro>