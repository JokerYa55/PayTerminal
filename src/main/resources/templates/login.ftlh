<!DOCTYPE html>
<html lang=en>
    <head>
        <meta charset=utf-8>
        <meta http-equiv=X-UA-Compatible content="IE=edge">
        <meta name=viewport content="width=device-width,initial-scale=1">
        <link rel=icon href=favicon.ico>
        <title>${title}</title>
    </head>
    <body>
        <noscript>
            <strong>We're sorry but lk doesn't work properly without JavaScript enabled. Please enable it to continue.</strong>
        </noscript>
        <div id = "header">
            <a href = "/registration">Регистрация</a>
        </div>
        <form action="/login" method="post">
            <div><label> User Name : <input type="text" name="username"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <div><input type="submit" value="Sign In"/></div>
        </form>
    </body>
</html>