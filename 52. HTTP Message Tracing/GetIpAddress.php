<?php

echo "Your IP Address: " . get_client_ip();

// Function to get the client IP address
function get_client_ip()
{
    $ip = getenv('HTTP_CLIENT_IP') ?:
        getenv('HTTP_X_FORWARDED_FOR') ?:
            getenv('HTTP_X_FORWARDED') ?:
                getenv('HTTP_FORWARDED_FOR') ?:
                    getenv('HTTP_FORWARDED') ?:
                        getenv('REMOTE_ADDR');
    return $ip;
}