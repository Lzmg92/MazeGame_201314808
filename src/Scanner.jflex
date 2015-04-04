import java_cup.runtime.Symbol;

%%

%class Scanner
%cupsym simbolo
%cup
%public
%unicode
%line
%char
%ignorecase

numero =[0-9]+ "."? [0-9]*
palabra =[a-zA-ZÑñ]+

oracion = {palabra}({palabra}|{numero}| ":" | " " | "_" | "/" | "." | ",")*

sstring = {oracion}[\"]

nombrefo = {palabra}[_]{numero}


%%
"<configuration>"      {return new Symbol(simbolo.aconfig, yychar,yyline); }
"<background>"         {return new Symbol(simbolo.abackground, yychar,yyline);}
"<figure>"             {return new Symbol(simbolo.afigure, yychar,yyline); }
"<design>"             {return new Symbol(simbolo.adesign, yychar,yyline); }

"</configuration>"      {return new Symbol(simbolo.cconfig, yychar,yyline); }
"</background>"         {return new Symbol(simbolo.cbackground, yychar,yyline);}
"</figure>"             {return new Symbol(simbolo.cfigure, yychar,yyline); }
"</design>"             {return new Symbol(simbolo.cdesign, yychar,yyline); }

"x-nombre"              {return new Symbol(simbolo.nombre, yychar,yyline); }
"x-imagen"              {return new Symbol(simbolo.imagen, yychar,yyline); }

"x-descripcion"         {return new Symbol(simbolo.descripcion, yychar,yyline); }
"x-vida"                {return new Symbol(simbolo.vida, yychar,yyline); }
"x-tipo"                {return new Symbol(simbolo.tipo, yychar,yyline); }

"x-heroe"               {return new Symbol(simbolo.theroe, yychar,yyline); }
"x-villano"             {return new Symbol(simbolo.tvillano, yychar,yyline); }

"x-destruir"            {return new Symbol(simbolo.destruir, yychar,yyline); }
"x-creditos"            {return new Symbol(simbolo.creditos, yychar,yyline); }

"x-meta"                {return new Symbol(simbolo.tmeta, yychar,yyline); }
"x-bloque"              {return new Symbol(simbolo.tbloque, yychar,yyline); }
"x-bomba"               {return new Symbol(simbolo.tbomba, yychar,yyline); }
"x-arma"                {return new Symbol(simbolo.tarma, yychar,yyline); }
"x-bonus"               {return new Symbol(simbolo.tbonus, yychar,yyline); }

"{"                     {return new Symbol(simbolo.llavea, yychar,yyline); }
"}"                     {return new Symbol(simbolo.llavec, yychar,yyline); }
","                     {return new Symbol(simbolo.coma, yychar,yyline); }
";"                     {return new Symbol(simbolo.pycoma, yychar,yyline); }
"="                     {return new Symbol(simbolo.igual, yychar,yyline); }
"/"                     {return new Symbol(simbolo.adireccion, yychar,yyline); }
"\""                    {return new Symbol(simbolo.astring, yychar,yyline); }

{nombrefo}            {return new Symbol(simbolo.nombrefo, yychar,yyline, new String(yytext())); }
{oracion}             {return new Symbol(simbolo.oracion, yychar,yyline, new String(yytext())); }
{sstring}             {return new Symbol(simbolo.sstring, yychar, yyline, new String(yytext())); }
{numero}              {return new Symbol(simbolo.numero, yychar, yyline, new String(yytext())); }

[ \t\r\f\n]+       { /* Se ignoran */}

.   { System.out.println("Error lexico: "+yytext()); }