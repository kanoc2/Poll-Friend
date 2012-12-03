<html>
<head><title>test</title></head>
<body>

<?php
function dbwr_users($id, $un, $pw)	{
	$dbh = pg_connect("host=csprojects.tcnj.edu dbname=team2d user=team2d password=pulimood");
	if (!$dbh) {
		die("Error in connection: " . pg_last_error());
	}
	
	$sql = "INSERT INTO users (ID, username, pw) VALUES ('$id', '$un', '$pw')";
	
	$result = pg_query($dbh, $sql);
	if (!$result) {
		die("Error in SQL query: " . pg_last_error());
	}
}

function dbrd_users($name)	{
	$dbh = pg_connect("host=csprojects.tcnj.edu dbname=team2d user=team2d password=pulimood");
	if (!$dbh) {
		die("Error in connection: " . pg_last_error());
	}
	
	$pw = "SELECT pw FROM users WHERE username='$name'";
	
	$result = pg_query($dbh, $pw);
	if (!$result) {
		die("Error in SQL query: " . pg_last_error());
	}
	return $pw;
}

function dbwr_poll($id, $ques, $ans1, $ans2, $ans3, $ans4)	{
	$dbh = pg_connect("host=csprojects.tcnj.edu dbname=team2d user=team2d password=pulimood");
	if (!$dbh) {
		die("Error in connection: " . pg_last_error());
	}
	
	$sql = "INSERT INTO polls (ID, question, a1, a2, a3, a4) VALUES ('$id', '$ques', '$ans1', '$ans2', '$ans3', '$ans4')";
	
	$result = pg_query($dbh, $sql);
	if (!$result) {
		die("Error in SQL query: " . pg_last_error());
	}
}

function dbrd_poll($id, $ansx)	{
	$dbh = pg_connect("host=csprojects.tcnj.edu dbname=team2d user=team2d password=pulimood");
	if (!$dbh) {
		die("Error in connection: " . pg_last_error());
	}
	
	$value = "SELECT '$ansx' FROM polls WHERE '$id'='$name'";
	
	$result = pg_query($dbh, $sql);
	if (!$result) {
		die("Error in SQL query: " . pg_last_error());
	}
	return $value;
}


function test($bleep)	{
  return "bloop";
}

?>

</body>
</html>