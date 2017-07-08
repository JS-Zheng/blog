<?php ob_start(); ?>

<!DOCTYPE html>
<html>
<body>
<p>Hello, World!</p>
<p>頁面生成於: <?=date("Y-m-d H:i:s")?></p>
</body>
</html>

<?php
// 取得輸出緩衝區內容
$content = ob_get_contents();

// 發送 並 關閉 輸出緩沖區
ob_end_flush();

// 寫入檔案
$fp = fopen("index.cache", 'w');
if ($fp) {
    fputs($fp, $content);
    fclose($fp);
}