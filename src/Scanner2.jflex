import java_cup.runtime.Symbol;

%%

%class Scanner2
%cupsym simbolo2
%cup
%public
%unicode
%line
%char
%ignorecase

numero =[0-9]+
palabra =[a-zA-ZÑñ]+
oracion ={palabra}({palabra}|{numero}| ":" | " " | "_" | "/" | ".")*

nombrefo = {palabra}[_]{numero}


%%
"escenarios background" {return new Symbol(simbolo2.aescenarios, yychar,yyline); }
"personajes"            {return new Symbol(simbolo2.apersonajes, yychar,yyline); }
"heroes"                {return new Symbol(simbolo2.aheroes, yychar,yyline); }
"villanos"              {return new Symbol(simbolo2.avillanos, yychar,yyline); }
"paredes"               {return new Symbol(simbolo2.aparedes, yychar,yyline); }
"extras"                {return new Symbol(simbolo2.aextras, yychar,yyline); }
"armas"                 {return new Symbol(simbolo2.aarmas, yychar,yyline); }
"bombas"                 {return new Symbol(simbolo2.abombas, yychar,yyline); }
"bonus"                 {return new Symbol(simbolo2.abonus, yychar,yyline); }
"meta"                  {return new Symbol(simbolo2.ameta, yychar,yyline); }

"/escenarios"            {return new Symbol(simbolo2.cescenarios, yychar,yyline); }
"/personajes"            {return new Symbol(simbolo2.cpersonajes, yychar,yyline); }
"/heroes"                {return new Symbol(simbolo2.cheroes, yychar,yyline); }
"/villanos"              {return new Symbol(simbolo2.cvillanos, yychar,yyline); }
"/paredes"               {return new Symbol(simbolo2.cparedes, yychar,yyline); }
"/extras"                {return new Symbol(simbolo2.cextras, yychar,yyline); }
"/armas"                 {return new Symbol(simbolo2.carmas, yychar,yyline); }
"/bombas"                 {return new Symbol(simbolo2.cbombas, yychar,yyline); }
"/bonus"                 {return new Symbol(simbolo2.cbonus, yychar,yyline); }
"/meta"                  {return new Symbol(simbolo2.cmeta, yychar,yyline); }

"dimension"             {return new Symbol(simbolo2.dimension, yychar,yyline); }


".."                    {return new Symbol(simbolo2.dpts, yychar,yyline); }
"("                     {return new Symbol(simbolo2.parenta, yychar,yyline); }
")"                     {return new Symbol(simbolo2.parentc, yychar,yyline); }
","                     {return new Symbol(simbolo2.coma, yychar,yyline); }
";"                     {return new Symbol(simbolo2.pycoma, yychar,yyline); }
"="                     {return new Symbol(simbolo2.igual, yychar,yyline); }
"<"                     {return new Symbol(simbolo2.etiqa, yychar,yyline); }
">"                     {return new Symbol(simbolo2.etiqc, yychar,yyline); }

{nombrefo}            {return new Symbol(simbolo2.nombrefo, yychar,yyline, new String(yytext())); }
{oracion}             {return new Symbol(simbolo2.oracion, yychar,yyline, new String(yytext())); }
{numero}           {return new Symbol(simbolo2.numero, yychar, yyline, new String(yytext())); }

[ \t\r\f\n]+       { /* Se ignoran */}

.   { System.out.println("Error lexico: "+yytext()); }