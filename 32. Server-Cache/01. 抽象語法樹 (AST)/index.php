<?php
require __DIR__ . '/vendor/autoload.php';

use PhpParser\Error;
use PhpParser\ParserFactory;

$code = <<<'CODE'
<?php
$flag = true;
$str = "Hello, World!";

if ($flag) {
    echo $str;
}
CODE;

$parser = (new ParserFactory)->create(ParserFactory::PREFER_PHP7);

try {
    $stmts = $parser->parse($code);
    echo "<pre>";
    print_r($stmts);
    echo "</pre>";
} catch (Error $e) {
    echo 'Parse Error: ', $e->getMessage();
}
