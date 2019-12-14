<html>
    <head>
        <title>ENTRAR DADES HABITACIO!</title>
    </head>
    <body>
        <h2>Detalls habitacio</h2>  
        <form method="post" action="roomById.do">
            <table>
                <tr>
                    <td>
                        ID de la habitacio a buscar:
                    </td>
                    <td>
                        <input type="text" 
                               name="idRoom" 
                         />
                    </td>
                </tr>
            </table>
            <input type="submit" value="Send Request">
        </form>
    </body>
</html>
