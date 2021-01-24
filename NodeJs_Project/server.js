const express = require('express');
const mysql = require('mysql');
const  ejs = require('ejs');
const path = require("path");

const port = 3333;

// ======== Connected NodeJS via MySQL========
var cnx = mysql.createConnection({
host : "localhost",
user : "root",
password :"",
database : "gestion_formations"
})
const app = express();
app.set('view engine', 'ejs');
app.set("views",path.join(__dirname , "./View_Map"));
cnx.connect(function(error){
    if(!!error) console.log(error);
    else  console.log('Connected successfuly! :)')
});

app.get("/",function(req,resp){
	resp.end("Hello World");
});
app.get('/Session/:idSession', (req, res) => {
    let idSession = req.params.idSession;

    const sql = `SELECT * FROM session where idSession = ${idSession}`;
    cnx.query(sql, (err, row) => {
        console.log(row)
           if (err) throw err;
           res.render('Home', {
            
               row: row
           });
   
       })
   
   });


   app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
  })