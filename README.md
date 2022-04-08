# moviles
-Jetpack Navigation

añadir la biblioteca (buscar en el navegador ¨bibliotecas jetpack¨)
primer link, luego buscar ¨activity¨ y dar click. Copiar activity_version y pegar en:

build gradle(project) -> arriba de la llave de plugings colocar

ext{
//aqui pegar la variable activity_version

ejemplo:
activity_version = "1.4.0"

}

luego ir al build gradle(module) y dentro de "dependencies" pegar:

implementation "androidx.activity:activity-ktx:$activity_version"

luego en la pagina del navegador, donde salen las librerias, regresar y buscar "fragments" y agregar:

build gradle(project) -> dentro de ext colocar fragment_version

por ejemplo: fragment_version = "1.4.1"

luego ir al build gradle(module) y dentro de "dependencies" pegar:

implementation "androidx.fragment:fragment-ktx:$fragment_version"

luego en el mismo "dependencies" en la misma lista de cosas, colocar de ultimo el

 debugImplementation "androidx.fragment:fragment-testing:$fragment_version"
 
 en la misma pagina de navegador, retroceder y buscar DataBinding y en el mismo build gradle(module):
 
 buscar el apartado android{
 
 } buscar el defaultConfig y abajo de el pegar:
 
 buildFeatures {
        dataBinding true
    }

 en la misma pagina de navegador, retroceder y buscar navigation y en build gradle(project):
 
 en ext pegar: nav_version = "2.4.1"
 
 en build gradle(module):
 
 en dependencies pegar:
 //kotlin
 implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
  implementation "androidx.navigation:navigation-ui-ktx:$nav_version"
  
  y luego de ultimo se pondra:
  
  // Testing Navigation
  androidTestImplementation "androidx.navigation:navigation-testing:$nav_version"
  
  luego se mueve a build gradle(project) y abajo de ext agregar 
  
 buildscript {
 
    repositories {
    
        google()
        
    }
    
    dependencies {
        
        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
        
    }
    
}

luego colocar ext{} dentro de buildscript arriba de repositories
  
  pasarse a build gradle(module), buscar plugins y pegar dentro:
  
id 'androidx.navigation.safeargs.kotlin'

luego de todo esto, presiona sync now (barra azul de arriba)
  
 ##EN RES
 
 crear un nuevo android resource file con el nombre de nav_graph (Resource Type: Navigation)
 
 en la vista de disenho del archivo nuevo se pueden agregar destinos a donde nosotros queremos ir 
 
 en la carpeta que contiene el MainActivity crear un nuevo fragmento (click derecho, nuevo, BlankFragment) con nombre HomeFragment
 
 crear otro fragmento con el nombre de SecondFragment
 
 volver al archivo de navegacion, darle click al celular con una cruz verde y darle click al HomeFragment, luego repetir pasos pero ahora con SecondFragment
 
 en los fragment salen unos circulos en sus bordes, al darle click a uno de ellos y llevarlo hasta el otro fragment, hace que la accion sea ir desde el fragmento del
 
 circulo al fragmento donde se llevo el circulo y en codigo aparece un <action.../> que indica ese movimiento

##ACTIVITYMAIN
en el archivo xml agregar FragmentContainerView (wrapcontent a todo) y agregar 
android:id="@+id/nav_host_fragment"
android:name="androidx.navigation.fragment.NavHostFragment"
app:defaultNavHost="true"
app:navGraph="@navigation/nav_graph"

y luego centrar desde el disenhador el fragmento que aparece en pantalla

crear un button (wrapcontent a todo)
id = action_chance 
text = cambiar

abajo del primer <?xml...> del xml del main colocar (activando databinding)

<layout aqui colocar los xmlns>

y cerrarlo hasta el final del archivo

</layout>

darle rebuilt project

nos movemos a MainActivity (clase)

private lateinit var binding : ActivityMainBinding

//se importa el  ActivityMainBinding (aparecera en rojo)

en onCreate borrar setContent y colocar

binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

val navController = navHostFragment.navController

binding.actionChange.setOnClickListener{

  navController.navigate(R.id.action_homeFragment_to_secondFragment)

}

##SECONDFRAGMENT
en el archivo xml solo se cambia el texto para diferenciar 




