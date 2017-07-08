<?php
require __DIR__ . '/vendor/autoload.php';

$options = [
    'scheme' => 'tcp',
    'host' => 'redis',
    'port' => 6379,
];

$client = new Predis\Client($options);

execute($client, "SET", array("name", "foo"));
execute($client, "GET", array("name"));
$count = $client->incr("counter");
println("Visits: $count");


function execute($object, $method, $args = array())
{
    if (!is_callable(array($object, $method))) {
        println("`$method` is not callable.");
    } else {

        $func = function () use ($object, $method, $args) {
            println("&gt; $method " . implode(" ", $args));
            return call_user_func_array(array($object, $method), $args);
        };

        prettyPrint($func);
    }
}


function println($str = null)
{
    if ($str != null)
        echo $str;
    echo "<br/>";

}

$bgc = "";
function prettyPrint($callback)
{
    global $bgc;
    $bgc = getColorHex($bgc);
    echo "<div style=\"background-color:$bgc; max-width: 200px\">";
    println($callback());
    echo "</div>";
    println();
}


function getColorHex($avoid = "")
{
    $bgcArray = array("#FFCDD2", "#F8BBD0", "#E1BEE7", "#D1C4E9", "#C5CAE9",
        "#BBDEFB", "#B3E5FC", "#B2EBF2", "#B2DFDB", "#DCEDC8", "#F0F4C3",
        "#FFF9C4", "#FFECB3", "#FFE0B2", "#FFCCBC", "#F5F5F5");

    $arrLen = count($bgcArray);

    do {
        $color = $bgcArray[rand(0, $arrLen - 1)];
    } while ($color == $avoid && $arrLen > 1);

    return $color;
}