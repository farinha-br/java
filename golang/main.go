package main

import (
    "fmt"
    "net/http"
    "time"
    _ "github.com/go-sql-driver/mysql"
)

func loginPage(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, html+loginForm+htmlClose)
}

func makeHandler(fn func(http.ResponseWriter, *http.Request)) http.HandlerFunc {
    return func(w http.ResponseWriter, r *http.Request) {
		session, _ := store.Get(r, "cookie-name")

		if auth, ok := session.Values["authenticated"].(bool); !ok || !auth {
			fmt.Fprintln(w, html + "error" + htmlClose)
			return
		}

		temp := session.Values["logTime"] 
	
		if temp.(int64) < time.Now().Unix() {
			fmt.Fprintln(w, html + "outdated" + htmlClose)
			return
		}
		// add more time after each view
		session.Values["logTime"] = time.Now().Unix()+600
		session.Save(r, w)

        fn(w, r)
    }
}

func secret(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintln(w, html+"Twist and Shout" + htmlClose)
}

func reserve(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintln(w, html+"Great Party" + htmlClose)
}

func login(w http.ResponseWriter, r *http.Request) {
	session, _ := store.Get(r, "cookie-name")

	loginID := r.FormValue("loginID")
	pswdPost := r.FormValue("pswd")

	if auth, ok := session.Values["authenticated"].(bool); !ok || !auth {
		pswd, _ := fetchDB(loginID)
		isDB := CheckPasswordHash(pswdPost, pswd)
		if isDB == true {
			session.Values["logTime"] = time.Now().Unix()+600
			session.Values["authenticated"] = true
			session.Save(r, w)
		}
	}
	fmt.Fprintln(w, html + "<br/>Login<br/>" + htmlClose)
}

func logout(w http.ResponseWriter, r *http.Request) {
	session, _ := store.Get(r, "cookie-name")

	session.Values["authenticated"] = false
	session.Save(r, w)
	fmt.Fprintln(w, html + htmlClose)
}

func main() {
	http.HandleFunc("/", loginPage)
	http.HandleFunc("/secret", makeHandler(secret))
	http.HandleFunc("/reserve", makeHandler(reserve))
	http.HandleFunc("/login", login)
	http.HandleFunc("/logout", logout)
	
	//	openssl genrsa -out server.key 2048
	//	openssl ecparam -genkey -name secp384r1 -out server.key
	//	openssl req -new -x509 -sha256 -key server.key -out server.crt -days 3650

	err := http.ListenAndServeTLS(":443", "server.crt", "server.key", nil)
    if err != nil {
        log.Fatal("ListenAndServe: ", err)
    }
}
