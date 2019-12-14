<html>
    <head>
        <title>ENTRAR DADES HABITACIO!</title>
    </head>
    <body>
        <h2>Detalls habitacio</h2>  
        <form method="post" action="getMyPassword.do">
            <table>
                <tr>
                    <td>
                        Nom Usuari:
                    </td>
                    <td>
                        <input type="text" 
                               name="username" 
                        />
                    </td>
                <tr>
                    <td>
                        Token:
                    </td>
                    <td>
                        <input
                            type="password"
                            name="token"
                            />
                    </td>
                </tr>
            </table>
            <input type="submit" value="Send Request">
        </form>
    </body>
</html>
