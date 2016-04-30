# lab1_compumovil

Actividad:
- Cree un nuevo proyecto (new project with empty activity) con el nombre Lab1UI, siendo X el número de su grupo de trabajo. Nombre del paquete debe ser co.edu.udea.compumovil.grX.lab1ui
- Desarrolle una interfaz gráfica (archivo activity_mail.xml en el directorio layouts) dividida en dos secciones (cada sección será un layout). Utilice un LinearLayout en el que se incluyan ambas secciones y utilice la propiedad android:weight para que la primera sección ocupe ¾ de la pantalla, mientras la segunda ¼ (Es decir, utilice el número 3 para la primera sección y el número 1 para la segunda, recuerde dejar la propiedad android:height en 0dp para que se le dé prioridad a la propiedad weight)
- Desarrolle una interfaz adicional para cuando la aplicación esté en modo landscape. En este caso la interfaz se debe reorganizar de forma tal que las dos secciones se ubiquen en forma horizontal.

-Primera sección
Se desea agregar un nuevo contacto, realice un formulario para con los siguientes campos: 
Nombres (EditText ), debe usar un teclado normal y con mayúscula inicial y no debe brindar sugerencias.
Apellidos (EditText), debe usar un teclado normal y con mayúscula inicial y no debe brindar sugerencias
Sexo (RadioButton)
Fecha de Nacimiento (DatePicker)
Pais (Autocomplete)
Teléfono (EditText), debe mostrar un teclado telefónico 
Dirección (EditText), el teclado no debe sugerir nada 
Email (EditText), tipo de dato: email
Hobbies (Spinner), utilice un spinner con varios hobbies, se deja a criterio del desarrollador cuales hobbies.
Favorito (Checkbox), por default no es favorito.
Los componentes anteriores deben estar organizados usando un relativelayout, la distribución de los componentes se deja a criterio de los desarrolladores. 
En el teclado debe aparecer siguiente en vez de enter, cuando se necesario agregar más información


-Segunda sección
Se desea capturar toda la información y escribirla en un campo de texto.
TextView con scroll en el que se mostrará la información ingresada cuando se presione el botón “Mostrar”.
Botón “Mostrar”,
Se debe validar que se ingresen todos los datos 
