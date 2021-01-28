 - El funcionamiento del componente se basa en añadir un DNI al campo de texto, al perder el foco dicho campo de texto, se hace una comprobación 
   para verificar si el texto introducido es un DNI válido.

 - Los formatos válidos para el componente son ( "123456789-A"   "123456789A" ) con guíon o sin guión, pero siempre seguido, sin espacios en blanco.

 - La manera en la que sabremos si el texto introducido es un DNI válido es al perder el foco, una vez perdido, el texto cambiará de color según el resultado,
   si el DNI es válido, el texto se pondrá verde, en su defecto lo hará de rojo. 

   El color por defecto es el negro, al ganar el foco se coloreará de dicho color, 
   el texto introducido solo cambiará de negro a otro color cuando la cadena tenga 9 o más caracteres.

 - Para hacer este componente decidí hacerlo en un java pero con un componente visual, extendiendo de JTextField, para que funcione el perder y ganar
   foco he tenido que implementar un FocusListener.

 - Para que el código funcione como componente, además del FocusListener, implementaremos Serializable, también haremos métodos getter and setter
   de las variables que nos sea necesario

 - El resto sería añadir funcionalidad al componente, en este caso tengo un método para para validar el DNI que devolverá un int, este int es necesario pasarlo 
   por parámetro al método pintar, también hecho por mí, este método es el que se encarga de pintar el texto del campo, según el número que reciba lo pintará
   de un color u otro.