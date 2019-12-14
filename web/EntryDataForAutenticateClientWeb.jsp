<html>
    <head>
        <title>ENTRAR DADES HABITACIO!</title>
    </head>
    <body>
        <h2>Detalls habitacio</h2>  
        <form method="post" action="authentication.do">
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
                </tr>
                <tr>
                    <td>
                        Correu electrònic:
                    </td>
                    <td>
                        <input type="text" 
                               name="email" 
                         />
                    </td>
                </tr>
                <tr>
                    <td>
                        Contrassenya:
                    </td>
                    <td>
                        <input type="password"
                               name="passwd"
                        />
                    </td>
                </tr>
            </table>
            <input type="submit" value="Send Request">
        </form>
    </body>
</html>
