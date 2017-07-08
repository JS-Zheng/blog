var request = require('request');

request.post({
        url: 'https://reqres.in/api/register',
        form: {
            email: 'jason@gg',
            password: '9487'
        }
    },
    function (err, response, body) {
        console.log('error:', err); // Print the error if one occurred
        console.log('statusCode:', response && response.statusCode); // Print the response status code if a response was received
        console.log('body:', body); // Print the HTML for the ReqRes homepage.
    });