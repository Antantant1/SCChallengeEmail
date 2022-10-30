# Syntax:

# Base BareBones:
- incr x; -increment variable x  
- decr x; -decrement variable x  
- clear x; -initialises the variable x to 0 or sets x to 0 if already initialised  
- while x not 0 do; -while x is not equal to 0, do the next statements until an end is reached  
- end; -used to end while block  

## Misc:
- #this is a comment  
- incr x; #this is also a comment  
- #this is a comment; incr x; -but the incr x will still execute as comment is finished by semicolon  
- print x; -prints x to console  
- printString Hello, World!; -prints anything that is after "printString" trimmed until the semicolon  

## Maths:
- add x y; -adds the value of y to x and stores result in x (x = x + y)  
- minus x y; -takes y away from x (x = x - y)  
- multiply x y; -multiplies x and y and stores in x (x = x * y)  
- divide x y; -divides y from x (x = x / y)  

-subroutine cannot use variables outside of it  
## Subroutines:
- -if the method name is the same as any pre-defined methods, the default pre-defined is used  
- def method1; -define method "method1" to the next statements until an end is reached  
- def method1 x; -define method with a single input x  
- def method1 x1 x2 x3... -define method for many inputs x1...  
- method1 x;  

## If-Else:
- if x not y; -if x not equal to y, do the if statement, broken on 'end'  
- else; -if previous if condition not met; (has to be after an if or will be ignored  

## Compares:
- -e.g. not, eq, leq, geq, less, greater  
- used for if/while  
- not, -not equal to  
- eq, -equal to  
- leq, -less than or equal to  
- geq, -greater than or equal to  
- l, -less than  
- g, -greater than  
