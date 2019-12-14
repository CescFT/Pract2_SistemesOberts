<html>
    <head>
        <title>ENTRAR DADES HABITACIO!</title>
    </head>
    <body>
        <h2>Detalls habitacio</h2>  
        <form method="post" action="findTenant.do">
            <table>
                <tr>
                    <td>
                        ID del llogater a buscar:
                    </td>
                    <td>
                        <input type="text" 
                               name="idTenant" 
                         />
                    </td>
                </tr>
            </table>
            <input type="submit" value="Send Request">
        </form>
    </body>
</html>
