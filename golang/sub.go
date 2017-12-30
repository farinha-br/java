package main

import (
	"github.com/gorilla/sessions"
	"database/sql"
	_ "github.com/go-sql-driver/mysql"
	"golang.org/x/crypto/bcrypt"
)

// store

var (
	key = []byte("super-secret-key")
	store = sessions.NewCookieStore(key)
)

// db

// logindb:
// id	int NOT NULL AUTO_INCREMENT,
// loginName varchar(64) DEFAULT NULL,
// pswd varchar(64) DEFAULT NULL,

func dbConn() (db *sql.DB) {
	dbDriver := "mysql"
	dbUser := "root"
	dbPass := ""
	dbName := "test"
	db, err := sql.Open(dbDriver, dbUser+":"+dbPass+"@/"+dbName)
	if err != nil {
		panic(err.Error())
	}
	return db
}

// query db

func fetchDB(loginID string) (string, error) {
	db := dbConn()
		selDB, err := db.Query("SELECT * FROM loginDB WHERE loginName=?", loginID)
		if err != nil {
			panic(err.Error())
		}
	    selDB.Next()
		var id int
		var loginName, pswd string
		err = selDB.Scan(&id, &loginName, &pswd)
		if err != nil {
			panic(err.Error())
		}
		defer db.Close()
	return pswd, err
}

// bcrypt

func HashPassword(password string) (string, error) {
	bytes, err := bcrypt.GenerateFromPassword([]byte(password), 14)
	return string(bytes), err
}

func CheckPasswordHash(password, hash string) bool {
	err := bcrypt.CompareHashAndPassword([]byte(hash), []byte(password))
	return err == nil
}

// vars

var html = `
<!doctype html>
<html>
<head lang="pt-br">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Login</title>
<style>
body { 
	margin: 0 auto;
	width: 720px;
	font-family: 'open sans', arial, verdana;
	font-size: 16px;
	line-height: 24px;
	background: #FFEAD5;
	text-align: justify;
}
input { lineheight: 32px; }
</style>
</head>
<body>
<br/>
<a href="/">Home</a> | <a href="/secret">Secret</a> | <a href="/reserve">Reserved</a> | 
<a href="/hello">Public</a> | <a href="/logout">Logout</a> <br/><br/><hr/><br/>
`

var loginForm = `
<form method="post" action="/login">
Name: <input type=text name="loginID" value="" size=24 /><br/><br/>
Password: <input type="password" name="pswd" value="" size=16 /><br/><br/>	
<input type=submit value="Login" />
</form>
 `
var htmlClose = `
</body>
</html>
`
