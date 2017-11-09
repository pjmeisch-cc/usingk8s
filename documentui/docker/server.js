var os = require('os');
var hostname = os.hostname();
console.log('running on ' + hostname);


var path = require("path"),
    express = require("express");

var DIST_DIR = path.join(__dirname, "dist"),
    PORT = 3000,
    app = express();

// logging
var morgan = require('morgan');
app.use(morgan('combined'));

// close connection to see loadbalancing
var closeConnection = function (req, res, next) {
    res.setHeader('Connection', 'close'); next()
};
app.use('*', closeConnection);

//Serving the files on the dist folder
app.use(express.static(DIST_DIR));


// proxy all requests to /api to the service running on port 8080 (or whatever is given as environment or argument),
// stripping the api part
var requestProxy = require('express-request-proxy');
var apiHost = process.argv[2] || process.env.API_HOST || 'localhost:8080';
app.get('/api/*', requestProxy({
    url: 'http://' + apiHost + '/*',
    query: {
        via: hostname
    }
}));


//Send index.html when the user accesses anything
app.get("*", function (req, res) {
    res.sendFile(path.join(DIST_DIR, "index.html"));
});

app.listen(PORT);
