<?php

$result = "BIG_ENDIAN";
$i = 0x12345678;

// 將 i 依本機 Byte Order 打包為 unsigned long
$uLong = pack('L', $i);

// 將 $uLong 依 little-endian 打包為 unsigned long
if ($i === current(unpack('V', $uLong))) {
    $result = "LITTLE_ENDIAN";
}

echo $result;
