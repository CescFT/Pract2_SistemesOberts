<html>
    <head>
        <title>ENTRAR DADES HABITACIO!</title>
    </head>
    <body>
        <h2>Detalls habitacio</h2>  
        <form method="post" action="roomsResult.do">
            <table>
                <tr>
                    <td>
                        Ciutat:
                    </td>
                    <td>
                        <input type="text" 
                               name="location" 
                        />
                    </td>
                </tr>
                <tr>
                    <td>
                        orientacio:
                    </td>
                    <td>
                        <input type="text" 
                               name="sort" 
                         />
                    </td>
                </tr>
            </table>
            <input type="submit" value="Send Request">
        </form>
    </body>
</html>
