/**
 * Arquivo temporario
 * Feito apenas para testar outputs do programa Term Frequency
 * Implementação padrão
 * 
 * Mostrar os N primeiros termos mais frequentes no texto lido
 * 
 * Input: 
 * white tigers live mostly in india
 * wild lions live mostly in africa
 * 
 * Output:
 * live - 2
 * mostly - 2
 * africa - 1
 * ....
 */

var fs = require("fs");

var splited = [];
var res = new Map();
var filedata = fs.readFileSync("input.txt", "utf-8").split("\n").forEach( (str,index) => { splited[index] = str.split(" ")  } );
var stopwords = fs.readFileSync("stopwords.txt", "utf-8").split("\n");

splited.map((str) => {
    str.map((word) => {
        if(!stopwords.includes(word)) {
            if(!res.get(word)) {
                res.set(word,0);
            }
            res.set(word, res.get(word) + 1);
        }
    });
});



//console.log(  ) ;
var answ = [...res.entries()].sort((a, b) => { return b[1] - a[1] });
answ.map( (value) => {
    console.log(`${value[0]} - ${value[1]}`);
});