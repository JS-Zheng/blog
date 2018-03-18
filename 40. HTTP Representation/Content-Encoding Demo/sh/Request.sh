## Payload
echo "email=jason%40gg&password=9487" | gzip -c > payload.gz;

## Request
curl --data-binary @payload.gz \
     -X "POST" "https://reqres.in/api/register" \
     -H "Content-Type: application/x-www-form-urlencoded; charset=UTF-8" \
     -H "Content-Encoding: gzip"