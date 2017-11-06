# DocumentUI

An Angular based web application to be used as frontend for the DocumentService

## API access

the ui access the API at /api/*. This must be routed to the API service by the processrunning the ui. 

In production, this is implemented in the server.js file.

For development this is configured in proxy.conf.json and is used by

    npm start
    
which effectivly calls
    
    ng serve --proxy-config proxy.conf.json
    
